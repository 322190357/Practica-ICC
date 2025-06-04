package logica;

import interfaz.Consola;
import jugador.Jugador;
import jugador.JugadorHumano;
import jugador.JugadorIA;
import modelo.Mazo;
import modelo.Tablero;
import modelo.Carta;
import util.ListaPersonalizada;
import util.ValidadorCartas;


public class Juego {
    private final JugadorHumano jugadorHumano;
    private final JugadorIA jugadorIA;
    private final Mazo mazo;
    private final Tablero tablero;
    private boolean juegoTerminado;

    public Juego() {
        this.mazo = new Mazo();
        mazo.barajar();
        this.tablero = new Tablero(mazo);
        this.jugadorHumano = new JugadorHumano();
        this.jugadorIA = new JugadorIA();
        this.juegoTerminado = false;
    }

    public void iniciar() {
        Consola.mostrarBienvenida();
        
        while (!juegoTerminado) {
            prepararNuevaRonda();
            ejecutarRonda();
            verificarFinJuego();
        }
        
        Consola.mostrarResultadoFinal(jugadorHumano, jugadorIA);
    }

    private void prepararNuevaRonda() {
        // Asignar nuevas cartas de inicio
        jugadorHumano.resetearRonda();
        jugadorIA.resetearRonda();
        
        // Robar cartas iniciales
        jugadorHumano.tomarCarta(mazo.robarCarta());
        jugadorIA.tomarCarta(mazo.robarCarta());
        
        tablero.rellenarHuecos();
    }

    private void ejecutarRonda() {
        boolean rondaActiva = true;
        
        while (rondaActiva) {
            // Turno jugador humano
            ejecutarTurno(jugadorHumano);
            
            // Turno IA
            ejecutarTurno(jugadorIA);
            
            // Verificar si alguien terminó
            rondaActiva = !jugadorHumano.finRonda && !jugadorIA.finRonda;
        }
        
        procesarFinRonda();
    }

    private void ejecutarTurno(Jugador jugador) {
        if (!jugador.finRonda) {
            ListaPersonalizada<Carta> visibles = tablero.getCartasVisibles();
            
            if (jugador instanceof JugadorHumano) {
                Consola.mostrarTablero(tablero);
                Consola.mostrarEstadoJugador(jugadorHumano, true);
            }
            
            jugador.jugarTurno(visibles);
            
            if (jugador.getUltimaCarta() != null) {
                tablero.eliminarCarta(jugador.getUltimaCarta());
            }
        }
    }

    private void procesarFinRonda() {
        // Verificar declaraciones de fin
        validarDeclaraciones();
        
        // Procesar puntajes
        actualizarPuntajes();
        
        // Mostrar resultados
        Consola.mostrarResultadosRonda(jugadorHumano, jugadorIA);
    }

    private void validarDeclaraciones() {
        validarJugador(jugadorHumano);
        validarJugador(jugadorIA);
    }

    private void validarJugador(Jugador jugador) {
        if (jugador.finRonda) {
            boolean declaracionCorrecta = !existenMovimientosValidos(jugador);
            
            if (declaracionCorrecta) {
                if (jugador instanceof JugadorHumano) {
                    Carta bonus = tablero.getCartasVisibles().obtener(0);
                    jugador.puntaje.agregar(bonus);
                }
            } else {
                jugador.secuencia = new ListaPersonalizada<>();
            }
        }
    }

    private boolean existenMovimientosValidos(Jugador jugador) {
        Carta ultima = jugador.getUltimaCarta();
        for (Carta carta : tablero.getCartasVisibles()) {
            if (ValidadorCartas.esValida(ultima, carta)) return true;
        }
        return false;
    }

    private void actualizarPuntajes() {
        if (jugadorHumano.validarSecuencia()) {
            jugadorHumano.puntaje.agregarTodos(jugadorHumano.secuencia);
        }
        if (jugadorIA.validarSecuencia()) {
            jugadorIA.puntaje.agregarTodos(jugadorIA.secuencia);
        }
    }

    private void verificarFinJuego() {
        // Verificar si hay suficientes cartas para nueva ronda
        int cartasNecesarias = 2 + (30 - tablero.getCartasVisibles().tamaño());
        juegoTerminado = mazo.tamaño() < cartasNecesarias;
    }
}
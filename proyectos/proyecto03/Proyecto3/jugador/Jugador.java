package jugador;

import modelo.Carta;
import util.ListaPersonalizada;
import util.ValidadorCartas;

public abstract class Jugador {
    // Cambiados a public para permitir acceso directo desde Juego
    public ListaPersonalizada<Carta> secuencia;
    public ListaPersonalizada<Carta> puntaje;
    public boolean finRonda;

    public Jugador() {
        secuencia = new ListaPersonalizada<>();
        puntaje = new ListaPersonalizada<>();
        finRonda = false;
    }

    public void tomarCarta(Carta carta) {
        secuencia.agregar(carta);
    }

    public void declararFinRonda() {
        finRonda = true;
    }

    public boolean validarSecuencia() {
        if (secuencia.tamaño() < 1) return false;
        
        for (int i = 1; i < secuencia.tamaño(); i++) {
            Carta actual = secuencia.obtener(i - 1);
            Carta siguiente = secuencia.obtener(i);
            if (!ValidadorCartas.esValida(actual, siguiente)) {
                return false;
            }
        }
        return true;
    }

    public void resetearRonda() {
        secuencia = new ListaPersonalizada<>();
        finRonda = false;
    }

    public int calcularPuntaje() {
        return puntaje.tamaño();
    }
    public ListaPersonalizada<Carta> getSecuencia() {
        return this.secuencia;
    }

    public Carta getUltimaCarta() {
        return secuencia.tamaño() > 0 ? secuencia.obtener(secuencia.tamaño() - 1) : null;
    }

    public abstract void jugarTurno(ListaPersonalizada<Carta> cartasVisibles);
}
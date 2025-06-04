package jugador;

import modelo.Carta;
import util.ListaPersonalizada;
import util.ValidadorCartas;


public class JugadorIA extends Jugador {
    @Override
    public void jugarTurno(ListaPersonalizada<Carta> cartasVisibles) {
        System.out.println("\n=== TURNO DE LA IA ===");         
        Carta ultima = getUltimaCarta();
        boolean cartaTomada = false;

        // Buscar primera carta válida
        for (int i = 0; i < cartasVisibles.tamaño(); i++) {
            Carta candidata = cartasVisibles.obtener(i);
            if (ultima == null || ValidadorCartas.esValida(ultima, candidata)) {
                tomarCarta(candidata);
                cartaTomada = true;
                System.out.println("La IA tomó: " + candidata.toString());
                break;
            }
        }

        if (!cartaTomada) {
            declararFinRonda();
            System.out.println("La IA declara fin de ronda.");
        }
    }
}
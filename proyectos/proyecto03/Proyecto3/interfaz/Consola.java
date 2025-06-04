package interfaz;

import jugador.Jugador;
import jugador.JugadorHumano;
import jugador.JugadorIA;
import modelo.Carta;
import modelo.Tablero;
import util.ListaPersonalizada;


public class Consola {
    private static final String RESET = "\u001B[0m";
    private static final String ROJO = "\u001B[31m";
    private static final String AZUL = "\u001B[34m";
    private static final String NEGRO = "\u001B[30m";
    private static final String FONDO_BLANCO = "\u001B[47m";

    public static void mostrarBienvenida() {
        System.out.println(FONDO_BLANCO + NEGRO + "¡Bienvenido a Pick-a-Perro Poker Edition!" + RESET);
        System.out.println("Encuentra secuencias de cartas con 0 o 1 diferencia!");
    }

    public static void mostrarTablero(Tablero tablero) {
        System.out.println("\n=== TABLERO ===");
        System.out.println("Cartas disponibles:");
        
        ListaPersonalizada<Carta> visibles = tablero.getCartasVisibles();
        for (int i = 0; i < visibles.tamaño(); i++) {
            Carta c = visibles.obtener(i);
            System.out.printf("%2d: %s%n", i, formatearCarta(c));
        }
    }

    private static String formatearCarta(Carta c) {
        String color = (c.getColorElemento() == Carta.ColorElemento.ROJO) ? ROJO : AZUL;
        String palo = switch (c.getPalo()) {
            case CORAZONES -> "♥";
            case TREBOLES -> "♣";
            case PICAS -> "♠";
            case DIAMANTES -> "♦";
        };
        
        String valor = switch (c.getValor()) {
            case 1 -> "A";
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            default -> String.valueOf(c.getValor());
        };

        return color + "[" + valor + palo + "]" + RESET;
    }

    public static void mostrarEstadoJugador(Jugador jugador, boolean esHumano) {
        System.out.println("\n--- Tu estado ---");
        System.out.println("Puntaje total: " + jugador.calcularPuntaje());
        
        System.out.println("Secuencia actual:");
        if (jugador.getSecuencia().tamaño() == 0) {
            System.out.println("Vacía");
        } else {
            for (Carta c : jugador.getSecuencia()) {
                System.out.print(formatearCarta(c) + " → ");
            }
            System.out.println("FIN");
        }
    }

    public static void mostrarResultadosRonda(JugadorHumano humano, JugadorIA ia) {
        System.out.println("\n=== RESULTADOS RONDA ===");
        System.out.println("Tu secuencia: " + verificarSecuencia(humano));
        System.out.println("Secuencia IA: " + verificarSecuencia(ia));
        System.out.println("Puntos acumulados:");
        System.out.println("- Tú: " + humano.calcularPuntaje());
        System.out.println("- IA: " + ia.calcularPuntaje());
    }

    private static String verificarSecuencia(Jugador jugador) {
        return jugador.validarSecuencia() ? "✓ VÁLIDA" : "✗ INVÁLIDA";
    }

    public static void mostrarResultadoFinal(JugadorHumano humano, JugadorIA ia) {
        System.out.println("\n=== JUEGO TERMINADO ===");
        System.out.println("Puntaje final:");
        System.out.println("- Tú: " + humano.calcularPuntaje());
        System.out.println("- IA: " + ia.calcularPuntaje());
        
        if (humano.calcularPuntaje() > ia.calcularPuntaje()) {
            System.out.println("¡HAS GANADO! 🎉");
        } else if (humano.calcularPuntaje() < ia.calcularPuntaje()) {
            System.out.println("Gana la IA... 😞");
        } else {
            System.out.println("¡EMPATE! 🤝");
        }
    }
}
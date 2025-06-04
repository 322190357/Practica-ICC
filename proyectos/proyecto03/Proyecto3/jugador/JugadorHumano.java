package jugador;

import java.util.Scanner;
import modelo.Carta;
import util.ListaPersonalizada;


public class JugadorHumano extends Jugador {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void jugarTurno(ListaPersonalizada<Carta> cartasVisibles) {
        System.out.println("\n=== TU TURNO ===");
        mostrarEstadoActual(cartasVisibles);

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Tomar carta");
            System.out.println("2. Finalizar ronda");
            System.out.print("Elección: ");
            
            String opcion = scanner.nextLine().trim();
            
            if (opcion.equals("2")) {
                declararFinRonda();
                break;
            } else if (opcion.equals("1")) {
                if (procesarSeleccionCarta(cartasVisibles)) break;
            } else {
                System.out.println("Opción inválida!");
            }
        }
    }

    private boolean procesarSeleccionCarta(ListaPersonalizada<Carta> cartasVisibles) {
        System.out.print("Ingresa el índice de la carta (0-" + (cartasVisibles.tamaño()-1) + "): ");
        try {
            int indice = Integer.parseInt(scanner.nextLine());
            if (indice < 0 || indice >= cartasVisibles.tamaño()) {
                System.out.println("Índice fuera de rango!");
                return false;
            }
            Carta seleccionada = cartasVisibles.obtener(indice);
            tomarCarta(seleccionada);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida! Debe ser un número.");
            return false;
        }
    }

    private void mostrarEstadoActual(ListaPersonalizada<Carta> cartasVisibles) {
        System.out.println("\n--- Cartas Disponibles ---");
        for (int i = 0; i < cartasVisibles.tamaño(); i++) {
            Carta c = cartasVisibles.obtener(i);
            System.out.printf("%d: %s%n", i, c.toString());
        }
        
        System.out.println("\nTu secuencia actual:");
        if (secuencia.tamaño() == 0) {
            System.out.println("(Vacía)");
        } else {
            System.out.println(secuencia.obtener(secuencia.tamaño() - 1).toString());
        }
    }
}
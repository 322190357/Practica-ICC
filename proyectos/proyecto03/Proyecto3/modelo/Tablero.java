package modelo;

import util.ListaPersonalizada;


public class Tablero {
    private static final int FILAS = 5;
    private static final int COLUMNAS = 6;
    private final Carta[][] cuadricula = new Carta[FILAS][COLUMNAS];
    private final Mazo mazo;

    public Tablero(Mazo mazo) {
        this.mazo = mazo;
        inicializar();
    }

    public void inicializar() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                cuadricula[i][j] = mazo.robarCarta();
            }
        }
    }

    public void rellenarHuecos() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (cuadricula[i][j] == null && !mazo.estaVacio()) {
                    cuadricula[i][j] = mazo.robarCarta();
                }
            }
        }
    }

    public ListaPersonalizada<Carta> getCartasVisibles() {
        ListaPersonalizada<Carta> visibles = new ListaPersonalizada<>();
        for (Carta[] fila : cuadricula) {
            for (Carta carta : fila) {
                if (carta != null) visibles.agregar(carta);
            }
        }
        return visibles;
    }

    public boolean eliminarCarta(Carta carta) {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (cuadricula[i][j] != null && cuadricula[i][j].equals(carta)) {
                    cuadricula[i][j] = null;
                    return true;
                }
            }
        }
        return false;
    }

    // Para mostrar el tablero en consola
    public void mostrarTablero() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                String cartaStr = (cuadricula[i][j] != null) ? cuadricula[i][j].toString() : "[VACÍO]";
                System.out.printf("%-25s", cartaStr);
            }
            System.out.println();
        }
    }
}
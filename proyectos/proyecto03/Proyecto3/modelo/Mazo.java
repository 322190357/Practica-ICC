package modelo;

import util.ListaPersonalizada;

public class Mazo {
    private final ListaPersonalizada<Carta> cartas;

    public Mazo() {
        cartas = new ListaPersonalizada<>();
        generarCartas();
    }

    private void generarCartas() {
        // Generamos 3 copias de cada combinación única (3 sets)
        for (int i = 0; i < 3; i++) {
            for (Carta.Fondo fondo : Carta.Fondo.values()) {
                for (int valor = 1; valor <= 13; valor++) {
                    for (Carta.Palo palo : Carta.Palo.values()) {
                        for (Carta.ColorElemento color : Carta.ColorElemento.values()) {
                            for (Carta.EstiloValor estilo : Carta.EstiloValor.values()) {
                                cartas.agregar(new Carta(fondo, valor, palo, color, estilo));
                            }
                        }
                    }
                }
            }
        }
    }

    public Carta robarCarta() {
        if (cartas.estaVacia()) return null;
        return cartas.eliminar(0); // Elimina y retorna la primera carta
    }

    public void barajar() {
        // Implementar algoritmo de Fisher-Yates para barajar
        for (int i = cartas.tamaño() - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            Carta temp = cartas.obtener(i);
            cartas.establecer(i, cartas.obtener(j));
            cartas.establecer(j, temp);
        }
    }

    public boolean estaVacio() {
        return cartas.estaVacia();
    }

    /**
     * Devuelve el número de cartas restantes en el mazo
     * @return cantidad de cartas en el mazo
     */
    public int tamaño() {
        return cartas.tamaño();
    }
}
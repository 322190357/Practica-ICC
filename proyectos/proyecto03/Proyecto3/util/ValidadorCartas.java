package util;

import modelo.Carta;

/**
 * Valida las diferencias entre cartas según las reglas del juego.
 */
public class ValidadorCartas {

    /**
     * Verifica si una carta puede seguir a otra en la secuencia.
     * @param actual Carta actual en la secuencia (null si es la primera).
     * @param siguiente Carta candidata a ser agregada.
     * @return true si son iguales o tienen exactamente 1 diferencia.
     */
    public static boolean esValida(Carta actual, Carta siguiente) {
        // Primera carta de la secuencia siempre es válida
        if (actual == null) return true; 

        int diferencias = 0;

        // Comparar cada atributo
        if (actual.getFondo() != siguiente.getFondo()) diferencias++;
        if (actual.getValor() != siguiente.getValor()) diferencias++;
        if (actual.getPalo() != siguiente.getPalo()) diferencias++;
        if (actual.getColorElemento() != siguiente.getColorElemento()) diferencias++;
        if (actual.getEstiloValor() != siguiente.getEstiloValor()) diferencias++;

        return diferencias == 0 || diferencias == 1;
    }
}
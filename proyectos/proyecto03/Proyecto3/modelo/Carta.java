package modelo;

import java.util.Objects;

public class Carta {
    public enum Fondo { NEGRO, BLANCO }
    public enum Palo { CORAZONES, TREBOLES, PICAS, DIAMANTES }
    public enum ColorElemento { ROJO, AZUL }
    public enum EstiloValor { CON_LINEAS, SIN_LINEAS }

    private final Fondo fondo;
    private final int valor; // 1-13 (As = 1, Rey = 13)
    private final Palo palo;
    private final ColorElemento colorElemento;
    private final EstiloValor estiloValor;

    public Carta(Fondo fondo, int valor, Palo palo, 
                 ColorElemento colorElemento, EstiloValor estiloValor) {
        this.fondo = fondo;
        this.valor = valor;
        this.palo = palo;
        this.colorElemento = colorElemento;
        this.estiloValor = estiloValor;
    }

    // Getters (necesarios para comparaciones)
    public Fondo getFondo() { return fondo; }
    public int getValor() { return valor; }
    public Palo getPalo() { return palo; }
    public ColorElemento getColorElemento() { return colorElemento; }
    public EstiloValor getEstiloValor() { return estiloValor; }

    // Para comparar igualdad entre cartas (crítico para el juego)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return valor == carta.valor &&
               fondo == carta.fondo &&
               palo == carta.palo &&
               colorElemento == carta.colorElemento &&
               estiloValor == carta.estiloValor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fondo, valor, palo, colorElemento, estiloValor);
    }

    // Representación visual básica (útil para debug)
    @Override
    public String toString() {
        String valorStr = switch (valor) {
            case 1 -> "A";
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            default -> String.valueOf(valor);
        };
        return String.format("%s-%s-%s-%s-%s", 
            fondo, valorStr, palo, colorElemento, estiloValor);
    }
}
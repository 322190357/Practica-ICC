package util;

import java.util.Iterator;

/**
 * Implementación personalizada de una lista enlazada simple.
 * @param <T> Tipo de elementos almacenados.
 */
public class ListaPersonalizada<T> implements Iterable<T> {
    private Nodo<T> cabeza;
    private int tamaño;

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;
        
        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public ListaPersonalizada() {
        cabeza = null;
        tamaño = 0;
    }

    /**
     * Agrega un elemento al final de la lista.
     * @param elemento Elemento a agregar.
     */
    public void agregar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamaño++;
    }

    /**
     * Agrega todos los elementos de otra lista a esta lista.
     * @param otraLista Lista cuyos elementos se agregarán.
     */
    public void agregarTodos(ListaPersonalizada<T> otraLista) {
        if (otraLista == null || otraLista.estaVacia()) return;
        
        Nodo<T> actual = otraLista.cabeza;
        while (actual != null) {
            this.agregar(actual.dato);
            actual = actual.siguiente;
        }
    }

    /**
     * Elimina un elemento por índice.
     * @param indice Posición a eliminar (0-based).
     * @return Elemento eliminado.
     * @throws IndexOutOfBoundsException Si el índice es inválido.
     */
    public T eliminar(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }

        T datoEliminado;
        if (indice == 0) {
            datoEliminado = cabeza.dato;
            cabeza = cabeza.siguiente;
        } else {
            Nodo<T> anterior = obtenerNodo(indice - 1);
            datoEliminado = anterior.siguiente.dato;
            anterior.siguiente = anterior.siguiente.siguiente;
        }
        tamaño--;
        return datoEliminado;
    }

    /**
     * Obtiene un elemento por índice.
     * @param indice Posición a obtener (0-based).
     * @return Elemento en la posición.
     * @throws IndexOutOfBoundsException Si el índice es inválido.
     */
    public T obtener(int indice) {
        return obtenerNodo(indice).dato;
    }

    private Nodo<T> obtenerNodo(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }

        Nodo<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual;
    }

    /**
     * Verifica si la lista contiene un elemento.
     * @param elemento Elemento a buscar.
     * @return true si existe.
     */
    public boolean contiene(T elemento) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(elemento)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    /**
     * Reemplaza el elemento en un índice.
     * @param indice Posición a reemplazar.
     * @param nuevoElemento Nuevo valor.
     */
    public void establecer(int indice, T nuevoElemento) {
        Nodo<T> nodo = obtenerNodo(indice);
        nodo.dato = nuevoElemento;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public int tamaño() {
        return tamaño;
    }

    /**
     * Implementación de Iterable para permitir for-each
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> actual = cabeza;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                T dato = actual.dato;
                actual = actual.siguiente;
                return dato;
            }
        };
    }

    // Para depuración
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Nodo<T> actual = cabeza;
        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) sb.append(", ");
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}
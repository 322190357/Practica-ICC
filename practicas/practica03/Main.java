public class Main {

    private Nodo cabeza;

    private class Nodo {
        private int elemento;
        private Nodo siguiente;

        public Nodo(int elemento) {
            this.elemento = elemento;
        }
    }

    public int longitud() {
        Nodo auxiliar = cabeza;
        int i = 0;
        for (; auxiliar != null; i++) {
            auxiliar = auxiliar.siguiente;
        }
        return i;
    }

    public void listaVacia() {
        cabeza = null;
    }

    public boolean esvacia() {
        if (cabeza == null)
            return true;
        else {
            return false;
        }
    }

    public void insertar(int elemento) {
        // Verificar si nuestra lista esta vacía
        if (esvacia() == true) {
            cabeza = new Nodo(elemento);
            return;
        }

        // Iterar hasta encontrar el último elemento
        Nodo auxiliar = cabeza;
        while (auxiliar.siguiente != null) {
            auxiliar = auxiliar.siguiente;
        }
        auxiliar.siguiente = new Nodo(elemento);
    }

    public void eliminar(int elemento) {
        // Verificar si nuestra lista esta vacía
        if (esvacia() == true)
            return;

        // Si cabeza es el nodo que queremos eliminar
        if (cabeza.elemento == elemento) {
            cabeza = cabeza.siguiente;
            return;
        }

        // Iterar hasta encontrar un nodo antes del que queremos eliminar
        Nodo auxiliar = cabeza;
        while (auxiliar.siguiente != null) {
            if (auxiliar.siguiente.elemento == elemento) {
                auxiliar.siguiente = auxiliar.siguiente.siguiente;
            }
            auxiliar = auxiliar.siguiente;
        }
    }

    public void insertarIndice(int elemento, int indice) {
        // Verificar si nuestra lista esta vacía
        if (esvacia() == true)
            return;

        Nodo auxiliar = cabeza;
        // Valores validos dentro del rango
        if (indice >= 0 && indice <= longitud() - 1) {
            System.out.println("Es admitido el valor del indice");
            //Iterar hasta encontrar el indice
            for (int i = indice; i > 1; i--){
                auxiliar = auxiliar.siguiente;
            }
        Nodo nuevo = new Nodo(elemento);
        nuevo.siguiente = auxiliar.siguiente;
        auxiliar.siguiente = nuevo;
        }
        else {
            System.out.println("No es valido el indice, ya que " + indice + " es mayor que " + (longitud()-1));
        } 

    }

    public String toString() {
        // Verificar si la lista esta vacía
        if (esvacia() == true) {
            return "La lista es vacía";
        }

        String cadena = "[";
        Nodo auxiliar = cabeza;

        while (auxiliar != null) {
            cadena = cadena + auxiliar.elemento;
            cadena += (" -> ");
            auxiliar = auxiliar.siguiente;
        }
        cadena += null;
        cadena += "]";
        return cadena;
    }

    public static void main(String[] args) {
        // Declararamos una lista
        Main lista = new Main();

        // Imprime como se ve la lista, es decir vacía
        System.out.println(lista);

        // Insertar 5 elementos
        lista.insertar(23);
        lista.insertar(4);
        lista.insertar(74);
        lista.insertar(32);
        lista.insertar(11);

        // Imprimir como es ve la lista
        System.out.println(lista);

        // Eliminar la cabeza
        lista.eliminar(23);

        // Imprimi como se ve la lista
        System.out.println(lista);

        // Eliminar un elemento que no sea la cabeza ni el elemento final de su lista
        lista.eliminar(74);

        // Imprimir como se ve la lista
        System.out.println(lista);

        // Tamaño de la lista
        System.out.println("La lista mide: " + lista.longitud());

        // Prueba de insertarindice con un elemento que no sea 0 y sea valido
        lista.insertarIndice(9, 2);

        // Imprimir como se ve la lista
        System.out.println(lista);

        // Tamaño de la lista
        System.out.println("La lista mide: " + lista.longitud());

        // Prueba de insertarindice con un elemento que no sea valido
        lista.insertarIndice(23,5);

        // Imprimir como se ve la lista
        System.out.println(lista);
    }
}
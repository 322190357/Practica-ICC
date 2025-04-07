import java.util.Scanner;

public class Esteganografia {

    // Normaliza: quita acentos, convierte a minúsculas y elimina signos (incluye
    // comillas)
    private String normaliza(String texto) {
        texto = texto.toLowerCase();
        texto = texto.replace("á", "a")
                .replace("é", "e")
                .replace("í", "i")
                .replace("ó", "o")
                .replace("ú", "u")
                .replace("ñ", "n")
                .replaceAll("[\"']", "") // remueve comillas
                .replaceAll("[^a-z0-9]", ""); // deja solo letras y números
        return texto;
    }

    private String limpiaPalabra(String palabra) {
        return palabra.replaceAll("[\"']", ""); // remueve comillas individuales y dobles
    }

    public String descifraNulo(String original, int n) {
        StringBuilder resultado = new StringBuilder();
        int posicionReal = n - 1;

        try (Scanner sc = new Scanner(original)) {
            while (sc.hasNext()) {
                String palabra = limpiaPalabra(sc.next());
                if (posicionReal < palabra.length()) {
                    resultado.append(palabra.charAt(posicionReal));
                }
            }
        }

        return resultado.toString();
    }

    public String descifraNulo(String original) {
        int n = 0;
        int i = original.length() - 1;
        while (i >= 0 && original.charAt(i) == ' ') {
            n++;
            i--;
        }
        return descifraNulo(original.substring(0, original.length() - n), n);
    }

    public boolean contieneNombre(String mensaje, String nombre) {
        String limpioMensaje = normaliza(mensaje);
        String limpioNombre = normaliza(nombre);
        return limpioMensaje.contains(limpioNombre);
    }

    public String descifraPalabrasMarcadas(String m, String e) {
        StringBuilder resultado = new StringBuilder();

        try (Scanner scM = new Scanner(m); Scanner scE = new Scanner(e)) {
            while (scM.hasNext() && scE.hasNext()) {
                String palabraM = limpiaPalabra(scM.next());
                String palabraE = limpiaPalabra(scE.next());
                if (!palabraM.equals(palabraE)) {
                    resultado.append(palabraM).append(" ");
                }
            }
        }

        return resultado.toString().trim();
    }

    public String descifraLetrasMarcadas(String m, String e) {
        StringBuilder resultado = new StringBuilder();

        try (Scanner scM = new Scanner(m); Scanner scE = new Scanner(e)) {
            while (scM.hasNext() && scE.hasNext()) {
                String palabraM = limpiaPalabra(scM.next());
                String palabraE = limpiaPalabra(scE.next());

                for (int i = 0; i < palabraM.length() && i < palabraE.length(); i++) {
                    if (palabraM.charAt(i) != palabraE.charAt(i)) {
                        resultado.append(palabraM.charAt(i));
                    }
                }
            }
        }

        return resultado.toString();
    }

    public static void main(String[] args) {
        Esteganografia est = new Esteganografia();
        try (Scanner sc = new Scanner(System.in)) {
            int opcion;

            do {
                System.out.println("\n=== Menú Esteganografía ===");
                System.out.println("1. Descifrar n-ésima letra (con n)");
                System.out.println("2. Descifrar n-ésima letra (sin n)");
                System.out.println("3. Buscar nombre oculto");
                System.out.println("4. Descifrar palabras marcadas");
                System.out.println("5. Descifrar letras marcadas");
                System.out.println("6. Salir");
                System.out.print("Elige una opción: ");

                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Mensaje original: ");
                        String entrada1 = sc.nextLine();
                        System.out.print("Valor de n: ");
                        int n = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Mensaje oculto: " + est.descifraNulo(entrada1, n));
                    }

                    case 2 -> {
                        System.out.print("Mensaje con espacios finales: ");
                        String entrada2 = sc.nextLine();
                        System.out.println("Mensaje oculto: " + est.descifraNulo(entrada2));
                    }

                    case 3 -> {
                        System.out.print("Texto completo: ");
                        String texto = sc.nextLine();
                        System.out.print("Nombre a buscar: ");
                        String nombre = sc.nextLine();
                        System.out.println("Resultado: " + est.contieneNombre(texto, nombre));
                    }

                    case 4 -> {
                        System.out.print("Texto M: ");
                        String m = sc.nextLine();
                        System.out.print("Texto E: ");
                        String e = sc.nextLine();
                        System.out.println("Mensaje oculto: " + est.descifraPalabrasMarcadas(m, e));
                    }

                    case 5 -> {
                        System.out.print("Texto M: ");
                        String m5 = sc.nextLine();
                        System.out.print("Texto E: ");
                        String e5 = sc.nextLine();
                        System.out.println("Mensaje oculto: " + est.descifraLetrasMarcadas(m5, e5));
                    }
                }
            } while (opcion != 6);
        }
        System.out.println("Saliendo del programa...");
    }
}
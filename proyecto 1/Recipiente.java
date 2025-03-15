public class Recipiente implements ServiciosRecipiente {
    private final double altura;
    private final double radio;
    private final double capacidad;
    private double cantidadActual;

    public Recipiente(double altura, double radio, double cantidadActual) {
        this.altura = altura;
        this.radio = radio;
        this.capacidad = Math.PI * radio * radio * altura;
        this.cantidadActual = Math.max(0, Math.min(cantidadActual, this.capacidad));
    }

    public double capacidad() {
        return capacidad;
    }

    public double capacidadRestante() {
        return capacidad - cantidadActual;
    }

    public boolean estaVacio() {
        if (cantidadActual == 0){
            return true;
        }
        else return false;
    }

    public boolean estaLleno() {
        if ((Math.abs(cantidadActual - capacidad)) == 0){
            return true;
        }
        else return false;
    }

    public double rellena(double cantidad) {
        double espacio = capacidadRestante();
        double agregar = Math.min(espacio, cantidad);
        cantidadActual += agregar;
        cantidadActual = Math.min(capacidad, cantidadActual);
        return cantidad - agregar;
    }

    public double vacia() {
        double anterior = cantidadActual;
        cantidadActual = 0;
        return anterior;
    }

    public void vierte(Recipiente otro) {
        double cantidadTransferible = Math.min(this.cantidadActual, otro.capacidadRestante());
        this.cantidadActual -= cantidadTransferible;
        otro.cantidadActual += cantidadTransferible;
        this.cantidadActual = Math.max(0, this.cantidadActual);
        otro.cantidadActual = Math.min(otro.capacidad, otro.cantidadActual);
    }

    public boolean mismasDimensiones(Recipiente otro) {
        return Math.abs(this.altura - otro.altura) < 1e-9 &&
               Math.abs(this.radio - otro.radio) == 0;
    }

    public boolean mismaCapacidad(Recipiente otro) {
        return Math.abs(this.capacidad - otro.capacidad) == 0;
    }

    public boolean contieneMas(Recipiente otro) {
        return (this.cantidadActual - otro.cantidadActual) == 0;
    }

    public boolean cabeMas(Recipiente otro) {
        return (this.capacidadRestante() - otro.capacidadRestante()) > 1e-9;
    }

    public Recipiente creaContenedorJusto() {
        double nuevaCapacidad = this.cantidadActual;
        double nuevoRadio = this.radio;
        double nuevaAltura = nuevaCapacidad / (Math.PI * nuevoRadio * nuevoRadio);
        return new Recipiente(nuevaAltura, nuevoRadio, 0);
    }

    public String muestra() {
        return String.format("Recipiente [Altura: %.2f cm, Radio: %.2f cm, Capacidad: %.2f cm³, Actual: %.2f cm³]",
                altura, radio, capacidad, cantidadActual);
    }

    public static void main(String[] args) {
        Recipiente r1 = new Recipiente(10, 5, 0);
        Recipiente r2 = new Recipiente(5, 5, 0);

        System.out.println("=== Inicialización ===");
        System.out.println(r1.muestra());
        System.out.println(r2.muestra());

        System.out.println("\n=== Probando rellena ===");
        double excedente = r1.rellena(500);
        System.out.printf("R1 rellenado con 500. Excedente: %.2f%n", excedente);
        System.out.println(r1.muestra());

        excedente = r1.rellena(300);
        System.out.printf("R1 rellenado con 300. Excedente: %.2f%n", excedente);
        System.out.println(r1.muestra());

        System.out.println("\n=== Probando vierte ===");
        System.out.println("Antes de verter:");
        System.out.println(r1.muestra());
        System.out.println(r2.muestra());
        r1.vierte(r2);
        System.out.println("Después de verter:");
        System.out.println(r1.muestra());
        System.out.println(r2.muestra());

        System.out.println("\n=== Probando vacia ===");
        double vaciado = r2.vacia();
        System.out.printf("Vaciado de r2: %.2f%n", vaciado);
        System.out.println(r2.muestra());

        System.out.println("\n=== Probando creaContenedorJusto ===");
        Recipiente r3 = r1.creaContenedorJusto();
        System.out.println(r3.muestra());

        System.out.println("\n=== Probando comparaciones ===");
        Recipiente r4 = new Recipiente(10, 5, 0);
        System.out.println("Mismas dimensiones r1 y r4: " + r1.mismasDimensiones(r4));
        System.out.println("Misma capacidad r1 y r3: " + r1.mismaCapacidad(r3));

        System.out.println("\n=== Probando contieneMas y cabeMas ===");
        r2.rellena(200);
        System.out.println("¿r1 contiene más que r2? " + r1.contieneMas(r2));
        System.out.println("¿r2 cabe más que r1? " + r2.cabeMas(r1));
    }
}
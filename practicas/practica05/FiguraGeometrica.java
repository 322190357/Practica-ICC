abstract class FiguraGeometrica  {
    protected int numeroLados;

    public FiguraGeometrica(int numeroLados)  {
        this.numeroLados = numeroLados;
    }

    public abstract double calcularArea();
    public abstract double calcularPerimetro();
    public abstract String toString();

    public static void main(String[] args) {
        FiguraGeometrica triangulo = new Triangulo(3, 4, 5, 3, 4);

        // crear un rectángulo de dos formas distintas 
        // Rectangulo rectangulo1 = ...
        FiguraGeometrica rectangulo1 = new Rectangulo (2, 5);
        // Rectangulo rectangulo2 = ...,
        Rectangulo rectangulo2 = new Cuadrado (6);

        // crear un cuadrado :)
        FiguraGeometrica cuadrado = new Cuadrado (3);

        // TODO: crear arreglo de FiguraGeometrica[] con todas las figuras
        // TODO: recorrer el arreglo e imprimir área y perímetro (polimorfismo)

        // Ejemplo con solo el triángulo
        System.out.println(triangulo);
        System.out.println("Area: " + triangulo.calcularArea());
        System.out.println("Perimetro: " + triangulo.calcularPerimetro());
        System.out.println(rectangulo1);
        System.out.println("Area: " + rectangulo1.calcularArea());
        System.out.println("Perimetro: " + rectangulo1.calcularPerimetro());
        System.out.println(cuadrado);
        System.out.println("Area: " + cuadrado.calcularArea());
        System.out.println("Perimetro: " + cuadrado.calcularPerimetro());
    }

}

    class Triangulo extends FiguraGeometrica{
        private final double lado1;
        private final double lado2;
        private final double lado3;
        private final double base;
        private final double altura;

        public Triangulo (double lado1, double lado2, double lado3, double base, double altura){
            super(3);
            this.lado1 = lado1;
            this.lado2 = lado2;
            this.lado3 = lado3;
            this.base = base;
            this.altura = altura;
        }

        public double calcularArea(){
            return (base * altura) / 2;
        }

        public double calcularPerimetro(){
            return lado1 + lado2 + lado3;
        }

        @Override
    public String toString() {
        return String.format("Triangulo de lados %.1f, %.1f, %.1f (base=%.1f, altura=%.1f)",
                lado1, lado2, lado3, base, altura);
    }
    }

// Clase Rectangulo
    class Rectangulo extends FiguraGeometrica {
    private final double lado1;
    private final double lado2;
    protected final double base;
    protected final double altura;

    public Rectangulo(double lado1, double lado2) {
        super(4);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.base = lado1;
        this.altura = lado2;
    }

    public double calcularArea(){
        return base * altura;
    }

    public double calcularPerimetro(){
        return 2*(lado1 + lado2);
    }

     //implementar toString()  
     
     public String toString() {
         return String.format("Rectangulo de lados %.1f, %.1f (base=%.1f, altura=%.1f)",
                 lado1, lado2, base, altura);
     }
}

//  Clase Cuadrado
    class Cuadrado extends Rectangulo {
    private final double lado;
    protected final double base;
    protected final double altura;

    public Cuadrado(double lado) {
        super(lado, lado);
        this.lado = lado;
        this.base = lado;
        this.altura = lado;
    }

    public double calcularArea(){
        return lado * lado;
    }

    public double calcularPerimetro(){
        return 4*lado;
    }

     //implementar toString()  
     @Override
     public String toString() {
         return String.format("Cuadrado de lados %.1f, %.1f, %.1f, %.1f (base=%.1f, altura=%.1f)",
                 lado, lado, lado, lado, base, altura);
     }
}


   

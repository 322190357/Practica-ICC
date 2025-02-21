import java.util.Scanner;
public class Main {
    public static void main (String []args){
		System.out.println("--------------------");
		System.out.println("-    CALCULADORA   -");
		System.out.println("--------------------");
        System.out.println("Seleciona el número para la opción que desea ocupar" );
        System.out.println("1. SUMA");
        System.out.println("2. MULTIPLICACIÓN");
        System.out.println("3. DIVISIÓN");
        System.out.println("4. UNIÓN DE LETRAS");
        Scanner scanner = new Scanner(System.in);
        int opc = scanner.nextInt();
        scanner.nextLine();
        if (opc==1){
            System.out.println("Selecionaste suma");
            System.out.println("Ingrese número");
            double num1 = scanner.nextDouble();
            System.out.println("Ingrese número");
            double num2 = scanner.nextDouble();
            double suma = num1 + num2;
            System.out.println("El resultado es: "+ suma);
        }
        else if (opc==2){
            System.out.println("Selecionaste multiplicación");
            System.out.println("Ingrese número");
            double num1 = scanner.nextDouble();
            System.out.println("Ingrese número");
            double num2 = scanner.nextDouble();
            double multi = num1 * num2;
            System.out.println("El resultado es: "+ multi);
        }
        else if (opc==3){
            System.out.println("Selecionaste división");
            System.out.println("Ingrese número");
            double num1 = scanner.nextDouble();
            System.out.println("Ingrese número");
            double num2 = scanner.nextDouble();
            double divi = num1 / num2;
            System.out.println("El resultado es: "+ divi);
        }
        else if (opc ==4){
            System.out.println("Selecionaste Unión de letra");
            System.out.println("Ingresa una tecla de tu teclado que puedes teclear telcleando");
            String tec1 = scanner.nextLine();
            System.out.println("Inngresa una tecla de tu teclado que puedes teclear telcleando");
            String tec2 = scanner.nextLine();
            System.out.println("El resultado es: "+ tec1 + tec2);
        }
        else {
            System.out.println("Ingresaste una opción invalida");
        }
        scanner.close();
    }
    
    
}
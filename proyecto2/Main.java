import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    while (true) {
            System.out.println("\n Menú de simulación");
            System.out.println("1. Usar ciclo for");
            System.out.println("2. Usar ciclo while");
            System.out.println("3. Usar ciclo do-while");
            System.out.println("4. Salir");
            System.out.println("Seleccione opción");

            switch (scanner.nextInt()) {
                case 1:
                    Main main1 = new Main (23,59,55);
                    System.out.println("Simulación con for:");
                    for (int i = main1.segundo; i<60 || !main1.MostrarHora().equals("00:00:00"); i++) {
                        main1.IncrementaSegundo();  
                        System.out.println(main1.MostrarHora()); 
                    }
                    break;   
                case 2:
                    Main main2 = new Main (23,59,55);
                    System.out.println("Simulación con While:");
                    while (!main2.MostrarHora().equals ("00:00:00")){
                        main2.IncrementaSegundo();
                        System.out.println(main2.MostrarHora());
                    }
                    break;
                case 3:
                    Main main = new Main (23,59,55);
                    System.out.println("Simulación con do while:");
                    do {
                        main.IncrementaSegundo();
                        System.out.println(main.MostrarHora());
                    } while (!main.MostrarHora().equals ("00:00:00"));
                    break;        
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Opción invalida");
            
            }


        } 

    }
        private int hora;
        private int minuto;
        private int segundo;

    public Main (int hora, int minuto, int segundo){
        if (hora >= 0 && hora < 24){
            this.hora = hora;
        }
        else {
            System.out.println ("Hora invalida");
            this.hora = 0;
        }

        if (minuto >= 0 && minuto < 60){
            this.minuto = minuto;
        }
        else {
            System.out.println("Minuto invalido");
            this.minuto = 0;
        }

        if (segundo >= 0 && segundo < 60){
            this.segundo = segundo;
        }
        else {
            System.out.println("Segundo invalido");
            this.segundo = 0;
        }
    }

    public void IncrementaHora (){
        hora = (hora + 1)%24; 
    } 

    public void IncrementaMinuto (){
        minuto++;
        if (minuto >= 60){
            minuto = 0;
            IncrementaHora();
        } 
    }

    public void IncrementaSegundo (){
        segundo += 1;
            if (segundo >= 60){
                segundo = 0;
                IncrementaMinuto();
            }
    }

    public String MostrarHora (){
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }
} 
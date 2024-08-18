import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        //obtencion y convercion de vueltas
        Scanner scanner = new Scanner(System.in);
        System.out.print("Vueltas de fibonacci: ");
        String vueltas = scanner.nextLine(); 
        int cantVueltas = Integer.parseInt(vueltas);
        scanner.close();

        //secuencia de Fibonacci

        if (cantVueltas >= 1){ 
            System.out.print(0);
            System.out.print(" ");
            if(cantVueltas >= 2){ 
                System.out.print(1);
                System.out.print(" ");
                Obtenerfibonacci(cantVueltas - 2,1,0);
            }
        }else{
            System.out.println("La cantidad de vueltas debe ser un entero mayor a 0");
        }
    }

    public static int Obtenerfibonacci(int VueltasRestantes, int numA, int numB) {
        if (VueltasRestantes == 1) {
            System.out.print(numA + numB);
            return (numA + numB);  
        } else if(VueltasRestantes > 1){
            System.out.print(numA + numB);
            System.out.print(" ");
            return numA + Obtenerfibonacci(VueltasRestantes - 1, numA + numB, numA);  // Llamada recursiva.
        }
        return -1;
    }
}
 
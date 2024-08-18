import java.util.Scanner;

public class fibonacci {
    public static int[] fiboSalida;
    public static int indice = 0;

    public static void main(String[] args) {
        //obtencion y convercion de vueltas
        Scanner scanner = new Scanner(System.in);
        System.out.print("Vueltas de fibonacci: ");
        String vueltas = scanner.nextLine(); 
        int cantVueltas = Integer.parseInt(vueltas);
        scanner.close();

        //secuencia de Fibonacci

        if (cantVueltas >= 1){ 
            fiboSalida = new int[cantVueltas];
            fiboSalida[indice] = 0;
            if(cantVueltas >= 2){ 
                indice++;
                fiboSalida[indice] = 1;
                Obtenerfibonacci(cantVueltas - 2,1,0);
            }
            imprimirFibo();
        }else{
            System.out.println("La cantidad de vueltas debe ser un entero mayor a 0");
        }
    }

    public static int Obtenerfibonacci(int VueltasRestantes, int numA, int numB) {
        indice++;
        if (VueltasRestantes == 1) {
            fiboSalida[indice] = numA + numB;
            return (numA + numB);  
        } else if(VueltasRestantes > 1){
            fiboSalida[indice] = numA + numB;
            return numA + Obtenerfibonacci(VueltasRestantes - 1, numA + numB, numA);  // Llamada recursiva.
        }
        return -1;
    }

    public static void imprimirFibo() {
        for (int vuelta = 0; vuelta < fiboSalida.length; vuelta++) {
            System.out.print(fiboSalida[vuelta]);
            System.out.print(" ");
        }
    }
}
import java.util.Scanner;

public class fibonacci {
    private static int[] fiboSalida;
    public static int indice = 0;

    public static void main(String[] args) {
        calcularFibonacci();
        getNumeroDeOro();
    }

    public static void calcularFibonacci() {
        try {
            //obtencion y convercion de vueltas
            Scanner scanner = new Scanner(System.in);
            System.out.print("Vueltas de fibonacci: ");
            String vueltas = scanner.nextLine(); 
            int cantVueltas = Integer.parseInt(vueltas);
            scanner.close();

            //calculo de fibonacci
            getFibonacci(cantVueltas);
        } catch (NumberFormatException e) {
            // Capturar la excepción si el String no es un número entero válido
            System.out.println("La cantidad de vueltas posee un formato invatido.");
        }
    }

    public static int[] getFibonacci(int cantVueltas) {
        //secuencia de Fibonacci
        try {
            if (cantVueltas >= 1){ 
                if (cantVueltas >= 48) { 
                    throw new fibonacciException("La cantidad de vueltas debe ser menor que 48, debido a que se sobrepasa el valor que pueden almacenar los datos tipo int.\n");
                }
                fiboSalida = new int[cantVueltas];
                fiboSalida[0] = 0;
                if(cantVueltas >= 2){ 
                    indice = 1;
                    fiboSalida[indice] = 1;
                    Obtenerfibonacci(cantVueltas - 2,1,0);
                }
                imprimirFibo();
            }else{
                throw new fibonacciException("La cantidad de vueltas debe ser un entero mayor a 0.");
            }
            return fiboSalida;
        } catch (fibonacciException e) {
            System.out.println(e.getMessage() + " Por lo cual no puede ser " + cantVueltas + ".");
            return null;
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
            System.out.print(Integer.toString(fiboSalida[vuelta]) + " ");
        }
    }

    public static float getNumeroDeOro() {
        float fiboMax =  fiboSalida[fiboSalida.length-1];
        float fiboMaxMenos1 = fiboSalida[fiboSalida.length-2];
        float numOro = fiboMax/fiboMaxMenos1;
        System.out.print("\nEl numero de oro obtenido con este largo de la secuencia de fibonacci es " + numOro);
        return numOro;
    }
}
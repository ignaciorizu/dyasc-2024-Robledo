package ar.edu.untref.dyasc;
import java.util.Scanner;

public class fibonacci {
    private static int[] fiboSalida;
    public static int indice = 0;
    public static boolean falla = false;

    public static void main(String[] args) {
        calcularFibonacci();
        if (args.length > 0 && args[0].equals("oro")){
            getNumeroDeOro();
        }
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
            falla = true;
            System.out.println("La cantidad de vueltas posee un formato invatido.");
        }
    }

    public static int[] getFibonacci(int cantVueltas) {
        //secuencia de Fibonacci
        try {
            falla = false;
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
            falla = true;
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
        try{
            if (falla) {
                throw new fibonacciException("");
            }
            float fiboMax =  fiboSalida[fiboSalida.length-1];
            float numOro = fiboMax;
            if (fiboSalida.length > 2){
                float fiboMaxMenos1 = fiboSalida[fiboSalida.length-2];
                numOro = fiboMax/fiboMaxMenos1;
            }
            System.out.print("\nEl numero de oro obtenido con este largo de la secuencia de fibonacci es " + numOro);
            return numOro;
        }catch (fibonacciException e){
            //Si hay un error por el cual no se pudo obtener la ultima secuencia fibonacci no obtengo el numero de oro, 
            //porque o ni bien no se ejecuto la clase ni una vez bien o hubo una cant de vueltas invalida por el tipo de dato o no estar entre 1 y 47.
        }
        return -1;
    }
}
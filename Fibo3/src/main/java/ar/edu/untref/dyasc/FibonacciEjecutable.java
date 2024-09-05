package ar.edu.untref.dyasc;

public class FibonacciEjecutable {
    public static void main(String[] args) {
        fibonacciMain(args);
    }

    public static int[] fibonacciMain(String[] args){
        try{
            OpcionesFibonacci opciones = new OpcionesFibonacci(args);
            Fibonacci fibo = new Fibonacci();
            int[] fibonacci = fibo.obtenerFibonacci(opciones.obtenerVueltas());
            FibonacciImpresion impresion = new FibonacciImpresion(fibonacci, opciones);
            impresion.imprimir();
            return fibonacci;
        } catch(FibonacciException e){
            System.out.println(e.getMessage());
        }
        return null;
    } 
}

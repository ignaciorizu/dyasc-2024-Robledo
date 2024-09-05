package java.ar.edu.untref.dyasc;

public class FibonacciEjecutable {
    public static void main(String[] args) {
        try{
            OpcionesFibonacci opciones = new OpcionesFibonacci(args);
            Fibonacci fibo = new Fibonacci();
            int[] fibonacci = fibo.obtenerFibonacci(opciones.obtenerVueltas());
            FibonacciImpresion impresion = new FibonacciImpresion(fibonacci, opciones);
            impresion.imprimir();
        } catch(FibonacciException e){
            System.out.println(e.getMessage());
        }
    }
}

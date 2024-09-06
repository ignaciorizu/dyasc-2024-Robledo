package ar.edu.untref.dyasc;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class testFibonacciOro {

    FibonacciEjecutable fiboExe = new FibonacciEjecutable();
   
    /*Prueba del numero de oro 1
     * caso 1: con cantVueltas = 1. Como necesita 2 numeros se especifico que por defecto las 2 primeras vueltas se quedara con el valor más alto de la serie.
     * Se prueba el correcto funcionamiento de buscarOro()
    */
    @SuppressWarnings("static-access")
    @Test
    public void testNumOro1() throws FibonacciException {
        String[] parametros = {"1","oro"};
        int[] fibo = fiboExe.fibonacciMain(parametros); //{0}
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        FibonacciImpresion fiboImp = new FibonacciImpresion(fibo,opciones);
        float resultado = fiboImp.calcularNumeroDeOro();
        float esperado = 0;
        assertTrue(opciones.buscarOro());
        assertEquals(esperado, resultado, 0.0001f);
    }
    
    /*Prueba del numero de oro 2
     * caso 2: cantVueltas = 2. Como el 1/0 no se puede hacer se utiliza el mismo criterio que el caso 1.
     * Se prueba el correcto funcionamiento de buscarOro()
    */
    @SuppressWarnings("static-access")
    @Test
    public void testNumOro2() throws FibonacciException {
        String[] parametros = {"2","oro"};
        int[] fibo = fiboExe.fibonacciMain(parametros); //{0, 1}
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        FibonacciImpresion fiboImp = new FibonacciImpresion(fibo,opciones);
        float resultado = fiboImp.calcularNumeroDeOro();
        float esperado = 1;
        assertTrue(opciones.buscarOro());
        assertEquals(esperado, resultado, 0.0001f);
    }
    
    /*Prueba del numero de oro 3
     * Caso general
     * Se prueba el correcto funcionamiento de buscarOro()
    */
    @SuppressWarnings("static-access")
    @Test
    public void testNumOro() throws FibonacciException {
        String[] parametros = {"8","oro"}; //{0, 1, 1, 2, 3, 5, 8, 13}
        int[] fibo = fiboExe.fibonacciMain(parametros); 
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        FibonacciImpresion fiboImp = new FibonacciImpresion(fibo,opciones);
        float resultado = fiboImp.calcularNumeroDeOro();
        float esperado = (float) 13/ (float) 8;
        assertTrue(opciones.buscarOro());
        assertEquals(esperado, resultado, 0.0001f);
    } 
    
    /*Prueba del numero de oro 4
     * Caso de falla, donde no hay oro y se trata de obtener. Devido a una mala escritura de la opcion
    */
    @SuppressWarnings("static-access")
    @Test
    public void testErrorNumOro() throws FibonacciException {
        String[] parametros = {"8","noro"}; //{0, 1, 1, 2, 3, 5, 8, 13}
        int[] fibo = fiboExe.fibonacciMain(parametros); 
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        FibonacciImpresion fiboImp = new FibonacciImpresion(fibo,opciones);
        fiboImp.calcularNumeroDeOro();
        assertFalse(opciones.buscarOro());
    } 
}
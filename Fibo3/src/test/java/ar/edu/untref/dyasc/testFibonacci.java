package ar.edu.untref.dyasc;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class testFibonacci {

    FibonacciEjecutable fiboExe = new FibonacciEjecutable();

    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 1.
     * caso default 1.
    */
    @SuppressWarnings("static-access")
    @Test
    public void testFibo1() {
        String[] parametros = {"1"};
        int[] resultado = fiboExe.fibonacciMain(parametros);
        int[] esperado = {0};
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 2.
     * caso default 2.
    */
    @SuppressWarnings("static-access")
    @Test
    public void testFibo2() {
        String[] parametros = {"2"};
        int[] resultado = fiboExe.fibonacciMain(parametros);
        int[] esperado = {0, 1};
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 3.
     * prueba de recursividad sin necesidad de dar vueltas.
    */
    @SuppressWarnings("static-access")
    @Test
    public void testFibo3() {
        String[] parametros = {"3"};
        int[] resultado = fiboExe.fibonacciMain(parametros);
        int[] esperado = {0, 1, 1};
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 4.
     * prueba de utilizacion de recursividad.
    */
    @SuppressWarnings("static-access")
    @Test
    public void testFibo4() {
        String[] parametros = {"4"};
        int[] resultado = fiboExe.fibonacciMain(parametros);
        int[] esperado = {0, 1, 1, 2};
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 5.
     * prueba de cumplimiento con la condicion del trabajo 1.
    */
    @SuppressWarnings("static-access")
    @Test
    public void testFibo5() {
        String[] parametros = {"5"};
        int[] resultado = fiboExe.fibonacciMain(parametros);
        int[] esperado = {0, 1, 1, 2, 3};
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 8.
     * prueba de cumplimiento con la condicion del trabajo 2.
    */
    @SuppressWarnings("static-access")
    @Test
    public void testFibo8() {
        String[] parametros = {"8"};
        int[] resultado = fiboExe.fibonacciMain(parametros);
        int[] esperado = {0, 1, 1, 2, 3, 5, 8, 13};
        assertArrayEquals(esperado, resultado);
    }

    /*Prueba de falla 1. No se tienen que obtener el valor de fibonacci con cantVueltas menor a 1.
     * Prueba con cantVueltas = 0.
     */
    @SuppressWarnings("static-access")
    @Test
    public void testFallaFiboConCeroVueltas() {
        String[] parametros = {"0"};
        int[] resultado = fiboExe.fibonacciMain(parametros);
        assertNull("La cantidad de vueltas debe ser un entero mayor a 0. Por lo cual no puede ser 0.", resultado);
    }

    /*Prueba de falla 2. No se tienen que obtener el valor de fibonacci con cantVueltas menor a 1.
     * Prueba con valores negartivos. cantVueltas = -1.
     */
    @SuppressWarnings("static-access")
    @Test
    public void testFallaFiboConVueltasNegativas() {
        String[] parametros = {"-1"};
        int[] resultado = fiboExe.fibonacciMain(parametros);
        assertNull("La cantidad de vueltas debe ser un entero mayor a 0. Por lo cual no puede ser -1.", resultado);
    }

    /*Prueba de falla 3. No se tienen que obtener el valor de fibonacci con cantVueltas mayores o iguales a 48.
     * Prueba con cantVueltas = 48.
     */
    @SuppressWarnings("static-access")
    @Test
    public void testFallaFiboConVueltasMayores1() {
        String[] parametros = {"48"};
        int[] resultado = fiboExe.fibonacciMain(parametros);
        assertNull("La cantidad de vueltas debe ser menor que 48, debido a que se sobrepasa el valor que pueden almacenar los datos tipo int.\n" +
                        " Por lo cual no puede ser 48.", resultado);
    }

    /*Prueba de falla 3. No se tienen que obtener el valor de fibonacci con cantVueltas mayores o iguales a 48.
     * Prueba con cantVueltas = 48.
     */
    @SuppressWarnings("static-access")
    @Test
    public void testFallaFiboConVueltasMayores2() {
        String[] parametros = {"50"};
        int[] resultado = fiboExe.fibonacciMain(parametros);
        assertNull("La cantidad de vueltas debe ser menor que 48, debido a que se sobrepasa el valor que pueden almacenar los datos tipo int.\n" +
                        " Por lo cual no puede ser 50.", resultado);
    }
    
    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 47.
     * obtener el maximo valor posible de la secuencia con tipo de dato int.
    */
    @SuppressWarnings("static-access")
    @Test
    public void testFibo47() {
        String[] parametros = {"47"};
        int[] resultado = fiboExe.fibonacciMain(parametros);
        int[] esperado = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418,
            317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296,
             433494437, 701408733, 1134903170, 1836311903};
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba del numero de oro 1
     * caso 1: con cantVueltas = 1. Como necesita 2 numeros se especifico que por defecto las 2 primeras vueltas se quedara con el valor más alto de la serie.
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
        assertEquals(esperado, resultado, 0.0001f);
    }
    
    /*Prueba del numero de oro 2
     * caso 2: cantVueltas = 2. Como el 1/0 no se puede hacer se utiliza el mismo criterio que el caso 1.
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
        assertEquals(esperado, resultado, 0.0001f);
    }
    
    /*Prueba del numero de oro 3
     * Caso funcional
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
        assertEquals(esperado, resultado, 0.0001f);
    } 
    
    /*Prueba de direccion
     * prueba de impresion inversa
    */
    @SuppressWarnings("static-access")
    @Test
    public void testDireccionInversa() {
        String[] parametros = {"2","-o=ih"}; //{1 ,0}
        int[] resultado = fiboExe.fibonacciMain(parametros); 
        int[] esperado = {0,1};
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de direccion
     * prueba de impresion directa
    */
    @SuppressWarnings("static-access")
    @Test
    public void testDireccionDirecta() {
        String[] parametros = {"3","-o=dh"}; //{0, 1, 1}
        int[] resultado = fiboExe.fibonacciMain(parametros); 
        int[] esperado = {0,1,1};
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de direccion
     * prueba de impresion horizontal
    */
    @SuppressWarnings("static-access")
    @Test
    public void testDireccionHorizontal() {
        String[] parametros = {"4","-o=ih"}; //{0, 1}
        int[] resultado = fiboExe.fibonacciMain(parametros); 
        int[] esperado = {0,1,1,2};
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de direccion
     * prueba de impresion vertical
    */
    @SuppressWarnings("static-access")
    @Test
    public void testDireccionVertical() {
        String[] parametros = {"5","-o=ih"}; //{0, 1}
        int[] resultado = fiboExe.fibonacciMain(parametros); 
        int[] esperado = {0,1,1,2,3};
        assertArrayEquals(esperado, resultado);
    }  
}
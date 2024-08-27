package ar.edu.untref.dyasc;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class testFibonacci {

    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 1.
     * caso default 1.
    */
    @Test
    public void testFibo1() {
        int[] resultado = fibonacci.getFibonacci(1,"hd");
        int[] esperado = {0};
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 2.
     * caso default 2.
    */
    @Test
    public void testFibo2() {
        int[] resultado = fibonacci.getFibonacci(2,"hd");
        int[] esperado = {0, 1};
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 3.
     * prueba de recursividad sin necesidad de dar vueltas.
    */
    @Test
    public void testFibo3() {
        int[] resultado = fibonacci.getFibonacci(3,"hd");
        int[] esperado = {0, 1, 1};
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 4.
     * prueba de utilizacion de recursividad.
    */
    @Test
    public void testFibo4() {
        int[] resultado = fibonacci.getFibonacci(4,"hd");
        int[] esperado = {0, 1, 1, 2};
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 5.
     * prueba de cumplimiento con la condicion del trabajo 1.
    */
    @Test
    public void testFibo5() {
        int[] resultado = fibonacci.getFibonacci(5,"hd");
        int[] esperado = {0, 1, 1, 2, 3};
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 8.
     * prueba de cumplimiento con la condicion del trabajo 2.
    */
    @Test
    public void testFibo8() {
        int[] resultado = fibonacci.getFibonacci(8,"hd");
        int[] esperado = {0, 1, 1, 2, 3, 5, 8, 13};
        assertArrayEquals(esperado, resultado);
    }

    /*Prueba de falla 1. No se tienen que obtener el valor de fibonacci con cantVueltas menor a 1.
     * Prueba con cantVueltas = 0.
     */
    @Test
    public void testFallaFiboConCeroVueltas() {
        int[] resultado = fibonacci.getFibonacci(0,"hd");
        assertNull("La cantidad de vueltas debe ser un entero mayor a 0. Por lo cual no puede ser 0.", resultado);
    }

    /*Prueba de falla 2. No se tienen que obtener el valor de fibonacci con cantVueltas menor a 1.
     * Prueba con valores negartivos. cantVueltas = -1.
     */
    @Test
    public void testFallaFiboConVueltasNegativas() {
        int[] resultado = fibonacci.getFibonacci(-1,"hd");
        assertNull("La cantidad de vueltas debe ser un entero mayor a 0. Por lo cual no puede ser -1.", resultado);
    }

    /*Prueba de falla 3. No se tienen que obtener el valor de fibonacci con cantVueltas mayores o iguales a 48.
     * Prueba con cantVueltas = 48.
     */
    @Test
    public void testFallaFiboConVueltasMayores1() {
        int[] resultado = fibonacci.getFibonacci(48,"hd");
        assertNull("La cantidad de vueltas debe ser menor que 48, debido a que se sobrepasa el valor que pueden almacenar los datos tipo int.\n" +
                        " Por lo cual no puede ser 48.", resultado);
    }

    /*Prueba de falla 3. No se tienen que obtener el valor de fibonacci con cantVueltas mayores o iguales a 48.
     * Prueba con cantVueltas = 48.
     */
    @Test
    public void testFallaFiboConVueltasMayores2() {
        int[] resultado = fibonacci.getFibonacci(50,"hd");
        assertNull("La cantidad de vueltas debe ser menor que 48, debido a que se sobrepasa el valor que pueden almacenar los datos tipo int.\n" +
                        " Por lo cual no puede ser 50.", resultado);
    }
    
    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 47.
     * obtener el maximo valor posible de la secuencia con tipo de dato int.
    */
    @Test
    public void testFibo47() {
        int[] resultado = fibonacci.getFibonacci(47,"hd");
        int[] esperado = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418,
            317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296,
             433494437, 701408733, 1134903170, 1836311903};
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba del numero de oro 1
     * caso 1: con cantVueltas = 1. Como necesita 2 numeros se especifico que por defecto las 2 primeras vueltas se quedara con el valor más alto de la serie.
    */
    @Test
    public void testNumOro1() {
        fibonacci.getFibonacci(1,"hd"); //{0}
        float resultado = fibonacci.getNumeroDeOro();
        float esperado = 0;
        assertEquals(esperado, resultado, 0.0001f);
    }
    
    /*Prueba del numero de oro 2
     * caso 2: cantVueltas = 2. Como el 1/0 no se puede hacer se utiliza el mismo criterio que el caso 1.
    */
    @Test
    public void testNumOro2() {
        fibonacci.getFibonacci(8,"hd"); //{0, 1}
        float resultado = fibonacci.getNumeroDeOro();
        float esperado = (float) 13/ (float) 8;
        assertEquals(esperado, resultado, 0.0001f);
    }
    
    /*Prueba del numero de oro 3
     * Caso funcional
    */
    @Test
    public void testNumOro() {
        fibonacci.getFibonacci(8,"hd"); //{0, 1, 1, 2, 3, 5, 8, 13}
        float resultado = fibonacci.getNumeroDeOro();
        float esperado = (float) 13/ (float) 8;
        assertEquals(esperado, resultado, 0.0001f);
    }
    
    /*Prueba del numero de oro 4 Falla
     * La ultima ejecucion fallo y no se puede obtener el numero de oro
    */
    @Test
    public void testNumOroFalla() {
        fibonacci.getFibonacci(0,"hd");
        float resultado = fibonacci.getNumeroDeOro();
        float esperado = -1;
        assertEquals(esperado, resultado, 0.0001f);
    }
    
    /*Prueba de direccion
     * prueba de impresion inversa
    */
    @Test
    public void testDireccionInversa() {
        int[] resultado = fibonacci.getFibonacci(2,"i");
        int[] esperado = {0,1};
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de direccion
     * prueba de impresion directa
    */
    @Test
    public void testDireccionDirecta() {
        int[] resultado = fibonacci.getFibonacci(3,"d");
        int[] esperado = {0,1,1};
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de direccion
     * prueba de impresion horizontal
    */
    @Test
    public void testDireccionHorizontal() {
        int[] resultado = fibonacci.getFibonacci(4,"h");
        int[] esperado = {0,1,1,2};
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de direccion
     * prueba de impresion vertical
    */
    @Test
    public void testDireccionVertical() {
        int[] resultado = fibonacci.getFibonacci(5,"v");
        int[] esperado = {0,1,1,2,3};
        assertArrayEquals(esperado, resultado);
    }  
    
}
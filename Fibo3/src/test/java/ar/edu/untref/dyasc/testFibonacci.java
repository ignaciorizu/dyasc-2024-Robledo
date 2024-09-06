package ar.edu.untref.dyasc;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testFibonacci {

    FibonacciEjecutable fiboExe = new FibonacciEjecutable();

    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 1.
     * caso default 1.
     * Se comprueba el correcto funcionamiento de obtenerVueltas()
    */
    @SuppressWarnings("static-access")
    @Test
    public void testFibo1() throws FibonacciException {
        String[] parametros = {"1"};
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        int[] resultado = fiboExe.fibonacciMain(parametros);
        int[] esperado = {0};
        assertEquals(1, opciones.obtenerVueltas());
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 2.
     * caso default 2.
     * Se comprueba el correcto funcionamiento de obtenerVueltas()
    */
    @SuppressWarnings("static-access")
    @Test
    public void testFibo2() throws FibonacciException {
        String[] parametros = {"2"};
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        int[] resultado = fiboExe.fibonacciMain(parametros);
        int[] esperado = {0, 1};
        assertEquals(2, opciones.obtenerVueltas());
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 3.
     * prueba de recursividad sin necesidad de dar vueltas.
     * Se comprueba el correcto funcionamiento de obtenerVueltas()
    */
    @SuppressWarnings("static-access")
    @Test
    public void testFibo3() throws FibonacciException {
        String[] parametros = {"3"};
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        int[] resultado = fiboExe.fibonacciMain(parametros);
        int[] esperado = {0, 1, 1};
        assertEquals(3, opciones.obtenerVueltas());
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 4.
     * prueba de utilizacion de recursividad.
     * Se comprueba el correcto funcionamiento de obtenerVueltas()
    */
    @SuppressWarnings("static-access")
    @Test
    public void testFibo4() throws FibonacciException {
        String[] parametros = {"4"};
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        int[] resultado = fiboExe.fibonacciMain(parametros);
        int[] esperado = {0, 1, 1, 2};
        assertEquals(4, opciones.obtenerVueltas());
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 5.
     * prueba de cumplimiento con la condicion del trabajo 1.
     * Se comprueba el correcto funcionamiento de obtenerVueltas()
    */
    @SuppressWarnings("static-access")
    @Test
    public void testFibo5() throws FibonacciException {
        String[] parametros = {"5"};
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        int[] resultado = fiboExe.fibonacciMain(parametros);
        int[] esperado = {0, 1, 1, 2, 3};
        assertEquals(5, opciones.obtenerVueltas());
        assertArrayEquals(esperado, resultado);
    }
    
    /*Prueba de que se cumple la secuencia de fibonacci para cantVueltas = 8.
     * prueba de cumplimiento con la condicion del trabajo 2.
     * Se comprueba el correcto funcionamiento de obtenerVueltas()
    */
    @SuppressWarnings("static-access")
    @Test
    public void testFibo8() throws FibonacciException {
        String[] parametros = {"8"};
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        int[] resultado = fiboExe.fibonacciMain(parametros);
        int[] esperado = {0, 1, 1, 2, 3, 5, 8, 13};
        assertEquals(8, opciones.obtenerVueltas());
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
     * Se comprueba el correcto funcionamiento de obtenerVueltas()
    */
    @SuppressWarnings("static-access")
    @Test
    public void testFibo47() throws FibonacciException {
        String[] parametros = {"47"};
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        int[] resultado = fiboExe.fibonacciMain(parametros);
        int[] esperado = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418,
            317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296,
             433494437, 701408733, 1134903170, 1836311903};
             assertEquals(47, opciones.obtenerVueltas());
        assertArrayEquals(esperado, resultado);
    }
}
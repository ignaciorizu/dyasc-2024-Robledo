package ar.edu.untref.dyasc;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class testFibonacciOpciones {

    FibonacciEjecutable fiboExe = new FibonacciEjecutable();
     
    /*
     * prueba de impresion con Direccion Directa y Orientacion Horizontal
    */
    @SuppressWarnings("static-access")
    @Test
    public void testDireccionDirectaHorizontal() throws FibonacciException {
        String[] parametros = {"2","-o=dh"}; //{0 ,1}
        int[] fibo = fiboExe.fibonacciMain(parametros); 
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        FibonacciImpresion fiboImp = new FibonacciImpresion(fibo,opciones);
        String esperado = "fibo<2>: 0 1 ";
        assertEquals(esperado, fiboImp.obtenerSalida());
        assertFalse(opciones.obtenerDireccion());
        assertFalse(opciones.obtenerOrientacion());
        assertEquals("l",opciones.obtenerModo());
        assertFalse(opciones.obtenerSalida());
    }
     
    /*
     * prueba de impresion con Direccion Inversa y Orientacion Horizontal
    */
    @SuppressWarnings("static-access")
    @Test
    public void testDireccionInversaHorizontal() throws FibonacciException {
        String[] parametros = {"2","-o=ih"}; //{1 ,0}
        int[] fibo = fiboExe.fibonacciMain(parametros); 
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        FibonacciImpresion fiboImp = new FibonacciImpresion(fibo,opciones);
        String esperado = "fibo<2>: 1 0 ";
        assertEquals(esperado, fiboImp.obtenerSalida());
        assertTrue(opciones.obtenerDireccion());
        assertFalse(opciones.obtenerOrientacion());
        assertEquals("l",opciones.obtenerModo());
        assertFalse(opciones.obtenerSalida());
    }

    /*
     * prueba de impresion con Direccion Directa y Orientacion Vertical
    */
    @SuppressWarnings("static-access")
    @Test
    public void testDireccionDirectaVertical() throws FibonacciException {
        String[] parametros = {"2","-o=dv"}; //{0 ,1}
        int[] fibo = fiboExe.fibonacciMain(parametros); 
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        FibonacciImpresion fiboImp = new FibonacciImpresion(fibo,opciones);
        String esperado = "fibo<2>: \n0 \n1 ";
        assertEquals(esperado, fiboImp.obtenerSalida());
        assertFalse(opciones.obtenerDireccion());
        assertTrue(opciones.obtenerOrientacion());
        assertEquals("l",opciones.obtenerModo());
        assertFalse(opciones.obtenerSalida());
    }
     
    /*
     * prueba de impresion con Direccion Inversa y Orientacion Vertical
    */
    @SuppressWarnings("static-access")
    @Test
    public void testDireccionInversaVertical() throws FibonacciException {
        String[] parametros = {"2","-o=iv"}; //{1 ,0}
        int[] fibo = fiboExe.fibonacciMain(parametros); 
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        FibonacciImpresion fiboImp = new FibonacciImpresion(fibo,opciones);
        String esperado = "fibo<2>: \n1 \n0 ";
        assertEquals(esperado, fiboImp.obtenerSalida());
        assertTrue(opciones.obtenerDireccion());
        assertTrue(opciones.obtenerOrientacion());
        assertEquals("l",opciones.obtenerModo());
        assertFalse(opciones.obtenerSalida());
    }
     
    /*
     * prueba de impresion con Direccion y Orientacion invalidos
    */
    @SuppressWarnings("static-access")
    @Test
    public void testDireccionInvalida() throws FibonacciException {
        String[] parametros = {"2","-o=xy"}; //{1 ,0}
        int[] fibo = fiboExe.fibonacciMain(parametros); 
        assertNull("Opciones no validas.",fibo);
    }
     
    /*
     * prueba de impresion con Direccion Directa y Orientacion Horizontal, explicitando modo de funcionamiento sea l (lista)
    */
    @SuppressWarnings("static-access")
    @Test
    public void testDireccionDirectaHorizontalModoL() throws FibonacciException {
        String[] parametros = {"2","-o=dh","-m=l"}; //{0 ,1}
        int[] fibo = fiboExe.fibonacciMain(parametros); 
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        FibonacciImpresion fiboImp = new FibonacciImpresion(fibo,opciones);
        String esperado = "fibo<2>: 0 1 ";
        assertEquals(esperado, fiboImp.obtenerSalida());
        assertFalse(opciones.obtenerDireccion());
        assertFalse(opciones.obtenerOrientacion());
        assertEquals("l",opciones.obtenerModo());
        assertFalse(opciones.obtenerSalida());
    }
     
    /*
     * prueba de impresion con Direccion y Orientacion defaul (hd), explicitando modo de funcionamiento sea l (lista)
    */
    @SuppressWarnings("static-access")
    @Test
    public void testModoFuncionamientoL() throws FibonacciException {
        String[] parametros = {"2","-m=l"}; //{0 ,1}
        int[] fibo = fiboExe.fibonacciMain(parametros); 
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        FibonacciImpresion fiboImp = new FibonacciImpresion(fibo,opciones);
        String esperado = "fibo<2>: 0 1 ";
        assertEquals(esperado, fiboImp.obtenerSalida());
        assertFalse(opciones.obtenerDireccion());
        assertFalse(opciones.obtenerOrientacion());
        assertEquals("l",opciones.obtenerModo());
        assertFalse(opciones.obtenerSalida());
    }
     
    /*
     * prueba de impresion con modo de funcionamiento s (sumatoria)
    */
    @SuppressWarnings("static-access")
    @Test
    public void testModoFuncionamientoS() throws FibonacciException {
        String[] parametros = {"2","-m=s"}; //{0 ,1}
        int[] fibo = fiboExe.fibonacciMain(parametros); 
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        FibonacciImpresion fiboImp = new FibonacciImpresion(fibo,opciones);
        String esperado = "fibo<2>s: 1";
        assertEquals(esperado, fiboImp.obtenerSalida());
        assertFalse(opciones.obtenerDireccion());
        assertFalse(opciones.obtenerOrientacion());
        assertEquals("s",opciones.obtenerModo());
        assertFalse(opciones.obtenerSalida());
    }
     
    /*
     * prueba de impresion con modo de funcionamiento s (sumatoria) y explicitando Direccion y Orientacion
    */
    @SuppressWarnings("static-access")
    @Test
    public void testDireccionHDModoFuncionamientoS() throws FibonacciException {
        String[] parametros = {"5","-o=hd","-m=s"}; //{0 ,1 ,1 ,2 ,3}
        int[] fibo = fiboExe.fibonacciMain(parametros); 
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        FibonacciImpresion fiboImp = new FibonacciImpresion(fibo,opciones);
        String esperado = "fibo<5>s: 7";
        assertEquals(esperado, fiboImp.obtenerSalida());
        assertFalse(opciones.obtenerDireccion());
        assertFalse(opciones.obtenerOrientacion());
        assertEquals("s",opciones.obtenerModo());
        assertFalse(opciones.obtenerSalida());
    }
     
    /*
     * prueba de impresion con modo de funcionamiento s (sumatoria) y explicitando Direccion y Orientacion
    */
    @SuppressWarnings("static-access")
    @Test
    public void testDireccionVIModoFuncionamientoS() throws FibonacciException {
        String[] parametros = {"5","-o=iv","-m=s"}; //{0 ,1 ,1 ,2 ,3}
        int[] fibo = fiboExe.fibonacciMain(parametros); 
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        FibonacciImpresion fiboImp = new FibonacciImpresion(fibo,opciones);
        String esperado = "fibo<5>s: \n7";
        assertEquals(esperado, fiboImp.obtenerSalida());
        assertTrue(opciones.obtenerDireccion());
        assertTrue(opciones.obtenerOrientacion());
        assertEquals("s",opciones.obtenerModo());
        assertFalse(opciones.obtenerSalida());
    }
     
    /*
     * prueba de impresion con modo de funcionamiento s (sumatoria) y explicitando Direccion y Orientacion
    */
    @SuppressWarnings("static-access")
    @Test
    public void testDireccionVDModoFuncionamientoS() throws FibonacciException {
        String[] parametros = {"5","-o=dv","-m=s"}; //{0 ,1 ,1 ,2 ,3}
        int[] fibo = fiboExe.fibonacciMain(parametros); 
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        FibonacciImpresion fiboImp = new FibonacciImpresion(fibo,opciones);
        String esperado = "fibo<5>s: 7";
        assertEquals(esperado, fiboImp.obtenerSalida());
        assertFalse(opciones.obtenerDireccion());
        assertTrue(opciones.obtenerOrientacion());
        assertEquals("s",opciones.obtenerModo());
        assertFalse(opciones.obtenerSalida());
    }
     
    /*
     * prueba de impresion con modo de funcionamiento s (sumatoria) y explicitando Direccion y Orientacion
    */
    @SuppressWarnings("static-access")
    @Test
    public void testSalida() throws FibonacciException {
        String[] parametros = {"5","-f=salida1.txt"}; //{0 ,1 ,1 ,2 ,3}
        int[] fibo = fiboExe.fibonacciMain(parametros); 
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        FibonacciImpresion fiboImp = new FibonacciImpresion(fibo,opciones);
        String esperado = "fibo<5> guardado en Fibo3/Salidas/salida1.txt";
        //assertEquals(esperado, fiboImp.obtenerSalida());
        String esperadoDocumento = "fibo<5>: 0 1 1 2 3 ";
        assertEquals(esperadoDocumento, fiboImp.obtenerSalidaDocumento());
        assertFalse(opciones.obtenerDireccion());
        assertFalse(opciones.obtenerOrientacion());
        assertEquals("l",opciones.obtenerModo());
        assertTrue(opciones.obtenerSalida());
        assertEquals("salida1.txt",opciones.obtenerSalidaNombre());
    }
     
    /*
     * prueba de impresion con modo de funcionamiento s (sumatoria) y explicitando Direccion y Orientacion
    */
    @SuppressWarnings("static-access")
    @Test
    public void testSalidaDireccionIV() throws FibonacciException {
        String[] parametros = {"5","-o=iv","-f=salida2.txt"}; //{0 ,1 ,1 ,2 ,3}
        int[] fibo = fiboExe.fibonacciMain(parametros); 
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        FibonacciImpresion fiboImp = new FibonacciImpresion(fibo,opciones);
        String esperado = "fibo<5> guardado en Fibo3/Salidas/salida2.txt";
        //assertEquals(esperado, fiboImp.obtenerSalida());
        String esperadoDocumento = "fibo<5>: 3 2 1 1 0 ";
        assertEquals(esperadoDocumento, fiboImp.obtenerSalidaDocumento());
        assertTrue(opciones.obtenerDireccion());
        assertTrue(opciones.obtenerOrientacion());
        assertEquals("l",opciones.obtenerModo());
        assertTrue(opciones.obtenerSalida());
        assertEquals("salida2.txt",opciones.obtenerSalidaNombre());
    }
     
    /*
     * prueba de impresion con modo de funcionamiento s (sumatoria) y explicitando Direccion y Orientacion
    */
    @SuppressWarnings("static-access")
    @Test
    public void testSalidaDireccionIVModoS() throws FibonacciException {
        String[] parametros = {"5","-o=iv","-m=s","-f=salida3.txt"}; //{0 ,1 ,1 ,2 ,3}
        int[] fibo = fiboExe.fibonacciMain(parametros); 
        OpcionesFibonacci opciones = new OpcionesFibonacci(parametros);
        FibonacciImpresion fiboImp = new FibonacciImpresion(fibo,opciones);
        String esperado = "fibo<5> guardado en Fibo3/Salidas/salida3.txt";
        //assertEquals(esperado, fiboImp.obtenerSalida());
        String esperadoDocumento = "fibo<5>s: \n7";
        assertEquals(esperadoDocumento, fiboImp.obtenerSalidaDocumento());
        assertTrue(opciones.obtenerDireccion());
        assertTrue(opciones.obtenerOrientacion());
        assertEquals("s",opciones.obtenerModo());
        assertTrue(opciones.obtenerSalida());
        assertEquals("salida3.txt",opciones.obtenerSalidaNombre());
    }
}
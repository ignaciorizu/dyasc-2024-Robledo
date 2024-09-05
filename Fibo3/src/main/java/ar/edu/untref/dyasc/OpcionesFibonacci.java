package ar.edu.untref.dyasc;

public class OpcionesFibonacci {
    private boolean direccion = false;
    private boolean orientacion = false;
    private String modo = "l";
    private boolean salida = false;
    private String salidaNombre = "";
    private int vueltas;
    private boolean numOro;

/*
 * 
        try {
            if (args.length > 1 && args[0].startsWith("-o=")) { 
                String direccion = args[0].substring(3);
                if (direccion.contains("v") || direccion.contains("h") || direccion.contains("d") || direccion.contains("i") ) {    
                    getFibonacci(Integer.parseInt(args[1]), direccion);
                } else {
                    throw new fibonacciException(direccion);
                }
            }else if(!args[0].equals("oro") || !args[0].startsWith("-o=")){
                getFibonacci(Integer.parseInt(args[0]), "hd");
            }else {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (args.length > 1 && (args[1].equals("oro") || (args.length > 2 && args[2].equals("oro")))){
                getNumeroDeOro();
            }
        } catch (NumberFormatException e){
            // Capturar la excepción si el String no es un número entero válido
            falla = true;
            System.out.println("La cantidad de vueltas posee un formato invalido.");
        } catch (fibonacciException e) {
            falla = true;
            System.out.println("La direccion no tiene un formato valido. Solo puede contener las siguientes conbinaciones vd vi hd hi. No se puede usar " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e){
            falla = true;
            System.out.println("No puede ejecutarse el calculo de la secuencia de fibonacci sin tener un numero maximo"); 
        }
 */

    /* */
    public OpcionesFibonacci(String[] argumentos) throws FibonacciException{
        buscarDatos(argumentos);
    }

    private void buscarDatos(String[] argumentos) throws FibonacciException {
        for (String argumento : argumentos) {
            if (argumento.startsWith("-o=")) {
                comprobarDireccion(argumento.substring(3));
                comprobarOrientacion(argumento.substring(3));
                /*En caso de que no haya ninguna de las opciones correspondientes lanza un error.*/
                if (!(this.direccion || this.orientacion || argumento.contains("d") || argumento.contains("h"))) {
                    throw new FibonacciException("Opciones no validas.");
                }
            }
            if (argumento.startsWith("-m=")) {
                this.modo = argumento.substring(3);
                /*En caso de que no haya ninguna de las opciones correspondientes lanza un error.*/
                if (!(this.modo.contains("s") || this.modo.contains("l"))) {
                    throw new FibonacciException("Opciones de modo no validas.");
                }
            }
            if (argumento.startsWith("-f=")) {
                this.salida = true;
                this.salidaNombre = argumento.substring(3);
            }
            if (esUnNumero(argumento)) {
                this.vueltas = Integer.parseInt(argumento);
            }
            if (argumento.startsWith("oro")) {
                this.numOro = true;
            }
        }
    }

    /*Busca si en las opciones se pide la direccion inversa.*/
    private void comprobarDireccion(String direccion){
        if (direccion.contains("i") ) {    
            this.direccion = true;
        }
    }

    /*Busca si en las opciones se pide la orientacion vertical.*/
    private void comprobarOrientacion(String orientacion){
        if (orientacion.contains("v") ) {    
            this.orientacion = true;
        }
    }

    /*Compruebo si estoy en un argumento numerico.*/
    private boolean esUnNumero(String argumento) {
        try {
            Integer.valueOf(argumento);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*Devuelve la direccion. Si la direccion es true entonces funciona en inversa, sino por default (direccion directa).*/
    public boolean obtenerDireccion(){
        return this.direccion;
    }

    /*Devuelve la orientacion. Si la orientacion es true entonces funciona en vertical, sino por default (orientacion horizontal).*/
    public boolean obtenerOrientacion(){
        return this.orientacion;
    }

    /*Devuelve el modo de funcionamiento. Si modo de funcionamiento es 's' entonces la salida sera un Sumatoria, si es una 'l' devuelve una lista.*/
    public String obtenerModo(){
        return this.modo;
    }

    /*Devuelve la salida. si la salida es true entonces se crea el archivo con el nombre idicado, sino no se crea un archivo.*/
    public boolean obtenerSalida(){
        return this.salida;
    }

    /*Devuelve el nombre de la salida.*/
    public String obtenerSalidaNombre(){
        return this.salidaNombre;
    }
    
    /*Devuelve la cantidad de vueltas para fibonacci.*/
    public int obtenerVueltas() {
        return this.vueltas;
    }

    /*Si la salida es true entonces se obtendra el numero de oro, caso contrario no se lo obtendra*/
    public boolean buscarOro() {
        return this.numOro;
    }
}

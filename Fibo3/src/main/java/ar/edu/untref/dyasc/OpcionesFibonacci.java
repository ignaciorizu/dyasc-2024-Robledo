package ar.edu.untref.dyasc;

public class OpcionesFibonacci {
    private boolean direccion = false;
    private boolean orientacion = false;
    private String modo = "l";
    private boolean salida = false;
    private String salidaNombre = "";
    private int vueltas;
    private boolean numOro;

    public OpcionesFibonacci(String[] argumentos) throws FibonacciException{
        buscarDatos(argumentos);
    }

    private void buscarDatos(String[] argumentos) throws FibonacciException {
        for (String argumento : argumentos) {
            validarDireccionHorientacion(argumento);
            validarModoFuncionamiento(argumento);
            validarSalida(argumento);
            validarVueltas(argumento);
            validarOro(argumento);
        }
    }

    /*Revisa que los valores de la direccion y orientacion sean validos.*/
    private void validarDireccionHorientacion(String argumento) throws FibonacciException {
        if (argumento.startsWith("-o=")) {
            comprobarDireccionInversa(argumento.substring(3));
            comprobarOrientacionVertical(argumento.substring(3));
            /*En caso de que no haya ninguna de las opciones correspondientes lanza un error.*/
            if (!(this.direccion || this.orientacion || argumento.contains("d") || argumento.contains("h"))) {
                throw new FibonacciException("Opciones no validas.");
            }
        }
    }

    /*Revisa que el valor del modo de funcionamieto sea valido.*/
    private void validarModoFuncionamiento(String argumento) throws FibonacciException {
        if (argumento.startsWith("-m=")) {
            this.modo = argumento.substring(3);
            /*En caso de que no haya ninguna de las opciones correspondientes lanza un error.*/
            if (!(this.modo.contains("s") || this.modo.contains("l"))) {
                throw new FibonacciException("Opciones de modo no validas.");
            }
        }
    }

    /*Revisa si el argumento indica el uso de la salida.*/
    private void validarSalida(String argumento) {
        if (argumento.startsWith("-f=")) {
            this.salida = true;
            this.salidaNombre = argumento.substring(3);
        }
    }

    /*Revisa si el argumento indica la cantidad de vueltas.*/
    private void validarVueltas(String argumento) {
        if (esUnNumero(argumento)) {
            this.vueltas = Integer.parseInt(argumento);
        }
    }

    /*Revisa si el argumento indica el pedido de obtencion del numero de oro.*/
    private void validarOro(String argumento) {
        if (argumento.startsWith("oro")) {
            this.numOro = true;
        }
    }

    /*Busca si en las opciones se pide la direccion inversa.*/
    private void comprobarDireccionInversa(String direccion){
        if (direccion.contains("i") ) {    
            this.direccion = true;
        }
    }

    /*Busca si en las opciones se pide la orientacion vertical.*/
    private void comprobarOrientacionVertical(String orientacion){
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

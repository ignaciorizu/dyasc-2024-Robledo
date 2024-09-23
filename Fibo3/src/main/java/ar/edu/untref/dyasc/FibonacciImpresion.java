package ar.edu.untref.dyasc;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FibonacciImpresion {
    private final int[] fibonacci;
    private final OpcionesFibonacci opciones;
    private String salida = "";
    private String salidaDocumento = "";

    public FibonacciImpresion(int[] fibonacci, OpcionesFibonacci opciones) {
        this.fibonacci = fibonacci;
        this.opciones = opciones;
        generarSalida();
    }

    public String obtenerSalida(){
        imprimir();
        return this.salida;
    }

    public String obtenerSalidaDocumento(){
        return this.salidaDocumento;
    }

    /*Se buscan por todas las opcciones y se imprime las pedidas*/
    private void imprimir(){
        if(this.opciones.obtenerSalida()){
            crearSalida(this.opciones.obtenerSalidaNombre());
        } else {
            System.out.println(this.salida);
        }
    }

    /*Se genera el string para imprimir.*/
    private void generarSalida(){
        String modo = this.opciones.obtenerModo();
        if("l".equals(modo)){
            imprimirLista();
        }else if("s".equals(modo)){
            imprimirSumatoria();
        }
        if(this.opciones.buscarOro()){
            imprimirNumOro();
        }
    }

    /*Se imprime en formato de lista */
    private void imprimirLista(){
        int num;
        //Incio de formato de salida
        this.salida += "fibo<" + this.fibonacci.length + ">: ";
        //Impresion de valores de fibo
        for (int vuelta = 0; vuelta < this.fibonacci.length; vuelta++) {
            num = vuelta;
            //Impresion en Dirección inversa
            if (this.opciones.obtenerDireccion()) {
                num = this.fibonacci.length - vuelta - 1;
            }
            //Impresion en Orientación inversa
            if(this.opciones.obtenerOrientacion()){
                this.salida += "\n";   
            }
            //Impresion de valor ej pa posicion num
            this.salida += Integer.toString(this.fibonacci[num]) + " ";
        }
    }

    /*Se imprime en formato de sumatoria.*/
    private void imprimirSumatoria() {
        this.salida += "fibo<"+ this.fibonacci.length +">s: ";
        if(opciones.obtenerDireccion()){
            this.salida+= "\n";
        }
        this.salida += obtenerSumatoria();
    }

    /*Calculo de la sumatoria. La sumatoria de la secuencia de fibonacci converge en F(n+2)-1*/
    private int obtenerSumatoria() {
        int fiboProximo = this.fibonacci[this.fibonacci.length-1] + this.fibonacci[this.fibonacci.length-2];
        int fiboProximo2 = fiboProximo + this.fibonacci[this.fibonacci.length-1];
        int sumaFibo = fiboProximo2 - 1 ;
        return sumaFibo;
    }

    /*Crear y escribir el archivo de la salida.*/
    private void crearSalida(String salidaNombre) {
        salidaNombre = "Fibo/Salidas/" + salidaNombre;
        /*
         *PrintWriter se encarga de crear un objeto para escribir.
         *FileWrite crea un archivo con el nombre pasado por parametro.
         */
        try(PrintWriter escritor = new PrintWriter(new FileWriter(salidaNombre))) {
            // Escribir en el archivo
            this.salidaDocumento = this.salida;
            escritor.println(this.salidaDocumento);
            this.salida = "fibo<" + this.fibonacci.length + "> guardado en " + salidaNombre;
            System.out.println(this.salida);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear o escribir en el archivo.\n" + e.getMessage());
        }
    }

    /*Se imprime el numero de oro.*/
    private void imprimirNumOro() {
        double phi = (1 + Math.sqrt(5)) / 2;
        float numOro = calcularNumeroDeOro();
        this.salida += ("\nEl numero de oro obtenido con este largo de la secuencia de fibonacci es " + numOro + 
                        ".\n El numero de oro real es " + phi +".");
    }

    /*Se calcula el numero de oro en base a la lista fibonacci.*/
    public float calcularNumeroDeOro(){
        float fiboUltimo = this.fibonacci[this.fibonacci.length-1];
        /*Se obtiene el ultimo para tratar con el caso de lenght 1 y 2.
         * En el caso length 1: no habria anteultimo.
         * En el caso length 2: no se puede dividir por 0.
         */
        float numOro = fiboUltimo;
        if (this.fibonacci.length > 2){
            float fiboAnteultimo = this.fibonacci[this.fibonacci.length-2];
            numOro = fiboUltimo/fiboAnteultimo;
        }
        return numOro;
    }
}

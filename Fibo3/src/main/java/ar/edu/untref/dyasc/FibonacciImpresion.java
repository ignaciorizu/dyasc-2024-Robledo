package ar.edu.untref.dyasc;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FibonacciImpresion {
    private final int[] fibonacci;
    private final OpcionesFibonacci opciones;

    public FibonacciImpresion(int[] fibonacci, OpcionesFibonacci opciones) {
        this.fibonacci = fibonacci;
        this.opciones = opciones;
    }

    /*Se buscan por todas las opcciones y se imprime las pedidas*/
    public void imprimir(){
        String modo = this.opciones.obtenerModo();
        String salida = "";
        if("l".equals(modo)){
            salida = imprimirLista();
        }else if("s".equals(modo)){
            salida = imprimirSumatoria();
        }
        if(this.opciones.buscarOro()){
            imprimirNumOro();
        }
        if(this.opciones.obtenerSalida()){
            crearSalida(this.opciones.obtenerSalidaNombre(), salida);
        } else {
            System.out.println(salida);
        }
    }

    /*Se imprime en formato de lista */
    private String imprimirLista(){
        int num;
        String salida = "";
        //Incio de formato de salida
        salida += "fibo<" + this.fibonacci.length + ">: ";
        //Impresion de valores de fibo
        for (int vuelta = 0; vuelta < this.fibonacci.length; vuelta++) {
            num = vuelta;
            //Impresion en Dirección inversa
            if (this.opciones.obtenerDireccion()) {
                num = this.fibonacci.length - vuelta - 1;
            }
            //Impresion en Orientación inversa
            if(this.opciones.obtenerOrientacion()){
                salida += "\n";   
            }
            //Impresion de valor ej pa posicion num
            salida += Integer.toString(this.fibonacci[num]) + " ";
        }
         
        return salida;
    }

    /*Se imprime en formato de sumatoria.*/
    private String imprimirSumatoria() {
        String salida = "fibo<"+ this.fibonacci.length +">s: " + obtenerSumatoria();
        return salida;
    }

    /*Calculo de la sumatoria. La sumatoria de la secuencia de fibonacci converge en F(n+2)-1*/
    private int obtenerSumatoria() {
        int fiboProximo = this.fibonacci[this.fibonacci.length-1] + this.fibonacci[this.fibonacci.length-2];
        int fiboProximo2 = fiboProximo + this.fibonacci[this.fibonacci.length-1];
        int sumaFibo = fiboProximo2 - 1 ;
        return sumaFibo;
    }

    /*Crear y escribir el archivo de la salida.*/
    private void crearSalida(String salidaNombre, String salida) {
        salidaNombre = "Fibo3/Salidas/" + salidaNombre;
        /*
         *PrintWriter se encarga de crear un objeto para escribir.
         *FileWrite crea un archivo con el nombre pasado por parametro.
         */
        try(PrintWriter escritor = new PrintWriter(new FileWriter(salidaNombre))) {
            // Escribir en el archivo
            escritor.println(salida);
            System.out.println("fibo<" + this.fibonacci.length + "> guardado en " + salidaNombre);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear o escribir en el archivo.\n" + e.getMessage());
        }
    }

    /*Se imprime el numero de oro.*/
    private void imprimirNumOro() {
        double phi = (1 + Math.sqrt(5)) / 2;
        float numOro = calcularNumeroDeOro();
        System.out.print("\nEl numero de oro obtenido con este largo de la secuencia de fibonacci es " + numOro + 
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

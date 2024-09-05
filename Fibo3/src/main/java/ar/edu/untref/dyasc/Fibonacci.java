package java.ar.edu.untref.dyasc;

public class Fibonacci {
    private int[] fiboSalida;
    private int indice = 0;

    public int[] obtenerFibonacci(int cantVueltas) throws FibonacciException {
        /*Revicion de inputs dentro de los limites*/
        if (cantVueltas >= 1){ 
            if (cantVueltas >= 48) { 
                throw new FibonacciException("La cantidad de vueltas debe ser menor que 48, debido a que se sobrepasa el valor que pueden almacenar los datos tipo int.\n");
            }
            /*Obtener los casos default de la secuencia fibonacci.*/
            this.fiboSalida = new int[cantVueltas];
            this.fiboSalida[0] = 0;
            if(cantVueltas >= 2){ 
                this.indice = 1;
                this.fiboSalida[this.indice] = 1;
                /*Obtenecion de la secuencia para casos mayores a 2*/
                calcularSecuenciaFibonacci(cantVueltas - 2,1,0);
            }
        }else{
            throw new FibonacciException("La cantidad de vueltas debe ser un entero mayor a 0.");
        }
        return this.fiboSalida;

    }

    /*Calculo de la secuencia fibonacci de forma recursiva.*/
    private int calcularSecuenciaFibonacci(int VueltasRestantes, int numA, int numB) {
        this.indice++;
        if (VueltasRestantes == 1) {
            this.fiboSalida[this.indice] = numA + numB;
            return (numA + numB);  
        } else if(VueltasRestantes > 1){
            this.fiboSalida[this.indice] = numA + numB;
            return numA + calcularSecuenciaFibonacci(VueltasRestantes - 1, numA + numB, numA);  // Llamada recursiva.
        }
        return -1;
    }
}
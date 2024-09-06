Fibo 3

Este codigo de Fibonacci cumple con las consignas de los 3 Tp de fibo.
Se busco que su implementacion sea lo más acorde posible con el modelo SOLID.

Esta ultima version dividio las partes importantes del codigo en varias clases.
Dentro de estas clases cada una tiene su propio papel, y FibonacciEcutable se encarga de juntarlas en un solo lugar.

Las pruebas unitarias tambien pasaron por el proceso de segmentacion en clases individuales, en la que cada una desempeña un papel individual.

Aclaraciones:
* El codigo solo calcula la secuencia hasta la posicion numero 47, debido a que valores mayores sobre pasan el numero de datos que pueden representar los int.
* Se emplea un metodo recursivo para oprimizar el funcionamiento del codigo.
* En caso de utilizar el modo de funcionamiento sumatoria y cargar las operaciones invalidas dara error.
* Tiene el adicional que tambien calcula el numero de oro o numero aureo, pasandose como parametro la palabra oro a la hora de ejecutarlo. El numero de oro se obtiene en la divicion entre los ultimos 2 digitos de la secuencia, por lo cual se tienen contemplado el caso de la primera vuelta como un caso especial y el segundo caso especial es la vuelta = 2, que posee la division 1/0; para estos casos se decidio que se quede con el numero mas alto de la secuencia. Solo se ejecuta si la ultima ejecucion no termino error.
----------------------------------------------------------------------------------------------------------------------------------------------------
Consignas de Fibo

Fibo 1:
Escribí una aplicación de consola (línea de comando) que reciba como parámetro un número y genere por pantalla los correspondientes esa cantidad de números de la serie de Fibonacci. A continuación se ofrecen algunos ejemplos concretos del comportamiento esperado:

# Ejemplo 1
java -jar fibo.jar 5
fibo<5>: 0 1 1 2 3

# Ejemplo 2
java -jar fibo.jar 8
fibo<8>: 0 1 1 2 3 5 8 13
Podés asumir que las entradas serán siempre válidas.

----------------------------------------------------------------------------------------------------------------------------------------------------
Fibo 2:
Partiendo del ejercicio Fibonacci, copiarlo en otra carpeta llamada Fibo2 y a partir de eso realizar las modificaciones necesarias para soportar las siguientes opciones:

Orientación: horizontal (h) o vertical (h)
Dirección: directa (d) o inversa (i)
Si es especifica una opción no válida debe indicarse "Opción no válida".

El programa puede invocarse sin la opción "-o" en cuyo caso el comportamiento debe ser por default hd.

# Ejemplo 1 vertical y directa
java -jar fibo.jar -o=vd 5
fibo<5>:
0
1
1
2
3

# Ejemplo 2 horizontal e inversa
java -jar fibo.jar -o=hi 8
fibo<8>: 13 8 5 3 2 1 1 0

# Ejemplo 3 vertical e inversa
java -jar fibo.jar -o=vi 8
fibo<8>: 
13
8
5
3
2
1
1
0

# Ejemplo 3 opción no valida
java -jar fibo.jar -o=xy 8
Opciones no validas.

# Ejemplo 4, sin -o
java -jar fibo.jar 8
fibo<8>: 0 1 1 2 3 5 8 13

----------------------------------------------------------------------------------------------------------------------------------------------------
Fibo 3:
Partiendo del ejercicio Fibonacci 2, copiarlo en otra carpeta llamada Fibo3 y a partir de eso realizar las modificaciones necesarias para soportar las siguientes opciones:

-f=xxxxxx: escribe la salida en el archivo cuyo nombre se especifique
-m=s: donde m define el modo de funcionamiento, el cual puede ser "l" o "s", "l" significa "lista", lo cual es el comportamiento actual en fibo2. "s"  significa "sumatoria" y significa que el programa debe calcular la sumatoria de los items de la secuencia de fibonacci del número especificado.
El programa puede invocarse sin la opción "-m" en cuyo caso el comportamiento debe ser por default debe ser el de fibo2.

# Ejemplo 1 salida a archivo
java -jar fibo.jar -o=vd -f=salida.txt 5
fibo<5> guardado en salida.txt 
# Y el archivo salida.txt debe tener el siguiente contenido
fibo<5>:
0
1
1
2
3

# Ejemplo 2 con opción s
java -jar fibo.jar -o=hd -m=s 5
fibo<5>s: 7

# Ejemplo 3 salida a archivo con opción s
java -jar fibo.jar -o=vd -f=salida.txt -m=s 5
fibo<5> guardado en salida.txt 
# Y el archivo salida.txt debe tener el siguiente contenido
fibo<5>s:
7
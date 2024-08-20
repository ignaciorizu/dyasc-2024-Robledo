Este codigo tiene por objetivo calcular la secuencia fibonacci. Se emplea un metodo recursivo para oprimizar el funcionamiento del codigo.

El codigo solo calcula la secuencia hasta la posicion numero 47, debido a que valores mayores sobre pasan el numero de datos que pueden representar los int.

Posee pruebas unitarias para poder verificar su correcto funcionamiento.

Cuenta con una excepccion especial para poder detectar cualquier fallo especifico de la aplicacion, como lo es el ingreso de vueltas de la secuencia ilegales.

Tiene el adicional que tambien calcula el numero de oro o numero aureo, pasandose como parametro la palabra oro a la hora de ejecutarlo. El numero de oro se obtiene en la divicion entre los ultimos 2 digitos de la secuencia, por lo cual se tienen contemplado el caso de la primera vuelta como un caso especial y el segundo caso especial es la vuelta = 2, que posee la division 1/0; para estos casos se decidio que se quede con el numero mas alto de la secuencia. Solo se ejecuta si la ultima ejecucion no termino error.
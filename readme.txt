Para iniciar el programa desde la consola, sigue los siguientes pasos:

	1. Inicia la consola, la de tu IDE, con Ctrl+Alt+T, o la de Windows, con Windows + R, escribiendo cmd y pulsando Enter.
	2. Ve hasta el directorio donde se encuentra App.java. Puedes hacerlo navegando con el comando cd.
		2.1. Por ejemplo, si estando en C:\\ escribimos "cd Program Files" y nos moveremos dentro del directorio llamado Program Files.
		2.2. Una vez allí, podremos seguir navegando, entrando en otros directorios escribiendo su nombre, o subiendo un nivel hasta donde estábamos con el comando "cd .."
	3. Una vez nos encontremos en el directorio nXexerciciX, usaremos el comando "javac" seguido de las clases que queramos compilar.
		3.1 Para el n1exercici1, por ejemplo, usaremos "javac App.java ListFilesInDirectory.java".
		3.2 Si necesitamos importar un .jar de apache commons IO, que ocurre en la mayoría de los ejercicios, deberemos también especificar el classpath para compilar correctamente.
			3.2.1 Lo haremos con el siguiente comando: -cp ruta\al\commons-io.jar
			3.2.2 Por ejemplo, para el ejercicio n1exercici3, compilaremos con el siguiente comando: javac -cp C:\Users\jmage\.m2\repository\commons-io\commons-io\2.12.0\commons-io-2.12.0.jar App.java ListFilesInDirectory.java
	4. Una vez hayamos compilado los .java, nos moveremos un directorio hacia arriba, donde se encuentra el paquete donde estaban los .java (el nXexerciciX).
		4.1. Siguiendo el mismo ejemplo, ejecutaríamos "cd .." y pasaríamos a estar en \src\main\java en lugar de en src\main\java\n1exercici1
	5. Ahora usaremos el comando "java" para ejecutar la clase que tenga el método main precedido del nombre del paquete y un punto.
		5.1. En nuestro caso, desde \src\main\java usaremos el comando "java n1exercici.App".
		5.2 Si necesitamos importar un .jar de apache commons IO, que ocurre en la mayoría de los ejercicios, deberemos también especificar el classpath para ejecutar el programa correctamente.
			3.2.1 Lo haremos con el siguiente comando: -cp ruta\al\commons-io.jar;.
			3.2.2 Por ejemplo, para el ejercicio n1exercici3, ejecutaríamos el programa con el siguiente comando: java -cp C:\Users\jmage\.m2\repository\commons-io\commons-io\2.12.0\commons-io-2.12.0.jar;. n1exercici3.App

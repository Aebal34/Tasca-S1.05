Para iniciar el programa desde la consola, sigue los siguientes pasos:

	1. Inicia la consola, la de tu IDE o la de Windows, con Windows + R, escribiendo cmd y pulsando Enter.
	2. Ve hasta el directorio donde se encuentra App.java. Puedes hacerlo navegando con el comando cd.
		2.1. Por ejemplo, si estando en C:\\ escribimos "cd Program Files", probablemente nos moveremos dentro del directorio llamado Program Files.
		2.2. Una vez allí, podremos seguir navegando, entrando en otros directorios escribiendo su nombre, o subiendo un nivel hasta donde estábamos con el comando "cd .."
	3. Una vez nos encontremos en el directorio nXexerciciX, usaremos el comando "javac" seguido de las clases que queramos compilar.
		3.1 Para el n1exercici1, por ejemplo, usaremos "javac App.java ListFilesInDirectory.java".
	4. Una vez hayamos compilado los .java, nos moveremos un directorio hacia arriba, donde se encuentra el paquete donde estaban los .java.
		4.1. Siguiendo el mismo ejemplo, ejecutaríamos "cd .." y pasaríamos a estar en \src\main\java en lugar de en src\main\java\n1exercici1
	5. Ahora usaremos el comando "java" para ejecutar la clase que tenga el método main precedido del nombre del paquete y un punto.
		5.1. En nuestro caso, desde \src\main\java usaremos el comando "java n1exercici.App".

Para ejercicios donde importamos .jar de Apache Commons, necesitamos, a la hora de compilar (paso 3), listar el classpath del .jar.
	Por ejemplo, en n1exercici3, debemos usar javac -cp C:\Users\jmage\.m2\repository\commons-io\commons-io\2.12.0\commons-io-2.12.0.jar App.java ListFilesInDirectory.java
	Luego, para ejecutar el .class, deberemos seguir escribiendo el classpath, seguido de la ejecución normal del .class
		Por ejemplo, en el n1exercici3, usaremos java -cp C:\Users\jmage\.m2\repository\commons-io\commons-io\2.12.0\commons-io-2.12.0.jar;. n1exercici3.App
		Para n2exercici1: java -cp C:\Users\jmage\.m2\repository\commons-io\commons-io\2.12.0\commons-io-2.12.0.jar;. n2exercici1.App
		Para n3exercici1: java -cp C:\Users\jmage\.m2\repository\commons-io\commons-io\2.12.0\commons-io-2.12.0.jar;. n3exercici1.App
		Para n3exercici1: javac -cp C:\Users\jmage\.m2\repository\commons-io\commons-io\2.12.0\commons-io-2.12.0.jar App.java ListFilesInDirectory.java CryptoFiles.java Input.java

Para el ejercicio n2exercici1, como tenemos que importar varios .jar, la ruta queda así:
	javac -cp C:\Users\jmage\.m2\repository\commons-io\commons-io\2.12.0\commons-io-2.12.0.jar:C:\Users\jmage\.m2\repository\org\apache\commons\commons-configuration2\2.9.0\commons-configuration2-2.9.0.jar App.java ListFilesInDirectory.java
	java -cp C:\Users\jmage\.m2\repository\commons-io\commons-io\2.12.0\commons-io-2.12.0.jar:C:\Users\jmage\.m2\repository\org\apache\commons\commons-configuration2\2.9.0\commons-configuration2-2.9.0.jar;. n2exercici1.App
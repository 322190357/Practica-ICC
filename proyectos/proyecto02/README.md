# Proyecto-ICC

#Breve descripción de la estructura del proyecto.
Este proyecto es un programa en Java llamado Esteganografía, que permite descifrar mensajes ocultos en textos mediante varias técnicas. Todo está contenido en una única clase Esteganografia, la cual organiza sus funciones principales de la siguiente manera:
- Métodos de apoyo:

    + normaliza(String texto): Limpia un texto eliminando acentos, símbolos, y convirtiendo todo a minúsculas.

    + limpiaPalabra(String palabra): Elimina comillas de las palabras.

- Métodos estándar importantes utilizados:

    + toLowerCase(): Convierte cadenas a minúsculas.

    + replace(), replaceAll(): Modifican o eliminan caracteres en cadenas.

    + substring(): Extrae partes de cadenas.

    + charAt(): Extrae caracteres específicos.

    + contains(): Verifica si una cadena contiene otra.

    + length(): Obtiene el tamaño de cadenas o palabras.

    + asNext(): Usado con Scanner para recorrer palabras del texto.

- Interfaz con el usuario:

    + Hay un menú interactivo en consola que ofrece al usuario 5 opciones distintas para aplicar las funciones anteriores.

    + El usuario puede ingresar los textos y parámetros necesarios basados en el pdf dado por el profesor.

#Inconvenientes que presentamos.
- Al momento de realizar las pruebas con cada forma de ocultar la información
  en una de las computadoras el código no compilaba bien, es decir las pruebas
  que si resultaban correctas en otra computadora en esta no eran las esperadas 
  por lo que optamos por usar el codigo en internet a traves de esta computadora.

#Instrucciones para ejecutar el código del proyecto 2:

1. Situarse desde la terminal en la carpeta donde se encuentra el codigo.
2. Ejecutar el comando javac Esteganografia.java
3. Ejecutar el comando java Esteganografia
4. Elegir mediante el número que se muestra la forma de ocultar la información.
5. Realizar la prueba de dicha forma, usando el pdf que se mandó.

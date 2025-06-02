# Practica-ICC

## Decisión sobre el método toString()

El método `toString()` fue declarado como `abstract` dentro de la clase `FiguraGeometrica`.

## Justificación:
Cada figura geométrica tiene una representación textual diferente. Es decir, un triángulo necesita mostrar sus tres lados, base y altura; un rectángulo requiere base y altura; y un cuadrado puede usar un solo lado o repetirlo.

Como la forma de representar cada figura varía, no es posible definir un comportamiento útil en la superclase. Por eso, la mejor decisión es que `toString()` sea un método abstracto y que cada subclase implemente su propia versión.

#Instrucciones para ejecutar el código de la practica 5:

1. Situarse desde la terminal en la carpeta donde se encuentra el codigo.
2. Ejecutar el comando javac Main.java
3. Ejecutar el comando java Main
4. Indicar con un número para ver que tipo de iteración usar.

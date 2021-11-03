# Ejercicio refuerzo hilos

## Ejercicio 1)

>Escriba una clase con un contador interno, que se incrementa cada vez que se invoca el método siguiente(). La clase debe poderse utilizar en un programa concurrente. Además, la clase proporciona otros dos métodos, esperarPar() y esperarImpar(), que hacen que el hilo (thread) que los invoca se quede bloqueada hasta que el valor del contador sea par o impar, respectivamente.

## Ejercicio 2)

>Sean tres hilos (threads), T1, T2 y T3, que utilizan tres recursos, R1, R2 y R3. El hilo T1 sólo necesita el recurso R1. El hilo T2 necesita los recursos R2 y R3. Por último, el hilo T3 requiere los tres recursos, R1, R2 y R3.

>Escriba un programa que controle el acceso de los hilos a los recursos. Cada hilo solicita los recursos que necesita invocando un método del programa. Cuando un hilo termina de usar los recursos que necesita, lo indica para que otros hilos puedan usarlos. El programa ha de asegurar que ningún recurso es utilizado por más de un hilo a la vez.
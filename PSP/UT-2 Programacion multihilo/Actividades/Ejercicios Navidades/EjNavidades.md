# Ejercicios Navidades Hilos 1

- **Creación de hilos cooperativos:**

## Ejercicio1. Temperaturas.

Tenemos una lista de todas las temperaturas máximas que se han producido cada día en Santa Cruz de Tenerife en los últimos 10 años. Los tenemos almacenados en una matriz de enteros.

Tendremos que encontrar la temperatura máxima de los últimos 100 días. Para ellos primero simularemos las temperaturas rellenando una matriz de 100 posiciones y a la rellenaremos aleatoriamente con números enteros, tomando valores entre -30 y 50.

Para encontrar la temperatura más alta, dividiremos la matriz en partes y crearemos tantos hilos como piezas hayamos creado. Cada subproceso debe buscar dentro de la matriz asignada cuál es la temperatura más alta.

Finalmente, una vez encontrado el máximo de cada subconjunto de la matriz, nos dirá cuál es el número máximo de los devueltos por cada subproceso.

Realizar el mismo ejercicio anterior pero para los últimos 10 años.


- **Creación de hilos que se comunican:**

## Ejercicio 2. Restaurante

En un restaurante hay un cocinero y un camarero. El cocinero no puede empezar a realizar pedidos hasta que el camarero no le notifique que tiene uno. Por tanto el cocinero deberá esperar a tener un pedido para poder hacerlo. Un camarero tarda unos 5 segundos en generar un pedido y los clientes van entrando en el restaurante de forma aleatoria. El cocinero sirve los platos cada 4 segundos.

Debe desarrollar una aplicación que controle este sistema utilizando hilos. Es una implementación de productor-consumidor donde el productor (camarero) notifica al consumidor (cocinero) que tiene un ítem (pedido) para consumir. Una forma de resolver el problema es crear dos clases: una camarero y otra cocinero, que implementen `runnable`(o hereden `thread`).

Deberemos sincronizar algún método o un bloque de código de algún método. Deberá mostrar a través de mensajes cuando el cocinero está esperando y cuando recibe el pedido del camarero. Dejamos la clase `Comanda` donde guardará los pedidos pendientes y el nombre del plato.
# Ejercicios Multihilos nivel 2

## Ejercicio 1) Ping Pong

>Modificar el código de la clase PingPong para obtener la siguiente salida: PpPpPpPpPp… (Se necesitará hacer uso de synchronized, wait y notify  Cuidado con el interbloqueo y la elección del testigo  O, alternativamente, se puede hacer uso de Semaphore).

## Ejercicio 2) Carrera 4x100

>Implementar una carrera por relevos: 

- Tenemos 4 Atletas dispuestos a correr

- Tenemos una clase principal Carrera 

- Tenemos un objeto estático testigo 

- Todos los atletas empiezan parados, uno comienza a correr (tarda entre 9 y 11s) y al terminar su carrera pasa el testigo a otro que comienza a correr, y así sucesivamente 

- Pistas: Thread.sleep y Math.random para simular la carrera, synchronized, wait y notify para el paso del testigo,O utlizar un Semaphore como testigo, System.currentTimeMillis o Calendar para ver tiempos


## Ejercicio 3) Carrera 100m lisos

>Implementar una carrera de 100m lisos: 

- Tenemos 8 Atletas dispuestos a correr 

- Cada uno tiene un atributo dorsal 

- Tenemos una clase principal Carrera 

- Indica el pistoletazo de salida y el resultado de la carrera 

- Todos los Atletas comienzan pero se quedan parados esperando el pistoletazo de salida 

- Luego comienzan a correr (tardan entre 9 y 11s) 

- Al llegar a meta notifican a la carrera su dorsal y terminan 

- La Carrera escribe “preparados” y espera 1s, luego escribe “listos” y espera 1s, finalmente escribe “ya!” y notifica a los hilos de los Atletas 

- Cada vez que un atleta le notifica su dorsal, escribe por pantalla: dorsal+” tarda “+System.currentTimeMillis()
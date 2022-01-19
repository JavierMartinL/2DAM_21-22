# Ejercicios InetAddress

## Ejercicio 1)

El objetivo de esta actividad es que tome práctica en el uso de la clase `InetAddress`.

Implemente un pedido similar al `nslookup` del sistema operativo. Para realizar la implementación creará una clase llamada `NsLookup`. La clase dispondrá de método `main` por el que recibirá los argumentos del pedido directamente del sistema. Recuerde que en Java los argumentos del sistema llegan en el parámetro del método `main` en formato de array de cadenas de carácter. Cada posición del array representa un argumento del pedido.

Concretamente, nuestro pedido `NsLookup`, podrá recibir como argumento o bien una IP o bien el nombre de un *host* . El pedido analizará el parámetro llegado desde el sistema operativo para detectar si se trata de una dirección IP o del nombre de un *host* . Es necesario detectar cualquiera de las dos versiones de direcciones IP.

Recuerde que la clase `String` dispone de un método llamado `matches` que permite pasarle una expresión regular como patrón, que le puede ayudar a detectar las direcciones. No es necesario utilizar una expresión demasiado compleja. No se trata de validar las direcciones sino de saber cómo distinguirlas de los nombres de dominio o dispositivos.

Una vez detectado el tipo de argumento, si se trata de una dirección IP habrá que encontrar el nombre del host asociado produciendo una salida similar a la siguiente:

~~~
Answer: 
	Address: <dirección IP> 
	Name: <nombre host>
~~~

Por ejemplo si desde el sistema operativo ejecutáramos `NsLookup 2a00:1450:400c:c06:0:0:0:69` deberíamos obtener la siguiente respuesta:

~~~
Answer: 
	Address: 2a00:1450:400c:c06:0:0:0:69 
	Nombre: wb-in-x69.1e100.net
~~~

Si por el contrario, se trata del nombre de un dominio o de un dispositivo, deberá mostrar todas las direcciones IP asociadas al nombre en un formato similar al anterior pero invirtiendo el orden y repitiendo la misma secuencia por cada dirección encontrada .

Así por ejemplo la llamada de podría producir una salida como la siguiente: `NsLookup` www.google.com

~~~
Answer:
  Name: www.google.com
  Address: 173.194.67.104
  Name: www.google.com
  Address: 173.194.67.147
  Name: www.google.com
  Address: 173.194.67.105
  Name: www.google.com
  Address: 173.194.67.99
~~~

## Ejercicio 2)

El objetivo de esta actividad es que tome práctica en el tratamiento de direcciones IP.

Se desea construir una clase llamada `InetAddressTester` que pueda realizar ciertas comprobaciones dada una dirección IP, representada por una instancia de `InetAddress`. Las comprobaciones que la clase podrá realizar son:

- Comprobar si es una dirección tipo loopback
- Comprobar si es una dirección local
- Comprobar si la dirección sigue un patrón determinado definido por una dirección base y una máscara.

La clase `InetAddressTester` deberá tener definidos 4 constantes con los siguientes valores:

~~~
	public static final int ANY_IP_TEST=0;
	public static final int LOOPBACK_TEST=1;
	public static final int LOCAL_TEST=2;
~~~

Además será necesario que implemente 2 métodos polimórficos llamados `init` para conseguir configurar adecuadamente los objetos `InetAddressTester` creados:

- `public void init(int property)`. Recibirá un valor numérico comprendido entre 1 y 2 ambos incluidos y permitirá indicar si queremos comprobar si una dirección es `LOOPBACK (1)`o `LOCAL (2)`.
- `public void init(byte[] ipToMatch, byte[] maskForMatching)`. Permitirá definir una dirección IP base y una máscara.

Por último, la clase tendrá un método con una sintaxis:

- `public boolean isCompliant(InetAddress address)` que comprueba si la dirección pasada por parámetro cumple con la última característica entrada a través de uno de los métodos `init`.
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjerciciosIniciales
{
    class Ejercicios
    {

        /**
         * Realiza una aplicación que pregunte un número por teclado y devuelva una 'piramide vertical' con 
         * altura el número que nos han facilitado.
         */
        public static void ejercicio1(int altura)
        {
            // Aumentar *
            for (int i = 1; i <= altura; i++)
            {
                for (int j = 0; j < i; j++)
                {
                    Console.Write("*");
                }
                Console.WriteLine();
            }

            // Disminuir *
            for (int i = altura - 1; i > 0; i--)
            {
                for (int j = 0; j < i; j++)
                {
                    Console.Write("*");
                }
                Console.WriteLine();
            }
        }

        /**
         * Realizar una función que dado un DNI (comprobar que es un número entre 0 y 99999999), devuelva la 
         * letra asociado al mismo. Esta letra se calcula como el módulo (resto) de la división del número del 
         * DNI entre 23, y a partir del resto se escoge una de las siguientes letras según la posición: TRWAGMYFPDXBNJZSQVHLCKET.
         * Por ejemplo, para el DNI 12345678, al dividir entre 23 se obtiene como resto 14, por lo que le 
         * corresponde la letra 'Z', siendo el DNI correcto 12345678Z.
         */
        public static void ejercicio2(int numDni)
        {
            String cadenaLetras = "TRWAGMYFPDXBNJZSQVHLCKET";

            if (numDni >= 0 && numDni <= 99999999)
            {
                int posLetra = numDni % 23;
                char letra = cadenaLetras.ToCharArray()[posLetra];

                Console.WriteLine("La letra para el DNI es {0} -> {1}-{0}", letra, numDni);
            }
            else
            {
                Console.WriteLine("Este número no es valido para un DNI");
            }

        }

        /**
         * Programa que nos dice qué índice de masa corporal tenemos a partir de nuestro peso en kilogramos y 
         * nuestra altura en metros.
         */
        public static void ejercicio3(double peso, double altura)
        {
            double imc = peso / (altura * altura);

            Console.WriteLine("Tu IMC es de : {0}", imc);
        }

        /**
         * Pide al usuario 2 valores numéricos, e indica cuál es más grande de los dos. Si son iguales indicarlo también.
         */
        public static void ejercicio4(int num1, int num2)
        {
            String mensaje = "";
            if (num1 > num2)
            {
                mensaje = "El número " + num1 + " es el mayor";
            } 
            else if (num1 < num2)
            {
                mensaje = "El número " + num2 + " es el mayor";
            } 
            else
            {
                mensaje = "Ambos números son iguales";
            }

            Console.WriteLine(mensaje);
        }

        /**
         * Lee un número por teclado e indica si es divisible entre 2 (resto = 0). Si no lo es, también debemos indicarlo. 
         * En caso afirmativo que calcule el factorial (n * (n-1) * ... * 1)
         */
        public static void ejercicio5(int num)
        {
            long resultado = num;
            int factorial = num;

            if (factorial % 2 == 0)
            {
                while (factorial > 1)
                {
                    factorial--;
                    resultado *= factorial;
                }
                Console.WriteLine("El factorial es: {0}", resultado);
            }
            else
            {
                Console.WriteLine("{0} no es un número par", num);
            }

        }

        /**
         * Crear una aplicación que nos permite insertar números hasta que insertamos un -1. Calcular el total de números introducidos, 
         * cuál es el más pequeño, cuál es el más grande, y el más repetido.
         */
        public static void ejercicio6(List<int> numeros)
        {
            int contador = 0;
            int numMax = 0;
            int numMin = 1000000000;
            int repetido = 0;
            int ocurencia = 0;

            Dictionary<int, int> repetidos = new Dictionary<int, int>();

            foreach(int numero in numeros)
            {
                contador += numero;
                if (numMax < numero)
                {
                    numMax = numero;
                }

                if (numMin > numero)
                {
                    numMin = numero;
                }

                if (!repetidos.ContainsKey(numero))
                {
                    repetidos.Add(numero, 1);
                }
                else
                {
                    repetidos[numero] += 1;
                }
            }

            foreach (var rep in repetidos)
            {
                if (rep.Value > ocurencia)
                {
                    ocurencia = rep.Value;
                    repetido = rep.Key;
                }
            }

            Console.WriteLine("El total de los numeros es {0}, el número mas pequeño es {1}, el número mas grande es {2} y el mas repetido es {3}", contador, numMin, numMax, repetido);
        }

        /**
         * Desarrollar un programa para jugar a "Adivina el número". Se parte de un número entero positivo previamente determinado 
         * (por ejemplo 15). Se pide al usuario que introduzca un valor numérico. Si el dato introducido por el usuario coincide con el almacenado,
         * el juego termina. Si el dato introducido por el usuario es menor (respectivamente mayor) que el almacenado, se indica esta 
         * situación al usuario y se le vuelve a pedir que introduzca otro número. El juego termina cuando el usuario acierta o si llega 
         * a las 5 oportunidades.
         */
        public static void ejercicio7()
        {
            int numero = 0;
            int secreto = 15;
            int oportunidades = 5;

            do
            {
                try
                {
                    Console.Write("-> ");
                    numero = int.Parse(Console.ReadLine());
                    oportunidades--;
                    if (numero < secreto)
                    {
                        Console.WriteLine("{0} , es mas pequeño que el secreto, te quedan {1} " + (oportunidades > 1 ? "oportunidades" : "oportunidad"), numero, oportunidades);
                    }
                    else if (numero > secreto)
                    {
                        Console.WriteLine("{0} , es mas grande que el secreto, te quedan {1} " + (oportunidades > 1 ? "oportunidades" : "oportunidad"), numero, oportunidades);
                    }
                    else
                    {
                        Console.WriteLine("Acertaste!!!  {0} , es el número secreto", numero);
                    }
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Debes introducir un número: " + ex.Message);
                }
            } 
            while (numero != secreto && oportunidades > 0);
        }

        /**
         * Aplicación de calculadora que muestre un menú con las opciones sumar, restar, multiplicar, dividir y salir. A continuación 
         * pida dos números, y por último la operación. Y devuelva el resultado.
         */
        public static void ejercicio8(int num1, int num2, char operacion)
        {
            int resutado;
            switch (operacion)
            {
                case 's':
                    resutado = num1 + num2;
                    Console.WriteLine("{0} + {1} = {2}", num1, num2, resutado);
                    break;
                case 'r':
                    resutado = num1 - num2;
                    Console.WriteLine("{0} - {1} = {2}", num1, num2, resutado);
                    break;
                case 'm':
                    resutado = num1 * num2;
                    Console.WriteLine("{0} * {1} = {2}", num1, num2, resutado);
                    break;
                case 'd':
                    resutado = num1 / num2;
                    Console.WriteLine("{0} / {1} = {2}", num1, num2, resutado);
                    break;
                default:
                    Console.WriteLine("El operador introducido '{0}' no equivale a un operador del menu", operacion);
                    break;
            }
        }

        /**
         * Crear un array de 20 números aleatorios enteros aleatorios entre 10 y 20. Para cada elemento, informar si es la primera vez 
         * que aparece, o si se trata de un elemento repetido y nos indique cuántas veces había aparecido con anterioridad. 
         * Con Diccionary: https://docs.microsoft.com/es-es/dotnet/api/system.collections.generic.dictionary-2?view=net-5.0
         */
        public static void ejercicio9()
        {

        }

        /**
         * Añadir el tratamiento de errores a los ejercicios anteriores
         * En los ejercicios:
         * > 5 - bucles hacer el factorial con recursividad.
         * > 6.- bucles utilizar arrayList
         * > 8.- iterativas, funciones(calculadora) utilizar una clase propia que recoja los operandos y que como métodos realice las operaciones
         */
        public static void ejercicio10()
        {

        }

        /**
         *  Crea un programa que nos dejará realizar diferentes acciones a escoger en menú siguiente:
         *  •  Mostrar el archivo 
         *  •  Añadir un texto al final del archivo 
         *  •  Borrar una palabra y nos devolverá el texto de nuevo pero sin la palabra escogida 
         *  •  Guardar el archivo con el mismo nombre 
         *  •  Salir 
         */
        public static void ejercicio11()
        {

        }

    }
}

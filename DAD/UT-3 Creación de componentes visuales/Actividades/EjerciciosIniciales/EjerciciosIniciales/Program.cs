﻿using System;
using System.Collections.Generic;

namespace EjerciciosIniciales
{
    class Program
    {
        static void Main(string[] args)
        {
            bool finalizar = false;
            do
            {
                menu();
                short opt = -1;

                try
                {
                    opt = short.Parse(Console.ReadLine());
                }
                catch (Exception ex)
                {
                    Console.WriteLine("\n\tERROR: El valor introducido no es válido: \n" + ex.Message);
                }

                Console.WriteLine();

                switch (opt)
                {
                    case 0:
                        finalizar = true;
                        break;

                    case 1:
                        Console.WriteLine("Ejercicio 1");

                        try
                        {
                            Console.Write("Introduce la altura de la piramide: ");
                            int altura = int.Parse(Console.ReadLine());
                            Console.WriteLine("La altura introducida es: {0} \n", altura);

                            Ejercicios.ejercicio1(altura);
                        }
                        catch (Exception ex)
                        {
                            Console.WriteLine("\n\tERROR: Debes introducir un número: \n" + ex.Message);
                        }
                        break;

                    case 2:
                        Console.WriteLine("Ejercicio 2");

                        try
                        {
                            Console.Write("Introduce el numero del DNI para asignar una letra: ");
                            int numDni = int.Parse(Console.ReadLine());

                            Ejercicios.ejercicio2(numDni);
                        }
                        catch (Exception ex)
                        {
                            Console.WriteLine("\n\tERROR: Debes introducir un número: \n" + ex.Message);
                        }
                        break;

                    case 3:
                        Console.WriteLine("Ejercicio 3");

                        try
                        {
                            Console.Write("Introduce tu peso (kg): ");
                            double peso = double.Parse(Console.ReadLine());
                            Console.Write("Introduce tu altura (m): ");
                            double altura = double.Parse(Console.ReadLine());

                            Ejercicios.ejercicio3(peso, altura);
                        }
                        catch (Exception ex)
                        {
                            Console.WriteLine("\n\tERROR: Debes introducir un número: \n" + ex.Message);
                        }
                        break;

                    case 4:
                        Console.WriteLine("Ejercicio 4");

                        Console.WriteLine("Calcular que número es mayor");
                        try
                        {
                            Console.Write("Introduce el primer número: ");
                            int num1 = int.Parse(Console.ReadLine());
                            Console.Write("Introduce el segundo número: ");
                            int num2 = int.Parse(Console.ReadLine());

                            Ejercicios.ejercicio4(num1, num2);
                        }
                        catch (Exception ex)
                        {
                            Console.WriteLine("\n\tERROR: Debes introducir un número: \n" + ex.Message);
                        }
                        break;

                    case 5:
                        Console.WriteLine("Ejercicio 5");

                        Console.WriteLine("Número Factorial");
                        try
                        {
                            Console.Write("Escribre un número: ");
                            int num = int.Parse(Console.ReadLine());

                            Ejercicios.ejercicio5(num);
                        }
                        catch (Exception ex)
                        {
                            Console.WriteLine("\n\tERROR: Debes introducir un número: \n" + ex.Message);
                        }

                        break;

                    case 6:
                        Console.WriteLine("Ejercicio 6");

                        Console.WriteLine("Introduces todos los números (Salir = -1)");
                        List<int> numeros = new List<int>();
                        try
                        {
                            bool finalizarEj = false;
                            do
                            {
                                Console.Write("-> ");
                                int numero = int.Parse(Console.ReadLine());

                                if (numero >= 0)
                                {
                                    numeros.Add(numero);
                                }
                                else
                                {
                                    finalizarEj = true;
                                }
                            }
                            while (!finalizarEj);

                            Ejercicios.ejercicio6(numeros);
                        }
                        catch (Exception ex)
                        {
                            Console.WriteLine("\n\tERROR: Debes introducir un número: \n" + ex.Message);
                        }

                        break;

                    case 7:
                        Console.WriteLine("Ejercicio 7");

                        Console.WriteLine("Acierta el número secreto, tienes 5 oportunidades");

                        Ejercicios.ejercicio7();
                        break;

                    case 8:
                        Console.WriteLine("Ejercicio 8");

                        menuCalculadora();
                        int primerNumero = 0;
                        int segundoNumero = 0;
                        char operacion = 'x';

                        try
                        {
                            Console.Write("Introduce el primer número: ");
                            primerNumero = int.Parse(Console.ReadLine());
                            Console.Write("Introduce el segundo número: ");
                            segundoNumero = int.Parse(Console.ReadLine());
                        }
                        catch (Exception ex)
                        {
                            Console.WriteLine("\n\tERROR: Debes introducir un número: \n" + ex.Message);
                        }
                        try
                        {
                            Console.Write("Introduce un operador del menu: ");
                            operacion = char.Parse(Console.ReadLine());
                        }
                        catch (Exception ex)
                        {
                            Console.WriteLine("\n\tERROR: Debes introducir un caracter: \n" + ex.Message);
                        }

                        if (operacion != 'x') {
                            Ejercicios.ejercicio8(primerNumero, segundoNumero, operacion);
                        }

                        break;

                    case 9:
                        Console.WriteLine("Ejercicio 9");
                        break;

                    case 10:
                        Console.WriteLine("Ejercicio 10");
                        break;

                    case 11:
                        Console.WriteLine("Ejercicio 11");
                        break;

                    default:
                        break;
                }

            } 
            while (!finalizar);

        }

        private static void menu()
        {
            String ejercicios = "\t1)  Ejercicio 1" +
                "\n\t2)  Ejercicio 2" +
                "\n\t3)  Ejercicio 3" +
                "\n\t4)  Ejercicio 4" +
                "\n\t5)  Ejercicio 5" +
                "\n\t6)  Ejercicio 6" +
                "\n\t7)  Ejercicio 7" +
                "\n\t8)  Ejercicio 8" +
                "\n\t9)  Ejercicio 9" +
                "\n\t10) Ejercicio 10" +
                "\n\t11) Ejercicio 11" +
                "\n\t0)  Salir";

            Console.WriteLine("\nMenu de Ejercicios:");
            Console.WriteLine(ejercicios);
            Console.Write("\nQue ejercicio quieres ejecutar: ");

        }

        private static void menuCalculadora()
        {
            String operaciones = "\ts) sumar" +
                "\n\tr) restar" +
                "\n\tm) multiplicar" +
                "\n\td) dividir" +
                "\n\tx) Salir";

            Console.WriteLine("\nMenu de Operaciones:");
            Console.WriteLine(operaciones);
        }
    }
}

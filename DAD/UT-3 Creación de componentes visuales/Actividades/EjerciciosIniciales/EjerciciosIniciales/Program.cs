using System;

namespace EjerciciosIniciales
{
    class Program
    {
        static void Main(string[] args)
        {
            bool finalizar = false;
            do
            {
                Program.menu();
                short opt = -1;

                try
                {
                    opt = short.Parse(Console.ReadLine());
                }
                catch (Exception ex)
                {
                    Console.WriteLine("\n\tERROR: El valor introducido no es válido\n");
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
                            int altura = Int32.Parse(Console.ReadLine());
                            Console.WriteLine("La altura introducida es: {0} \n", altura);

                            Ejercicios.ejercicio1(altura);
                        } catch (Exception ex)
                        {
                            Console.WriteLine("\n\tERROR: Debes introducir un número\n");
                        }
                        break;

                    case 2:
                        Console.WriteLine("Ejercicio 2");

                        try
                        {
                            Console.Write("Introduce el numero del DNI para asignar una letra: ");
                            int numDni = Int32.Parse(Console.ReadLine());

                            Ejercicios.ejercicio2(numDni);
                        } catch (Exception ex)
                        {
                            Console.WriteLine("\n\tERROR: Debes introducir un número\n");
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
                        } catch (Exception ex)
                        {
                            Console.WriteLine("\n\tERROR: Debes introducir un número\n");
                        }
                        break;

                    case 4:
                        Console.WriteLine("Ejercicio 4");

                        Console.WriteLine("Calcular que número es mayor");
                        try
                        {
                            Console.Write("Introduce el primer número: ");
                            int num1 = Int32.Parse(Console.ReadLine());
                            Console.Write("Introduce el segundo número: ");
                            int num2 = Int32.Parse(Console.ReadLine());

                            Ejercicios.ejercicio4(num1, num2);
                        } catch (Exception ex)
                        {
                            Console.WriteLine("\n\tERROR: Debes introducir un número\n");
                        }
                        break;

                    default:
                        break;
                }

            } while (!finalizar);

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
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;

namespace AEUT3_02_Ejercicios_CS
{
    class Metodo
    {
        public static void calcularDiasManual(string fechaActual)
        {
            string fechaDiaCanarias = "30/05/2022";
            Console.WriteLine("fecha actual: " + fechaActual);
            Console.WriteLine("fecha dia canarias: " + fechaDiaCanarias);

            string[] fechaDia = fechaDiaCanarias.Split("/");
            string[] fechaAc = fechaActual.Split("/");
            int cantAnios = int.Parse(fechaDia[2]) - int.Parse(fechaAc[2]);
            if (cantAnios >= 0)
            {
                Console.WriteLine(cantAnios);
            }
        }

        public static string accionesTexto(string texto, string palabra, string palabraNueva, int accion)
        {
            string textoLower = texto.ToLower();
            string palabraLower = palabra.ToLower();
            string palabraNuevaLower = palabraNueva.ToLower();

            switch (accion)
            {
                case 1:
                    int cantRepetido = Regex.Matches(textoLower, palabraLower).Count;
                    if (cantRepetido == 0)
                    {
                        Console.WriteLine("\nLa palabra '{0}' no aparece en el texto\n", palabra);
                    }
                    else
                    {
                        Console.WriteLine("\nLa palabra '{0}' aparece {1} {2}\n", palabra, cantRepetido, cantRepetido > 1 ? "veces" : "vez");
                    }
                    break;
                case 2:
                    texto = textoLower.Replace(palabraLower, palabraNuevaLower);
                    break;
                case 3:
                    texto = textoLower.Replace(palabraLower, "");
                    break;
            }
            return texto;
        }
    }
}

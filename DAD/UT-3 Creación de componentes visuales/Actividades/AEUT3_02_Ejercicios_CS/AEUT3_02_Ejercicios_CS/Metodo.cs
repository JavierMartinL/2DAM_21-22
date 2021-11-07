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

        /**
         * Método que con un texto introducido realiza acciones sobre él con una palabra introducida
         */
        public static string accionesTexto(string texto, string palabra, string palabraNueva, int accion) 
        {
            // Pasamos todo el texto introducido a minúsculas para poder buscar mejor las palabras
            string textoLower = texto.ToLower();
            string palabraLower = palabra.ToLower();
            string palabraNuevaLower = palabraNueva.ToLower();

            switch (accion)
            {
                case 1: // Buscar
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
                case 2: // Modificar
                    texto = textoLower.Replace(palabraLower, palabraNuevaLower);
                    break;
                case 3: // Eliminar
                    texto = textoLower.Replace(palabraLower, "");
                    break;
            }
            return texto;
        }

        /**
         * Método que se encarga de contar cuántas bases aparecen, saber cual es la que se repite mayor veces seguidamente y comprobar cuál es el codón predominante.
         * @cadena string con la cadena de bases
         */
        public static void bioinformatica(string cadena)
        {
            // Contabilizar la cantidad de bases que existen
            Dictionary<char, int> bases = new Dictionary<char, int>();
            // Contabilizar la cantidad de codones que existen
            Dictionary<string, int> codones = new Dictionary<string, int>();

            // Variables para localizar las bases que se repiten más veces seguidas
            char caracterAnterior = 'F';
            int sumaCaracteres = 0;
            char caracterbaseLarga = ' ';
            int cantbaseLarga = 0;

            // Recorrer la cadena
            foreach (char caracter in cadena)
            {
                // Guardar la base dentro del diccionario
                bases[caracter] = (!bases.ContainsKey(caracter)) ? 1 : bases[caracter] + 1;

                // Comprobar si la base anterior es igual a esta y si es asi aumentar la cantidad
                sumaCaracteres = (caracter == caracterAnterior) ? sumaCaracteres + 1 : 1;

                // Si la cantidad de base es mayor que la base más largas lo actualizamos
                if (sumaCaracteres > cantbaseLarga)
                {
                    caracterbaseLarga = caracter;
                    cantbaseLarga = sumaCaracteres;
                }
                
                // Actualizar la base anterior
                caracterAnterior = caracter;
            }

            // Variables para localizar el codón predominante
            string codonPredominante = "";
            int cantCodonPredominante = 0;

            for (int i = 0; i < cadena.Length - 2; i++)
            {
                string codon = cadena.Substring(i, 3);

                // Guardar el codón en el diccionario
                codones[codon] = (!codones.ContainsKey(codon)) ? 1 : codones[codon] + 1;

                // Si el codón tiene más repeticiones que el actual predominante lo actualizamos
                if (codones[codon] > cantCodonPredominante)
                {
                    codonPredominante = codon;
                    cantCodonPredominante = codones[codon];
                }
            }

            // Mostrar los resultados
            Console.WriteLine("{0} A, {1} C, {2} T, {3} G",
                bases.TryGetValue('A', out int value) ? value : 0, 
                bases.TryGetValue('C', out value) ? value : 0,
                bases.TryGetValue('T', out value) ? value : 0,
                bases.TryGetValue('G', out value) ? value : 0
                );

            Console.WriteLine("La base que más veces seguidas se repite es la {0} con {1} repeticiones seguidas", caracterbaseLarga, cantbaseLarga);

            if (codonPredominante.Equals(""))
            {
                Console.WriteLine("No existe ningún codón");
            }
            else
            {
                Console.WriteLine("El codón que predomina es {0}", codonPredominante);
            }
        }
    }
}

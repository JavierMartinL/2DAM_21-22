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
        /**
         * Método que calcula la diferencia de días entre la fecha introducida y el dia de Canarias (Manualmente)
         * @fechaActual string con la fecha de donde comenzará a contar
         */
        public static void calcularDiasManual(string fechaActual)
        {
            // Cantidad de días que tiene cada mes
            int[] meses = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            // Pasar la fecha introducida a enteros
            string[] arrayFechaActual = fechaActual.Split("/");
            int diaActual = int.Parse(arrayFechaActual[0]);
            int mesActual = int.Parse(arrayFechaActual[1]);
            int anioActual = int.Parse(arrayFechaActual[2]);

            // Dia de Canarias
            int diaCanarias = 30;
            int mesDiaCanarias = 5;
            int anioDiaCanarias = 2022;

            // Cantidad de dias
            int cantDias = 0;

            // Bucle que recorre los años
            for (int i = anioActual; i <= anioDiaCanarias; i++)
            {
                // Comprobamos hasta qué mes contamos
                int mesFin = i < anioDiaCanarias ? 12 : mesDiaCanarias;

                // Bucle que recorre los meses
                for (int j = mesActual; j <= mesFin; j++)
                {
                    // Bucle que recorre los dias
                    for (int k = diaActual; k <= meses[j - 1]; k++)
                    {
                        // Si es el dia de Canarias terminamos el bucle
                        if (j == mesFin && k == diaCanarias && i == anioDiaCanarias)
                        {
                            break;
                        }
                        // Sumamos los dias
                        cantDias++;
                    }
                    // Al finalizar el mes comenzar el siguiente desde el día 1
                    diaActual = 1;
                }
                // Al finalizar el año comenzar el siguiente desde enero
                mesActual = 1;
            }

            Console.WriteLine("Desde {0} faltan {1} dias para llegar al Dia de Canarias ({2}/{3}/{4})", fechaActual, cantDias, diaCanarias, mesDiaCanarias, anioDiaCanarias);

        }

        /**
         * Método que calcula la diferencia de días entre la fecha introducida y el día de Canarias
         */
        public static void calcularDiasAutomatico(DateTime fechaActual)
        {
            // Día de Canarias
            DateTime diaCanarias = new DateTime(2022, 5, 30);

            // Recoger el tiempo entre las dos fechas
            TimeSpan tiempo = diaCanarias - fechaActual;

            // Con ese tiempo calcular el número de dias
            int cantDias = tiempo.Days;

            Console.WriteLine("Desde {0} faltan {1} dias para llegar al Dia de Canarias ({2})", fechaActual.ToString("d"), cantDias, diaCanarias.ToString("d"));
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
         * Método que se encarga de contar cuántas bases aparecen, saber cual es la que se repite mayor veces seguidamente y comprobar cuál 
         * es el codón predominante.
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

        /**
         * Método que se encarga en controlar los datos que recibimos del fichero y muestra las media de temperaturas Máximas/Mínimas/Medias 
         * y muestra las temperaturas más frecuentes
         * @informacion List<string> con los datos del fichero
         */
        public static void calcularTemperatura(List<string> informacion)
        {
            // Se encargan de controlar cuantas veces se repiten las temperaturas
            Dictionary<int, int> temperaturasMax = new Dictionary<int, int>();
            Dictionary<int, int> temperaturasMin = new Dictionary<int, int>();
            Dictionary<int, int> temperaturasMedia = new Dictionary<int, int>();

            // Se encargan de sumar todas las temperaturas para calcular la media
            decimal sumaTempMaximas = 0;
            decimal sumaTempMinimas = 0;
            decimal sumaTempMedias = 0;

            // Cantidad de temperaturas introducidas
            int cantTemperaturas = 0;

            // Recorrer la información recibida y empezar a contabilizar de la línea 10 que es donde se introducen las temperaturas
            for (int i = 10; i < informacion.Count; i++)
            {
                string[] datos = informacion[i].Split(",");

                // Máxima
                decimal max = decimal.Round(decimal.Parse(datos[1].Replace(".", ",")), 2);
                sumaTempMaximas += max;
                temperaturasMax[(int) max] = (!temperaturasMax.ContainsKey((int) max)) ? 1 : temperaturasMax[(int) max] + 1;

                // MÍnima
                decimal min = decimal.Round(decimal.Parse(datos[2].Replace(".", ",")), 2);
                sumaTempMinimas += min;
                temperaturasMin[(int) min] = (!temperaturasMin.ContainsKey((int) min)) ? 1 : temperaturasMin[(int) min] + 1;

                // Media
                decimal media = decimal.Round(decimal.Parse(datos[3].Replace(".", ",")), 2);
                sumaTempMedias += media;
                temperaturasMedia[(int) media] = (!temperaturasMedia.ContainsKey((int) media)) ? 1 : temperaturasMedia[(int) media] + 1;

                cantTemperaturas++;
            }

            // Media de las temperaturas
            decimal mediaTempMax = decimal.Round((sumaTempMaximas / cantTemperaturas), 2);
            decimal mediaTempMin = decimal.Round((sumaTempMinimas / cantTemperaturas), 2);
            decimal mediaTempMedia = decimal.Round((sumaTempMedias / cantTemperaturas), 2);

            // Variables para controlar las temperaturas más frecuentes
            int frecuenciaMax = 0;
            int cantFrecuenciaMax = 0;
            int frecuenciaMin = 0;
            int cantFrecuenciaMin = 0;
            int frecuenciaMedia = 0;
            int cantFrecuenciaMedia = 0;

            // Calcular la temperatura más frecuente de las máximas
            foreach (var a in temperaturasMax)
            {
                if (a.Value > cantFrecuenciaMax)
                {
                    frecuenciaMax = a.Key;
                    cantFrecuenciaMax = a.Value;
                }
            }

            // Calcular la temperatura más frecuente de las mínimas
            foreach (var a in temperaturasMin)
            {
                if (a.Value > cantFrecuenciaMin)
                {
                    frecuenciaMin = a.Key;
                    cantFrecuenciaMin = a.Value;
                }
            }

            // Calcular la temperatura más frecuente de las medias
            foreach (var a in temperaturasMedia)
            {
                if (a.Value > cantFrecuenciaMedia)
                {
                    frecuenciaMedia = a.Key;
                    cantFrecuenciaMedia = a.Value;
                }
            }

            // Mostrar los resultados
            Console.WriteLine("\tLa media de las temperaturas maximas es: {0} ºC y la temperatura mas frecuente es {1} ºC", mediaTempMax, frecuenciaMax);
            Console.WriteLine("\tLa media de las temperaturas minimas es: {0} ºC y la temperatura mas frecuente es {1} ºC", mediaTempMin, frecuenciaMin);
            Console.WriteLine("\tLa media de las temperaturas medias es: {0} ºC y la temperatura mas frecuente es {1} ºC", mediaTempMedia, frecuenciaMedia);
        }
    }
}

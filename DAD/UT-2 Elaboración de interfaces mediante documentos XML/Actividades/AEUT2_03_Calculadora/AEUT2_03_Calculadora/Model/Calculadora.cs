using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AEUT2_03_Calculadora.Model
{
    public class Calculadora
    {

        private double resultado;
        private double numGuardado;
        private double numIntroducido;
        private string operador;
        private List<string> operaciones;

        /// <summary>
        /// Contructor por defecto que inicializa las variables necesarias
        /// </summary>
        public Calculadora()
        {
            this.resultado = this.numGuardado = this.numIntroducido = 0;
            this.operador = "";
            this.operaciones = new List<string>();
        }

        /// <summary>
        /// Metodo para insercion del numero que se ha introducido el usuario
        /// </summary>
        /// <param name="strNumero">string con el numero que queremos almacenar</param>
        public void introducirNumero(string strNumero)
        {
            numIntroducido = Double.Parse(strNumero);
        }

        /// <summary>
        /// Metodo que realiza el calculo de la operacion insertada por el usuario
        /// </summary>
        /// <param name="op">operador introducido por el usuario</param>
        public void operar(string op)
        {
            
            if (operador.Equals(""))
            {
                resultado = numGuardado = numIntroducido;
                numIntroducido = 0;
            } else
            {
                double num = numGuardado;
                switch (operador)
                {
                    case "+": // Sumar
                        resultado = numGuardado += numIntroducido;
                        break;
                    case "-": // Restar
                        resultado = numGuardado -= numIntroducido;
                        break;
                    case "x": // Multiplicar
                        resultado = numGuardado *= numIntroducido;
                        break;
                    case "/": // Dividir
                        resultado = numGuardado /= numIntroducido;
                        break;
                }
                // Guardar la operacion realizada
                if (!operador.Equals("="))
                    operaciones.Add(num + " " + operador + " " + numIntroducido + " = " + resultado);
            }

            numIntroducido = 0;
            operador = op;
        }

        /// <summary>
        /// Metodo que limpia todos las variables utilizadas
        /// El historial de operaciones no se limpia
        /// </summary>
        public void limpiar()
        {
            resultado = numGuardado = numIntroducido = 0;
            operador = "";
        }

        /// <summary>
        /// Metodo que genera un string con la operacion que estamos realizando
        /// </summary>
        /// <returns>string con la operacion</returns>
        public string getOperacion()
        {
            if (operador.Equals("="))
            {
                string strOperacion = operaciones[operaciones.Count() - 1].Split('=')[0];
                return strOperacion + "=";
            } else
            {
                return numGuardado + " " + operador;
            }
        }

        /// <summary>
        /// Metodo que devuelve el resultado de la operacion
        /// </summary>
        /// <returns>string con el resultado</returns>
        public string getResultado()
        {
            return "" + resultado;
        }

        /// <summary>
        /// Metodo que devuelve todas las operaciones que han sido realizadas
        /// </summary>
        /// <returns>string con las operaciones</returns>
        public string historial()
        {
            string historial = "";
            foreach (string operacion in operaciones)
            {
                historial += operacion + "\n";
            }
            return historial;
        }
    }
}

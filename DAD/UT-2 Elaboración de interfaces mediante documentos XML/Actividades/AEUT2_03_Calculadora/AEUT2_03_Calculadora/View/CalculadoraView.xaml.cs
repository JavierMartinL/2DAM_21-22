using AEUT2_03_Calculadora.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace AEUT2_03_Calculadora.View
{
    /// <summary>
    /// Lógica de interacción para CalculadoraView.xaml
    /// </summary>
    public partial class CalculadoraView : Page
    {
        private string strNumero;
        private Calculadora calculadora;

        private bool numAlmacenado;
        private bool numDecimal;
        private bool mostrarHistorial;

        /// <summary>
        /// Contructor que inicializa las variables necesarias para el
        /// funcionamiento de la calculadora
        /// </summary>
        public CalculadoraView()
        {
            InitializeComponent();
            calculadora = new Calculadora();

            // Mostrar el numero 0 al iniciar la calculadora y no mostar nada en la memoria
            strNumero = "0";
            Resultado.Content = strNumero;
            Memoria.Content = " ";

            // variables que controlan si creamos un numero nuevo, si es decimal
            numAlmacenado = numDecimal = false;
            // Variable que contrala si se muestra/oculta el Historial
            mostrarHistorial = false;
            controlarHistorial(null, null);
        }

        /// <summary>
        /// Metodo que controla la accion de todos los botones
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void buttonPulsado(object sender, RoutedEventArgs e)
        {
            // Recoger el boton pulsado
            Button button = (Button)e.OriginalSource;

            switch(button.Content)
            {
                // Si es un numero lo almacenamos y mostramos
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    string valor = button.Content.ToString();

                    if (strNumero.Equals("0") || numAlmacenado)
                    {
                        strNumero = valor;
                        numAlmacenado = false;
                    }
                    else
                    {
                        strNumero += valor;
                    }
                    break;

                // Si es un operador preparamos el calculo
                case "+":
                case "-":
                case "x":
                case "/":
                case "=":
                    // Almacenar numero generado
                    calculadora.introducirNumero(strNumero);

                    // Preparar el calculo
                    calculadora.operar(button.Content.ToString());

                    // Mostramos los datos en la pantalla
                    Resultado.Content = calculadora.getResultado();
                    Memoria.Content = calculadora.getOperacion();

                    // Generar un nuevo numero
                    numAlmacenado = true;
                    numDecimal = false;
                    strNumero = "0";
                    break;

                // Limpiar todos los datos mostrados
                // No se contempla el historial que se limpia al cambiar de pagina
                case "C":
                    calculadora.limpiar();
                    strNumero = "0";
                    Resultado.Content = strNumero;
                    Memoria.Content = " ";
                    numAlmacenado = numDecimal = false;
                    break;

                // Borrar el ultimo valor del numero introducido
                case "⌫":
                    if (strNumero.Length == 1)
                        strNumero = "0";
                    else
                    {
                        if (strNumero[strNumero.Length - 1] == ',')
                            numDecimal = false;

                        strNumero = strNumero.Substring(0, strNumero.Length - 1);
                    }
                    break;

                // Invertir el numero introducido
                case "+/-":
                    if (!strNumero.Equals("0"))
                    {
                        if (strNumero.Contains("-"))
                            strNumero = strNumero.Replace("-", "");
                        else
                            strNumero = "-" + strNumero;
                    }
                    break;

                // Agregar decimales al numero
                case ",":
                    if (!numDecimal)
                    {
                        strNumero += ",";
                        numDecimal = true;
                        numAlmacenado = false;
                    }
                    break;
            }

            // Mostrar el numero que esta introduciendo el usuario
            if (!numAlmacenado)
            {
                Resultado.Content = strNumero;
            }

        }

        /// <summary>
        /// Metodo que muestra/oculta el historial con los calculos que han sido realizados
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public void controlarHistorial(object sender, RoutedEventArgs e)
        {
            DoubleAnimation animacion;

            if (mostrarHistorial)
            {
                animacion = new DoubleAnimation(300, new Duration(TimeSpan.FromSeconds(0.4)));
                Historial.BeginAnimation(WidthProperty, animacion);

                // Mostrar los calculos realizados
                string strHistorial = calculadora.historial();

                if (strHistorial.Equals(""))
                {
                    ContenidoHistorial.Content = "Vacio";
                }
                else
                {
                    ContenidoHistorial.Content = strHistorial;
                }
                
            }
            else
            {
                animacion = new DoubleAnimation(0, new Duration(TimeSpan.FromSeconds(0.2)));
                Historial.BeginAnimation(WidthProperty, animacion);
            }

            mostrarHistorial = !mostrarHistorial;
        }
    }
}
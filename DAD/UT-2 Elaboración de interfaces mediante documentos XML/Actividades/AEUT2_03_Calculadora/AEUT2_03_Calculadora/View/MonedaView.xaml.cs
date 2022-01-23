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
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace AEUT2_03_Calculadora.View
{
    /// <summary>
    /// Lógica de interacción para MonedaView.xaml
    /// </summary>
    public partial class MonedaView : Page
    {
        private string strNumero;
        private bool numDecimal;

        public MonedaView()
        {
            InitializeComponent();
            strNumero = "0";
            valorIntroducido.Content = "0 $";
            numDecimal = false;
        }

        private void buttonPulsado(object sender, RoutedEventArgs e)
        {
            // Recoger el boton pulsado
            Button button = (Button)e.OriginalSource;

            switch (button.Content)
            {
                // recoger numero pulsado
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

                    if (strNumero.Equals("0"))
                    {
                        strNumero = valor;
                    }
                    else
                    {
                        strNumero += valor;
                    }
                    break;

                // Limpiar el numero
                case "CE":
                    strNumero = "0";
                    numDecimal = false;
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

                // Agregar decimales al numero
                case ",":
                    if (!numDecimal)
                    {
                        strNumero += ",";
                        numDecimal = true;
                    }
                    break;
            }
            valorIntroducido.Content = strNumero + " $";
        }
    }
}

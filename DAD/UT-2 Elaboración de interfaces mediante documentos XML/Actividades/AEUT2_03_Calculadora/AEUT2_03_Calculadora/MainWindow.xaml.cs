using AEUT2_03_Calculadora.View;
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

namespace AEUT2_03_Calculadora
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            //Vista.Navigate(new CalculadoraView());
        }

        private void cambiarMoneda(object sender, RoutedEventArgs e)
        {
            //Vista.Navigate(new MonedaView());
        }

        private void cambiarCalculadora(object sender, RoutedEventArgs e)
        {
            //Vista.Navigate(new CalculadoraView());
        }

        private void pulsar(object sender, KeyEventArgs e)
        {
            Console.WriteLine(e.Key);
        }
    }
}

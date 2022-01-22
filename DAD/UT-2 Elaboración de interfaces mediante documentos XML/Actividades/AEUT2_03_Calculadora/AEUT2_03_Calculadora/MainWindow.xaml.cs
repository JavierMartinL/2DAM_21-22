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
using System.Windows.Media.Animation;
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
        // Variable para controlar si mostramos o ocultamos el Menu
        private bool mostrarMenu;

        public MainWindow()
        {
            InitializeComponent();

            // Ocultar el menu y mostrar por defecto la Calculadora
            mostrarMenu = false;
            Titulo.Text = "Estándar";
            Vista.Navigate(new CalculadoraView());
            controlarMenu(null, null);
        }

        /// <summary>
        /// Método que controla la visualización del menu
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public void controlarMenu(object sender, RoutedEventArgs e)
        {
            DoubleAnimation animacion;

            if (mostrarMenu)
            {
                animacion = new DoubleAnimation(200, new Duration(TimeSpan.FromSeconds(0.4)));
                Menu.BeginAnimation(WidthProperty, animacion);
            }
            else
            {
                animacion = new DoubleAnimation(0, new Duration(TimeSpan.FromSeconds(0.2)));
                Menu.BeginAnimation(WidthProperty, animacion);
            }

            mostrarMenu = !mostrarMenu;
        }

        /// <summary>
        /// Método que controla la vista segun el item pulsado en el Menu
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void mostrarVista(object sender, RoutedEventArgs e)
        {
            // Recoger el boton y extraer el nombre
            Button itemButton = (Button)e.OriginalSource;
            string buttonName = itemButton.Name;

            switch(buttonName)
            {
                // Mostrar la calculadora Básica
                case "Estándar":
                    Titulo.Text = buttonName;
                    Vista.Navigate(new CalculadoraView());
                    break;

                // Mostrar el convertidor de Moneda
                case "Moneda":
                    Titulo.Text = buttonName;
                    Vista.Navigate(new MonedaView());
                    break;

                // Resto de vistas
                default:
                    MessageBox.Show("La vista está en construccion!", "En construccion", MessageBoxButton.OK, MessageBoxImage.Warning);
                    break;
            }

            controlarMenu(null, null);
        }
    }
}

using ExUT2_01_XML.View;
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

namespace ExUT2_01_XML
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            // Cargar la vista de Vendedor
            Vista.Navigate(new VendedorView());
        }

        /// <summary>
        /// Método encargado de cambiar el tipo de vista
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void cambiarVista(object sender, RoutedEventArgs e)
        {
            Button button = (Button)e.OriginalSource;

            switch (button.Content)
            {
                // Vista de Vendedor
                case "Vendedores":
                    Vista.Navigate(new VendedorView());
                    break;

                // Vista de Responsabale
                case "Responsables":
                    Vista.Navigate(new ResponsableView());
                    break;
            }
        }
    }
}

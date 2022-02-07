using ExRecUT2_01_XML.View;
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

namespace ExRecUT2_01_XML
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            // Cargar la vista del Vendedor por defecto
            frmVista.Navigate(new VendedorView());
        }

        /// <summary>
        /// Metodo encargado de cambiar el tipo de vista segun los botones del Menu
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void cambiarVista(object sender, RoutedEventArgs e)
        {
            Button buttonMenu = (Button) e.OriginalSource;

            switch(buttonMenu.Content)
            {
                case "Vendedores": // Vista de Vendedores
                    frmVista.Navigate(new VendedorView());
                    break;
                case "Responsables": // Vista de Responsables
                    frmVista.Navigate(new ResponsableView());
                    break;
            }
        }
    }
}

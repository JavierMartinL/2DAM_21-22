using ExRecUT2_01_XML.Model;
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

namespace ExRecUT2_01_XML.View
{
    /// <summary>
    /// Lógica de interacción para ResponsableView.xaml
    /// </summary>
    public partial class ResponsableView : Page
    {
        // Lista de Articulos Vendidos
        List<ArticuloVendido> lista;

        public ResponsableView()
        {
            InitializeComponent();

            // Almacenar datos en una lista de Articulos Vendidos de prueba
            lista = new List<ArticuloVendido>();
            lista.Add(new ArticuloVendido("Botas", 42, "Marrón", 2));
            lista.Add(new ArticuloVendido("Sandalias", 36, "Naranja", 4));

            // Cargar la lista de Articulos Vendidos en el DataGrid
            dtgListaArticulosVendidos.ItemsSource = lista;
        }
    }
}

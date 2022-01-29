using ExUT2_01_XML.model;
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
using System.Xml;

namespace ExUT2_01_XML.View
{
    /// <summary>
    /// Lógica de interacción para VendedorView.xaml
    /// </summary>
    public partial class VendedorView : Page
    {
        List<Articulo> lista;

        public VendedorView()
        {
            InitializeComponent();

            // Cargar los colores disponibles
            cargarColores();

            // Mostrar una lista de prueba de Articulos
            lista = new List<Articulo>();
            for (int i = 0; i < 5; i ++)
            {
                lista.Add(new Articulo("articulo" + i, i, "Rojo", i));
            }
            listaArticulos.ItemsSource = lista;
        }

        /// <summary>
        /// Método que lee el xml y lo agrega al combobox
        /// </summary>
        private void cargarColores()
        {
            // Abrir fichero
            XmlDocument doc = new XmlDocument();
            doc.Load("D:\\Javier\\Desktop\\colores_basico.xml");

            // Crear lista de colores
            List<string> listaColores = new List<string>();

            // Recorrer el documento
            foreach (XmlNode node in doc.DocumentElement.ChildNodes)
            {
                // agregar cada color a la lista
                listaColores.Add(node.InnerText);
            }

            // Cargar la lista en el combobox
            Color.ItemsSource = listaColores;
        }

        /// <summary>
        /// Agregar un nuevo articulo
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void insertarArticulo(object sender, RoutedEventArgs e)
        {
            try
            {
                // Recoger los valores
                string tipoValue = Tipo.Text;
                int tallaValue = int.Parse(Talla.Text);
                string colorValue = Color.Text;
                double precioValue = double.Parse(Precio.Text);

                // Controlar los valores
                if (!tipoValue.Equals("") && !colorValue.Equals("") && precioValue > 0)
                {
                    Console.WriteLine("Guardar");
                    lista.Add(new Articulo(tipoValue, tallaValue, colorValue, precioValue));
                }

            }
            catch (Exception ex) { };
            listaArticulos.ItemsSource = lista;
        }

        /// <summary>
        /// Modificar un articulo
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void modificarArticulo(object sender, RoutedEventArgs e)
        {
            int a = listaArticulos.SelectedIndex;

            Console.WriteLine(a);
        }

        /// <summary>
        /// Eliminar un articulo
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void eliminarArticulo(object sender, RoutedEventArgs e)
        {
            int index = listaArticulos.SelectedIndex;
            if (index >= 0 && index > lista.Count)
            {
                lista.RemoveAt(index);
            }
            listaArticulos.ItemsSource = lista;
        }
    }
}

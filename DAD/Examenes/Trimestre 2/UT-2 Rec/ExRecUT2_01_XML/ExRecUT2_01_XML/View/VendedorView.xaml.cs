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
using System.Xml;

namespace ExRecUT2_01_XML.View
{
    /// <summary>
    /// Lógica de interacción para VendedorView.xaml
    /// </summary>
    public partial class VendedorView : Page
    {
        // Lista de Articulos
        List<Articulo> lista;

        public VendedorView()
        {
            InitializeComponent();

            // Almacenar datos en una lista de Articulos de prueba
            lista = new List<Articulo>();
            lista.Add(new Articulo("Sandalias", 36, "Naranja", 1, 35.00));
            lista.Add(new Articulo("Botas", 42, "Marrón", 2, 55.34));
            lista.Add(new Articulo("Sandalias", 36, "Naranja", 3, 35.00));

            // Cargar la lista de Articulos en el DataGrid
            dtgListaArticulos.ItemsSource = lista;
        }

        /// <summary>
        /// Método que inserta un nuevo Articulo validado en el DataGrid
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void insertarArticulo(object sender, RoutedEventArgs e)
        {
            // Validamos los datos
            Articulo articulo = validarDatos();

            if (articulo != null)
            {
                lista.Add(articulo);
                dtgListaArticulos.ItemsSource = null;
                dtgListaArticulos.ItemsSource = lista;
                limpiarValores();
            }
            
        }

        /// <summary>
        /// Método que modifica un Articulo seleccionado, valida los datos introducidos y actualiza el DataGrid
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void modificarArticulo(object sender, RoutedEventArgs e)
        {
            // Comprobar que existe un Articulo seleccionado
            if (dtgListaArticulos.SelectedIndex >= 0)
            {
                // recoger la posicion y actualizar los datos
                int index = dtgListaArticulos.SelectedIndex;
                Articulo articulo = validarDatos();

                if (articulo != null)
                {
                    lista[index] = articulo;
                    dtgListaArticulos.ItemsSource = null;
                    dtgListaArticulos.ItemsSource = lista;
                    limpiarValores();
                }
            }
            
        }

        /// <summary>
        /// Método que elimina un Articulo seleccionado del DataGrid
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void eliminarArticulo(object sender, RoutedEventArgs e)
        {
            // Comprobar que existe un Articulo seleccionado
            if (dtgListaArticulos.SelectedIndex >= 0)
            {
                // recoger la posicion y eliminar el Articulo
                int index = dtgListaArticulos.SelectedIndex;
                lista.RemoveAt(index);

                dtgListaArticulos.ItemsSource = null;
                dtgListaArticulos.ItemsSource = lista;
                limpiarValores();
            }
        }

        /// <summary>
        /// Método que lee el fichero de colores_extra.xml y segun el tipo carga sus colores
        /// </summary>
        /// <param name="tipo">Tipo de Articulo seleccionado</param>
        private void cargarColores(string tipo)
        {
            XmlDocument doc = new XmlDocument();
            doc.Load("colores_extra.xml");

            // Crear lista de colores
            List<string> listaColores = new List<string>();

            // Recorrer el documento
            foreach (XmlNode node in doc.DocumentElement.ChildNodes)
            {
                // Si el nodo es igual que el tipo
                if (node.Name.Equals(tipo.ToLower()))
                {
                    // Recoger todo sus valores
                    foreach (XmlNode children in node)
                    {
                        listaColores.Add(children.InnerText);
                    }
                }
            }

            // Cargar los colores en el combobox
            cmbColor.ItemsSource = listaColores;
        }

        /// <summary>
        /// Método que limpia los valores del formulario
        /// </summary>
        private void limpiarValores()
        {
            cmbTipo.SelectedItem = null;
            cmbColor.SelectedItem = null;
            cmbColor.ItemsSource = null;
            txtCantidad.Text = "";
            txtPrecio.Text = "";
            sldTalla.Value = 0;
        }

        /// <summary>
        /// Método que recoge el Articulo seleccionado en el DataGrid y muestra sus datos en el formulario
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void cargarItem(object sender, SelectionChangedEventArgs e)
        {
            // Comprobar si hay un Articulo seleccionado
            if (dtgListaArticulos.SelectedItem != null)
            {
                // Recoger el Articulo
                Articulo a = dtgListaArticulos.SelectedItem as Articulo;

                // Mostrar sus datos
                cmbTipo.Text = a.Tipo;
                cmbColor.Text = a.Color;
                txtCantidad.Text = a.Cantidad + "";
                txtPrecio.Text = a.Precio + "";
                sldTalla.Value = a.Talla; 
            }
        }

        /// <summary>
        /// Método que controla si se ha seleccionado un tipo de articulo para poder cargar sus colores
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void seleccionarTipo(object sender, SelectionChangedEventArgs e)
        {
            // Comprobar que hay un tipo seleccionado
            if (cmbTipo.SelectedItem != null)
            {
                // Recoger el valor y llamar al metodo que carga los colores
                ContentControl a = cmbTipo.SelectedItem as ContentControl;
                cargarColores(a.Content.ToString());
            }
        }

        /// <summary>
        /// Método que controla que los datos del formulario sean validos
        /// </summary>
        /// <returns>Si todo esta bien un Alumno con los datos, si falla algo un null</returns>
        private Articulo validarDatos()
        {
            // Iniciarlizar los datos
            Articulo articulo = null;
            string tipo = "";
            string color = "";
            int cantidad = 0;
            int talla = 0;
            double precio = 0;
            bool valoresErroneos = false;

            // Validar Tipo
            if (!cmbTipo.Text.Trim().Equals(""))
                tipo = cmbTipo.Text;
            else
                valoresErroneos = true;

            // Validar Color
            if (!cmbColor.Text.Trim().Equals(""))
                color = cmbColor.Text;
            else
                valoresErroneos = true;

            // Validar Cantidad
            if (!txtCantidad.Text.Trim().Equals(""))
            {
                // Controlar que sea un número
                try
                {
                    cantidad = int.Parse(txtCantidad.Text);
                } catch (Exception e)
                {
                    valoresErroneos = true;
                }
            }
            else
                valoresErroneos = true;

            // Validar Talla
            if (!txtTalla.Text.Trim().Equals(""))
            {
                // Controlar que sea un número
                try
                {
                    talla = int.Parse(txtTalla.Text);
                }
                catch (Exception e)
                {
                    valoresErroneos = true;
                }
            }
            else
                valoresErroneos = true;

            // Validar Precio
            if (!txtPrecio.Text.Trim().Equals(""))
            {
                // Controlar que sea un número
                try
                {
                    precio = double.Parse(txtPrecio.Text);
                }
                catch (Exception e)
                {
                    valoresErroneos = true;
                }
            }
            else
                valoresErroneos = true;

            // Si todos los campos son correctos creamos el Alumno
            if (!valoresErroneos)
                articulo = new Articulo(tipo, talla, color, cantidad, precio);
            else // Si falla algo muestro una alerta
                MessageBox.Show(
                    "Por favor revisa que los campos están rellenos y con sus valores introducidos correctamente",
                    "ERROR", 
                    MessageBoxButton.OK, 
                    MessageBoxImage.Error
                    );

            return articulo;
        }
    }
}
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using Controller;
using Model.entities;

namespace View
{
    public partial class AddProductView : Form
    {
        private ProductCategoryController productCategoryController;
        private Producto producto;

        public AddProductView(int idProducto)
        {
            productCategoryController = new ProductCategoryController();
            // Recoger el producto seleccionado
            producto = productCategoryController.recogerProducto(idProducto);
            InitializeComponent();

            lblNombre.Text = producto.Nombre;
        }

        /*
         * Método que recoge los valores para poder realizar un pedido
         */
        private void crearPedido(object sender, EventArgs e)
        {
            // Limpiar errores
            bool error = lblErrorCantidad.Visible = false;

            // Recoger la cantidad del producto
            int cantidad = 0;
            string strCantidad = txbCantidad.Text;

            // Controlar los errores
            if (strCantidad.Equals(""))
            {
                lblErrorCantidad.Text = "Este campo no puede estar vacio";
                error = lblErrorCantidad.Visible = true;
            }
            else
            {
                // Controlar que lo introducido sea un número
                try
                {
                    cantidad = int.Parse(txbCantidad.Text);

                    // Controlar que sea un valor positivo
                    if (cantidad <= 0)
                    {
                        lblErrorCantidad.Text = "Introduce un valor positivo";
                        error = lblErrorCantidad.Visible = true;
                    }
                }
                catch (Exception ex)
                {
                    txbCantidad.Text = "";
                    lblErrorCantidad.Text = "Debes introducir un número";
                    error = lblErrorCantidad.Visible = true;
                }
            }

            // Si no tenemos errores
            if (!error)
            {
                // Crear el nuevo pedido
                if (productCategoryController.crearPedido(producto, cantidad)) {
                    // Cerrar formulario
                    this.Close();
                }
                else
                {
                    // Mostrar error
                    lblErrorCantidad.Text = "No tenemos tanto Stock";
                    error = lblErrorCantidad.Visible = true;
                }
            }
        }

        /*
         * Método para poder enviar el formulario pulsando ENTER
         */
        private void keyEnter(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
                crearPedido(sender, e);
        }
    }
}

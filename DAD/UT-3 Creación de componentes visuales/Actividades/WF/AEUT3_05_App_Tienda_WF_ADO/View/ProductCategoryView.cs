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

namespace View
{
    public partial class ProductCategoryView : Form
    {
        private ProductCategoryController productCategoryController;

        public ProductCategoryView()
        {
            productCategoryController = new ProductCategoryController();
            InitializeComponent();
            
            // Cargar todos los productos
            cargarProductos("All");
            // Cargar todas las categorias
            cargarCategorias();
        }

        /*
         * Método que recoge los valores y los muestra dentro de un DataGridView
         */
        private void cargarProductos(string categoria)
        {
            // Recoger y mostrar los datos en el dataGridView
            dgvProductos.DataSource = productCategoryController.recogerProductos(categoria);

            // Cambiar el tipo de letra
            dgvProductos.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));

            // Modificar las cabeceras y evitar que puedan ser editadas
            if (dgvProductos.Columns.Count > 0)
            {
                dgvProductos.Columns[0].HeaderText = "ID";
                dgvProductos.Columns[0].ReadOnly = true;

                dgvProductos.Columns[1].HeaderText = "Name";
                dgvProductos.Columns[1].ReadOnly = true;

                dgvProductos.Columns[2].HeaderText = "Category";
                dgvProductos.Columns[2].ReadOnly = true;

                dgvProductos.Columns[3].HeaderText = "Description";
                dgvProductos.Columns[3].ReadOnly = true;

                dgvProductos.Columns[4].HeaderText = "Price";
                dgvProductos.Columns[4].ReadOnly = true;

                dgvProductos.Columns[5].HeaderText = "Quantity";
                dgvProductos.Columns[5].ReadOnly = true;
            }

            // Ajustar el tamaño de las celdas
            dgvProductos.AutoResizeColumns();
            dgvProductos.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;

            // Actualizar la lista
            dgvProductos.Update();
        }

        /*
         * Método que recoge todas las categorias y lo muestra dentro de un ListBox
         */
        private void cargarCategorias()
        {
            // Limpiar las categorias
            ltbCategorias.Items.Clear();

            // Recoger todas las categorias
            List<string> categorias = productCategoryController.recogerCategorias();

            // Insertar las categorias en la lista
            foreach (string categoria in categorias)
            {
                ltbCategorias.Items.Add(categoria);
            }

            // Agregar la opción para todos los productos
            ltbCategorias.Items.Add("All");
        }

        /*
         * Método para filtrar los productos segun la categoría seleccionada
         */
        private void filtar(object sender, EventArgs e)
        {
            // Recoger la categoría seleccionada
            string categoria = ltbCategorias.SelectedItem.ToString();

            // Cargar los productos
            if (!categoria.Equals(""))
            {
                cargarProductos(categoria);
            }
        }
    }
}

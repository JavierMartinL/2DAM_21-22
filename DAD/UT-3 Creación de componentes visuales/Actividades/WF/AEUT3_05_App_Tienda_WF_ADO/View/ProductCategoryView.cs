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
            cargarProductos();
            cargarCategorias();
        }

        private void cargarProductos()
        {
            // Recoger y mostrar los datos en el dataGridView
            dgvProductos.DataSource = productCategoryController.recogerProductos();

            dgvProductos.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
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

        private void cargarCategorias()
        {
            ltbCategorias.Items.Clear();
            List<string> categorias = productCategoryController.recogerCategorias();

            foreach (string categoria in categorias)
            {
                ltbCategorias.Items.Add(categoria);
            }

            ltbCategorias.Items.Add("All");
        }
    }
}

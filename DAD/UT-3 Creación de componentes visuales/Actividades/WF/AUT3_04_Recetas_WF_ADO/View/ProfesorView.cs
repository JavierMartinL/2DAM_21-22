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
    public partial class ProfesorView : Form
    {
        private ProfesorController profesorController;

        public ProfesorView()
        {
            profesorController = new ProfesorController();
            InitializeComponent();
            cargarCategorias();
        }

        private void cargarCategorias()
        {
            tsmiCategorias.DropDownItems.Clear();

            var itemTodas = new ToolStripMenuItem("TODAS");
            itemTodas.Click += new EventHandler(mostrarRecetasCategoria); 
            tsmiCategorias.DropDownItems.Add(itemTodas);

            foreach (string categoria in profesorController.recogerCategorias())
            {
                var newItem = new ToolStripMenuItem(categoria.ToUpper());
                newItem.Click += new EventHandler(mostrarRecetasCategoria);
                tsmiCategorias.DropDownItems.Add(newItem);
            }

        }

        private void mostrarRecetasCategoria(object sender, EventArgs e)
        {
            dgvRecetas.DataSource = profesorController.buscarRecetasCategoria(sender.ToString().ToLower());

            if (dgvRecetas.Columns.Count > 0)
            {
                dgvRecetas.Columns[0].HeaderText = "Nombre de la receta";
                dgvRecetas.Columns[0].ReadOnly = true;

                dgvRecetas.Columns[1].HeaderText = "Tiempo de preparación en minutos";
                dgvRecetas.Columns[1].ReadOnly = true;

                dgvRecetas.Columns[2].HeaderText = "Ingredientes necesarios";
                dgvRecetas.Columns[2].ReadOnly = true;

                dgvRecetas.Columns[3].HeaderText = "Descripción de la preparación";
                dgvRecetas.Columns[3].ReadOnly = true;
            }
            dgvRecetas.AutoResizeColumns();
            dgvRecetas.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.AllCells;
            dgvRecetas.Update();
        }

        private void salir(object sender, EventArgs e)
        {
            string titulo = "Salir";
            string mensaje = "¿Quieres cerrar la aplicación?";

            DialogResult cerrar = MessageBox.Show(mensaje, titulo, MessageBoxButtons.YesNo, MessageBoxIcon.Exclamation);

            if (cerrar == DialogResult.Yes)
            {
                Application.Exit();
            }
        }

        private void cerrarFormulario(object sender, FormClosedEventArgs e)
        {
            salir(sender, e);
        }
    }
}

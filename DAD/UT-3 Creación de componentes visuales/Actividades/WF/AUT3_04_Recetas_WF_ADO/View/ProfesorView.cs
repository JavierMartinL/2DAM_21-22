
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

        /*
         * Método que introduce las categorías dentro del menú desplegable 
         */
        private void cargarCategorias()
        {
            // Limpiar Categorias
            tsmiCategorias.DropDownItems.Clear();

            // Opción para mostrar todas las recetas
            var itemTodas = new ToolStripMenuItem("TODAS");
            itemTodas.Click += new EventHandler(mostrarRecetasCategoria); 
            tsmiCategorias.DropDownItems.Add(itemTodas);

            // Insertar todas las categorías recogidas de la DDBB
            foreach (string categoria in profesorController.recogerCategorias())
            {
                var newItem = new ToolStripMenuItem(categoria.ToUpper());
                newItem.Click += new EventHandler(mostrarRecetasCategoria);
                tsmiCategorias.DropDownItems.Add(newItem);
            }

        }

        /*
         * Método que muestra las recetas
         */
        private void mostrarRecetasCategoria(object sender, EventArgs e)
        {
            // Recoger las recetas según la opción elegida
            dgvRecetas.DataSource = profesorController.buscarRecetasCategoria(sender.ToString().ToLower());

            // Cambiar el nombre de las columnas
            if (dgvRecetas.Columns.Count > 0)
            {
                dgvRecetas.Columns[0].Visible = false;

                dgvRecetas.Columns[1].HeaderText = "Nombre de la receta";
                dgvRecetas.Columns[1].ReadOnly = true;

                dgvRecetas.Columns[2].HeaderText = "Tiempo de preparación en minutos";
                dgvRecetas.Columns[2].ReadOnly = true;

                dgvRecetas.Columns[3].HeaderText = "Ingredientes necesarios";
                dgvRecetas.Columns[3].ReadOnly = true;

                dgvRecetas.Columns[4].HeaderText = "Descripción de la preparación";
                dgvRecetas.Columns[4].ReadOnly = true;
            }
            // Ajustar el tamaño de las celdas
            dgvRecetas.AutoResizeColumns();
            dgvRecetas.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.AllCells;
            // Actualizar la lista
            dgvRecetas.Update();
        }

        /*
         * Método que muestra del modal para insertar una nueva receta
         */
        private void crearReceta(object sender, EventArgs e)
        {
            CrearReceta crearReceta = new CrearReceta();
            crearReceta.ShowDialog();
            cargarCategorias();
        }

        /*
         * Método que recoge las filas seleccionadas que queremos eliminar
         */
        private void borrarReceta(object sender, EventArgs e)
        {
            if (dgvRecetas.SelectedRows.Count > 0)
            {
                //Recorrer las filas seleccionadas
                foreach (DataGridViewRow Rw in dgvRecetas.SelectedRows)
                {
                    // Confirmar su eliminación
                    string mensaje = "¿Estas seguro que quieres eliminar la receta \"" + Rw.Cells[1].Value + "\"?";
                    DialogResult eliminar = MessageBox.Show(mensaje, "Eliminar Receta", MessageBoxButtons.YesNo, MessageBoxIcon.Warning);

                    if (eliminar == DialogResult.Yes)
                        // Eliminar la receta y la fila a la que corresponde
                        if (profesorController.eliminarReceta((int)Rw.Cells[0].Value))
                        {
                            dgvRecetas.Rows.Remove(Rw);
                            cargarCategorias();
                        }
                }
            }
        }

        /*
         * Método para cerrar el formulario
         */
        private void salir(object sender, EventArgs e)
        {
            Close();
        }

        /*
         * Método que pregunta al usuario si está seguro de cerrar el formulario
         */
        private void cerrarFormulario(object sender, FormClosingEventArgs e)
        {
            string titulo = "Salir";
            string mensaje = "¿Quieres cerrar la aplicación?";

            DialogResult cerrar = MessageBox.Show(mensaje, titulo, MessageBoxButtons.YesNo, MessageBoxIcon.Exclamation);

            if (cerrar == DialogResult.No)
            {
                e.Cancel = true;
            }
        }
    }
}

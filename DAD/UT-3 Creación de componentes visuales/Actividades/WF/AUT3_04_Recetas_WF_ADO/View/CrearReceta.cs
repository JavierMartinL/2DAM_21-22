using Controller;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace View
{
    public partial class CrearReceta : Form
    {
        private ProfesorController profesorController;

        public CrearReceta()
        {
            profesorController = new ProfesorController();
            InitializeComponent();
            cargarCategorias();
        }

        private void cargarCategorias()
        {
            cmbCategoria.Items.Clear();
            cmbCategoria.Items.Add("");

            foreach (string categoria in profesorController.recogerCategorias())
            {
                cmbCategoria.Items.Add(categoria);
            }

        }

        private void crear(object sender, EventArgs e)
        {
            bool error = lblErrorNombre.Visible = lblErrorCategoria.Visible = false;

            string nombre = txbNombre.Text;
            string categoria = cmbCategoria.Text.ToLower();
            string tiempo = txbTiempo.Text;
            string ingredientes = txaIngredientes.Text;
            string descripcion = txaDescripcion.Text;

            if (nombre.Trim().Equals("")) error = lblErrorNombre.Visible = true;
            if (categoria.Trim().Equals("")) error = lblErrorCategoria.Visible = true;
            
            if (!error) 
                if (profesorController.crearReceta(nombre, categoria, tiempo, ingredientes, descripcion))
                    Close();
        }

        private void cancelar(object sender, EventArgs e)
        {
            Close();
        }
    }
}

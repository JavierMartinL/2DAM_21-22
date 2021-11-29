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

        /*
         * Método que carga las categorías existentes en el combobox
         */
        private void cargarCategorias()
        {
            // Limpiar las categorias
            cmbCategoria.Items.Clear();
            // En blanco para que el usuario pueda escribir
            cmbCategoria.Items.Add("");

            // recoger la lista de categorías y agregarlas al combobox
            foreach (string categoria in profesorController.recogerCategorias())
            {
                cmbCategoria.Items.Add(categoria);
            }

        }

        /*
         * Método que recoge los datos del formulario y los envía al controlador para crear una receta
         */
        private void crear(object sender, EventArgs e)
        {
            // Limpiar los errores
            bool error = lblErrorNombre.Visible = lblErrorCategoria.Visible = false;

            // Recoger los valores
            string nombre = txbNombre.Text;
            string categoria = cmbCategoria.Text.ToLower();
            string tiempo = txbTiempo.Text;
            string ingredientes = txaIngredientes.Text;
            string descripcion = txaDescripcion.Text;

            // Si esta vacio lanzamos el error
            if (nombre.Trim().Equals("")) error = lblErrorNombre.Visible = true;
            if (categoria.Trim().Equals("")) error = lblErrorCategoria.Visible = true;
            
            if (!error) 
                // Guardar y si todo sale bien cerramos el formulario
                if (profesorController.crearReceta(nombre, categoria, tiempo, ingredientes, descripcion))
                    Close();
        }

        /*
         * Método para cerrar el formulario
         */
        private void cancelar(object sender, EventArgs e)
        {
            Close();
        }
    }
}

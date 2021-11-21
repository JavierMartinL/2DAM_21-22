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
    public partial class PersonalView : Form
    {

        public PersonalView()
        {
            InitializeComponent();
        }

        private void buscarPaciente(object sender, EventArgs e)
        {
            mensaje("Buscar paciente");
        }

        private void verFicha(object sender, EventArgs e)
        {
            mensaje("Ver ficha paciente");
        }

        private void sacarEtiqueta(object sender, EventArgs e)
        {
            mensaje("Sacar etiquetas del paciente");
        }

        private void actasClinicas(object sender, EventArgs e)
        {
            mensaje("Ver actas clínicos del paciente");
        }

        private void buscarNota(object sender, EventArgs e)
        {
            mensaje("Buscar nota");
        }

        private void crearNota(object sender, EventArgs e)
        {
            mensaje("Crear nota");
        }

        private void modificarNota(object sender, EventArgs e)
        {
            mensaje("Modificar nota");
        }

        private void eliminarNota(object sender, EventArgs e)
        {
            mensaje("Eliminar nota");
        }

        /*
         * Método para cerrar la App
         */
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


        /*
         * Método que muestra un mensaje al usuario
         */
        private void mensaje(string accion)
        {
            string titulo = accion;
            string mensaje = "La accion \"" + accion + "\" no está disponible" +
                "\n\nLo lamentamos, esta sección está en construcción";

            MessageBox.Show(mensaje, titulo, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
        }

    }
}

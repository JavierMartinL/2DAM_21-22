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
    /// <summary>
    /// Vista de Personal
    /// </summary>
    public partial class PersonalView : Form
    {

        public PersonalView()
        {
            InitializeComponent();
        }

        /// <summary>
        /// Método que abre la ventana para buscar pacientes
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void buscarPaciente(object sender, EventArgs e)
        {
            mensaje("Buscar paciente");
        }

        /// <summary>
        /// Método que abre la ventana para ver la ficha de un paciente
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void verFicha(object sender, EventArgs e)
        {
            mensaje("Ver ficha paciente");
        }

        /// <summary>
        /// Método que abre la ventana para ver etiquetas de un paciente
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void sacarEtiqueta(object sender, EventArgs e)
        {
            mensaje("Sacar etiquetas del paciente");
        }

        /// <summary>
        /// Método que abre la ventana para ver las actas de un paciente
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void actasClinicas(object sender, EventArgs e)
        {
            mensaje("Ver actas clínicos del paciente");
        }

        /// <summary>
        /// Método que abre la ventana para buscar una nota
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void buscarNota(object sender, EventArgs e)
        {
            mensaje("Buscar nota");
        }

        /// <summary>
        /// Método que abre la ventana para crear una nota
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void crearNota(object sender, EventArgs e)
        {
            mensaje("Crear nota");
        }

        /// <summary>
        /// Método que abre la ventana para modificar una nota
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void modificarNota(object sender, EventArgs e)
        {
            mensaje("Modificar nota");
        }

        /// <summary>
        /// Método que abre la ventana para eliminar una nota
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void eliminarNota(object sender, EventArgs e)
        {
            mensaje("Eliminar nota");
        }

        /// <summary>
        /// Método para cerrar la App
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
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

        /// <summary>
        /// Método que muestra un mensaje al usuario
        /// </summary>
        /// <param name="accion">Acción que queremos mostrar en el mensaje</param>
        private void mensaje(string accion)
        {
            string titulo = accion;
            string mensaje = "La accion \"" + accion + "\" no está disponible" +
                "\n\nLo lamentamos, esta sección está en construcción";

            MessageBox.Show(mensaje, titulo, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
        }

        /// <summary>
        /// Método que muestra la Ayuda de SANDCASTLE
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void mostrarAyuda(object sender, EventArgs e)
        {
            Help.ShowHelp(this, "DocumentacionSHFB.chm");
        }
    }
}

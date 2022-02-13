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
    /// Vista de Administrativo
    /// </summary>
    public partial class AdministrativoView : Form
    {
        public AdministrativoView()
        {
            InitializeComponent();
        }

        /// <summary>
        /// Método que muestra el menú de paciente
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void pacientesMenu(object sender, EventArgs e)
        {
            tlsPaciente.Visible = true;
        }

        /// <summary>
        /// Método que abre la ventana de centro de día
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void centroDia(object sender, EventArgs e)
        {
            tlsPaciente.Visible = false;
            mensaje("Centro de día");
        }

        /// <summary>
        /// Método que abre la ventana de cita
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void cita(object sender, EventArgs e)
        {
            tlsPaciente.Visible = false;
            mensaje("Cita");
        }

        /// <summary>
        /// Método que abre la ventana de guardar Actividad
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void guardarActividad(object sender, EventArgs e)
        {
            tlsPaciente.Visible = false;
            mensaje("Guardar actividad");
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
        /// Método que muestra el formulario para crear un nuevo Paciente
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void crearPaciente(object sender, EventArgs e)
        {
            CrearPacienteView crearPacienteView = new CrearPacienteView();
            crearPacienteView.ShowDialog();
        }

        /// <summary>
        /// Método que muestra el formulario para buscar a los pacientes
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void buscarPaciente(object sender, EventArgs e)
        {
            BuscarPacienteView buscarPacienteView = new BuscarPacienteView();
            buscarPacienteView.ShowDialog();
        }

        /// <summary>
        /// Método que muestra el formulario para eliminar a los pacientes
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void eliminarPaciente(object sender, EventArgs e)
        {
            BorrarPacienteView borrarPacienteView = new BorrarPacienteView();
            borrarPacienteView.ShowDialog();
        }

        /// <summary>
        /// Método que muestra un mensaje al usuario
        /// </summary>
        /// <param name="accion">Mensaje que queremos mostrar al Usuario</param>
        private void mensaje(string accion)
        {
            string titulo = "En construcción";
            string mensaje = "La accion \"" + accion + "\" no está disponible" +
                "\n\nLo lamentamos, esta sección está en construcción";

            MessageBox.Show(mensaje, titulo, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
        }
    }
}

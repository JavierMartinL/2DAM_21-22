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
    public partial class AdministrativoView : Form
    {
        public AdministrativoView()
        {
            InitializeComponent();
        }

        private void pacientesMenu(object sender, EventArgs e)
        {
            tlsPaciente.Visible = true;
        }

        private void centroDia(object sender, EventArgs e)
        {
            tlsPaciente.Visible = false;
            mensaje("Centro de día");
        }

        private void cita(object sender, EventArgs e)
        {
            tlsPaciente.Visible = false;
            mensaje("Cita");
        }

        private void guardarActividad(object sender, EventArgs e)
        {
            tlsPaciente.Visible = false;
            mensaje("Guardar actividad");
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
         * Método que muestra el formulario para crear un nuevo Paciente
         */
        private void crearPaciente(object sender, EventArgs e)
        {
            CrearPacienteView crearPacienteView = new CrearPacienteView();
            crearPacienteView.ShowDialog();
        }

        /*
         * Método que muestra el formulario para buscar a los pacientes
         */
        private void buscarPaciente(object sender, EventArgs e)
        {
            BuscarPacienteView buscarPacienteView = new BuscarPacienteView();
            buscarPacienteView.ShowDialog();
        }

        /*
         * Método que muestra un mensaje al usuario
         */
        private void mensaje(string accion)
        {
            string titulo = "En construcción";
            string mensaje = "La accion \"" + accion + "\" no está disponible" +
                "\n\nLo lamentamos, esta sección está en construcción";

            MessageBox.Show(mensaje, titulo, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
        }

    }
}

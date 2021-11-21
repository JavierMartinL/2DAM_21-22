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

        private void centroDia(object sender, EventArgs e)
        {
            mensaje("Centro de día");
        }

        private void cita(object sender, EventArgs e)
        {
            mensaje("Cita");
        }

        private void guardarActividad(object sender, EventArgs e)
        {
            mensaje("Guardar actividad");
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

        private void mensaje(string accion)
        {
            string titulo = "En construcción";
            string mensaje = "La accion \"" + accion + "\" no está disponible" +
                "\n\nLo lamentamos, esta sección está en construcción";

            MessageBox.Show(mensaje, titulo, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
        }
    }
}

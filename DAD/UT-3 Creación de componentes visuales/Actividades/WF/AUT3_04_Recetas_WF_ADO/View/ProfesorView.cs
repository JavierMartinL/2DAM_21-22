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
    public partial class ProfesorView : Form
    {
        public ProfesorView()
        {
            InitializeComponent();
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
    }
}

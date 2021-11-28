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

            tsmiCategorias.DropDownItems.Add("TODAS");

            foreach (string categoria in profesorController.recogerCategorias())
            {
                tsmiCategorias.DropDownItems.Add(categoria.ToUpper());
            }

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

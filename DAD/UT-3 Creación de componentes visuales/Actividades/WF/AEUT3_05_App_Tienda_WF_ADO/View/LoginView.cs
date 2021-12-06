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
    public partial class LoginVIew : Form
    {
        private LoginController loginController;

        public LoginVIew()
        {
            loginController = new LoginController();
            InitializeComponent();
        }

        /*
         * Método que recoger los valores del formulario, comprueba que no existan errores y los envía al controlador
         */
        private void login(object sender, EventArgs e)
        {
            // Restablecer los errores
            bool error = lblErrorStaff.Visible = lblErrorPassword.Visible = lblError.Visible = false;

            // Recoger los datos del usuario
            string strStaff = txbStaff.Text;
            int staff = 0;
            string password = txbPassword.Text;

            // Controlar los errores en los textBox
            // Controlar que introduzcan un valor en el staff
            if (strStaff.Trim().Equals("")) {
                lblErrorStaff.Text = "Introduce el número de Staff";
                error = lblErrorStaff.Visible = true;
            } 
            else
            {
                // Controlar que lo introducido se un número
                try
                {
                    staff = int.Parse(txbStaff.Text);
                }
                catch (Exception ex)
                {
                    // Si no es un número mostrar el error
                    lblErrorStaff.Text = "Este campo tiene que ser un número";
                    error = lblErrorStaff.Visible = true;
                }
            }

            // Controlar que introduzcan un valor en la contraseña
            if (password.Trim().Equals(""))
                error = lblErrorPassword.Visible = true;
            

            // enviar datos al controlador si no hay errores
            if (!error) {
                if (loginController.login(staff, password)) // Login Correcto
                {
                    // Ocultar login
                    this.Hide();

                    // Mostrar formulario de Categorias
                    CategoriaView categoriasView = new CategoriaView();
                    categoriasView.ShowDialog();

                    // Mostrar Login
                    this.Show();
                }
                else // Error con las credenciales
                {
                    lblError.Visible = true;
                }

                // Limpiar los valores
                txbStaff.Text = "";
                txbPassword.Text = "";
            }
        }

        /*
         * Método para hacer el login cuando el usuario pulse en Enter
         */
        private void loginkey(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
                login(sender, e);
        }
    }
}

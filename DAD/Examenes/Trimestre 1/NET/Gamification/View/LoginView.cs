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
    public partial class LoginView : Form
    {
        private LoginController loginController;

        public LoginView()
        {
            loginController = new LoginController();
            InitializeComponent();
        }

        /*
         * Método para lanzar el login cuando se pulse la tecle Enter
         */
        private void loginKey(object sender, KeyEventArgs e)
        {
            // Si la tecla precionada es ENTER
            if (e.KeyCode == Keys.Enter)
            {
                // Lanzar login
                login(sender, e);
            }
        }

        private void login(object sender, EventArgs e)
        {
            // Limpiar todos los errores
            bool error = lblErrorUserName.Visible = lblErrorPassword.Visible = lblError.Visible = false;

            // Recoger los datos del usuario
            string username = txbUsername.Text;
            string password = txbPassword.Text;
            string rol = null;

            // Si los campos estan vacios mostramos el error
            if (username.Trim().Equals(""))
                error = lblErrorUserName.Visible = true;
            if (password.Trim().Equals(""))
                error = lblErrorPassword.Visible = true;

            // Si no hay error realizamos el login
            if (!error)
                rol = loginController.login(username, password);

            // Según el rol devuelto
            switch (rol)
            {
                // Si no recibimos nada mostramos un error con las credenciales
                case "":
                    lblError.Text = "Las credenciales introducidas no son validas";
                    lblError.Visible = true;
                    break;

                // Si el usuario no esta activo
                case "inactivo":
                    lblError.Text = "Este Usuario está inactivo";
                    lblError.Visible = true;
                    break;

                // Si es un administrador
                case "admin":
                // Si es un profesor
                case "teacher":
                // Si un un alumno
                case "student":
                    PrincipalView principalView = new PrincipalView(rol);
                    this.Hide();
                    principalView.ShowDialog();
                    this.Close();
                    break;
            }
        }
    }
}

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
    public partial class AddUserView : Form
    {
        private UsuarioController usuarioController;
        public AddUserView()
        {
            usuarioController = new UsuarioController();
            InitializeComponent();
        }

        private void crearUsuario(object sender, EventArgs e)
        {
            // Limpiar los errores
            bool error = lblErrorUserName.Visible = 
                lblErrorPassword.Visible = lblErrorRepeatPassword.Visible = 
                lblErrorRol.Visible = lblErrorPassworRepetidas.Visible = false;

            // Recoger los valores del formulario
            string username = txbUserName.Text;
            string password = txbPassword.Text;
            string repeatPassword = txbRepeatPassword.Text;
            string rol = "";
            if (cmbRol.SelectedItem.ToString().ToLower() != null)
            {
                rol = cmbRol.SelectedItem.ToString().ToLower();
            }

            // Si los campos estan vacios mostramos el error
            if (username.Trim().Equals(""))
                error = lblErrorUserName.Visible = true;

            if (password.Trim().Equals(""))
            {
                lblErrorPassword.Text = "Introduce la contraseña";
                error = lblErrorPassword.Visible = true;
            } 
            else if (password.Length < 8)
            {
                lblErrorPassword.Text = "Mínimo 8 caracteres";
                error = lblErrorPassword.Visible = true;
            }

            if (repeatPassword.Trim().Equals(""))
                error = lblErrorRepeatPassword.Visible = true;
            // Comprobar que las contraseñas son iguales
            else if(!password.Equals(repeatPassword))
                error = lblErrorPassworRepetidas.Visible = true;

            if (rol.Trim().Equals(""))
                error = lblErrorRol.Visible = true;

            
            

            if (!error)
            {
                if (usuarioController.crearUsuario(username, password, rol))
                {

                }
            }
        }
    }
}

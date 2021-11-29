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
    public partial class RegistroView : Form
    {
        private RegistroController registroController;

        public RegistroView()
        {
            registroController = new RegistroController();
            InitializeComponent();
        }

        /*
         * Método que recoger los valores del registro para poder realizar el login
         */
        private void login(object sender, EventArgs e)
        {
            // Limpiar todos los errores
            bool error = lblErrorUser.Visible = lblErrorPassword.Visible = lblError.Visible = false;

            // Recoger los datos del usuario
            string user = txbUser.Text;
            string password = txbPassword.Text;
            string rol = null;

            // Si los campos estan vacios mostramos el error
            if (user.Equals("")) 
                error = lblErrorUser.Visible = true;
            if (password.Equals("")) 
                error = lblErrorPassword.Visible = true;

            // Si no hay error realizamos el login
            if (!error) 
                rol = registroController.login(user, password);

            // Según el rol devuelto
            switch (rol)
            {
                // Si no recibimos nada mostramos un error con las credenciales
                case "":
                    lblError.Visible = true;
                    break;

                // Si es un profesor mostramos el nuevo formulario
                case "profesor":
                case "profesora":
                    ProfesorView profesorView = new ProfesorView();
                    this.Hide();
                    profesorView.ShowDialog();
                    Application.Exit();
                    break;

                // Si un un alumno mostramos un mensaje de bienvenida
                case "alumno":
                case "alumna":

                    string mensaje = "Bienvenido \"" + user +
                        "\"\nTe has registrado correctamente " +
                        "\n\nLo lamentamos, esta sección está en construcción";
                    const string titulo = "Bienvenido";

                    MessageBox.Show(mensaje, titulo, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                    Application.Exit();
                    break;
            }
        }
    }
}

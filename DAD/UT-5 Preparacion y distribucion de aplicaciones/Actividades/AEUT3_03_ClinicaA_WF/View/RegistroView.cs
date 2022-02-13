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
    /// <summary>
    /// Vista del Registro
    /// </summary>
    public partial class RegistroView : Form
    {
        private RegistroController registroController;

        /// <summary>
        /// Controlador que inicializa el controlador de Registro
        /// </summary>
        public RegistroView()
        {
            registroController = new RegistroController();
            InitializeComponent();
        }

        /// <summary>
        /// Método que controla el Login de los Usuarios
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void login(object sender, EventArgs e)
        {
            // Recoger los valores introducidos
            string user = txbUser.Text;
            string password = txbPassword.Text;

            // Resetear los errores
            bool error = false;
            lblErrorUser.Visible = false;
            lblErrorPassword.Visible = false;
            lblError.Visible = false;           

            string rol = null;

            // Comprobar si los campos estan vacios 
            if (user.Trim().Equals("")) error = lblErrorUser.Visible = true;
            if (password.Trim().Equals("")) error = lblErrorPassword.Visible = true;

            // Si no hay error hacer el login
            if (!error)
            {
                rol = registroController.login(user, password);
            }

            // Según el rol obtenido mostramos una vista
            switch (rol)
            {
                case "direccion":
                    mensajeConstruccion(user);
                    break;
                case "administrativo":
                    AdministrativoView administrativoView = new AdministrativoView();
                    Hide();
                    administrativoView.ShowDialog();
                    Close();
                    break;
                case "administrador":
                    mensajeConstruccion(user);
                    break;
                case "personalsanitario":
                    PersonalView personalView = new PersonalView();
                    Hide();
                    personalView.ShowDialog();
                    Close();
                    break;
                case "":
                    lblError.Visible = true;
                    break;
            }
        }

        /// <summary>
        /// Método que muestra un mensaje al usuario y la vista esta en construcción
        /// </summary>
        /// <param name="user">Nombre del usuario</param>
        private void mensajeConstruccion(string user)
        {
            string mensaje = "Bienvenido " + user + 
                " \nTe has registrado correctamente " +
                "\n\nLo lamentamos, esta sección está en construcción";
            const string titulo = "Construcción";

            var result = MessageBox.Show(mensaje, titulo, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);

            // Cerrar la App
            if (result == DialogResult.OK)
            {
                Application.Exit();
            }
        }
    }
}

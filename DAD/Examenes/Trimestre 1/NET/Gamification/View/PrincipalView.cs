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
    public partial class PrincipalView : Form
    {
        private string rol;

        public PrincipalView(string rol)
        {
            InitializeComponent();
            this.rol = rol;
            // Controlar menus
            mostrarMenu();
        }

        /*
         * Método que controla que menus mostrar segun el rol del usuario
         */
        private void mostrarMenu()
        {
            // Ocultamos todos los menus afectados
            tsmiUsersManager.Visible = false;
            tsUserManager.Visible = false;
            tsmiGamificationManager.Visible = false;
            tsmiAdd.Visible = false;
            tsmiDelete.Visible = false;

            switch (rol) {
                // Si es admin mostramos todo
                case "admin":
                    tsmiUsersManager.Visible = true;
                    tsUserManager.Visible = true;
                    tsmiGamificationManager.Visible = true;
                    tsmiAdd.Visible = true;
                    tsmiDelete.Visible = true;
                    break;

                // Si es teacher se muestra todo menos los iconos y el UserManager
                case "teacher":
                    tsmiGamificationManager.Visible = true;
                    tsmiAdd.Visible = true;
                    tsmiDelete.Visible = true;
                    break;
            }
        }

        /*
         * Método que muestra el formulario Listar
         */
        private void listAll(object sender, EventArgs e)
        {
            // Crear Formulario
            ListarUsuariosView listarUsuariosView = new ListarUsuariosView();
            // Seleccionar padre
            listarUsuariosView.MdiParent = this;
            // Mostrar Formulario
            listarUsuariosView.Show();
        }

        private void crearUsuario(object sender, EventArgs e)
        {
            AddUserView addUserView = new AddUserView();
            addUserView.Show();
        }
    }
}

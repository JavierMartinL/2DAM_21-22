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
    public partial class ListarUsuariosView : Form
    {
        private UsuarioController usuarioController;

        public ListarUsuariosView()
        {
            usuarioController = new UsuarioController();
            InitializeComponent();
            mostrarUsuarios("todos");
        }

        private void mostrarUsuarios(string rol)
        {
            // Recoger los usuarios según el rol
            dgvUsuarios.DataSource = usuarioController.mostrarUsuariosRoles(rol);

            // Cambiar el nombre de las columnas
            if (dgvUsuarios.Columns.Count > 0)
            {
                dgvUsuarios.Columns[0].HeaderText = "Nombre de usuario";
                dgvUsuarios.Columns[0].ReadOnly = true;

                dgvUsuarios.Columns[1].HeaderText = "Rol";
                dgvUsuarios.Columns[1].ReadOnly = true;

                dgvUsuarios.Columns[2].HeaderText = "Activo";
                dgvUsuarios.Columns[2].ReadOnly = true;
            }
            // Ajustar el tamaño de las celdas
            dgvUsuarios.AutoResizeColumns();
            dgvUsuarios.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.AllCells;
            // Actualizar la lista
            dgvUsuarios.Update();
        }

        /*
         * Método que recoger el valor del combobox para buscar segun el rol
         */
        private void buscarRol(object sender, EventArgs e)
        {
            mostrarUsuarios(cmbRoles.SelectedItem.ToString().ToLower());
        }
    }
}

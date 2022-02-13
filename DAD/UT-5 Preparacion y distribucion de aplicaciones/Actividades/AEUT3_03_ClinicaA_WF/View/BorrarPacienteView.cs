using Model.entities;
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
    /// Vista de eliminar Paciente
    /// </summary>
    public partial class BorrarPacienteView : Form
    {
        private AdministrativoController administrativoController;

        /// <summary>
        /// Controlador que inicializa el controlador de Administrativo
        /// </summary>
        public BorrarPacienteView()
        {
            administrativoController = new AdministrativoController();
            InitializeComponent();
        }

        /// <summary>
        /// Método para guardar un nuevo Paciente
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void buscarPacientes(object sender, EventArgs e)
        {
            // Limpiar la lista
            ltvPacientes.Items.Clear();

            // Recoger los datos
            string valor = txbValor.Text;
            int opcion = cbxSeleccion.SelectedIndex;

            // Mostrar los Pacientes en la lista
            foreach (Paciente paciente in administrativoController.buscarPaciente(valor, opcion))
            {
                ListViewItem itemAgregar = new ListViewItem();

                itemAgregar.Text = paciente.Nhc + "";
                itemAgregar.SubItems.Add(paciente.Dni);
                itemAgregar.SubItems.Add(paciente.Nombre);
                itemAgregar.SubItems.Add(paciente.Apellidos);
                itemAgregar.SubItems.Add(paciente.Direccion);
                itemAgregar.SubItems.Add(paciente.Poblacion);

                ltvPacientes.Items.Add(itemAgregar);
            }

        }

        /// <summary>
        /// Método que recoge el item de la lista que ha sido pulsado con el click derecho 
        /// y pregunta al usuario si esta seguro de eliminarlo
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void eliminarPaciente(object sender, MouseEventArgs e)
        {
            // Comprobar que es el click izq
            if (e.Button == MouseButtons.Right)
            {
                // Recoger el item seleccionado
                var focusedItem = ltvPacientes.FocusedItem;
                if (focusedItem != null && focusedItem.Bounds.Contains(e.Location))
                {
                    // Mostrar mensaje
                    DialogResult respuesta = MessageBox.Show(
                        "¿Realmente quieres eliminar a este Paciente?", 
                        "Eliminar Paciente", 
                        MessageBoxButtons.YesNo, 
                        MessageBoxIcon.Exclamation);

                    // Si desea eliminarlo
                    if (respuesta == DialogResult.Yes)
                    {
                        // Valor del item
                        int nhc = int.Parse(focusedItem.Text);
                        
                        // Si existen cambios al eliminarlo
                        if (administrativoController.eliminarPaciente(nhc))
                        {
                            // Eliminar el item de la lista
                            focusedItem.Remove();
                        }
                    }
                }
            }
        }
    }
}

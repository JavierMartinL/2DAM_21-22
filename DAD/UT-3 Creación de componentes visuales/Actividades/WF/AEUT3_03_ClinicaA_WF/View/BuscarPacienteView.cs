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
using Model.entities;

namespace View
{
    public partial class BuscarPacienteView : Form
    {
        AdministrativoController administrativoController;

        public BuscarPacienteView()
        {
            administrativoController = new AdministrativoController();
            InitializeComponent();
        }

        /*
         * Método que recoge y muestra los datos de los Pacientes
         */
        private void buscarPaciente(object sender, EventArgs e)
        {
            // Limpiar la lista
            ltvPacientes.Items.Clear();

            // Recoger los datos
            string dni = txbDni.Text.Trim();
            string nhc = txbNhc.Text.Trim();

            // Mostrar los Pacientes en la lista
            foreach(Paciente paciente in administrativoController.buscarPaciente(dni, nhc))
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
    }
}

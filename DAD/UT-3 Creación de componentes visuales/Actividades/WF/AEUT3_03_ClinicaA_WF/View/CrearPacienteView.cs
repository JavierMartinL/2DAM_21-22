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
    public partial class CrearPacienteView : Form
    {
        CrearPacienteController crearPacienteController;

        public CrearPacienteView()
        {
            crearPacienteController = new CrearPacienteController();
            InitializeComponent();
        }

        private void crearPaciente(object sender, EventArgs e)
        {
            bool error = false;

            string dni = txbDni.Text.Trim();
            string strNhc = txbNhc.Text.Trim();
            int nhc = -1;
            string nombre = txbNombre.Text.Trim();
            string apellidos = txbApellidos.Text.Trim();
            string direccion = txbDireccion.Text.Trim();
            string poblacion = txbPoblacion.Text.Trim();

            lblErrorDni.Visible = false;
            lblErrorNhc.Visible = false;
            lblErrorNombre.Visible = false;
            lblErrorApellidos.Visible = false;
            lblErrorDireccion.Visible = false;
            lblErrorPoblacion.Visible = false;

            if (dni.Equals("")) error = lblErrorDni.Visible = true;
            if (strNhc.Equals(""))
            {
                lblErrorNhc.Text = "Introduce el NHC";
                error = lblErrorNhc.Visible = true;
            }
            else
            {
                try
                {
                    nhc = int.Parse(strNhc);
                }
                catch (Exception ex)
                {
                    lblErrorNhc.Text = "Debe ser un número";
                    error = lblErrorNhc.Visible = true;
                }
            }
            if (nombre.Equals("")) error = lblErrorNombre.Visible = true;
            if (apellidos.Equals("")) error = lblErrorApellidos.Visible = true;
            if (direccion.Equals("")) error = lblErrorDireccion.Visible = true;
            if (poblacion.Equals("")) error = lblErrorPoblacion.Visible = true;

            string guardado = "";
            if (!error)
            {
                guardado = crearPacienteController.crearPaciente(dni, nhc, nombre, apellidos, direccion, poblacion);
            }

            switch(guardado)
            {
                case "dni":
                    mensajeError("Existe un Paciente con este DNI");
                    break;

                case "dniFalso":
                    mensajeError("El DNI introducido no es valido");
                    break;

                case "nhc":
                    mensajeError("Existe un Paciente con este NHC");
                    break;

                case "guardado":
                    Close();
                    break;
            }

        }

        private void mensajeError(string mensaje)
        {
            MessageBox.Show(mensaje, "ERROR", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }
    }
}

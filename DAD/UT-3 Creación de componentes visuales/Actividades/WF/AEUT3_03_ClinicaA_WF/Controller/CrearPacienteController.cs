using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Model.dao;
using Model.entities;

namespace Controller
{
    public class CrearPacienteController
    {
        private PacienteDAO pacienteDAO;

        public CrearPacienteController()
        {
            pacienteDAO = new PacienteDAO();
        }

        /*
         * Método que se encarga de comprobar si el DNI es válido y llamar a paciente DAO para guardar el Paciente
         */
        public string crearPaciente(string dni, int nhc, string nombre, string apellidos, string direccion, string poblacion)
        {
            // Crear al Paciente
            Paciente paciente = new Paciente(dni.ToUpper(), nhc, nombre, apellidos, direccion, poblacion);

            // Comprobar que el DNI es válido
            if (paciente.validarDNI(dni))
            {
                return pacienteDAO.save(paciente);
            }
            else
            {
                return "dniFalso";
            }
        }

    }
}

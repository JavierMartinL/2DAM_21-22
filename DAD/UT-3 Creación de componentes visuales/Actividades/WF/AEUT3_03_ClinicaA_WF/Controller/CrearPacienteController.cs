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

        public string crearPaciente(string dni, int nhc, string nombre, string apellidos, string direccion, string poblacion)
        {
            Paciente paciente = new Paciente(dni.ToUpper(), nhc, nombre, apellidos, direccion, poblacion);
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

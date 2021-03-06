using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Model.dao;
using Model.entities;

namespace Controller
{
    public class AdministrativoController
    {
        private PacienteDAO pacienteDAO;

        public AdministrativoController()
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

        /*
         * Método que controla de que forma vamos a buscar
         */
        public List<Paciente> buscarPaciente(string dni, string nhc)
        {
            List<Paciente> pacientes;

            // Por NHC
            if (!nhc.Equals(""))
            {
                pacientes = pacienteDAO.findAllNHC(nhc);
            }
            // Por DNI
            else if (!dni.Equals(""))
            {   
                pacientes = pacienteDAO.findAllDni(dni);
            }
            // Todos
            else
            {
                pacientes = pacienteDAO.findAll();
            }

            return pacientes;
        }

        /*
         * Método que busca segun la opcion
         */
        public List<Paciente> buscarPaciente(string valor, int opcion)
        {
            List<Paciente> pacientes;

            // Por NHC
            if (opcion == 0)
            {
                pacientes = pacienteDAO.findAllNHC(valor);
            }
            // Por DNI
            else
            {
                pacientes = pacienteDAO.findAllDni(valor);
            }

            return pacientes;
        }

        /*
         * Método para eliminar un Paciente
         */
        public bool eliminarPaciente(int nhc)
        {
            return pacienteDAO.deleteByNHC(nhc);
        }

    }
}

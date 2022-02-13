using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Model.dao;
using Model.entities;

namespace Controller
{
    /// <summary>
    /// Controlador de Administrativo
    /// </summary>
    public class AdministrativoController
    {
        private PacienteDAO pacienteDAO;

        /// <summary>
        /// Constructor que inicializa la clase PacienteDAO
        /// </summary>
        public AdministrativoController()
        {
            pacienteDAO = new PacienteDAO();
        }

        /// <summary>
        /// Método que se encarga de comprobar si el DNI es válido y llamar a paciente DAO para guardar el Paciente
        /// </summary>
        /// <param name="dni">DNI del paciente</param>
        /// <param name="nhc">NHC del paciente</param>
        /// <param name="nombre">Nombre del paciente</param>
        /// <param name="apellidos">Apellidos del paciente</param>
        /// <param name="direccion">Dirección del paciente</param>
        /// <param name="poblacion">Poblacion del paciente</param>
        /// <returns></returns>
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

        /// <summary>
        /// Método que controla de que forma vamos a buscar
        /// </summary>
        /// <param name="dni">DNI del paciente a buscar</param>
        /// <param name="nhc">NHC del paciente a buscar</param>
        /// <returns>Lista de pacientes relacionados con el NHC, el DNI o todos</returns>
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

        /// <summary>
        /// Método que busca segun la opcion
        /// </summary>
        /// <param name="valor">Contenido a buscar</param>
        /// <param name="opcion">0 = NHC, 1 = DNI</param>
        /// <returns>Lista de pacientes relacionados con el NHC o el DNI</returns>
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

        /// <summary>
        /// Método para eliminar un Paciente
        /// </summary>
        /// <param name="nhc">NHC del paciente</param>
        /// <returns>TRUE si se elimina el paciente, FALSE si falla la eliminacion</returns>
        public bool eliminarPaciente(int nhc)
        {
            return pacienteDAO.deleteByNHC(nhc);
        }

    }
}

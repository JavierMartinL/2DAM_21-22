using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Model.entities;

namespace Model.dao
{
    /// <summary>
    /// Clase PacienteDAO que trabaja con los datos del paciente
    /// </summary>
    public class PacienteDAO
    {
        ManejoFichero mf;

        /// <summary>
        /// Constructor que inicializa el fichero de pacientes
        /// </summary>
        public PacienteDAO()
        {
            mf = new ManejoFichero("./Files/pacientes.txt");
        }

        /// <summary>
        /// Método que busca todos los Pacientes registrados
        /// </summary>
        /// <returns>Lista con todos los paciente registrados</returns>
        public List<Paciente> findAll()
        {
            List<Paciente> pacientes = new List<Paciente>();

            foreach (string paci in mf.leerTodo().Split('\n'))
            {
                string[] datosPaciente = paci.Split(':');

                if (datosPaciente.Length > 1)
                {
                    pacientes.Add(new Paciente(datosPaciente[5], int.Parse(datosPaciente[6]), datosPaciente[0], datosPaciente[1], datosPaciente[2], datosPaciente[4]));
                }
            }

            return pacientes;
        }

        /// <summary>
        /// Método que busca un Paciente por su DNI
        /// </summary>
        /// <param name="dni">DNI del paciente</param>
        /// <returns>Objeto Paciente que tenga el mismo DNI</returns>
        public Paciente findByDni(string dni)
        {
            Paciente paciente= null;

            foreach(string paci in mf.leerTodo().Split('\n'))
            {
                string[] datosPaciente = paci.Split(':');

                if (datosPaciente.Length > 1)
                {
                    if (dni.Equals(datosPaciente[5]))
                    {
                        paciente = new Paciente(datosPaciente[5], int.Parse(datosPaciente[6]), datosPaciente[0], datosPaciente[1], datosPaciente[2], datosPaciente[4]);
                    }
                }
            }

            return paciente;
        }

        /// <summary>
        /// Método que busca todos los Pacientes que comienzan con el mismo numero de DNI
        /// </summary>
        /// <param name="dni">DNI del paciente</param>
        /// <returns>Lista de Pacientes que estan relacionados con el DNI</returns>
        public List<Paciente> findAllDni(string dni)
        {
            List<Paciente> pacientes = new List<Paciente>();

            foreach (string paci in mf.leerTodo().Split('\n'))
            {
                string[] datosPaciente = paci.Split(':');

                if (datosPaciente.Length > 1)
                {
                    if (datosPaciente[5].StartsWith(dni))
                    {
                        pacientes.Add(new Paciente(datosPaciente[5], int.Parse(datosPaciente[6]), datosPaciente[0], datosPaciente[1], datosPaciente[2], datosPaciente[4]));
                    }
                }
            }

            return pacientes;
        }

        /// <summary>
        /// Método que busca un Paciente por su NHC
        /// </summary>
        /// <param name="nhc">NHC del paciente</param>
        /// <returns>Objeto Paciente que tenga el mismo NHC</returns>
        public Paciente findByNHC(int nhc)
        {
            Paciente paciente = null;

            foreach (string paci in mf.leerTodo().Split('\n'))
            {
                string[] datosPaciente = paci.Split(':');

                if (datosPaciente.Length > 1)
                {
                    int.TryParse(datosPaciente[6], out int nhcPaciente);
                    if (nhc == nhcPaciente)
                    {
                        paciente = new Paciente(datosPaciente[5], nhcPaciente, datosPaciente[0], datosPaciente[1], datosPaciente[2], datosPaciente[4]);
                    }
                }
            }

            return paciente;
        }

        /// <summary>
        /// Método que busca todos los Pacientes que empiezan con el mismo NHC
        /// </summary>
        /// <param name="nhc">NHC del paciente</param>
        /// <returns>Lista con los pacientes relacionados con el NHC</returns>
        public List<Paciente> findAllNHC(string nhc)
        {
            List<Paciente> pacientes = new List<Paciente>();

            foreach (string paci in mf.leerTodo().Split('\n'))
            {
                string[] datosPaciente = paci.Split(':');

                if (datosPaciente.Length > 1)
                {
                    if (datosPaciente[6].StartsWith(nhc))
                    {
                        pacientes.Add(new Paciente(datosPaciente[5], int.Parse(datosPaciente[6]), datosPaciente[0], datosPaciente[1], datosPaciente[2], datosPaciente[4]));
                    }
                }
            }

            return pacientes;
        }

        /// <summary>
        /// Método que comprueba si los el DNI y el NHC no existe en el fichero y si es así guarda el nuevo Paciente
        /// </summary>
        /// <param name="paciente">Objeto Paciente con sus datos</param>
        /// <returns>Si todo sale bien devuelve "guardado", si algo falla puede devolver "nhc" o "dni"</returns>
        public string save(Paciente paciente)
        {
            string guardarPaciente;

            // Comporbar que no existe el DNI
            if (findByDni(paciente.Dni) == null)
            {
                // Comprobar que no existe el NHC
                if (findByNHC(paciente.Nhc) == null)
                {
                    // Guardar el nuevo Paciente
                    mf.guardarFinal(paciente.ToString());
                    guardarPaciente = "guardado";
                }
                else
                {
                    guardarPaciente = "nhc";
                }
            }
            else
            {
                guardarPaciente = "dni";
            }

            return guardarPaciente;
        }

        /// <summary>
        /// Método que eliminar un Paciente segun su nhc
        /// </summary>
        /// <param name="nhc">NHC del paciente</param>
        /// <returns>TRUE si se elimina el paciente, FALSE si no elimina nada</returns>
        public bool deleteByNHC(int nhc)
        {
            int postNhc = 6;
            string strNhc = nhc + "";

            return mf.eliminarFila(postNhc, strNhc);
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Model.entities;

namespace Model.dao
{
    public class PacienteDAO
    {
        ManejoFichero mf;

        public PacienteDAO()
        {
            mf = new ManejoFichero("./Files/pacientes.txt");
        }

        /*
         * Método que busca un Paciente por su DNI
         */
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

        /*
         * Método que busca un Paciente por su NHC
         */
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

        /*
         * Método que comprueba si los el DNI y el NHC no existe en el fichero y si es así guarda el nuevo Paciente
         */
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

    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Model;
using System.Collections;

namespace Controller
{
    /// <summary>
    /// Controlador de la vista Categorias
    /// </summary>
    public class ControllerCategories
    {
        ModelCategories model;

        /// <summary>
        /// Constructor que inicializa el modelo de Categorias
        /// </summary>
        public ControllerCategories()
        {
            model = new ModelCategories();
        }

        /// <summary>
        /// Método que recoge las todas las categorias y se la envia a la vista
        /// </summary>
        /// <returns>Lista con todas las categorias</returns>
        public ArrayList getCategories()
        {

            ArrayList result = model.getCategories();
            String msg = "";

            return result;
        }
    }
}

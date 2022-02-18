using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;
using Model;

namespace Controller
{
    /// <summary>
    /// Controlador de la vista Categoria Man
    /// </summary>
    public class ControllerCategoryMan
    {
        ModelCategoryMan model;

        /// <summary>
        /// Constructor que inicializa el modelo de Categoria Man
        /// </summary>
        public ControllerCategoryMan()
        {
            model = new ModelCategoryMan();
        }

        /// <summary>
        /// Método que recoge todas las categorias de Man y se la envia a la vista
        /// </summary>
        /// <param name="cat">Nombre de la categoria</param>
        /// <returns>Lista con todas las categorias</returns>
        public ArrayList getCategoryMan(String cat)
        {

            ArrayList result = model.getCategoryMan(cat);

            return result;
        }

        /// <summary>
        /// Método que actualiza los datos de una Categoria de Man
        /// </summary>
        /// <param name="cm">Objeto categoria con todos los datos</param>
        /// <returns>TRUE si se actualiza, FALSE si ocurre un error</returns>
        public bool updateQuantity(CategoryMan cm)
        {

            bool result = model.updateQuantity(cm);

            return result;
        }
    }
}

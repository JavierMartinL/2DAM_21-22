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
    /// Controlador de la vista Basket
    /// </summary>
    public class ControllerBasket
    {
        ModelBasket model;

        /// <summary>
        /// Constructor que inicializa el modelo de Basket
        /// </summary>
        public ControllerBasket()
        {
            model = new ModelBasket();
        }

        /// <summary>
        /// Método que con un objeto lo almacena en la DDBB
        /// </summary>
        /// <param name="b">Objecto Basket que queremos almacenar</param>
        /// <returns></returns>
        public bool addToBasket(Basket b)
        {

            bool result = model.addToBasket(b);
            String msg = "";

            return result;
        }
    }
}

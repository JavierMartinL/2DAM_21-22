using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExRecUT2_01_XML.Model
{
    class ArticuloVendido
    {
        private string tipo;
        private int talla;
        private string color;
        private int totalVendidas;

        /// <summary>
        /// Constructor por defecto
        /// </summary>
        public ArticuloVendido() { }

        /// <summary>
        /// Constructor con parametros
        /// </summary>
        /// <param name="tipo">Tipo del articulo vendidos</param>
        /// <param name="talla">Talla del articulo vendidos</param>
        /// <param name="color">Color del articulo vendidos</param>
        /// <param name="totalVendidas">Cantidad de articulos vendidos</param>
        public ArticuloVendido(string tipo, int talla, string color, int totalVendidas)
        {
            this.tipo = tipo;
            this.talla = talla;
            this.color = color;
            this.totalVendidas = totalVendidas;
        }

        // Getters y Setters
        public string Tipo { get => tipo; set => tipo = value; }

        public int Talla { get => talla; set => talla = value; }

        public string Color { get => color; set => color = value; }

        public int TotalVendidas { get => totalVendidas; set => totalVendidas = value; }
    }
}

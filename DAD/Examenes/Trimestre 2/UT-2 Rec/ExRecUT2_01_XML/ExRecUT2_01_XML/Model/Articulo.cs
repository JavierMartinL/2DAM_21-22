using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExRecUT2_01_XML.Model
{
    public class Articulo
    {
        // Variables
        private string tipo;
        private int talla;
        private string color;
        private int cantidad;
        private double precio;

        /// <summary>
        /// Constructor por defecto
        /// </summary>
        public Articulo() { }

        /// <summary>
        /// Constructor con parametros
        /// </summary>
        /// <param name="tipo">Tipo del articulo</param>
        /// <param name="talla">Talla del articulo</param>
        /// <param name="color">Color del articulo</param>
        /// <param name="cantidad">Cantidad del articulo</param>
        /// <param name="precio">Precio del articulo</param>
        public Articulo(string tipo, int talla, string color, int cantidad, double precio)
        {
            this.tipo = tipo;
            this.talla = talla;
            this.color = color;
            this.cantidad = cantidad;
            this.precio = precio;
        }

        // Getters y Setters
        public string Tipo { get => tipo; set => tipo = value; }

        public int Talla { get => talla; set => talla = value; }

        public string Color { get => color; set => color = value; }

        public int Cantidad { get => cantidad; set => cantidad = value; }

        public double Precio { get => precio; set => precio = value; }
    }
}

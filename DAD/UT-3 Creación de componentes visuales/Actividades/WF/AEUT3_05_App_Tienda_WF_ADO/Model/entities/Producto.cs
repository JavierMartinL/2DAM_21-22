using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model.entities
{
    public class Producto
    {
        private int id;
        private string nombre;
        private string categoria;
        private string descripcion;
        private double precio;
        private int cantidad;

        public Producto() { }

        public Producto(int id, string nombre, string categoria, string descripcion, double precio, int cantidad) {
            this.id = id;
            this.nombre = nombre;
            this.categoria = categoria;
            this.descripcion = descripcion;
            this.precio = precio;
            this.cantidad = cantidad;
        }

        public int Id { get => id; set => id = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Categoria { get => categoria; set => categoria = value; }
        public string Descripcion { get => descripcion; set => descripcion = value; }
        public double Precio { get => precio; set => precio = value; }
        public int Cantidad { get => cantidad; set => cantidad = value; }
    }
}

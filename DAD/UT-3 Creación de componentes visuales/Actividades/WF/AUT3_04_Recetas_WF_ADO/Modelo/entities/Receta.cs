using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelo.entities
{
    public class Receta
    {
        private int id;
        private string nombre;
        private string categoria;
        private string tiempo;
        private string ingredientes;
        private string descripcion;

        public Receta() { }

        public Receta(int id, string nombre, string categoria, string tiempo, string ingredientes, string descripcion)
        {
            this.id = id;
            this.nombre = nombre;
            this.categoria = categoria;
            this.tiempo = tiempo;
            this.ingredientes = ingredientes;
            this.descripcion = descripcion;
        }

        public int Id { get => id; set => id = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Categoria { get => categoria; set => categoria = value; }
        public string Tiempo { get => tiempo; set => tiempo = value; }
        public string Ingredientes { get => ingredientes; set => ingredientes = value; }
        public string Descripcion { get => descripcion; set => descripcion = value; }
    }
}

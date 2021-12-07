using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model.entities
{
    public class Pedido
    {
        private int id;
        private string nombre;
        private double total;

        public Pedido() { }

        public Pedido(int id, string nombre, double total)
        {
            this.id = id;
            this.nombre = nombre;
            this.total = total;
        }

        public int Id { get => id; set => id = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public double Total { get => total; set => total = value; }
    }
}

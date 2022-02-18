using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class CategoryMan
    {
        private int id;
        private String name;
        private String category;
        private String description;
        private double price;
        private int quantity;

        public CategoryMan() { }

        public CategoryMan(int id, int quantity) {
            this.id = id;
            this.quantity = quantity;
        }
        public CategoryMan(int id, String name, String category, String description, double price, int quantity)
        {
            this.id = id;
            this.name = name;
            this.category = category;
            this.description = description;
            this.price = price;
            this.quantity = quantity;

        }


        public CategoryMan(int id, double price, int quantity)
        {
            this.id = id;
            this.price = price;
            this.quantity = quantity;

        }


        public int Id
        {
            get
            {
                return id;
            }

            set
            {
                id = value;
            }
        }

        public string Name
        {
            get
            {
                return name;
            }

            set
            {
                name = value;
            }
        }

        public string Category
        {
            get
            {
                return category;
            }

            set
            {
                category = value;
            }
        }

        public string Description
        {
            get
            {
                return description;
            }

            set
            {
                description = value;
            }
        }

        public double Price
        {
            get
            {
                return price;
            }

            set
            {
                price = value;
            }
        }

        public int Quantity
        {
            get
            {
                return quantity;
            }

            set
            {
                quantity = value;
            }
        }

    }
}

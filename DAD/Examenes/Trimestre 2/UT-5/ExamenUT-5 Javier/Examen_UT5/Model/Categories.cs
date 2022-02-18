using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Categories
    {
        private int id_category;
        private String description;

       
        public Categories(int id_category, string description)
        {
            this.id_category = id_category;
            this.description = description;
        }

        public int Id_category
        {
            get
            {
                return id_category;
            }

            set
            {
                id_category = value;
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


    }
}

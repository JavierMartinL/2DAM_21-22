using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class UserDAO
    {
        public void leer()
        {
            ManejoFichero mf = new ManejoFichero("./Files/users.txt");
            List<string> a = mf.leerTodo();
            for (int i = 0; i < a.Count; i++)
            {
                Console.WriteLine(a[i]);
            }
        }
    }
}

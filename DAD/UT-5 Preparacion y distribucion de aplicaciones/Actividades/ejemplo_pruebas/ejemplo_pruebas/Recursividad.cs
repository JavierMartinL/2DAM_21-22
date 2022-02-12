using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ejemplo_pruebas
{
	public class Recursividad
	{
		static int MainRecursividad()
		{
			int num = 0;
			string snum;
			do
			{
				Console.Write("teclea un número [ MAX 33 ]: ");
				snum = Console.ReadLine();
			}
			while (!esNumero(snum) || Int32.Parse(snum) > 33);
			num = Int32.Parse(snum);
			Console.WriteLine("El factorial de {0} es {1}", num, factorial(num));
			Console.ReadLine();
			return 0;
		}

		static bool esNumero(string s)
		{
			if (s.IndexOf("1") != -1 ||
				s.IndexOf("2") != -1 ||
				s.IndexOf("3") != -1 ||
				s.IndexOf("4") != -1 ||
				s.IndexOf("5") != -1 ||
				s.IndexOf("6") != -1 ||
				s.IndexOf("7") != -1 ||
				s.IndexOf("8") != -1 ||
				s.IndexOf("9") != -1 ||
				s.IndexOf("0") != -1)
				return true;
			else
				return false;
		}

		static public long factorial(int n)
		{
			if (n <= 1)
				return 1;
			else
				return n * factorial(n - 1);
		}
	}
}

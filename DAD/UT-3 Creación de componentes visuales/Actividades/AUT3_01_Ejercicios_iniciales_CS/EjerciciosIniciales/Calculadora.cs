using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjerciciosIniciales
{
    class Calculadora
    {
        private int _numero1;
        private int _numero2;
        private char _operador;
		private int _resultado;

        public Calculadora(int numero1, int numero2, char operador)
        {
            _numero1 = numero1;
            _numero2 = numero2;
            _operador = operador;
        }

        public string calcular()
        {
			string strResultado = "";
			switch (_operador)
			{
				case 's':
					_resultado = _numero1 + _numero2;
					strResultado = _numero1 + " + " + _numero2 + " = " + _resultado;
					break;
				case 'r':
					_resultado = _numero1 - _numero2;
					strResultado = _numero1 + " - " + _numero2 + " = " + _resultado;
					break;
				case 'm':
					_resultado = _numero1 * _numero2;
					strResultado = _numero1 + " * " + _numero2 + " = " + _resultado;
					break;
				case 'd':
					_resultado = _numero1 / _numero2;
					strResultado = _numero1 + " / " + _numero2 + " = " + _resultado;
					break;
				default:
					strResultado = "El operador introducido no es valido";
					break;
			}
			return strResultado;
		}

		// getters y setters
		public int Numero1
		{
			get { return _numero1; }
			set { _numero1 = value; }
		}

		public int Numero2
		{
			get { return _numero2; }
			set { _numero2 = value; }
		}

		public char Operador
		{
			get { return _operador; }
			set { _operador = value; }
		}

		public int Resultado
		{
			get { return _resultado; }
			set { _resultado = value; }
		}
    }
}

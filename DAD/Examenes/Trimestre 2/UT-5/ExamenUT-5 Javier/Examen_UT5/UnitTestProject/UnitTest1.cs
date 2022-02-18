using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using View;

namespace UnitTestProject
{
    [TestClass]
    public class UnitTest1
    {
        /*
         * Con esta prueba quiero comprobar una introduccion correcta de datos, para ello
         * introduzco un usuario y contraseña correcta para que ve devuelva
         * que el validado ha sido correcto con un valor 0
         */
        [TestMethod]
        public void validar_Login_ok()
        {
            Login l = new Login();
            int resultado = l.validar_Login("12345678", "pruebas");
            int resultado_ok = 0;
            Assert.AreEqual(resultado_ok, resultado);
        }

        /*
         * Con esta prueba quiero comprobar una introduccion incorrecta de datos, para ello
         * introduzco un usuario y contraseña vacios para que ve devuelva el codigo de error 1
         */
        public void validar_Login_vacio()
        {
            Login l = new Login();
            int resultado = l.validar_Login("", "");
            int resultado_ok = 1;
            Assert.AreEqual(resultado_ok, resultado);
        }

        /**
         * Test de caja blanca:
         *  
         *  I -> 1 -> F
         *  I -> 1 -> 2 -> 3 -> F
         *  I -> 1 -> 2 -> 3 -> 4 -> F
         *  I -> 1 -> 5 -> F
         * 
         * 
         */
        [TestMethod]
        public void add_new_quantity_to_basket_camino1()
        {
            int resultado, resultado_ok;
            //resultado = ;
            //resultado_ok;
            //Assert.AreEqual(resultado_ok, resultado);
        }
    }
}

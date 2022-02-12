using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ejemplo_pruebas;

namespace Ejemplo_UnitTestProject1
{
    [TestClass]
    public class TestMedia
    {

        //Tenemos 4 camins
        //    * Camino1: 1-2-3-4-6-7-8
        //    * Camino2: 1-2-3-5-6-7-8
        //    * Camino3: 1-2-4-6-7-8
        //    * Camino4: 1-2-6-7-2-3-4-6-7-8

        [TestMethod]
        //    * Camino1: 1-2-3-4-6-7-8
        //   Entrada = 16
        //   Salida = 16

        public void TestMedia_Camino1()
        {
            long resultado, resultado_ok;
            int[] llista = {10, 20, 5};
            resultado = Media.calculo_media(llista);  //llamamos al método coon losvalores de la prueba
            resultado_ok = 15;                        // indicamos el valor que debe tener la salida
            Assert.AreEqual(resultado_ok, resultado);  // mediante esta funcion validamos si es correcto
        }

        [TestMethod]
        //    * Camino1: 1-2-3-4-6-7-8
        //   Entrada = 5
        //   Salida = 5
        public void TestMedia_Camino2()
        {
            long resultado, resultado_ok;
            int[] llista = { 5 };
            resultado = Media.calculo_media(llista);
            resultado_ok = 0;
            Assert.AreEqual(resultado_ok, resultado);
        }
    }
}

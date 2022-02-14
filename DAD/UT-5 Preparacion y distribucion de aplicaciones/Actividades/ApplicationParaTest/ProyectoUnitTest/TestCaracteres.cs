using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ApplicationParaTest;

namespace ProyectoUnitTest
{
    [TestClass]
    public class TestCaracteres
    {
        [TestMethod]
        public void TestTransformaTexto()
        {
            string resultado, resultado_ok;
            resultado = EjercicioCaracteres.transformaTexto("Estoy íntentando tránsfórmar un téxto");
            resultado_ok = "OtxEtnUrAmrOfsnArtOdnAtnEtnIyOtsE";
            Assert.AreEqual(resultado_ok, resultado);
        }

        [TestMethod]
        public void TestDarVuelta()
        {
            string resultado, resultado_ok;
            resultado = EjercicioCaracteres.darVuelta("EstoEsUnaPrueba");
            resultado_ok = "abeurPanUsEotsE";
            Assert.AreEqual(resultado_ok, resultado);
        }

        [TestMethod]
        public void TestSacarAcentos()
        {
            string resultado, resultado_ok;
            resultado = EjercicioCaracteres.sacarAcentos("Martín");
            resultado_ok = "Martin";
            Assert.AreEqual(resultado_ok, resultado);
        }

        // Recorridos para leerArchivo
        // Camino 1 = I -> 1 -> 2 -> 3 -> ... -> 2 -> F
        // Camino 2 = I -> 1 -> 2 -> F
        // Camino 3 = I -> 1 -> F

        [TestMethod]
        public void TestLeerArchivo_Camino1()
        {
            string resultado, resultado_ok;
            resultado = EjercicioCaracteres.leerArchivo("frases.txt");
            resultado_ok = "á à lá é è de le clí clicliOOOOOOOOOOOUkilo àéíla la la";
            Assert.AreEqual(resultado_ok, resultado);
        }

        [TestMethod]
        public void TestLeerArchivo_Camino2()
        {
            string resultado, resultado_ok;
            resultado = EjercicioCaracteres.leerArchivo("vacio.txt");
            resultado_ok = "";
            Assert.AreEqual(resultado_ok, resultado);
        }

        [TestMethod]
        public void TestLeerArchivo_Camino3()
        {
            string resultado, resultado_ok;
            resultado = EjercicioCaracteres.leerArchivo("noExiste.txt");
            resultado_ok = "";
            Assert.AreEqual(resultado_ok, resultado);
        }

    }
}

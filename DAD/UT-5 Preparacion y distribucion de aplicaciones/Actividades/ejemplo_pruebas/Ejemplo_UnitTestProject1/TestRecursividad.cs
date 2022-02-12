using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ejemplo_pruebas;

namespace Ejemplo_UnitTestProject1
{
    [TestClass]
    public class TestRecursividad
    {
        [TestMethod]
        public void TestFactorial_ok()
        {
            long resultat, resultat_ok;
            resultat = Recursividad.factorial(4);
            resultat_ok = (4 * 3 * 2 * 1);
            Assert.AreEqual(resultat_ok, resultat);
        }

        [TestMethod]
        public void TestFactorial_ko()
        {
            long resultat, resultat_ok;
            resultat = Recursividad.factorial(3);
            resultat_ok = (4 * 3 * 2 * 1);
            Assert.AreEqual(resultat_ok, resultat);
        }
    }
}

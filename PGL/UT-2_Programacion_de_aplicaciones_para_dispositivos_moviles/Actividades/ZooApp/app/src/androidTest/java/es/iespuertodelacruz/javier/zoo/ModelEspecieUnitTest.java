package es.iespuertodelacruz.javier.zoo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import es.iespuertodelacruz.javier.zoo.vo.Especie;
import es.iespuertodelacruz.javier.zoo.vo.Zoo;


public class ModelEspecieUnitTest extends ComunUtilsTest {

    Especie especie = null;

    @Before
    public void setUp() {
        especie = new Especie("test", "test", "test", true);
    }

    @Test
    public void guardarEspecieTest() {
        long id = especieDbHelper.save(especie);
        assertTrue("La especie no se ha creado", id > 0);
    }

    @Test
    public void buscarEspeciePorNombreTest() {
        especieDbHelper.save(especie);
        Especie especieFind = especieDbHelper.getById(especie.getNombreCientifico());
        assertNotNull("La especie encontrada es null", especieFind);
        assertEquals("El objeto almacenado y encontrado no son iguales", especieFind, especie);
    }

    @Test
    public void obtenerEspeciesTest() {
        especieDbHelper.save(especie);
        List<Especie> especies = especieDbHelper.getAll();
        assertNotNull("El numero de especies encontrado es menor de 1", especies.size() < 1);
        assertEquals("El objeto almacenado y encontrado no son iguales", especies.get(0), especie);
    }

    @Test
    public void modificarEspecieTest() {
        especieDbHelper.save(especie);
        Especie especie1 = new Especie("test1", "test1", "test1", false);
        int id = especieDbHelper.update(especie1, especie.getNombreCientifico());
        especie1 = especieDbHelper.getById(especie1.getNombreCientifico());
        assertNotNull("El objeto especie es null", especie1);
        assertTrue("La especie no se ha modificado", id > 0);
    }

    @Test
    public void eliminarEspecieTest() {
        especieDbHelper.save(especie);
        int id = especieDbHelper.delete(especie.getNombreCientifico());
        assertTrue("La especie no se ha eliminado", id > 0);
    }

    @After
    public void clean() {
        especieDbHelper.onUpgrade(especieDbHelper.getWritableDatabase(), 1, 2);
    }
}

package es.iespuertodelacruz.javier.zoo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import es.iespuertodelacruz.javier.zoo.vo.Animal;
import es.iespuertodelacruz.javier.zoo.vo.Zoo;

public class ModelZooUnitTest extends ComunUtilsTest {

    Zoo zoo = null;

    @Before
    public void setUp() {
        zoo = new Zoo("test", "test", "test", 20, 12222.34);
    }

    @Test
    public void guardarZooTest() {
        long id = zooDbHelper.save(zoo);
        assertTrue("El zoo no se ha creado", id > 0);
    }

    @Test
    public void buscarZooPorNombreTest() {
        zooDbHelper.save(zoo);
        Zoo zooFind = zooDbHelper.getById(zoo.getNombre());
        assertNotNull("El zoo encontrado es null", zooFind);
        assertEquals("El objeto almacenado y encontrado no son iguales", zooFind, zoo);
    }

    @Test
    public void obtenerZoosTest() {
        zooDbHelper.save(zoo);
        List<Zoo> zoos = zooDbHelper.getAll();
        assertNotNull("El numero de zoos encontrado es menor de 1", zoos.size() < 1);
        assertEquals("El objeto almacenado y encontrado no son iguales", zoos.get(0), zoo);
    }

    @Test
    public void modificarZooTest() {
        zooDbHelper.save(zoo);
        Zoo zoo1 = new Zoo("test1", "test1", "test1", 10, 123452.34);
        int id = zooDbHelper.update(zoo1, zoo.getNombre());
        zoo1 = zooDbHelper.getById(zoo1.getNombre());
        assertNotNull("El objeto zoo es null", zoo1);
        assertTrue("El zoo no se ha modificado", id > 0);
    }

    @Test
    public void eliminarZooTest() {
        zooDbHelper.save(zoo);
        int id = zooDbHelper.delete(zoo.getNombre());
        assertTrue("El zoo no se ha eliminado", id > 0);
    }

    @After
    public void clean() {
        zooDbHelper.onUpgrade(zooDbHelper.getWritableDatabase(), 1, 2);
    }
}

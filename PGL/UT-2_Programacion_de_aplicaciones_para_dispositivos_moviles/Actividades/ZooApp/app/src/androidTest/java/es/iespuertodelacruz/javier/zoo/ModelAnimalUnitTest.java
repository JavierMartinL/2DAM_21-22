package es.iespuertodelacruz.javier.zoo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import es.iespuertodelacruz.javier.zoo.vo.Animal;

public class ModelAnimalUnitTest extends ComunUtilsTest {

    Animal animal = null;

    @Before
    public void setUp() {
        animal = new Animal(1, "test", "test", "test", "test", "test");
    }

    @Test
    public void guardarAnimalTest() {
        long id = animalDbHelper.save(animal);
        assertTrue("El animal no se ha creado", id == animal.getIdentificador());
    }

    @Test
    public void buscarAnimalPorIdTest() {
        animalDbHelper.save(animal);
        Animal animalFind = animalDbHelper.getById(animal.getIdentificador()+"");
        assertNotNull("El animal encontrado es null", animalFind);
        assertEquals("El objeto almacenado y encontrado no son iguales", animalFind, animal);
    }

    @Test
    public void obtenerAnimalesTest() {
        animalDbHelper.save(animal);
        List<Animal> animales = animalDbHelper.getAll();
        assertNotNull("El numero de animales encontrado es menor de 1", animales.size() < 1);
        assertEquals("El objeto almacenado y encontrado no son iguales", animales.get(0), animal);
    }

    @Test
    public void modificarAnimalTest() {
        animalDbHelper.save(animal);
        Animal animal1 = new Animal(1, "test1", "test1", "test1", "test1", "test1");
        int id = animalDbHelper.update(animal1, animal.getIdentificador()+"");
        animal1 = animalDbHelper.getById(animal1.getIdentificador()+"");
        assertNotNull("El objeto animal es null", animal1);
        assertTrue("El animal no se ha modificado", animal1.getIdentificador() == id);
    }

    @Test
    public void eliminarAnimalTest() {
        animalDbHelper.save(animal);
        int id = animalDbHelper.delete(animal.getIdentificador()+"");
        assertTrue("El animal no se ha eliminado", id > 0);
    }

    @After
    public void clean() {
        animalDbHelper.onUpgrade(animalDbHelper.getWritableDatabase(), 1, 2);
    }
}

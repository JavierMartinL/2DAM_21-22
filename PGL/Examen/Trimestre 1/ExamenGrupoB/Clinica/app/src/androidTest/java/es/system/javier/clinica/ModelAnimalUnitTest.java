package es.system.javier.clinica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import es.system.javier.clinica.model.helper.AnimalDbHelper;
import es.system.javier.clinica.vo.Animal;

public class ModelAnimalUnitTest {

    Context appContext = null;
    AnimalDbHelper animalDbHelper;
    Animal animal = null;

    @Before
    public void setUp() {
        try {
            appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

            animalDbHelper = new AnimalDbHelper(appContext);
        }catch (Exception ex) {
            fail("Se ha producido un error creando el elemento:"+ex.getMessage());
        }

        animal = new Animal(1, "toby", "caniche", 5, "tf2312gr");
    }

    @Test
    public void saveAnimalTest() {
        long id = animalDbHelper.save(animal);
        assertTrue("El animal no se ha creado", id == animal.getIdentificador());
    }

    /*@Test
    public void findByIDAnimalTest() {
        animalDbHelper.save(animal);
        Animal animalFind = animalDbHelper.getById(animal.getIdentificador()+"");
        assertNotNull("El animal encontrado es null", animalFind);
        assertEquals("El objeto almacenado y encontrado no son iguales", animalFind, animal);
    }*/

    /*@Test
    public void findAllAnimalTest() {
        animalDbHelper.save(animal);
        List<Animal> animales = animalDbHelper.getAll();
        assertNotNull("El numero de animales encontrado es menor de 1", animales.size() < 1);
        assertEquals("El objeto almacenado y encontrado no son iguales", animales.get(0), animal);
    }*/

    /*@Test
    public void updateAnimalTest() {
        animalDbHelper.save(animal);
        Animal animal1 = new Animal(1, "paco", "gato", 3, "tf242cf");
        int id = animalDbHelper.update(animal1, animal.getIdentificador()+"");
        animal1 = animalDbHelper.getById(animal1.getIdentificador()+"");
        assertNotNull("El objeto animal es null", animal1);
        assertTrue("El animal no se ha modificado", animal1.getIdentificador() == id);
    }*/

    @Test
    public void deleteAnimalTest() {
        animalDbHelper.save(animal);
        int id = animalDbHelper.delete(animal.getIdentificador()+"");
        assertTrue("El animal no se ha eliminado", id > 0);
    }

    @After
    public void clean() {
        animalDbHelper.onUpgrade(animalDbHelper.getWritableDatabase(), 1, 2);
    }
}

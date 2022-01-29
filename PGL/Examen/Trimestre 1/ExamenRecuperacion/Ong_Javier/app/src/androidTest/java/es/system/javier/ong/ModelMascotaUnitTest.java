package es.system.javier.ong;

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

import es.system.javier.ong.database.helper.MascotaHelper;
import es.system.javier.ong.model.Mascota;

public class ModelMascotaUnitTest {

    Context appContext = null;
    MascotaHelper mascotaHelper;
    Mascota mascota = null;

    @Before
    public void setUp() {
        try {
            appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

            mascotaHelper = new MascotaHelper(appContext);
        }catch (Exception ex) {
            fail("Se ha producido un error creando el elemento:"+ex.getMessage());
        }

        mascota = new Mascota("123jhj12hj", "toby",  23425235, "Perro");
    }

    @Test
    public void saveMascotaTest() {
        boolean save = mascotaHelper.save(mascota);
        assertTrue("El mascota no se ha creado", save);
    }

    @Test
    public void searchOneMascotaTest() {
        mascotaHelper.save(mascota);
        Mascota mascotaFind = mascotaHelper.searchOne(mascota.getIdentificador());
        assertNotNull("El mascota encontrado es null", mascotaFind);
        assertEquals("El objeto almacenado y encontrado no son iguales", mascotaFind, mascota);
    }

    @Test
    public void searchAllMascotaTest() {
        mascotaHelper.save(mascota);
        List<Mascota> mascotas = mascotaHelper.searchAll();
        assertNotNull("El numero de mascotas encontrado es menor de 1", mascotas.size() < 1);
    }

    @Test
    public void updateMascotaTest() {
        mascotaHelper.save(mascota);
        Mascota mascota1 = new Mascota("123jhj12hj", "Pepq", 332432523, "perro");
        boolean update = mascotaHelper.update(mascota1);
        assertNotNull("El objeto animal es null", mascota1);
        assertTrue("El animal no se ha modificado", mascota1.getIdentificador() == mascota.getIdentificador());
    }

    @Test
    public void deleteMascotaTest() {
        mascotaHelper.save(mascota);
        boolean delete = mascotaHelper.delete(mascota);
        assertTrue("El mascota no se ha eliminado", delete);
    }

    @After
    public void clean() {
        mascotaHelper.onUpgrade(mascotaHelper.getWritableDatabase(), 1, 2);
    }
}

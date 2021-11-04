package es.iespuertodelacruz.javier.zoo;

import static org.junit.Assert.fail;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;

import es.iespuertodelacruz.javier.zoo.model.helper.AnimalDbHelper;
import es.iespuertodelacruz.javier.zoo.model.helper.EspecieDbHelper;
import es.iespuertodelacruz.javier.zoo.model.helper.ZooDbHelper;

public class ComunUtilsTest {

    static Context appContext = null;

    static AnimalDbHelper animalDbHelper;
    static EspecieDbHelper especieDbHelper;
    static ZooDbHelper zooDbHelper;

    @Before
    public void beforeClass() {
        try {
            appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

            animalDbHelper = new AnimalDbHelper(appContext);
            especieDbHelper = new EspecieDbHelper(appContext);
            zooDbHelper = new ZooDbHelper(appContext);
        }catch (Exception ex) {
            fail("Se ha producido un error creando el elemento:"+ex.getMessage());
        }
    }

}

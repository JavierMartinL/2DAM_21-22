package es.system.javier.clinica.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import es.system.javier.clinica.R;

public class AnimalActivity extends AppCompatActivity {

    public static final String EXTRA_ANIMAL_ID = "extra_animal_id";

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        AnimalFragment fragment = (AnimalFragment)
                getSupportFragmentManager().findFragmentById(R.id.animal_container);

        if (fragment == null) {
            fragment = AnimalFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.animal_container, fragment)
                    .commit();
        }
    }
}

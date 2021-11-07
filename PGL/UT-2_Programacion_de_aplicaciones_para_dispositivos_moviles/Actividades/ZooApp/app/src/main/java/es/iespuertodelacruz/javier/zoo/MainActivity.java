package es.iespuertodelacruz.javier.zoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.iespuertodelacruz.javier.zoo.activity.PrincipalActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cambioPantalla1(View view) {
        Intent anteriorPantalla = new Intent(this, PrincipalActivity.class);
        startActivity(anteriorPantalla);
    }
}
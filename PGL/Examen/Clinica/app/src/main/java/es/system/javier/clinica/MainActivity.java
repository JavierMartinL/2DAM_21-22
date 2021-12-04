package es.system.javier.clinica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.system.javier.clinica.activity.AnimalActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pantallaZoo(View view) {
        Intent intent = new Intent(this, AnimalActivity.class);
        startActivity(intent);
    }
}
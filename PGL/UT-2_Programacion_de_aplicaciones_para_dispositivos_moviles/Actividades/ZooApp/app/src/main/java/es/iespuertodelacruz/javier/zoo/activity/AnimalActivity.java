package es.iespuertodelacruz.javier.zoo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import es.iespuertodelacruz.javier.zoo.MainActivity;
import es.iespuertodelacruz.javier.zoo.R;

public class AnimalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
    }
}
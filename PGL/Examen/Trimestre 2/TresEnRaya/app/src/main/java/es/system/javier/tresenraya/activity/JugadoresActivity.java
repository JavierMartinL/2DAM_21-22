package es.system.javier.tresenraya.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import es.system.javier.tresenraya.R;
import es.system.javier.tresenraya.activity.JuegoActivity;

public class JugadoresActivity extends AppCompatActivity {

    private EditText jugador1;
    private EditText jugador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugadores);

        // Inicializar los inputs que recogen los nombre de los jugadores
        jugador1 = findViewById(R.id.jugador1Nombre);
        jugador2 = findViewById(R.id.jugador2Nombre);
    }

    /**
     * Evento que recoge los nombre de los jugadores y muestra la pantalla del juego
     * @param view
     */
    public void iniciarPartidaBotonClick(View view) {
        String jugador1Nombre = jugador1.getText().toString();
        String jugador2Nombre = jugador2.getText().toString();

        Intent intent = new Intent(this, JuegoActivity.class);
        intent.putExtra("NOMBRE_JUGADORES", new String[] {jugador1Nombre, jugador2Nombre});
        startActivity(intent);
    }
}
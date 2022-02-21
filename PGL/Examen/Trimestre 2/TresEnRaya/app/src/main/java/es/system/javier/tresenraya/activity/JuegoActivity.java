package es.system.javier.tresenraya.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.system.javier.tresenraya.R;

public class JuegoActivity extends AppCompatActivity {

    private TresEnRayaBoard tresEnRayaBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        // Inicializar los botones y el texto superior que muestra el turno
        Button btnReiniciar = findViewById(R.id.btnReiniciar);
        Button btnInicio = findViewById(R.id.btnInicio);
        TextView turnoJugador = findViewById(R.id.lblJugador);

        // Ocultar los botones
        btnReiniciar.setVisibility(View.GONE);
        btnInicio.setVisibility(View.GONE);

        // Recoger los nombres de los jugadores
        String[] nombreJugadores = getIntent().getStringArrayExtra("NOMBRE_JUGADORES");

        // mostrar el turno del primer jugador
        if (nombreJugadores != null) {
            turnoJugador.setText("Turno: " + (nombreJugadores[0]));
        }

        // Inicializar la vista del tablero
        tresEnRayaBoard = findViewById(R.id.tresEnRayaBoard);

        // Enviar los botones, jugadores y el turno al tablero
        tresEnRayaBoard.setUpGame(btnReiniciar, btnInicio, turnoJugador, nombreJugadores);
    }

    /**
     * Evento del boton reinicar que comienza una partida nueva
     * @param view vista actual
     */
    public void repetirBotonClick(View view) {
        tresEnRayaBoard.reiniciarJuego();
        tresEnRayaBoard.invalidate();
    }

    /**
     * Evento del boton home que te envia al login
     * @param view vista actual
     */
    public void inicioBotonClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
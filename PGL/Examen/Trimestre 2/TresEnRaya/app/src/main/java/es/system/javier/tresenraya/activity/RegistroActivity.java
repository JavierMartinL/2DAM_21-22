package es.system.javier.tresenraya.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import es.system.javier.tresenraya.R;

public class RegistroActivity extends AppCompatActivity {

    private EditText registroNombre;
    private EditText registroEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registroNombre = findViewById(R.id.registroNombre);
        registroEmail = findViewById(R.id.registroEmail);
    }

    /**
     * Evento que controla que los campos esten completos y si es asi redirigir al login
     * @param view actual
     */
    @SuppressLint("WrongConstant")
    public void botonRegistroClick(View view) {

        // Recoger los campos
        String nombre = registroNombre.getText().toString();
        String email = registroEmail.getText().toString();

        // Si los campos no estan vacios ir al Main
        if (!nombre.equals("") && !email.equals("")) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(
                    RegistroActivity.this,
                    "Por favor rellene los campos",
                    10).show();
        }
    }

}

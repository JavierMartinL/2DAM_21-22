package es.system.javier.tresenraya.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.system.javier.tresenraya.R;
import es.system.javier.tresenraya.model.User;
import es.system.javier.tresenraya.networking.connection.APIUtils;
import es.system.javier.tresenraya.networking.connection.service.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private UserService userService;
    private List<User> listaUsuarios = new ArrayList<>();

    private EditText loginNombre;
    private EditText loginEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inicilizar los inputs
        loginNombre = findViewById(R.id.loginNombre);
        loginEmail = findViewById(R.id.loginEmail);

        // Generar el servicio y hacer una peticion
        userService = APIUtils.getUserService();
        recogerUsuarios();
    }

    /**
     * Evento que controla el login de los usuarios
     * @param view
     */
    @SuppressLint("WrongConstant")
    public void botonLoginClick(View view) {

        // Recoger los datos de los inputs
        String nombre = loginNombre.getText().toString();
        String email = loginEmail.getText().toString().trim();

        // Si los campos no estan vacios
        if (!nombre.equals("") && !email.equals("")) {

            // Recorrer la lista de usuarios
            boolean registrado = false;
            for (User user : listaUsuarios) {

                // Si coincide el email introducido con el de un usuario
                if (user.getEmail().equals(email)) {
                    registrado = true;

                    // comprobar que el usuario esta activo
                    if (user.getStatus().equals("active")) {
                        Intent intent = new Intent(this, JugadoresActivity.class);
                        startActivity(intent);
                    } else {
                        System.out.println("No valido");
                        Toast.makeText(
                                MainActivity.this,
                                "Este usuario no esta activo",
                                10).show();
                    }
                }
            }

            // Si el email no corresponde a ningun usuario mostrar la vista de registro
            if (!registrado) {
                Intent intent = new Intent(this, RegistroActivity.class);
                startActivity(intent);
            }
        } else {
            Toast.makeText(
                    MainActivity.this,
                    "Por favor rellene los campos",
                    10).show();
        }

    }

    /**
     * Metodo que hace una peticion a la API y si recive informacion la almacena en una lista
     */
    private void recogerUsuarios() {
        Call<List<User>> call = userService.getUsers();
        call.enqueue(new Callback<List<User>>() {

            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    // guardar los datos en la lista
                    listaUsuarios = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}
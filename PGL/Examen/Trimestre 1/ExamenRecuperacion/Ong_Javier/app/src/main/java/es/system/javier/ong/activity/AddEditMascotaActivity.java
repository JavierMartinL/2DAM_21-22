package es.system.javier.ong.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import es.system.javier.ong.R;
import es.system.javier.ong.database.helper.MascotaHelper;
import es.system.javier.ong.model.Mascota;

public class AddEditMascotaActivity extends AppCompatActivity {

    private EditText identificador, nombre, fechaNacimiento, raza;
    private Button btnGuardar;
    private MascotaHelper mascotaHelper;

    private boolean editar;
    private DateFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_mascota);
        editar = false;
        // Formato de la fecha
        formatter = new SimpleDateFormat("dd/MM/yyyy");

        // Instanciar el helper de Mascotas
        mascotaHelper = new MascotaHelper(this);

        // Recoger campos
        identificador = (EditText) findViewById(R.id.editIdentificadorMascota);
        nombre = (EditText) findViewById(R.id.editNombreMascota);
        fechaNacimiento = (EditText) findViewById(R.id.editFechaNacimientoMascota);
        raza = (EditText) findViewById(R.id.editRazaMascota);
        btnGuardar = findViewById(R.id.btnGuardarPersona);

        // Recoger el identificador de la mascota
        String idMascota = getIntent().getStringExtra("id_mascota");

        if (idMascota != null) {
            Mascota mascota = mascotaHelper.searchOne(idMascota);

            if (mascota != null) {
                cargarDatosMascota(mascota);
                editar = true;
            } else {
                navegarMain();
            }

        }

        // Accion del boton Guardar
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    almacenarMascota();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * Método que rellena los campos editables con los datps de la mascota
     * @param mascota
     */
    private void cargarDatosMascota(Mascota mascota) {
        identificador.setText(mascota.getIdentificador());
        identificador.setEnabled(false);
        nombre.setText(mascota.getNombre());

        String fecha = formatter.format(new Date(mascota.getFechaNacimiento()));
        fechaNacimiento.setText(fecha);

        raza.setText(mascota.getRaza());
        btnGuardar.setText("Modificar");
    }

    /**
     * Método que recoge los valores introducidos y crea una Mascota
     * @return Objeto Mascota con los datos introducidos
     * @throws ParseException
     */
    private Mascota recogerDatos() throws ParseException {
        String identificador = this.identificador.getText().toString();
        String nombre = this.nombre.getText().toString();
        String fechaNacimiento = this.fechaNacimiento.getText().toString();
        Date fecha = formatter.parse(fechaNacimiento);
        String raza = this.raza.getText().toString();

        return new Mascota(identificador, nombre, fecha.getTime(), raza);
    }

    /**
     * Segun la opcion crearemos una Mascota nueva o modificamos una existente
     * @throws ParseException
     */
    private void almacenarMascota() throws ParseException {
        boolean ok = false;
        Mascota mascota = recogerDatos();

        if (!editar) {
            ok = mascotaHelper.save(mascota);
        } else {
            ok = mascotaHelper.update(mascota);
        }

        if (ok) {
            navegarMain();
        }

    }

    /**
     * Método que nos devuelve a MainActivity
     */
    private void navegarMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

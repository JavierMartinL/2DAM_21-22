package es.system.javier.ong.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import es.system.javier.ong.R;
import es.system.javier.ong.database.helper.MascotaHelper;
import es.system.javier.ong.model.Mascota;

public class DetailMascotaActivity extends AppCompatActivity {

    private MascotaHelper mascotaHelper;
    private Mascota mascota;

    FloatingActionButton btnEditarMascota, btnEliminarMascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mascota);

        // Instanciar el helper de Mascotas
        mascotaHelper = new MascotaHelper(this);

        // Recoger campos
        TextView tvIdentificador = (TextView) findViewById(R.id.tvIdentificadorDetailMascota);
        TextView tvNombre = (TextView) findViewById(R.id.tvnombreDetailMascota);
        TextView tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimientoDetailMascota);
        TextView tvRaza = (TextView) findViewById(R.id.tvRazaDetailMascota);

        // Recoger boton de editar y agregarle un listener
        btnEditarMascota = findViewById(R.id.btnEditarMascota);
        btnEditarMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editarMascota();
            }
        });

        // Recoger boton de eliminar y agregarle un listener
        btnEliminarMascota = findViewById(R.id.btnEliminarMascota);
        btnEliminarMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarMascota();
            }
        });

        // Recoger el identificador de la mascota
        String identificador = getIntent().getStringExtra("id_mascota");

        if (identificador != null) {
            mascota = mascotaHelper.searchOne(identificador);

            if (mascota != null) {
                tvIdentificador.setText(mascota.getIdentificador());
                tvNombre.setText(mascota.getNombre());

                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String fecha = formatter.format(new Date(mascota.getFechaNacimiento()));
                tvFechaNacimiento.setText(fecha);

                tvRaza.setText(mascota.getRaza());
            } else {
                navegarMain();
            }
        } else {
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

    /**
     * Método que nos muestra la vista para poder modificar los datos de la mascota
     */
    private void editarMascota() {
        Intent intent = new Intent(this, AddEditMascotaActivity.class);
        intent.putExtra("id_mascota", mascota.getIdentificador());
        startActivity(intent);
    }

    /**
     * Método que eliminar la mascota que estamos observando
     */
    private void eliminarMascota() {
        boolean delete = mascotaHelper.delete(mascota);

        if (delete) {
            navegarMain();
        }

    }

}

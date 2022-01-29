package es.system.javier.ong.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import es.system.javier.ong.R;
import es.system.javier.ong.adapter.ListaMascotasAdapter;
import es.system.javier.ong.database.helper.MascotaHelper;
import es.system.javier.ong.model.Mascota;

public class MainActivity extends AppCompatActivity implements ListaMascotasAdapter.ListaItemClick {

    private MascotaHelper mascotaHelper;
    private FloatingActionButton btnAddMascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciar el helper de Mascotas
        mascotaHelper = new MascotaHelper(this);

        // Recoger boton de crear Mascota y agregarle un listener
        btnAddMascota = findViewById(R.id.btnCrearMascota);
        btnAddMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearMascotaView();
            }
        });

        obtenerDatos();
    }

    /**
     * Cambiar la vista a AddEditMascotaActivity
     */
    public void crearMascotaView() {
        Intent intent = new Intent(MainActivity.this, AddEditMascotaActivity.class);
        startActivity(intent);
    }

    /**
     * Recoger los datos de la DDBB y mostrarlos en el RecyclerView
     */
    private void obtenerDatos() {

        List<Mascota> mascotas = mascotaHelper.searchAll();

        RecyclerView rvListaMascotas = findViewById(R.id.rvListaMascotas);
        rvListaMascotas.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvListaMascotas.setLayoutManager(linearLayoutManager);

        ListaMascotasAdapter listaMascotasAdapter = new ListaMascotasAdapter(mascotas, this, this);
        rvListaMascotas.setAdapter(listaMascotasAdapter);

    }

    /**
     * Acción que se realiza al pulsar un item del RecyclerView
     * @param clickedMascota
     */
    @Override
    public void onListaItemClick(Mascota clickedMascota) {
        Intent intent = new Intent(MainActivity.this, DetailMascotaActivity.class);

        intent.putExtra("id_mascota", clickedMascota.getIdentificador());
        startActivity(intent);
    }
}
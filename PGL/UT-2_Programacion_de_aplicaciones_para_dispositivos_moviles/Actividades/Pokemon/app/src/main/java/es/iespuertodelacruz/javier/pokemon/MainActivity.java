package es.iespuertodelacruz.javier.pokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import es.iespuertodelacruz.javier.pokemon.Activity.Adapter.ListPokemonsAdapter;
import es.iespuertodelacruz.javier.pokemon.Activity.DetailPokemonActivity;
import es.iespuertodelacruz.javier.pokemon.api.Pokemon;
import es.iespuertodelacruz.javier.pokemon.api.PokemonFetchResults;
import es.iespuertodelacruz.javier.pokemon.service.PokemonAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements ListPokemonsAdapter.ListItemClick {

    private static final String TAG = "POKE";
    private Retrofit retrofit;

    private RecyclerView mRvListaPokemons;
    private ListPokemonsAdapter listPokemonsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Conectar con la API
        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Cargar y mostrar los datos de la API
        obtenerDatos(this, this);
    }

    /**
     * Recoger los datos de la API para mostrarlo en el RecyclerView
     * @param context
     * @param listener
     */
    private void obtenerDatos(Context context, ListPokemonsAdapter.ListItemClick listener) {
        PokemonAPIService service = retrofit.create(PokemonAPIService.class);
        Call<PokemonFetchResults> pokemonFetchResultsCall = service.getPokemons();

        pokemonFetchResultsCall.enqueue(new Callback<PokemonFetchResults>() {
            @Override
            public void onResponse(Call<PokemonFetchResults> call, Response<PokemonFetchResults> response) {
                if (response.isSuccessful()) {

                    // Recoger los datos
                    PokemonFetchResults pokemonFetchResults = response.body();
                    ArrayList<Pokemon> listaPokemon = pokemonFetchResults.getResults();

                    // Trabajar con el RecyclerView
                    mRvListaPokemons = findViewById(R.id.rvPokemons);
                    mRvListaPokemons.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                    mRvListaPokemons.setLayoutManager(linearLayoutManager);

                    listPokemonsAdapter = new ListPokemonsAdapter(listaPokemon, context, listener);
                    mRvListaPokemons.setAdapter(listPokemonsAdapter);

                } else {
                    Log.e(TAG, " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PokemonFetchResults> call, Throwable t) {
                Log.e(TAG, " onFailure: " + t.getMessage());
            }
        });
    }

    /**
     * Metodo que recoge los datos del pokemon pulsado y mostrarlos en una nueva activity
     * @param clickedItem
     */
    @Override
    public void onListItemClick(Pokemon clickedItem) {
        Intent intent = new Intent( MainActivity.this, DetailPokemonActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("pokemon", clickedItem);

        intent.putExtras(bundle);
        startActivity(intent);
    }
}
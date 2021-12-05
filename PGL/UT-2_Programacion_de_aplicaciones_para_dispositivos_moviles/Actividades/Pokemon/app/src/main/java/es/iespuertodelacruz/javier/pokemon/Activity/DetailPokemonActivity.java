package es.iespuertodelacruz.javier.pokemon.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.iespuertodelacruz.javier.pokemon.R;
import es.iespuertodelacruz.javier.pokemon.api.Pokemon;

public class DetailPokemonActivity extends AppCompatActivity {

    TextView name, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pokemon);

        name = (TextView) findViewById(R.id.namePokemon);
        descripcion = (TextView) findViewById(R.id.descriptionPokemon);

        Bundle pokemonEnviado = getIntent().getExtras();
        Pokemon pokemon = null;

        if (pokemonEnviado != null) {
            pokemon = (Pokemon) pokemonEnviado.getSerializable("pokemon");

            name.setText(pokemon.getName());
            descripcion.setText(pokemon.getDescription());
        }
    }

}

package es.iespuertodelacruz.javier.pokemon.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import es.iespuertodelacruz.javier.pokemon.R;
import es.iespuertodelacruz.javier.pokemon.api.Pokemon;

public class DetailPokemonActivity extends AppCompatActivity {

    ImageView imageNormalPokemon, imageShinyPokemon;
    TextView name, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pokemon);

        imageNormalPokemon = (ImageView) findViewById(R.id.fotoNormalPokemon);
        imageShinyPokemon = (ImageView) findViewById(R.id.fotoShinyPokemon);
        name = (TextView) findViewById(R.id.nameDetailPokemon);
        descripcion = (TextView) findViewById(R.id.descriptionDetailPokemon);

        Bundle pokemonEnviado = getIntent().getExtras();
        Pokemon pokemon = null;

        if (pokemonEnviado != null) {
            pokemon = (Pokemon) pokemonEnviado.getSerializable("pokemon");

            name.setText(pokemon.getName());
            descripcion.setText(pokemon.getDescription());

            Glide.with(this)
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokemon.getNumber() + ".png")
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageNormalPokemon);

            Glide.with(this)
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/" + pokemon.getNumber() + ".png")
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageShinyPokemon);
        }
    }

}

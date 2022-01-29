package es.system.javier.clinica.activity.detail;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import es.system.javier.clinica.R;
import es.system.javier.clinica.activity.AnimalFragment;
import es.system.javier.clinica.model.helper.AnimalDbHelper;
import es.system.javier.clinica.vo.Animal;

public class AnimalDetailFragment extends Fragment {
    private static final String ARG_ANIMAL_ID = "animalId";

    private String mAnimalId;

    private CollapsingToolbarLayout mCollapsingView;
    private TextView mNombre;
    private TextView mRaza;
    private TextView mEdad;
    private TextView mChip;

    private AnimalDbHelper mAnimalDbHelper;


    public AnimalDetailFragment() { }

    public static AnimalDetailFragment newInstance(String zooId) {
        AnimalDetailFragment fragment = new AnimalDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ANIMAL_ID, zooId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mAnimalId = getArguments().getString(ARG_ANIMAL_ID);
        }

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_animal_detail, container, false);
        mCollapsingView = (CollapsingToolbarLayout) getActivity().findViewById(R.id.toolbar_layout);
        mNombre = (TextView) root.findViewById(R.id.tv_nombre);
        mRaza = (TextView) root.findViewById(R.id.tv_raza);
        mEdad = (TextView) root.findViewById(R.id.tv_edad);
        mChip = (TextView) root.findViewById(R.id.tv_chip);

        mAnimalDbHelper = new AnimalDbHelper(getActivity());

        loadAnimal();

        return root;
    }

    private void loadAnimal() {
        new GetAnimalByIdTask().execute();
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                showEditScreen();
                break;
            case R.id.action_delete:
                new DeleteZooTask().execute();
                break;
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == AnimalFragment.REQUEST_UPDATE_DELETE_ANIMAL) {
            if (resultCode == Activity.RESULT_OK) {
                getActivity().setResult(Activity.RESULT_OK);
                getActivity().finish();
            }
        }
    }

    private void showAnimal(Animal animal) {
        mCollapsingView.setTitle(animal.getNombre());
        mNombre.setText(animal.getNombre());
        mRaza.setText(animal.getRaza());
        mEdad.setText(animal.getEdad() + "");
        mChip.setText(animal.getChip());
    }

    /*private void showEditScreen() {
        Intent intent = new Intent(getActivity(), AddEditAnimalActivity.class);
        intent.putExtra(AnimalActivity.EXTRA_Animal_ID, mAnimalId);
        startActivityForResult(intent, AnimalFragment.REQUEST_UPDATE_DELETE_ANIMAL);
    }*/

    private void showAnimalesScreen(boolean requery) {
        if (!requery) {
            showDeleteError();
        }
        getActivity().setResult(requery ? Activity.RESULT_OK : Activity.RESULT_CANCELED);
        getActivity().finish();
    }

    private void showLoadError() {
        Toast.makeText(getActivity(),
                "Error al cargar información", Toast.LENGTH_SHORT).show();
    }

    private void showDeleteError() {
        Toast.makeText(getActivity(),
                "Error al eliminar animal", Toast.LENGTH_SHORT).show();
    }

    private class GetAnimalByIdTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return mAnimalDbHelper.getById(mAnimalId);
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.moveToLast()) {
                showAnimal(new Animal(cursor));
            } else {
                showLoadError();
            }
        }

    }

    private class DeleteAnimalTask extends AsyncTask<Void, Void, Integer> {

        @Override
        protected Integer doInBackground(Void... voids) {
            return  mAnimalDbHelper.delete(mAnimalId);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            showAnimalesScreen(integer > 0);
        }

    }

}
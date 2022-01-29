package es.system.javier.clinica.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import es.system.javier.clinica.R;
import es.system.javier.clinica.activity.add.AddEditAnimalActivity;
import es.system.javier.clinica.activity.detail.AnimalDetailActivity;
import es.system.javier.clinica.model.contract.AnimalContract;
import es.system.javier.clinica.model.helper.AnimalDbHelper;

public class AnimalFragment extends Fragment {
    public static final int REQUEST_UPDATE_DELETE_ANIMAL = 2;

    private AnimalDbHelper mAnimalDbHelper;

    private ListView mAnimalList;
    private AnimalCursorAdapter mAnimalAdapter;
    private FloatingActionButton mAddButton;

    public AnimalFragment() {
    }

    public static AnimalFragment newInstance() {
        return new AnimalFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View root = inflater.inflate(R.layout.fragment_animal, container, false);

        mAnimalList = (ListView) root.findViewById(R.id.animal_list);
        mAnimalAdapter = new AnimalCursorAdapter(getActivity(), null);
        mAddButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);

        mAnimalList.setAdapter(mAnimalAdapter);

        mAnimalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor currentItem = (Cursor) mAnimalAdapter.getItem(i);
                @SuppressLint("Range") String currentLawyerId = currentItem.getString(
                        currentItem.getColumnIndex(AnimalContract.AnimalEntry.IDENTIFICADOR));
                showDetailScreen(currentLawyerId);
            }
        });
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showAddScreen();
            }
        });

        mAnimalDbHelper = new AnimalDbHelper(getActivity());

        loadAnimales();

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Activity.RESULT_OK == resultCode) {
            switch (requestCode) {
                /*case AddEditAnimalActivity.REQUEST_ADD_ANIMAL:
                    showSuccessfullSavedMessage();
                    loadAnimales();
                    break;*/
                case REQUEST_UPDATE_DELETE_ANIMAL:
                    loadAnimales();
                    break;
            }
        }
    }

    private void loadAnimales() {
        new AnimalesLoadTask().execute();
    }

    private void showSuccessfullSavedMessage() {
        Toast.makeText(getActivity(),
                "Animal guardado correctamente", Toast.LENGTH_SHORT).show();
    }

    /*private void showAddScreen() {
        Intent intent = new Intent(getActivity(), AddEditAnimalActivity.class);
        startActivityForResult(intent, AddEditAnimalActivity.REQUEST_ADD_ANIMAL);
    }*/

    private void showDetailScreen(String animalId) {
        Intent intent = new Intent(getActivity(), AnimalDetailActivity.class);
        intent.putExtra(AnimalActivity.EXTRA_ANIMAL_ID, animalId);
        startActivityForResult(intent, REQUEST_UPDATE_DELETE_ANIMAL);
    }

    private class AnimalesLoadTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return mAnimalDbHelper.getAll();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                mAnimalAdapter.swapCursor(cursor);
            } else {
                // mostrar Vacio
            }
        }

    }
}

package es.system.javier.clinica.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import es.system.javier.clinica.R;
import es.system.javier.clinica.model.contract.AnimalContract;

public class AnimalCursorAdapter extends CursorAdapter {

    public AnimalCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.list_item_animal, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameText = (TextView) view.findViewById(R.id.tv_name);
        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.NOMBRE));
        nameText.setText(name);
    }
}

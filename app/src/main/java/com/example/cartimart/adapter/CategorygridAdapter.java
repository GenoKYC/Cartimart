package com.example.cartimart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cartimart.R;
import com.example.cartimart.model.Category;

import java.util.ArrayList;

public class CategorygridAdapter extends ArrayAdapter<Category> {
    public CategorygridAdapter(@NonNull Context context, ArrayList<Category> categoryArrayList) {
        super(context, 0, categoryArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.categorycard, parent, false);
        }

        Category categorymodel = getItem(position);
        TextView catname = listitemView.findViewById(R.id.catname);
        ImageView catimg = listitemView.findViewById(R.id.catimg);

        catname.setText(categorymodel.getCategory_name());
        catimg.setImageResource(categorymodel.getImg_url());
        return listitemView;
    }
}

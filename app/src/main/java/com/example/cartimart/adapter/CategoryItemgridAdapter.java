package com.example.cartimart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cartimart.R;
import com.example.cartimart.model.Category;
import com.example.cartimart.model.CategoryItem;

import java.util.ArrayList;

public class CategoryItemgridAdapter extends ArrayAdapter<CategoryItem> {
    public CategoryItemgridAdapter(@NonNull Context context, ArrayList<CategoryItem> categoryItemArrayList) {
        super(context, 0, categoryItemArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.categoryitemcard, parent, false);
        }

        CategoryItem categoryitemmodel = getItem(position);
        TextView catid = listitemView.findViewById(R.id.catitemid);
        TextView catname = listitemView.findViewById(R.id.catitemname);
        ImageView catimg = listitemView.findViewById(R.id.catitemimg);

        catname.setText(categoryitemmodel.getCitem_name());
        catid.setText(String.valueOf(categoryitemmodel.getCId()));
        catimg.setImageResource(categoryitemmodel.getImage_url());
        return listitemView;
    }}

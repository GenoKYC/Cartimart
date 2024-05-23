package com.example.cartimart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cartimart.List2;
import com.example.cartimart.R;
import com.example.cartimart.model.NotesList;

import java.util.List;

public class ListgridAdapter extends BaseAdapter {
    private Context context;
    private List<NotesList> Noteslisting;
    public ListgridAdapter(Context context, List<NotesList> Noteslist){
        this.context = context;
        this.Noteslisting = Noteslist;
    }

    public ListgridAdapter(List2 list2, List<NotesList> notesLists) {

    }

    @Override
    public int getCount() {
        return Noteslisting.size();
    }

    @Override
    public Object getItem(int position) {
        return Noteslisting.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listcard, parent,false);
            }

        TextView listTitle = convertView.findViewById(R.id.listNameTitle);


            NotesList notesList = Noteslisting.get(position);
            listTitle.setText(notesList.getListTitle());
            return convertView;
    }

}
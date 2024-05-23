package com.example.cartimart;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.cartimart.adapter.ListgridAdapter;
import com.example.cartimart.model.NotesList;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link List2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class List2 extends Fragment {

    // Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button createList;
    ListView idListItems;
    ListgridAdapter adapter;
    DatabaseNotesList dbHelper;


    public List2() {
        // Required empty public constructor
    }

    public static List2 newInstance(String param1, String param2) {
        List2 fragment = new List2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list2, container, false);

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createList = view.findViewById(R.id.buttonCreateList);
        createList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), listAdding.class);
                getActivity().startActivity(intent);
            }
        });
        idListItems = view.findViewById(R.id.idListItems);
        dbHelper = new DatabaseNotesList(this);
        List<NotesList> notesLists = dbHelper.getAlladdress();
        adapter = new ListgridAdapter(this,notesLists);
        idListItems.setAdapter(adapter);


    }

}

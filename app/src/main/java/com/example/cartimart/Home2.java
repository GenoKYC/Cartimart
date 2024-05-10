package com.example.cartimart;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.cartimart.adapter.CategorygridAdapter;
import com.example.cartimart.helper.HCategory;
import com.example.cartimart.model.Category;

import java.util.ArrayList;

public class Home2 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    GridView categoryGV;

    public Home2() {
        // Required empty public constructor
    }

    public static Home2 newInstance(String param1, String param2) {
        Home2 fragment = new Home2();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        HCategory hcat = new HCategory(getContext());

        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_home2, container, false);
        categoryGV = view.findViewById(R.id.idCartegory);
        ArrayList<Category> categoryModelArrayList = new ArrayList<Category>();
//        categoryModelArrayList = hcat.getCategories();
        categoryModelArrayList.add(new Category(1,"DSA", R.drawable.cartiad1, "2024-05-09"));
        categoryModelArrayList.add(new Category(2,"JAVA", R.drawable.cartiad1, "2024-05-09"));
        categoryModelArrayList.add(new Category(3,"C++", R.drawable.cartiad1, "2024-05-09"));
        categoryModelArrayList.add(new Category(4,"Python", R.drawable.cartiad1, "2024-05-09"));
        categoryModelArrayList.add(new Category(5,"Javascript", R.drawable.cartiad1, "2024-05-09"));
        categoryModelArrayList.add(new Category(7, "DSA", R.drawable.cartiad1, "2024-05-09"));

        CategorygridAdapter adapter = new CategorygridAdapter(this.getContext(), categoryModelArrayList);
        categoryGV.setAdapter(adapter);

        categoryGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String catname = ((TextView)view.findViewById(R.id.catname)).getText().toString();
//                Toast.makeText(showMissions.this, "" + item, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), CategoryItems.class);
                intent.putExtra("activity_title", catname);
                startActivity(intent);
            }
        });

//         Find the ConstraintLayout with ID fruits_box
//        ConstraintLayout fruitsBox = view.findViewById(R.id.fruits_box);
//
//        // Set OnClickListener for fruits_box
//        fruitsBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Handle the click event, navigate to another page
//                // For example, start a new activity
//                Intent intent = new Intent(getActivity(), CategoryItems.class);
//                intent.putExtra("activity_title", "Fruits");
//                startActivity(intent);
//            }
//        });
//        // Find the ConstraintLayout with ID veggies_box
//        ConstraintLayout veggiesBox = view.findViewById(R.id.veggies_box);
//
//        // Set OnClickListener for veggies_box
//        veggiesBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Handle the click event for veggies_box
//                // For example, start a new activity
//                Intent intent = new Intent(getActivity(), CategoryItems.class);
//                intent.putExtra("activity_title", "Veggies");
//                startActivity(intent);
//            }
//        });
//
//        ConstraintLayout fishesBox = view.findViewById(R.id.fishes_box);
//
//        // Set OnClickListener for fishes_box
//        fishesBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Handle the click event for fishes_box
//                // For example, start a new activity
//                Intent intent = new Intent(getActivity(), CategoryItems.class);
//                intent.putExtra("activity_title", "Fishes");
//                startActivity(intent);
//            }
//        });


        return view;
    }


}
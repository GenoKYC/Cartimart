package com.example.cartimart;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.cartimart.helper.HAddToCart;
import com.example.cartimart.helper.HCategoryItem;
import com.example.cartimart.model.CartView;
import com.example.cartimart.model.CategoryItem;

import java.util.ArrayList;

public class Cart2 extends Fragment {

    GridView cartViewItem = null;



//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.fragment_cart2);
//        HAddToCart cartitv = new HAddToCart(this);
//
//        cartViewItem = cartViewItem.findViewById(R.id.idCartView);
//        ArrayList<CartView> cartViewArrayList = new ArrayList<>();
//
//        cartViewArrayList.add( CartView(getID,20.00,));
//
//
//
//        Intent intent = getIntent();
//
//
//        ArrayList<CartView> cartitems = new ArrayList<CartView>();
//        for (cartViewItem item : cartViewArrayList) {
//            if(item.getCa() == car{
//                cartitems.add(item);
//            }
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart2, container, false);
    }
}
package com.example.cartimart.helper;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.cartimart.Cart2;
import com.example.cartimart.R;
import com.example.cartimart.model.Cart;
import com.example.cartimart.model.CategoryItem;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class HAddToCart extends BottomSheetDialogFragment {
    private TextView txtid, txtqty, txtitemname, txtitemprice;
    private int number = 0;
    private String catname = "";
    private String catId = "";


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bs_addtocard, container, false);

        String catName = getArguments().getString("itemname");
        String catId = getArguments().getString("itemid");

        txtid = v.findViewById(R.id.txtitemid);
        txtqty = v.findViewById(R.id.txtqty);
        txtitemname = v.findViewById(R.id.txtitemname);
        txtitemprice = v.findViewById(R.id.txtitemprice);
        Button increaseButton = v.findViewById(R.id.increase_button);
        Button decreaseButton = v.findViewById(R.id.decrease_button);
        Button btnaddtocart = v.findViewById(R.id.btnaddtocart);

        txtitemname.setText(catName);
        txtid.setText(catId);

        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                updateNumberTextView();
            }
        });

        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number > 0) {
                    number--;
                    updateNumberTextView();
                } else {
                    Toast.makeText(getActivity(), "Number cannot be less than 0", Toast.LENGTH_SHORT).show();
                }


            }
        });

        btnaddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "Added to cart", Toast.LENGTH_SHORT).show();
//                navigateToNextActivity();
                HCart cart = new HCart(getContext());
                ArrayList<Cart> CartItems = cart.addCartItem(new Cart(1,"","PINYA",10.00,5, 50));
                int x = 0;
                for (Cart item : CartItems) {

                    Log.d("CART_ITEM",x++ + item.getItem_name());
                }

                Log.d("CART_ITEM","" + CartItems.size());
            }
        });


        return v;


    }

    private void updateNumberTextView() {
        txtqty.setText(String.valueOf(number));
    }

    private void navigateToNextActivity() {
        Intent intent = new Intent(requireActivity(), Cart2.class);
        startActivity(intent);
    }



}

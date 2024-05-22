package com.example.cartimart.helper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.cartimart.R;
import com.example.cartimart.model.Cart;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class HUpdateCart extends BottomSheetDialogFragment {
    private TextView txtid, txtqty, txtitemname, txtitemprice;
    private int number = 0;
    private String catname = "";
    private String catId = "";
    ArrayList<Cart> CartItems = new ArrayList<Cart>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bs_cartupd, container, false);

        String catName = getArguments().getString("itemname");
        String catId = getArguments().getString("itemid");
        double catprice = getArguments().getDouble("itemprice");

        txtitemname.setText(catName);
        txtid.setText(catId);
        txtitemprice.setText(String.valueOf(catprice));
        updateNumberTextView();

        txtid = v.findViewById(R.id.crtviewid);
        txtqty = v.findViewById(R.id.crt_txtqty);
        txtitemname = v.findViewById(R.id.crt_txtitemname);
        txtitemprice = v.findViewById(R.id.crt_txtitemprice);
        Button increaseButton = v.findViewById(R.id.crt_increase_button);
        Button decreaseButton = v.findViewById(R.id.crt_decrease_button);
        Button btnaddtocart = v.findViewById(R.id.crt_btnUpdtocart);
        Button btnviewcart = v.findViewById(R.id.crt_btnDeleteCart);


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


        return v;
    }

    private void updateNumberTextView() {
        txtqty.setText(String.valueOf(number));
    }

}

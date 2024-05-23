package com.example.cartimart.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cartimart.Cart_Layout;
import com.example.cartimart.R;
import com.example.cartimart.interfaces.RemoveItemBottomSheetListener;
import com.example.cartimart.model.Cart;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class HUpdateCart extends BottomSheetDialogFragment {
    private TextView txtid, txtqty, txtitemname, txtitemprice;
    private int number = 0;
     int idx = 0;
    private String catname = "";
    private String catId = "";
    ArrayList<Cart> CartItems = new ArrayList<Cart>();

    private RemoveItemBottomSheetListener removeitemlistener ;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bs_cartupd, container, false);

        txtid = v.findViewById(R.id.crtviewid);
        txtqty = v.findViewById(R.id.crt_txtqty);
        txtitemname = v.findViewById(R.id.crt_txtitemname);
        txtitemprice = v.findViewById(R.id.crt_txtitemprice);

        idx = getArguments().getInt("idx");
        String catName = getArguments().getString("cartitem_namev");
        String catId = getArguments().getString("cartitem_idv");
        double catprice = getArguments().getDouble("cartitem_pricev");

        Log.d("Cart_Layout",idx + " " + catname);
        txtitemname.setText(catName);
        txtid.setText(catId);
        txtitemprice.setText(String.valueOf(catprice));

        Button increaseButton = v.findViewById(R.id.crt_increase_button);
        Button decreaseButton = v.findViewById(R.id.crt_decrease_button);
        Button btnupdatecart = v.findViewById(R.id.crt_btnUpdtocart);
        Button btndeletecart = v.findViewById(R.id.crt_btnDeleteCart);

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

        btndeletecart.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), idx, Toast.LENGTH_SHORT);
               if(removeitemlistener != null){
                   removeitemlistener.onRemoveItemBottomSheetListener(idx);
                   dismiss();
               }

//                Log.d("Cart_Layout",idx + " " + catname);
            }
        }));

        return v;
    }

    private void updateNumberTextView() {
        txtqty.setText(String.valueOf(number));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            removeitemlistener = (RemoveItemBottomSheetListener) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString() + " must implement bottomsheet listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        removeitemlistener = null;
    }
}

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
import com.example.cartimart.model.Cart;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CartgridAdapter extends ArrayAdapter<Cart> {

    public CartgridAdapter (@NonNull Context context, ArrayList<Cart> cartArrayList) {
        super(context, 0, cartArrayList);
    }

    @NonNull
    @Override
    public View view(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        View listitemView = convertView;
        if (listitemView == null){
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.cartcard, parent, false);
        }

        Cart cart = getItem(position);
        ImageView cartitemimg = listitemView.findViewById(R.id.cartitemimg);
        TextView cartitemname_view = listitemView.findViewById(R.id.cartitemname_view);
        TextView totalitem_priceview = listitemView.findViewById(R.id.totalitem_priceview);
        TextView qnty_view = listitemView.findViewById(R.id.qnty_view);

        cartitemimg.setImageResource(cart.get);
        //last edit
    }
}

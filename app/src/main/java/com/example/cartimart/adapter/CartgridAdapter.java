package com.example.cartimart.adapter;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cartimart.R;
import com.example.cartimart.helper.HCart;
import com.example.cartimart.model.Cart;
import com.example.cartimart.model.CartView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;
// FOR CART VIEWING PURPOSES FILE


public class CartgridAdapter extends ArrayAdapter<Cart> {

    public CartgridAdapter (@NonNull Context context, ArrayList<Cart> cartArrayList) {
        super(context, 0, cartArrayList);
    }

    @NonNull
    @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

            View listitemView = convertView;
            if (listitemView == null){
                listitemView = LayoutInflater.from(getContext()).inflate(R.layout.cartcard, parent, false);
            }

                Cart cartmodel = getItem(position);

            TextView cartitemname_view = listitemView.findViewById(R.id.cartitemname_view);
            TextView totalitem_priceview = listitemView.findViewById(R.id.totalitem_priceview);
            TextView qnty_view = listitemView.findViewById(R.id.qnty_view);
            Button removebtn = listitemView.findViewById(R.id.remove_button);


            cartitemname_view.setText(cartmodel.getItem_name());
            totalitem_priceview.setText(String.format(Locale.getDefault(), "%.2f", cartmodel.getItem_price()));
            qnty_view.setText(String.valueOf(cartmodel.getItem_qty()));
            return listitemView;


//            removebtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(requireContext(), "item removed", Toast.LENGTH_SHORT).show();
////                   navigateToNextActivity();
//                    HCart cart = new HCart(getContext());
//
//                }
//            });

        }




}

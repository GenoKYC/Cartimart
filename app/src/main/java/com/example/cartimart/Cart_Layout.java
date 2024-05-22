package com.example.cartimart;

import static com.example.cartimart.helper.HCart.cart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cartimart.adapter.CartgridAdapter;
import com.example.cartimart.adapter.CategoryItemgridAdapter;
import com.example.cartimart.adapter.CategorygridAdapter;
import com.example.cartimart.helper.HAddToCart;
import com.example.cartimart.helper.HUpdateCart;
import com.example.cartimart.model.Cart;
import com.example.cartimart.model.CategoryItem;

import java.util.ArrayList;

public class Cart_Layout extends AppCompatActivity {
    ArrayList<Cart> CartItems = new ArrayList<Cart>();
    GridView cartGV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart_layout);

        Intent intent = getIntent();
        CartItems = (ArrayList<Cart>) intent.getSerializableExtra("CartItems");

        cartGV = findViewById(R.id.CartGridView);
        CartgridAdapter adapter = new CartgridAdapter(this.getApplicationContext(), CartItems);
        cartGV.setAdapter(adapter);


        for (Cart item : CartItems) {
            String msg = item.getId() + "\t" +
                    item.getItem_name() + "\t" +
                    item.getItem_price() + "\t" +
                    item.getItem_qty() + "\t" +
                    item.getItem_subtotal();
            Log.d("Cart_Layout", msg);
        }

        int cartid = intent.getIntExtra("cartid", 0);

        ArrayList<Cart> CartItems = new ArrayList<Cart>();
        {
            for (Cart item : CartItems) {
                if (item.getId() == cartid) {
                    CartItems.add(item);
                }
            }

            cartGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Bundle bs_bundle = new Bundle();
                    bs_bundle.clear();
                    Cart item = CartItems.get(i);


                    String cartid_view = String.valueOf(item.getId());
                    String cartname_view = String.valueOf(item.getItem_name());
                    double cartprice_view = item.getItem_price();

                    bs_bundle.putString("cartitem_idv", cartid_view);
                    bs_bundle.putString("cartitem_namev", cartname_view);
                    bs_bundle.putDouble("cartitem_namev", cartprice_view);

                    HUpdateCart bottomsheet = new HUpdateCart();
                    bottomsheet.setArguments(bs_bundle);
                    bottomsheet.show(getSupportFragmentManager(), "Modal Bottom Sheet");

                }

            });


        }
    }
}
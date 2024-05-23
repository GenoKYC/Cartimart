package com.example.cartimart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cartimart.adapter.CartgridAdapter;
import com.example.cartimart.helper.HUpdateCart;
import com.example.cartimart.interfaces.CartUpdateListener;
import com.example.cartimart.interfaces.RemoveItemBottomSheetListener;
import com.example.cartimart.model.Cart;

import java.util.ArrayList;

public class Cart_Layout extends AppCompatActivity implements RemoveItemBottomSheetListener {
    ArrayList<Cart> CartItems;
    GridView cartGV;
    CartgridAdapter adapter;

    CartUpdateListener updateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart_layout);

        Intent intent = getIntent();
        CartItems = (ArrayList<Cart>) intent.getSerializableExtra("CartItems");
        int cartid = intent.getIntExtra("cartid", 0);

        // Ensure CartItems is not null
//        if (CartItems == null) {
//            CartItems = new ArrayList<>();
//        }

        cartGV = findViewById(R.id.CartGridView1);
        adapter = new CartgridAdapter(this, CartItems);
        cartGV.setAdapter(adapter);

//        for (Cart item : CartItems) {
//            String msg = item.getId() + "\t" +
//                    item.getItem_name() + "\t" +
//                    item.getItem_price() + "\t" +
//                    item.getItem_qty() + "\t" +
//                    item.getItem_subtotal();
//            Log.d("Cart_Layout", msg);
//        }


        cartGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bs_bundle = new Bundle();
                Cart item = CartItems.get(i);

                bs_bundle.putInt("idx", i);
                bs_bundle.putString("cartitem_idv", String.valueOf(item.getId()));
                bs_bundle.putString("cartitem_namev", item.getItem_name());
                bs_bundle.putDouble("cartitem_pricev", item.getItem_price());

                HUpdateCart bottomsheet = new HUpdateCart();
                bottomsheet.setArguments(bs_bundle);
                bottomsheet.show(getSupportFragmentManager(), "Modal Bottom Sheet");


            }
        });




        View mainView = findViewById(R.id.main);
        ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onRemoveItemBottomSheetListener(int index) {
        CartItems.remove(index);
        adapter.notifyDataSetChanged();
        if(updateListener != null){
            updateListener.onCartItemUpdate(CartItems);
        }

//        for (Cart item : CartItems) {
//            String msg = item.getId() + "\t" +
//                    item.getItem_name() + "\t" +
//                    item.getItem_price() + "\t" +
//                    item.getItem_qty() + "\t" +
//                    item.getItem_subtotal();
//            Log.d("Cart_Layout", msg);
//        }
        Log.d("Cart_Layout", String.valueOf(index));
//        Toast.makeText(getApplicationContext(), index, Toast.LENGTH_SHORT);
    }




}

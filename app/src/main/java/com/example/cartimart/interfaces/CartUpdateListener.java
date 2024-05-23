package com.example.cartimart.interfaces;

import com.example.cartimart.model.Cart;

import java.util.ArrayList;

public interface CartUpdateListener {
    void onCartItemUpdate(ArrayList<Cart> uCartItems);
}

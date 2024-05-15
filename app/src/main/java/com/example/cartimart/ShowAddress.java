package com.example.cartimart;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cartimart.adapter.ItemAddressAdapter;
import com.example.cartimart.model.ItemAddress;

import java.util.List;

public class ShowAddress extends AppCompatActivity {
    private SharedPreferences prefs;
    RecyclerView addressview;
    String searchValue;
    Accountdatabase dbHelper;
    ItemAddressAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_address);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        searchValue = prefs.getString("accountValidators","default_Value");
        dbHelper = new Accountdatabase(this);

        addressview = findViewById(R.id.address_View);
        List<ItemAddress> itemAddresses = dbHelper.getAlladdress(searchValue);
        adapter = new ItemAddressAdapter(this, itemAddresses);
        addressview.setAdapter(adapter);
    }
}
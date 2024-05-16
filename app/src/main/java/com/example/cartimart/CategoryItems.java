
package com.example.cartimart;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cartimart.adapter.CategoryItemgridAdapter;
import com.example.cartimart.helper.HAddToCart;
import com.example.cartimart.helper.HCategoryItem;
import com.example.cartimart.model.CategoryItem;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;


public class CategoryItems extends AppCompatActivity {

    TextView screen_title;
    GridView categoryItemGV = null;
    TextView tvCatItemName;
    String[] listItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category_items);
        HCategoryItem catitem = new HCategoryItem(this);



        categoryItemGV = findViewById(R.id.idCategoryItems);
        ArrayList<CategoryItem> categoryItemModelArrayList = new ArrayList<>();
        categoryItemModelArrayList.add(new CategoryItem(1, 1, "Manga per Piece", R.drawable.fruits_item, 40.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(2, 1, "Apple per Piece", R.drawable.fruits_item,30.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(3, 1, "Banana per Piece", R.drawable.fruits_item, 12.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(4, 1, "Pinya per Piece", R.drawable.fruits_item, 245.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(5, 1, "Orange per Piece", R.drawable.fruits_item, 32.00, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(7, 2, "Tomato per Piece", R.drawable.veggies_item, 7.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(8, 2, "Petchay per Leaf", R.drawable.veggies_item, 59.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(9, 2, "Sitaw 1 Set", R.drawable.veggies_item, 55.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(10, 2, "Sibuyas per Piece", R.drawable.veggies_item, 25.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(11, 2, "Eggplant per Piece", R.drawable.veggies_item, 55.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(11, 3,"Bangus per Piece", R.drawable.fishes_item, 180.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(12, 3,"Tilapia per Piece", R.drawable.fishes_item, 120.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(13, 3,"Clown Fish", R.drawable.fishes_item, 80.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(14, 3,"Si Dori", R.drawable.fishes_item, 150.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(15, 3,"Fish Fillet 1KG", R.drawable.fishes_item, 319.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(16, 4,"Tenderloin Steaks 1KG", R.drawable.beef_item, 1380.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(17, 4,"Certified Angus Beef Burger per Piece", R.drawable.beef_item, 80.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(18, 4,"Ground Beef 1KG", R.drawable.beef_item, 200.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(19, 4,"Beef Tenderloin", R.drawable.beef_item, 440.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(20, 4,"Food Crafters Burger Patties 240g", R.drawable.beef_item, 85.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(21, 5,"Breast Part 1KG", R.drawable.poultry_item, 275.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(22, 5,"Whole Chicken", R.drawable.poultry_item, 235.00, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(23, 5,"Thigh Part Chicken 1KG", R.drawable.poultry_item, 220.00, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(24, 5,"Nuggets 200g", R.drawable.poultry_item, 190.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(25, 5,"Lollipop 12pcs", R.drawable.poultry_item, 355.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(27, 7,"Fresh Adobo Cut 500g", R.drawable.pork_item, 200.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(28, 7,"Pork Chop 1kg", R.drawable.pork_item, 435.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(29, 7,"Pork Cubes 1kg", R.drawable.pork_item, 500.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(30, 7,"Pork Cutlets 500g", R.drawable.pork_item, 215.00, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(31, 7,"Pork BBQ CUT 500g", R.drawable.pork_item, 250.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(32, 8,"BearBrand Milk 180ml", R.drawable.milk_item, 29.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(33, 8,"Cowhead Milk 1L", R.drawable.milk_item, 100.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(34, 8,"Nestle Non Fat 1L", R.drawable.milk_item, 122.00, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(35, 8,"Alaska Evaporada 140ml", R.drawable.milk_item, 40.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(37, 8,"Nestle All Purpose 250ml", R.drawable.milk_item, 75.00, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(38, 9,"Snow Peas 500g", R.drawable.legumes_item, 180.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(39, 9,"Chicken Peas 225g", R.drawable.legumes_item, 40.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(40, 9,"Molinera Lentils 400g", R.drawable.legumes_item, 125.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(41, 9,"Peanuts per KG", R.drawable.legumes_item, 30.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(42, 9,"Iuengo White Beans 500g", R.drawable.legumes_item, 150.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(43, 10,"Now Foods Beet Sugar 3lbs", R.drawable.sugar_item, 550.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(44, 10,"Brown Sugar 1KG", R.drawable.sugar_item, 50.00, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(45, 10,"Hershey's Caramel Syrup 22oz", R.drawable.sugar_item, 299.00,"2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(47, 10,"Organic Cane Sugar 2lbs", R.drawable.sugar_item, 349.00,"2024-05-09"));


        Intent intent = getIntent();

        screen_title = findViewById(R.id.fishes_title);
        String str = intent.getStringExtra("activity_title");
        screen_title.setText(str);

        int catid = intent.getIntExtra("catid",0);

        ArrayList<CategoryItem> catitems = new ArrayList<CategoryItem>();
        for (CategoryItem item : categoryItemModelArrayList) {
            if(item.getCategory_id() == catid){
                catitems.add(item);
            }
         }


        CategoryItemgridAdapter adapter = new CategoryItemgridAdapter(getApplicationContext(), catitems);
        categoryItemGV.setAdapter(adapter);
        // Added bs_bundle price id, and double value of price.
        categoryItemGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bs_bundle = new Bundle();
                bs_bundle.clear();
                CategoryItem item = catitems.get(i);

                String catid = String.valueOf(item.getCId());
                String catname =  item.getCitem_name();
                double catitemprice = item.getCitem_price();

                bs_bundle.putString("itemname", catname);
                bs_bundle.putString("itemid", catid);
                bs_bundle.putDouble("itemprice", catitemprice);

                HAddToCart bottomSheet = new HAddToCart();
                bottomSheet.setArguments(bs_bundle);
                bottomSheet.show(getSupportFragmentManager(),"ModalBottomSheet");

            }
        });



//        listItem = getResources().getStringArray(R.array.array_technology);
//
//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
//        gridView.setAdapter(adapter);
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                // TODO Auto-generated method stub
//                String value=adapter.getItem(position);
//                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
//
//            }
//        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}

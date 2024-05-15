
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
        categoryItemModelArrayList.add(new CategoryItem(1, 1, "Manga", R.drawable.fruits_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(2, 1, "Apples", R.drawable.fruits_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(3, 1, "Banana", R.drawable.fruits_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(4, 1, "Pinya", R.drawable.fruits_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(5, 1, "Orange", R.drawable.fruits_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(7, 2, "Tomatoes?", R.drawable.veggies_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(8, 2, "Petchay", R.drawable.veggies_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(9, 2, "Sitaw", R.drawable.veggies_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(10, 2, "Sibuyas", R.drawable.veggies_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(11, 2, "Eggplant", R.drawable.veggies_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(11, 3,"Bangus", R.drawable.fishes_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(12, 3,"Tilapia", R.drawable.fishes_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(13, 3,"Clown Fish", R.drawable.fishes_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(14, 3,"Si Dori", R.drawable.fishes_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(15, 3,"Fish Fillet", R.drawable.fishes_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(16, 4,"Tenderloin steaks", R.drawable.beef_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(17, 4,"Certified Angus Beef Burger", R.drawable.beef_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(18, 4,"Ground Beef", R.drawable.beef_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(19, 4,"Beef Tenderloin", R.drawable.beef_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(20, 4,"Beef Burgers", R.drawable.beef_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(21, 5,"Breast Part", R.drawable.poultry_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(22, 5,"Whole Chicken", R.drawable.poultry_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(23, 5,"Thigh Part Chicken", R.drawable.poultry_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(24, 5,"Nuggets", R.drawable.poultry_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(25, 5,"Lollipop", R.drawable.poultry_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(27, 7,"Fresh Adobo Cut", R.drawable.pork_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(28, 7,"Pork Chop", R.drawable.pork_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(29, 7,"Pork Cubes", R.drawable.pork_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(30, 7,"Pork Cutlets", R.drawable.pork_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(31, 7,"Pork BBQ CUT", R.drawable.pork_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(32, 8,"BearBrand Milk ", R.drawable.milk_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(33, 8,"Cowhead Milk ", R.drawable.milk_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(34, 8,"Nestle Non Fat ", R.drawable.milk_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(35, 8,"Alaska Evaporada ", R.drawable.milk_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(37, 8,"Nestle All Purpose ", R.drawable.milk_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(38, 9,"Peas", R.drawable.legumes_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(39, 9,"Chicken Peas", R.drawable.legumes_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(40, 9,"Lentils", R.drawable.legumes_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(41, 9,"Peanuts", R.drawable.legumes_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(42, 9,"Beans", R.drawable.legumes_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(43, 10,"beet sugar", R.drawable.sugar_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(44, 10,"brown sugar", R.drawable.sugar_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(45, 10,"caramel", R.drawable.sugar_item, "2024-05-09"));
        categoryItemModelArrayList.add(new CategoryItem(47, 10,"Cane Sugar", R.drawable.sugar_item, "2024-05-09"));


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

        categoryItemGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bs_bundle = new Bundle();
                bs_bundle.clear();
                CategoryItem item = catitems.get(i);

                String catid = String.valueOf(item.getCId());
                String catname =  item.getCitem_name();

                bs_bundle.putString("itemname", catname);
                bs_bundle.putString("itemid", catid);

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

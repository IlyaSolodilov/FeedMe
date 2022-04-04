package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.feedme.adapter.MealAdapter;
import com.example.feedme.model.Meal;
import com.example.feedme.model.Order;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_page);

        ListView cart_list = findViewById(R.id.cart_list);

        List<String> mealsTitle = new ArrayList<>();
        for (Meal c : MainActivity.mealList){
            if(Order.items.contains(c.getId()))
                mealsTitle.add(c.getTitle());
        }

        cart_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mealsTitle));
    }
}
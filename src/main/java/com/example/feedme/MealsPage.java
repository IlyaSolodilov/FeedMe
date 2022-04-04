package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.feedme.model.Order;

public class MealsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_page);

        ConstraintLayout mealsBg = findViewById(R.id.mealsPageBg);
        ImageView mealsImage = findViewById(R.id.mealsPageImage);
        TextView mealsTitle = findViewById(R.id.mealsPageTitle);
        TextView mealsPrice = findViewById(R.id.mealsPriceTitle);
        TextView mealsWeight = findViewById(R.id.mealsPageWeight);

        mealsBg.setBackgroundColor(getIntent().getIntExtra("mealsBg", 0));
        mealsImage.setImageResource(getIntent().getIntExtra("mealsImage", 0));
        mealsTitle.setText(getIntent().getStringExtra("mealsTitle"));
        mealsPrice.setText(getIntent().getStringExtra("mealsPrice"));
        mealsWeight.setText(getIntent().getStringExtra("mealsWeight"));

    }

    public void addToCart(View view){
        int id = getIntent().getIntExtra("mealsId",0 );
        Order.items.add(id);
        Toast.makeText(this,"Добавлено! :)", Toast.LENGTH_LONG).show();
    }
}
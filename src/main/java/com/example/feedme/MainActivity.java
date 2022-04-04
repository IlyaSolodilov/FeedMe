package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.feedme.adapter.CategoryAdapter;
import com.example.feedme.adapter.MealAdapter;
import com.example.feedme.model.Category;
import com.example.feedme.model.Meal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, mealRecycler;
    CategoryAdapter categoryAdapter;
    static MealAdapter mealAdapter;
    static List<Meal> mealList = new ArrayList<>();
    static List<Meal> fullMealList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Мясо"));
        categoryList.add(new Category(2, "Овощи"));
        categoryList.add(new Category(3, "Фрукты"));
        categoryList.add(new Category(4, "Напитки"));
        setCategoryRecycler(categoryList);


        mealList.add(new Meal(1, "meatt","Говядина", "500р", "#BEEBE5","1кг", 1));
        mealList.add(new Meal(2, "tomato", "Помидоры", "100р","#BEEBE5","1кг", 2));
        mealList.add(new Meal(3, "bananas", "Бананы", "140р","#BEEBE5","1кг", 3));
        mealList.add(new Meal(4, "water", "Вода", "100р","#BEEBE5","1л", 4));



        fullMealList.addAll(mealList);

        setMealRecycler(mealList);
    }


    public void openCart(View view){
        Intent intent = new Intent(this, CartPage.class);
        startActivity(intent);
    }

    private void setMealRecycler(List<Meal> mealList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        mealRecycler = findViewById(R.id.mealRecycler);
        mealRecycler.setLayoutManager(layoutManager);

        mealAdapter = new MealAdapter(this, mealList);
        mealRecycler.setAdapter(mealAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    public static void showMealsByCategory(int category){
        
        mealList.clear();
        mealList.addAll(fullMealList);

        List<Meal> filterMeal = new ArrayList<>();

        for(Meal c : mealList){
            if(c.getCategory() == category)
                filterMeal.add(c);
        }

        mealList.clear();
        mealList.addAll(filterMeal);

        mealAdapter.notifyDataSetChanged();

    }
}
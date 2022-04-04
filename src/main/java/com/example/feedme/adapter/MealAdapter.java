package com.example.feedme.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.feedme.MealsPage;
import com.example.feedme.R;
import com.example.feedme.model.Meal;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealViewHolder> {

    Context context;
    List<Meal> meals;

    public MealAdapter(Context context,List<Meal> meals) {
        this.context = context;
        this.meals = meals;
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mealItems = LayoutInflater.from(context).inflate(R.layout.meals_item, parent, false);
        return new MealAdapter.MealViewHolder(mealItems);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.mealBg.setBackgroundColor(Color.parseColor(meals.get(position).getColor()));

        int imageId = context.getResources().getIdentifier("ic_" + meals.get(position).getImg(),"drawable", context.getPackageName());
        holder.mealImage.setImageResource(imageId);

        holder.mealTitle.setText(meals.get(position).getTitle());
        holder.mealPrice.setText(meals.get(position).getPrice());
        holder.mealWeight.setText(meals.get(position).getWeight());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MealsPage.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context,
                        new Pair<View, String>(holder.mealBg, "mealsImage"));

                intent.putExtra("mealBg",Color.parseColor(meals.get(position).getColor()));
                intent.putExtra("mealsImage",imageId);
                intent.putExtra("mealsTitle",meals.get(position).getTitle());
                intent.putExtra("mealsPrice",meals.get(position).getPrice());
                intent.putExtra("mealsWeight",meals.get(position).getWeight());
                intent.putExtra("mealsId",meals.get(position).getId());

                context.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public static final class MealViewHolder extends RecyclerView.ViewHolder{

        LinearLayout mealBg;
        ImageView mealImage;
        TextView mealTitle, mealPrice, mealWeight;

        public MealViewHolder(@NonNull View itemView) {
            super(itemView);

            mealBg = itemView.findViewById(R.id.mealBg);
            mealImage = itemView.findViewById(R.id.meat);
            mealTitle = itemView.findViewById(R.id.mealTitle);
            mealWeight = itemView.findViewById(R.id.meal_weight);
            mealPrice = itemView.findViewById(R.id.meal_price);
        }
    }

}

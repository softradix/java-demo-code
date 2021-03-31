package com.softradix.recipes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.softradix.recipes.R;
import com.softradix.recipes.modelClasses.GetRecipeModel;

import java.util.List;

public class ReceipeDetailAdapter extends RecyclerView.Adapter<ReceipeDetailAdapter.ViewHolder> {
    Context context;
    List<GetRecipeModel.Ingredient> list;

    public ReceipeDetailAdapter(Context context, List<GetRecipeModel.Ingredient> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.ingredient_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ingredientNameTv.setText(list.get(position).getIngredientName());
        holder.quantityTv.setText(list.get(position).getCalculatedQuantity());
        if (list.get(position).getUnit() != null) {
            holder.unitsTv.setVisibility(View.VISIBLE);
            holder.unitsTv.setText(list.get(position).getUnit().getUnit());
        } else {
            holder.unitsTv.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView ingredientNameTv, quantityTv, unitsTv;
        CardView cardView;
        LinearLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ingredientNameTv = itemView.findViewById(R.id.ingredientNameTv);
            cardView = itemView.findViewById(R.id.cardView);
            quantityTv = itemView.findViewById(R.id.quantityTv);
            unitsTv = itemView.findViewById(R.id.unitsTv);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }

    public void multiplyQuantity(int number) {
        for (int i = 0; i < list.size(); i++) {
            int quantityCount = Integer.parseInt(list.get(i).getQuantity()) * number;
            list.get(i).setCalculatedQuantity(String.valueOf(quantityCount));
        }

        notifyDataSetChanged();
    }

    public void divideQuantity() {
        for (int i = 0; i < list.size(); i++) {
            int quantityCount = Integer.parseInt(list.get(i).getCalculatedQuantity()) - Integer.parseInt(list.get(i).getQuantity());
            list.get(i).setCalculatedQuantity(String.valueOf(quantityCount));
        }
        notifyDataSetChanged();
    }
}

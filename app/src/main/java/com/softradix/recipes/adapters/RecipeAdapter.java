package com.softradix.recipes.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softradix.recipes.R;
import com.softradix.recipes.modelClasses.GetRecipeModel;
import com.softradix.recipes.utils.ConstantData;
import com.softradix.recipes.views.activities.ReceipeDetailActivity;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    Context context;
    List<GetRecipeModel.Recipe> list;

    public RecipeAdapter(Context context, List<GetRecipeModel.Recipe> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.receipe_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameTv.setText(list.get(position).getReceipeName());
        Glide.with(context).load(list.get(position).getReceipeImage()).placeholder(R.drawable.ic_noimage_placeholder).into(holder.recipeImg);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, ReceipeDetailActivity.class);
            intent.putExtra(ConstantData.RECIPE_DATA, list.get(position));
            context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView recipeImg;
        TextView nameTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeImg = itemView.findViewById(R.id.receipeImg);
            nameTv = itemView.findViewById(R.id.nameTv);

        }
    }
}

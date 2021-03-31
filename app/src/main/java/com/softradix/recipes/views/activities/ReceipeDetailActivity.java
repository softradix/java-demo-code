package com.softradix.recipes.views.activities;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softradix.recipes.R;
import com.softradix.recipes.adapters.ReceipeDetailAdapter;
import com.softradix.recipes.modelClasses.GetRecipeModel;
import com.softradix.recipes.utils.AppClass;
import com.softradix.recipes.utils.ConstantData;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@SuppressLint("NonConstantResourceId")

public class ReceipeDetailActivity extends AppCompatActivity {
    GetRecipeModel.Recipe recipeData;
    @BindView(R.id.cook_txtbtn)
    TextView cook_txtbtn;
    @BindView(R.id.recipeImg)
    ImageView recipeImg;
    @BindView(R.id.ivstar)
    ImageView ivstar;
    @BindView(R.id.recipeNameTv)
    TextView recipeNameTv;
    @BindView(R.id.timeTv)
    TextView timeTv;
    @BindView(R.id.foodTypeTv)
    TextView foodTypeTv;
    @BindView(R.id.missingIngredientTv)
    TextView missingIngredientTv;
    @BindView(R.id.directionTv)
    TextView directionTv;
    @BindView(R.id.ingredientsRv)
    RecyclerView ingredientsRv;
    @BindView(R.id.quantityCountTv)
    TextView quantityTv;
    @BindView(R.id.increementLay)
    RelativeLayout increementLay;
    @BindView(R.id.decreementLay)
    RelativeLayout decreementLay;
    List<GetRecipeModel.Ingredient> ingredientList = new ArrayList<>();
    ReceipeDetailAdapter recipeDetailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipe_detail);
        setListeners();
        getData();
    }

    private void setListeners() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        ButterKnife.bind(this);
    }

    private void getData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            recipeData = (GetRecipeModel.Recipe) bundle.getSerializable(ConstantData.RECIPE_DATA);
        }
        if (recipeData != null) {
            setData(recipeData);
        }

    }

    private void setData(GetRecipeModel.Recipe recipeData) {
        if (!AppClass.getAppPreferences().getString(ConstantData.TOTAL_SERVING).equals("")) {
            if (AppClass.getAppPreferences().getString(ConstantData.TOTAL_SERVING).equals("0")) {
                quantityTv.setText("1");
            } else {
                quantityTv.setText(AppClass.getAppPreferences().getString(ConstantData.TOTAL_SERVING));
            }
        } else {
            quantityTv.setText("1");
        }

        Glide.with(this).load(recipeData.getReceipeImage()).placeholder(R.drawable.ic_noimage_placeholder).into(recipeImg);
        recipeNameTv.setText(recipeData.getReceipeName());
        String time = recipeData.getCookingTime() + getString(R.string.min);
        timeTv.setText(time);
        foodTypeTv.setText(recipeData.getDiet());
        directionTv.setText(recipeData.getDirections());

        ingredientsRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        if (recipeData.getIngredients().size() > 0) {
            if (ingredientList != null) {
                ingredientList.clear();
            }
            assert ingredientList != null;
            ingredientList.addAll(recipeData.getIngredients());
            for (int i = 0; i < ingredientList.size(); i++) {
                int quantity = Integer.parseInt(ingredientList.get(i).getQuantity()) * Integer.parseInt(quantityTv.getText().toString());
                ingredientList.get(i).setCalculatedQuantity(String.valueOf(quantity));
            }
            recipeDetailAdapter = new ReceipeDetailAdapter(this, ingredientList);
            ingredientsRv.setAdapter(recipeDetailAdapter);

//            int isAvailableCount = 0;
//            for (int i = 0; i < ingredientList.size(); i++) {
//                if (ingredientList.get(i).getIsAvailable().equals(0)) {
//                    ingredientList.get(i).setMissingStatus(0);
//                    isAvailableCount++;
//                    String str;
//                    if (isAvailableCount == 0) {
//                        str = isAvailableCount + getString(R.string.no_missingIngredinet);
//                    } else if (isAvailableCount == 1) {
//                        str = isAvailableCount + getString(R.string.singlemissingIngredient);
//                    } else {
//                        str = isAvailableCount + getString(R.string.missingIngredient);
//                    }
//                    missingIngredientTv.setTextColor(getColor(R.color.red));
//                    missingIngredientTv.setText(str);
//                } else {
//                    ingredientList.get(i).setMissingStatus(1);
//                }
//            }
        }

    }

    @OnClick(R.id.iv_back)
    void onback() {
        onBackPressed();
    }

    @OnClick(R.id.increementLay)
    void onPlusClick() {
        String count = quantityTv.getText().toString();
        int no = Integer.parseInt(count) + 1;
        quantityTv.setText(String.valueOf(no));
        recipeDetailAdapter.multiplyQuantity(no);
    }


    @OnClick(R.id.decreementLay)
    void onMinusClick() {
        String count = quantityTv.getText().toString();
        if (!count.equalsIgnoreCase("1")) {
            int no = Integer.parseInt(count) - 1;
            quantityTv.setText(String.valueOf(no));
            recipeDetailAdapter.divideQuantity();
        }
    }


    @OnClick(R.id.cook_txtbtn)
    void onCookedThisClick() {
        onBackPressed();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(getColor(R.color.white));

    }

}
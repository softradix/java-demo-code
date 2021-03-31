package com.softradix.recipes.views.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.softradix.recipes.R;
import com.softradix.recipes.adapters.RecipeAdapter;
import com.softradix.recipes.modelClasses.GetRecipeModel;
import com.softradix.recipes.utils.AppClass;
import com.softradix.recipes.utils.ViewUtils;
import com.softradix.recipes.viewModelClasses.RecipeViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.nfc.tech.MifareUltralight.PAGE_SIZE;

@SuppressLint("NonConstantResourceId")
public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.recipesRv)
    RecyclerView rv;
    @BindView(R.id.tv_nodataTxt)
    TextView tv_nodataTxt;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    boolean isLastPage = false;
    boolean isLoading = false;
    int favApiHitFromDetail = 0;
    int scrolling_page = 1;
    String limit = "10";
    List<GetRecipeModel.Recipe> receipeList = new ArrayList<>();
    RecipeAdapter receipeAdapter;
    RecipeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setListeners();
        if (ViewUtils.InternetCheck(this)) {
            getRecipes();
        }
    }

    private void setListeners() {
        ButterKnife.bind(this);
        viewModel = ViewModelProviders.of(this).get(RecipeViewModel.class);
    }

    private void getRecipes() {
        JSONObject receipesObject = new JSONObject();
        try {
            receipesObject.put("limit", limit);
            receipesObject.put("page", scrolling_page);

            System.out.println("Data Is:" + receipesObject);

        } catch (JsonIOException | JSONException e) {
            e.printStackTrace();
        }
        JsonParser jsonParser = new JsonParser();
        JsonObject gsonObject = (JsonObject) jsonParser.parse(receipesObject.toString());


        isLoading = true;
        if (scrolling_page == 1) {// if page no is 1 then show main screen loader , else bottom pagination loader
            if (favApiHitFromDetail == 0) {
                ViewUtils.showProgress(this);
            }
        } else {
            progressBar.setVisibility(View.VISIBLE);
        }
        viewModel.getRecipes(this, gsonObject).observe(this, getRecipesModel -> {
            isLoading = false;
            if (getRecipesModel != null) {
                if (getRecipesModel.getSuccess()) {
                    // checking if page is last page
                    isLastPage = scrolling_page >= getRecipesModel.getLastPage();
                    if (getRecipesModel.getRecipes().size() > 0) {

                        if (receipeList != null) {
                            if (scrolling_page == 1) {      // clear list only when page no is 1 else add new data in previous
                                receipeList.clear();
                            } else {
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                        assert receipeList != null;
                        receipeList.addAll(getRecipesModel.getRecipes());

                        for (int i = 0; i < receipeList.size(); i++) {
                            int isAvailableCount = 0;
                            for (int j = 0; j < receipeList.get(i).getIngredients().size(); j++) {
                                if (receipeList.get(i).getIngredients().get(j).getIsAvailable().equals(0)) {
                                    isAvailableCount++;
                                    receipeList.get(i).setIngredientsCount(isAvailableCount);
                                }
                            }
                        }
                        //for sorting
                        Collections.sort(receipeList, (lhs, rhs) -> lhs.getIngredientsCount().compareTo(rhs.getIngredientsCount()));

                        if (scrolling_page == 1) {
                            setAdapter();
                        } else {
                            receipeAdapter.notifyDataSetChanged();
                        }

                    }
                }
                showView();
            }
        });
    }

    private void setAdapter() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        receipeAdapter = new RecipeAdapter(this, receipeList);
        rv.setAdapter(receipeAdapter);

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

                if (!isLoading && !isLastPage) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                            && firstVisibleItemPosition >= 0
                            && totalItemCount >= PAGE_SIZE) {
                        scrolling_page += 1;
                        getRecipes();

                    }
                }
            }
        });
    }

    private void showView() {
        if (receipeList.isEmpty()) {
            rv.setVisibility(View.GONE);
            tv_nodataTxt.setVisibility(View.VISIBLE);
        } else {
            rv.setVisibility(View.VISIBLE);
            tv_nodataTxt.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.logOut)
    void onLogOutClick() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Logout").setMessage("Are you really want to logout?")
                .setCancelable(false).setPositiveButton("YES", (dialog, which) -> {

            AppClass.getAppPreferences().clearEditor(this);
            startActivity(new Intent(this, WelcomeActivity.class));
            finishAffinity();

        }).setNegativeButton("NO", (dialog, which) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }

}
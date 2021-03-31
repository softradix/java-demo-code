package com.softradix.recipes.viewModelClasses;

import android.app.Activity;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.JsonObject;
import com.softradix.recipes.R;
import com.softradix.recipes.modelClasses.GetRecipeModel;
import com.softradix.recipes.retrofit.ApiInterface;
import com.softradix.recipes.retrofit.UserApiClient;
import com.softradix.recipes.utils.ViewUtils;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeViewModel extends ViewModel {
    ApiInterface api = UserApiClient.apiClient().create(ApiInterface.class);

    private MutableLiveData<GetRecipeModel> getRecipesModelMutableLiveData;

    public LiveData<GetRecipeModel> getRecipes(final Activity activity, JsonObject object) {

        if (ViewUtils.InternetCheck(activity)) {
            getRecipesModelMutableLiveData = new MutableLiveData<>();

            api.getRecipes(object).enqueue(new Callback<GetRecipeModel>() {
                @Override
                public void onResponse(@NotNull Call<GetRecipeModel> call, @NotNull Response<GetRecipeModel> response) {
                    ViewUtils.progressDismiss(activity);
                    if (response.isSuccessful()) {
                        getRecipesModelMutableLiveData.setValue(response.body());
                    }
                }

                @Override
                public void onFailure(@NotNull Call<GetRecipeModel> call, @NotNull Throwable t) {
                    ViewUtils.progressDismiss(activity);
                }
            });

        } else {
            Toast.makeText(activity, R.string.noInternet_msg, Toast.LENGTH_SHORT).show();
        }
        return getRecipesModelMutableLiveData;
    }

}

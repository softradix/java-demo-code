package com.softradix.recipes.viewModelClasses;

import android.app.Activity;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.softradix.recipes.R;
import com.softradix.recipes.modelClasses.UserRegisterModel;
import com.softradix.recipes.retrofit.ApiInterface;
import com.softradix.recipes.retrofit.UserApiClient;
import com.softradix.recipes.utils.ViewUtils;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {
    ApiInterface api = UserApiClient.apiClient().create(ApiInterface.class);

    private MutableLiveData<UserRegisterModel> registerMutableLiveData;

    public LiveData<UserRegisterModel> userRegister(final Activity activity, String firstName,
                                                    String lastName, String email,
                                                    String password, String device_token, String device_type) {

        if (ViewUtils.InternetCheck(activity)) {
            registerMutableLiveData = new MutableLiveData<>();
            ViewUtils.showProgress(activity);

            api.userRegister(firstName, lastName, email, password, device_token, device_type).enqueue(new Callback<UserRegisterModel>() {
                @Override
                public void onResponse(@NotNull Call<UserRegisterModel> call, @NotNull Response<UserRegisterModel> response) {
                    ViewUtils.progressDismiss(activity);
                    if (response.isSuccessful()) {
                        registerMutableLiveData.setValue(response.body());
                    }
                }
                @Override
                public void onFailure(@NotNull Call<UserRegisterModel> call, @NotNull Throwable t) {
                    ViewUtils.progressDismiss(activity);
                }
            });

        } else {
            Toast.makeText(activity, R.string.noInternet_msg, Toast.LENGTH_SHORT).show();
        }
        return registerMutableLiveData;

    }

    private MutableLiveData<UserRegisterModel> loginModelMutableLiveData;

    public LiveData<UserRegisterModel> userLogin(final Activity activity, String email, String password, String device_token, String device_type) {

        if (ViewUtils.InternetCheck(activity)) {
            loginModelMutableLiveData = new MutableLiveData<>();
            ViewUtils.showProgress(activity);

            api.userLogin(email, password, device_token, device_type).enqueue(new Callback<UserRegisterModel>() {
                @Override
                public void onResponse(@NotNull Call<UserRegisterModel> call, @NotNull Response<UserRegisterModel> response) {
                    ViewUtils.progressDismiss(activity);
                    if (response.isSuccessful()) {
                        loginModelMutableLiveData.setValue(response.body());
                    }
                }

                @Override
                public void onFailure(@NotNull Call<UserRegisterModel> call, @NotNull Throwable t) {
                    ViewUtils.progressDismiss(activity);
                }
            });

        } else {
            Toast.makeText(activity, R.string.noInternet_msg, Toast.LENGTH_SHORT).show();
        }
        return loginModelMutableLiveData;
    }
}

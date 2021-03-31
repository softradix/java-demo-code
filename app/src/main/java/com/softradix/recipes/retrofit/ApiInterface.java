package com.softradix.recipes.retrofit;

import com.google.gson.JsonObject;
import com.softradix.recipes.modelClasses.GetRecipeModel;
import com.softradix.recipes.modelClasses.UserRegisterModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("auth/register")
    Call<UserRegisterModel> userRegister(@Field("first_name") String first_name,
                                         @Field("last_name") String last_name,
                                         @Field("email") String email,
                                         @Field("password") String password,
                                         @Field("device_token") String device_token,
                                         @Field("device_type") String device_type);

    @FormUrlEncoded
    @POST("auth/login")
    Call<UserRegisterModel> userLogin(@Field("email") String email,
                                      @Field("password") String password,
                                      @Field("device_token") String device_token,
                                      @Field("device_type") String device_type);

    @POST("get_recipes")
    Call<GetRecipeModel> getRecipes(@Body JsonObject jsonObject);
}

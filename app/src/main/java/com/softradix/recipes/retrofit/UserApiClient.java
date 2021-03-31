package com.softradix.recipes.retrofit;


import android.util.Log;

import com.softradix.recipes.utils.AppClass;
import com.softradix.recipes.utils.ConstantData;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserApiClient {
    public static String baseUrl = "https://swate.softradixtechnologies.com/api/";
    public static Retrofit retrofit = null;

    public static Retrofit apiClient() {
        if (retrofit == null) {
            final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(50, TimeUnit.SECONDS)
                    .writeTimeout(50, TimeUnit.SECONDS)
                    .addNetworkInterceptor(interceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addInterceptor(chain -> {
                        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                        Request original = chain.request();
                        Request request = original.newBuilder()
                                .header("Authorization", "Bearer" + " " + AppClass.getAppPreferences().getString(ConstantData.ACCESS_TOKEN))
                                .method(original.method(), original.body())
                                .build();

                        Response response = chain.proceed(request);
                        Log.d("MyApp", "Code : " + response.code());

                        return response;
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}

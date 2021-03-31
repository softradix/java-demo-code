package com.softradix.recipes.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.softradix.recipes.R;
import com.softradix.recipes.utils.AppClass;
import com.softradix.recipes.utils.ConstantData;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.theme1);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(() -> {
            if (AppClass.getAppPreferences().getString(ConstantData.TOKEN).equalsIgnoreCase("1")) {
                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                finishAffinity();
            } else if (AppClass.getAppPreferences().getString(ConstantData.TOKEN).equalsIgnoreCase("")) {
                startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
                finishAffinity();
            }
        }, 2000);
    }
}
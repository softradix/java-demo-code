package com.softradix.recipes.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.softradix.recipes.R;
import com.softradix.recipes.utils.ConstantData;

import butterknife.ButterKnife;
import butterknife.OnClick;

@SuppressLint("NonConstantResourceId")
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.theme1);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.join_btn)
    void onJoinBtnClick() {
        startActivity(new Intent(this, LoginActivity.class).putExtra(ConstantData.TO_LOGIN_ACTIVITY, ConstantData.FROM_REGISTER));
    }

    @OnClick(R.id.login_btn)
    void onLoginBtnClick() {
        startActivity(new Intent(this, LoginActivity.class).putExtra(ConstantData.TO_LOGIN_ACTIVITY, ConstantData.FROM_LOGIN));

    }
}
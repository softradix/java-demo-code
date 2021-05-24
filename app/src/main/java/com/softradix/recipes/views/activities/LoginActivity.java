package com.softradix.recipes.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.softradix.recipes.R;
import com.softradix.recipes.utils.ConstantData;
import com.softradix.recipes.views.fragments.FragmentLogin;
import com.softradix.recipes.views.fragments.FragmentRegister;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.theme1);
        setContentView(R.layout.activity_login);
        setListeners();
    }

    private void setListeners() {
        if (getIntent().getStringExtra(ConstantData.TO_LOGIN_ACTIVITY) != null) {
            if (getIntent().getStringExtra(ConstantData.TO_LOGIN_ACTIVITY).equalsIgnoreCase(ConstantData.FROM_LOGIN)) {
                loadFragment(new FragmentLogin());
            } else {
                loadFragment(new FragmentRegister());
            }
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fts = this.getSupportFragmentManager().beginTransaction();
        fts.add(R.id.fragmentContainer, fragment);
//        fts.addToBackStack(fragment.getClass().getSimpleName());
        fts.commit();

    }
}
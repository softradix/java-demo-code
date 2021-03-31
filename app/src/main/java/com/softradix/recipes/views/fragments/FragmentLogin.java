package com.softradix.recipes.views.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;


import com.softradix.recipes.R;
import com.softradix.recipes.utils.AppClass;
import com.softradix.recipes.utils.ConstantData;
import com.softradix.recipes.utils.ViewUtils;
import com.softradix.recipes.viewModelClasses.LoginViewModel;
import com.softradix.recipes.views.activities.HomeActivity;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@SuppressLint("NonConstantResourceId")
public class FragmentLogin extends Fragment {
    @BindView(R.id.email_et)
    EditText emailEt;
    @BindView(R.id.password_et)
    EditText passwordEt;
    @BindView(R.id.mainLayout)
    RelativeLayout mainLayout;
    LoginViewModel viewModel;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_login, container, false);
        setListeners();
        return v;
    }

    private void setListeners() {
        ButterKnife.bind(this, v);
        viewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(LoginViewModel.class);
    }

    @OnClick(R.id.login_btn)
    void onLoginClick() {
        validate();
    }

    @OnClick(R.id.iv_back)
    void onBackPress() {
        Objects.requireNonNull(getActivity()).onBackPressed();
    }

    private void validate() {
        if (emailEt.getText().toString().equals("")) {
            ViewUtils.showSnackBar(mainLayout, getResources().getString(R.string.enterEmail));
        } else if (!emailEt.getText().toString().matches(getResources().getString(R.string.email_pattern))) {
            ViewUtils.showSnackBar(mainLayout, getResources().getString(R.string.enterValidemail));
        } else if (passwordEt.getText().toString().equals("")) {
            ViewUtils.showSnackBar(mainLayout, getResources().getString(R.string.enterPassword));
        } else {
            if (ViewUtils.InternetCheck(Objects.requireNonNull(getActivity()))) {
                login();
            }
        }
    }

    private void login() {
        viewModel.userLogin(getActivity(), emailEt.getText().toString(), passwordEt.getText().toString(), "abc", "2").observe(Objects.requireNonNull(getActivity()), loginModel -> {
            if (loginModel != null) {
                if (loginModel.getSuccess()) {
                    AppClass.getAppPreferences().putString(ConstantData.TOKEN, "1");
                    AppClass.getAppPreferences().putString(ConstantData.ACCESS_TOKEN, loginModel.getToken());
                    AppClass.getAppPreferences().putString(ConstantData.TOTAL_SERVING, loginModel.getUser().getCookForPeople());

                    startActivity(new Intent(getActivity(), HomeActivity.class));
                    Objects.requireNonNull(getActivity()).finishAffinity();

                } else {
                    ViewUtils.showSnackBar(mainLayout, loginModel.getMessage());
                }
            }
        });
    }

}
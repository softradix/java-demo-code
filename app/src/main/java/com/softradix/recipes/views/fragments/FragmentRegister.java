package com.softradix.recipes.views.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

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
public class FragmentRegister extends Fragment {
    @BindView(R.id.firstname_et)
    EditText firstNameEt;
    @BindView(R.id.lastname_et)
    EditText lastNameEt;
    @BindView(R.id.email_et)
    EditText emailEt;
    @BindView(R.id.pasword_et)
    EditText passwordEt;
    @BindView(R.id.tnC_checkbox)
    CheckBox tncCheckbox;
    @BindView(R.id.mainLayout)
    RelativeLayout mainLayout;
    LoginViewModel viewModel;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_register, container, false);
        setListeners();
        return v;
    }

    private void setListeners() {
        ButterKnife.bind(this, v);
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
    }

    @OnClick(R.id.continue_btn)
    void onContinue() {
        validate();

    }

    private void validate() {
        if (firstNameEt.getText().toString().equals("")) {
            ViewUtils.showSnackBar(mainLayout, getResources().getString(R.string.enterFirstname));
        } else if (lastNameEt.getText().toString().equals("")) {
            ViewUtils.showSnackBar(mainLayout, getResources().getString(R.string.enterLastname));
        } else if (emailEt.getText().toString().equals("")) {
            ViewUtils.showSnackBar(mainLayout, getResources().getString(R.string.enterEmail));
        } else if (!emailEt.getText().toString().matches(getResources().getString(R.string.email_pattern))) {
            ViewUtils.showSnackBar(mainLayout, getResources().getString(R.string.enterValidemail));
        } else if (passwordEt.getText().toString().equals("")) {
            ViewUtils.showSnackBar(mainLayout, getResources().getString(R.string.enterPassword));
        } else if (!tncCheckbox.isChecked()) {
            ViewUtils.showSnackBar(mainLayout, getResources().getString(R.string.checkTnc));
        } else {
            if (ViewUtils.InternetCheck(Objects.requireNonNull(getActivity()))) {
                register();
            }
        }
    }

    private void register() {
        viewModel.userRegister(getActivity(), firstNameEt.getText().toString(), lastNameEt.getText().toString(), emailEt.getText().toString(), passwordEt.getText().toString(), "abc", "2").observe(this, loginModel -> {
            if (loginModel != null) {
                if (loginModel.getSuccess()) {
                    AppClass.getAppPreferences().putString(ConstantData.ACCESS_TOKEN, loginModel.getToken());
                    AppClass.getAppPreferences().putString(ConstantData.TOTAL_SERVING, loginModel.getUser().getCookForPeople());
                    AppClass.getAppPreferences().putString(ConstantData.TOKEN, "1");

                    startActivity(new Intent(getActivity(), HomeActivity.class));
                    Objects.requireNonNull(getActivity()).finishAffinity();

                } else {
                    ViewUtils.showSnackBar(mainLayout, loginModel.getMessage());
                }
            }
        });
    }

    @OnClick(R.id.iv_back)
    void onBack() {
        Objects.requireNonNull(getActivity()).onBackPressed();
    }
}
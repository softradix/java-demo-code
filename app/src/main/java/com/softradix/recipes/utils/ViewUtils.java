package com.softradix.recipes.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.softradix.recipes.R;

import static android.content.Context.CONNECTIVITY_SERVICE;
import static android.text.Html.fromHtml;

public class ViewUtils {

    Activity activity;
    private static Dialog mProgressDialog;

    public ViewUtils(Activity c) {
        this.activity = c;

    }

    public static void showToast(Context context, String message) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.show();
    }


    public static void hideKeyBoard(Activity activity) {
        InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(
                Context.INPUT_METHOD_SERVICE);
        View focusedView = activity.getCurrentFocus();
        if (focusedView != null) {
            inputManager.hideSoftInputFromWindow(focusedView.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static void showSnackBar(View rootView, String msg) {
        final Snackbar snackbar = Snackbar.make(rootView, fromHtml("<font color=\"#000000\">" + msg), Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(Color.parseColor("#ffffff"));
        snackbar.show();
    }

    public static boolean InternetCheck(Activity activity) {
        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected() && networkInfo.isAvailable()) {
            return true;
        } else {
            showInternetCheckDialog(activity);
        }
        return false;
    }

    private static void showInternetCheckDialog(Activity activity) {
        mProgressDialog = new Dialog(activity);
        mProgressDialog.setContentView(R.layout.loader_check_internet);
        mProgressDialog.setCancelable(false);
        mProgressDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mProgressDialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
        Button button = mProgressDialog.findViewById(R.id.ok_btn);

        button.setOnClickListener(v -> mProgressDialog.dismiss());
        mProgressDialog.show();

    }


    private static Dialog progressDialog;

    public static void showProgress(Activity activity) {
        if (activity != null)

            if (progressDialog == null && !activity.isFinishing()) {
                progressDialog = new Dialog(activity, android.R.style.Theme_Translucent);
                progressDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                progressDialog.setContentView(R.layout.progress_loader);

                progressDialog.setCancelable(false);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    progressDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    progressDialog.getWindow().setStatusBarColor(Color.parseColor("#80000000"));
                }

                progressDialog.show();
            }
    }

    public static void progressDismiss(Activity activity) {
        if (activity != null)
            if (progressDialog != null && progressDialog.isShowing() && !activity.isFinishing()) {
                progressDialog.dismiss();
                progressDialog = null;
            }
    }

}

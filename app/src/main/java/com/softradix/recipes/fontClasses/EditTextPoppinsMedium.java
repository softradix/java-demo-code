package com.softradix.recipes.fontClasses;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@SuppressLint("AppCompatCustomView")
public class EditTextPoppinsMedium extends EditText {


    private String mTag = EditTextPoppinsMedium.this.getClass().getSimpleName();

    public EditTextPoppinsMedium(Context context) {
        super(context);
        init();
    }

    public EditTextPoppinsMedium(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditTextPoppinsMedium(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public EditTextPoppinsMedium(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "Poppins-Medium.ttf");
        this.setTypeface(font);
    }
}


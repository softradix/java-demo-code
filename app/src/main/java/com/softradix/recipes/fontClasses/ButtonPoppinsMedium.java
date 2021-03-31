package com.softradix.recipes.fontClasses;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

@SuppressLint("AppCompatCustomView")
public class ButtonPoppinsMedium extends Button {
    private String mTag = ButtonPoppinsMedium.this.getClass().getSimpleName();

    public ButtonPoppinsMedium(Context context) {
        super(context);
        init();
    }

    public ButtonPoppinsMedium(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ButtonPoppinsMedium(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ButtonPoppinsMedium(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "Poppins-Medium.ttf");
        this.setTypeface(font);
    }
}


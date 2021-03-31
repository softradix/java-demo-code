package com.softradix.recipes.fontClasses;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@SuppressLint("AppCompatCustomView")
public class TextViewRobotoMedium extends TextView {
    private String mTag = TextViewRobotoMedium.this.getClass().getSimpleName();

    public TextViewRobotoMedium(Context context) {
        super(context);
        init();
    }

    public TextViewRobotoMedium(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewRobotoMedium(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TextViewRobotoMedium(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private void init() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "Roboto-Medium.ttf");
        this.setTypeface(font);
    }
}

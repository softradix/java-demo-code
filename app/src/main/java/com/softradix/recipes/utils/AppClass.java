package com.softradix.recipes.utils;

import android.app.Application;
import android.content.Context;

public class AppClass extends Application {
    private static AppClass instance;
    private static AppPreferences appPreferences;

    public static Context context;

    public static synchronized AppClass getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = this;
        appPreferences = AppPreferences.init(context);
    }

    public static AppPreferences getAppPreferences() {
        return appPreferences;
    }
}

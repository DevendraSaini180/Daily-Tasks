package com.devendrasaini.sharedpreferencesapplication;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this.getApplicationContext();
    }
}

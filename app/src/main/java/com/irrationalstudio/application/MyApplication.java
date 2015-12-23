package com.irrationalstudio.application;

import android.app.Application;

/**
 * Created by Prasad-Dekstop on 18-12-2015.
 */
public class MyApplication extends Application {

    private static String action;

    public static void setAction(String response) {
        action = response;
    }

    public static String getAction() {
        return action;
    }


}

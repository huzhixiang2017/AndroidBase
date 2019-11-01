package com.java.base.common;


import android.app.Application;

import com.java.base.utils.Utils;


public class BaseApplication extends Application {
    private static BaseApplication applications = null;


    @Override
    public void onCreate() {
        super.onCreate();
        applications = this;

        //初始化toast
        Utils.init(applications);

    }

    public static BaseApplication getInstance() {
        return applications;
    }


}

package com.java.base.common;


import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;

import com.java.base.utils.Utils;

import receiver.NetworkConnectChangedReceiver;


public class BaseApplication extends Application {
    private static BaseApplication applications = null;
    private NetworkConnectChangedReceiver changedReceiver;
    private  IntentFilter filter;


    @Override
    public void onCreate() {
        super.onCreate();
        applications = this;
        Utils.init(applications); //初始化applications

        initReceiver();

    }


    /**
     * 注册广播Receiver
     */
    private void initReceiver(){
        filter = new IntentFilter();
        changedReceiver =  new NetworkConnectChangedReceiver();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        Utils.getContext().registerReceiver(changedReceiver, filter);

    }


    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
//        if(changedReceiver != null){
//            unregisterReceiver(changedReceiver);
//        }
    }


}

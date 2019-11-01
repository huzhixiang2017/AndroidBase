package com.java.base.utils;

import android.content.Context;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com  https://juejin.im/post/5c032d895188257c5237c8a3
 *     time  : 16/12/08
 *     desc  : Utils初始化相关
 *
 *     吐槽一下，自己暂时用到的不多，是copy的，好的借鉴用不到的放着也没事
 * </pre>
 */
public class Utils {

    private static Context context;

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        Utils.context = context.getApplicationContext();
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        if (context != null) return context;
        throw new NullPointerException("u should init first");
    }
}
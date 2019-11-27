package com.java.base.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.java.base.R;
import com.java.base.common.BaseFragment;
import com.java.base.utils.ToastUtils;

/**
 * Created by frank on 2016/12/14.
 */

public class ThreeFragment extends BaseFragment {
    private static final String TAG = ThreeFragment.class.getSimpleName();
    public final static String CONTENT = "content";


    public static ThreeFragment newInstance() {
        return new ThreeFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test;
    }


    @Override
    protected void initView( ViewGroup container, Bundle savedInstanceState) {

    }



    @Override
    protected void initData() {

    }


    @Override
    public void onResume() {
        super.onResume();
        ToastUtils.showShortToast("2");
    }
}

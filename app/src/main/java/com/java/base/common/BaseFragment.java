package com.java.base.common;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @ProjectName: AndroidBase
 * @Package: com.java.base.common
 * @ClassName: BaseFragment
 * @Description: DataBinding的使用
 *               https://blog.csdn.net/liangjingkanji/article/details/82180695
 *               https://blog.csdn.net/sinat_17164495/article/details/100112237
 *               https://www.jianshu.com/p/6aaa38d0948e
 * @Author: 作者名
 * @CreateDate: 2019/11/4 15:19
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/4 15:19
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public abstract class BaseFragment<DB extends ViewDataBinding> extends Fragment {
    public FragmentActivity activity;
    private Unbinder unbinder;
    public DB bindView;
    private View view;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(this.getContext()).inflate(getLayoutId(), null);
        bindView = DataBindingUtil.bind(view);

        unbinder = ButterKnife.bind(activity);
        initView(container, savedInstanceState);
        initData();

        return bindView.getRoot();
    }


    /**
     * 获取布局 ID
     */
    protected abstract int getLayoutId();
    /**
     * 初始化控件
     */
    protected abstract void initView( ViewGroup container, Bundle savedInstanceState);

    /**
     * 初始化数据
     */
    protected abstract void initData();


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}

package com.java.base.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.java.base.R;
import com.java.base.common.BaseFragment;
import com.java.base.databinding.FragmentHomeBinding;
import com.java.base.utils.ToastUtils;
import com.java.base.views.RecyclerViewScrollListener;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;

/**
 * @method
 * @description 描述一下作用
 * @date: 2019/11/14 16:06
 * @author: yupan
 * @param
 * @return
 */
public class HomeFragment extends BaseFragment<FragmentHomeBinding> {
    private static final  String TAG = HomeFragment.class.getSimpleName();
    private final List<DelegateAdapter.Adapter> adapters = new LinkedList<>();
    private DelegateAdapter delegateAdapter;


    @BindView(R.id.base_recycler)
    public RecyclerView recyclerView;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(ViewGroup container, Bundle savedInstanceState) {
//        recyclerView = bindView.baseRecycler;
//        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
//        recyclerView.setRecycledViewPool(viewPool);
//        viewPool.setMaxRecycledViews(0, 10);

//        adapters.add(initClassifyDatailsHeaderAdapte(activity));
//        adapters.add(initClassifyDetailsAdapter(activity));
//        adapters.add(initAllGoodsFooterAdapter(activity));

//        VirtualLayoutManager manager = new VirtualLayoutManager(activity);
//        recyclerView.setLayoutManager(manager);
//        delegateAdapter = new DelegateAdapter(manager);
//        delegateAdapter.setAdapters(adapters);
//        recyclerView.setAdapter(delegateAdapter);
//
//        recyclerView.addOnScrollListener(new RecyclerViewScrollListener(activity,null));
//        recyclerView.smoothScrollToPosition(0);//点击回到顶部
    }



    @Override
    protected void initData() {

    }


    @Override
    public void onResume() {
        super.onResume();
        ToastUtils.showShortToast("0");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}

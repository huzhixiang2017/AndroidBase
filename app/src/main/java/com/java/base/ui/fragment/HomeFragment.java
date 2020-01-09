package com.java.base.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.java.base.R;
import com.java.base.adapter.HomeAdapter;
import com.java.base.common.BaseFragment;
import com.java.base.common.BaseRecyclerViewAdapter;
import com.java.base.databinding.HomeFragmentBinding;
import com.java.base.model.bean.ClassifyDetailsBean;
import com.java.base.utils.ConstUtils;
import com.java.base.utils.JsonUtils;
import com.java.base.utils.ToastUtils;
import com.java.base.views.RecyclerViewScrollListener;
import com.java.base.views.RefreshPtrCustom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;
import pl.droidsonroids.gif.GifImageView;

/**
 * @method
 * @description 描述一下作用
 * @date: 2019/11/14 16:06
 * @author: yupan
 * @param
 * @return
 */
public class HomeFragment extends BaseFragment<HomeFragmentBinding> implements HomeAdapter.ActionInterface {
    private static final  String TAG = HomeFragment.class.getSimpleName();
    private final List<DelegateAdapter.Adapter> adapters = new LinkedList<>();
    private DelegateAdapter delegateAdapter;
    private HomeAdapter homeAdapter;
    private List<ClassifyDetailsBean> beanList = new ArrayList<>();


    @BindView(R.id.base_recycler)
    public RecyclerView recyclerView;
    @BindView(R.id.ptr_home_refresh)
    public RefreshPtrCustom mRefresh;
    @BindView(R.id.home_return_top)
    public ImageView home_return_top;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView(ViewGroup container, Bundle savedInstanceState) {
        recyclerView = bindView.baseRecycler;
        mRefresh = bindView.ptrHomeRefresh;
        home_return_top = bindView.homeReturnTop;

        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);

//        adapters.add(initClassifyDatailsHeaderAdapte(activity));
        adapters.add(initClassifyDetailsAdapter());
//        adapters.add(initAllGoodsFooterAdapter(activity));

        VirtualLayoutManager manager = new VirtualLayoutManager(activity);
        recyclerView.setLayoutManager(manager);
        delegateAdapter = new DelegateAdapter(manager);
        delegateAdapter.setAdapters(adapters);
        recyclerView.setAdapter(delegateAdapter);

        recyclerView.addOnScrollListener(new RecyclerViewScrollListener(activity,home_return_top));
        recyclerView.smoothScrollToPosition(0);//点击回到顶部

        vcRefreshInit();
    }


    public BaseRecyclerViewAdapter initClassifyDetailsAdapter() {
        if(homeAdapter != null){
            return homeAdapter;
        }
        StaggeredGridLayoutHelper layoutHelper = new StaggeredGridLayoutHelper(1, 8);
        layoutHelper.setMargin(13, 0,13,8);
        beanList = JsonUtils.parseDataHomeItem(getActivity(), ConstUtils.JSON_FILE_CLASSIFY);
        homeAdapter = new HomeAdapter(getActivity(),layoutHelper,beanList,R.layout.home_item_recycler);
        bindView.baseRecycler.setAdapter(homeAdapter);
        homeAdapter.setActionInterface(this);

        return homeAdapter;
    }


    private void vcRefreshInit() {
        View footer= LayoutInflater.from(getActivity()).inflate(R.layout.view_loading_head,null);
        GifImageView mGifFromAssets = footer.findViewById(R.id.gif_header_loading);
        mGifFromAssets.setImageResource(R.drawable.loading_footer);
        mRefresh.setFooterView(footer);
        mRefresh.setLastUpdateTimeRelateObject(this);
        mRefresh.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                //loadData();
                mRefresh.refreshComplete();
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                //loadVoucherCenterData();
                mRefresh.refreshComplete();
            }

            @Override
            public boolean checkCanDoLoadMore(PtrFrameLayout frame, View content, View footer) {
                return super.checkCanDoLoadMore(frame, content, footer);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return super.checkCanDoRefresh(frame, content, header);
            }
        });

        //回到"顶部"点击事件
        home_return_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.smoothScrollToPosition(0);
            }
        });
    }


    @Override
    protected void initData() {

    }


    @Override
    public void doShare(ClassifyDetailsBean bean) {
        ToastUtils.showShortToast("doShare " + bean.getName());
    }


    @Override
    public void doAddToShopCar(ClassifyDetailsBean bean) {
        ToastUtils.showShortToast("doAddToShopCar " + bean.getName());
    }


    @Override
    public void goDetail(ClassifyDetailsBean bean, int position) {
        ToastUtils.showShortToast( bean.getName() +  " position " + position);
    }


    @Override
    public void onResume() {
        super.onResume();
        ToastUtils.showShortToast("0 Home");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}

package com.java.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.java.base.common.BaseRecyclerViewHolder;
import com.java.base.databinding.HomeItemHeaderBinding;

/**
 * @ProjectName: AndroidBase
 * @Package: com.java.base.adapter
 * @ClassName: HomeAdapter
 * @Description: java类作用描述HomeItemRecyclerBindingImpl
 * @Author: 作者名
 * @CreateDate: 2019/12/11 14:37
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/12/11 14:37
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class HomeHeaderAdapter<T> extends DelegateAdapter.Adapter<BaseRecyclerViewHolder> {
    private static final String TAG = HomeHeaderAdapter.class.getSimpleName();
    private  HomeItemHeaderBinding itemBing;
    private Context context;
    private LayoutHelper helper;
    private int layoutId;


    public HomeHeaderAdapter(Context context, LayoutHelper helper, @LayoutRes int layoutId) {
        this.context = context;
        this.helper = helper;
        this.layoutId = layoutId;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return helper;
    }

    @NonNull
    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //获取DataBing相当于获取View
        itemBing = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),layoutId,parent,false);
        //初始化ViewHolder存放View
        BaseRecyclerViewHolder holder = new BaseRecyclerViewHolder(itemBing);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerViewHolder holder, int position) {
        Glide.with(context).load("https://pic3.zhimg.com/v2-4d8dcd6de27f81bc01435e0c6867b60e.jpg").into( itemBing.homeHeaderImg);
        holder.dataBing.executePendingBindings();//刷新界面
    }




    @Override
    public int getItemCount() {
        return 1;
    }



}

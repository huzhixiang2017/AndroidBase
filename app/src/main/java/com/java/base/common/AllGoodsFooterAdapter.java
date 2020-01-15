package com.java.base.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.java.base.R;

/**
 * 所有商品底部布局
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public class AllGoodsFooterAdapter extends DelegateAdapter.Adapter {
    public Context context;
    private LayoutHelper helper;
    private int layoutId;

    public AllGoodsFooterAdapter(Context context, LayoutHelper helper,int layoutId) {
        this.helper = helper;
        this.context = context;
        this.layoutId = layoutId;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return this.helper;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TheViewHolder(LayoutInflater.from(context).inflate(layoutId,parent,false));

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class TheViewHolder extends RecyclerView.ViewHolder{
        public TheViewHolder(View itemView) {
            super(itemView);
        }
    }
}

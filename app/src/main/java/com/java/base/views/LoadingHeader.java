package com.java.base.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.java.base.R;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import pl.droidsonroids.gif.GifImageView;

/**
 * @ProjectName: AndroidBase
 * @Package: com.java.base.views.main
 * @ClassName: LoadingHeader
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/11/9 14:59
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/9 14:59
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class LoadingHeader extends FrameLayout implements PtrUIHandler {

    private GifImageView mGifFromAssets;

    public LoadingHeader(Context context) {
        this(context, null);
    }

    public LoadingHeader(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    //实例化控件
    private void init() {
        FrameLayout container = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.item_loading_head, this, false);
        addView(container);
        mGifFromAssets=(GifImageView) container.findViewById(R.id.gif_header_loading);
        mGifFromAssets.setImageResource(R.drawable.loading_header);
    }

    //重写方法
    @Override
    public void onUIReset(PtrFrameLayout frame) {
        //重置
    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {
        //准备刷新
        mGifFromAssets.setVisibility(VISIBLE);
    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
        //开始刷新 显示刷新进度跟文本
//        tvLoading.setText("刷新中");
        mGifFromAssets.setVisibility(VISIBLE);
    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame, boolean isHeader) {
        //刷新完成  设置文本 设置进度隐藏
//        tvLoading.setText("刷新完成");
        mGifFromAssets.setVisibility(GONE);
    }




    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
        final int mOffsetToRefresh = frame.getOffsetToRefresh();
        final int currentPos = ptrIndicator.getCurrentPosY();
        final int lastPos = ptrIndicator.getLastPosY();

        if (currentPos < mOffsetToRefresh) {
            //未到达刷新线
            if (status == PtrFrameLayout.PTR_STATUS_PREPARE) {
                //tvLoading.setText("下拉刷新");
            }
        } else if (currentPos > mOffsetToRefresh) {
            //到达或超过刷新线
            if (isUnderTouch && status == PtrFrameLayout.PTR_STATUS_PREPARE) {
                //tvLoading.setText("释放刷新");
            }
        }
    }
    //
    public void setHeadColor(int color){
        mGifFromAssets.setBackgroundColor(color);
    }
}


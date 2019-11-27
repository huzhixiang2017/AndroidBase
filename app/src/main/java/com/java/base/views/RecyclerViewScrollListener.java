package com.java.base.views;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @ProjectName: AndroidBase
 * @Package: com.java.base.views
 * @ClassName: RecyclerViewScrollListener
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/11/15 11:37
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/15 11:37
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class RecyclerViewScrollListener extends RecyclerView.OnScrollListener {
    private Context xcontext;
    public ImageView view;

    public RecyclerViewScrollListener(Context context, ImageView imageView){
        this.xcontext = context;
        this.view = imageView;
    }

    @Override
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int firstVisibleItemPosition = manager.findFirstVisibleItemPosition();
        // 当不滚动时
        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
            // 判断是否滚动超过一屏
            if (firstVisibleItemPosition == 0) {
                view.setVisibility(View.INVISIBLE);
            } else {
                view.setVisibility(View.VISIBLE);
            }

        } else if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {//拖动中
            view.setVisibility(View.VISIBLE);
        }
    }

}

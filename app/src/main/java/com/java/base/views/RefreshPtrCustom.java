package com.java.base.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;

/**
 * @ProjectName: AndroidBase
 * @Package: com.java.base.views
 * @ClassName: RefreshPtrCustom
 * @Description: https://www.jianshu.com/p/28bf6d38e0ea
 * @Author: 作者名
 * @CreateDate: 2019/11/9 14:57
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/9 14:57
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class RefreshPtrCustom extends PtrClassicFrameLayout {

    private boolean disallowInterceptTouchEvent = false;

    public RefreshPtrCustom(Context context) {
        this(context,null);
    }

    public RefreshPtrCustom(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RefreshPtrCustom(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        //添加header
        LoadingHeader header = new LoadingHeader(context);
        setKeepHeaderWhenRefresh(true);
        setHeaderView(header);
        addPtrUIHandler(header);
    }

    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        disallowInterceptTouchEvent = disallowIntercept;
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_UP:
                //解除刷新的屏蔽
                this.requestDisallowInterceptTouchEvent(false);
                break;
            default:
        }

        if (disallowInterceptTouchEvent) {
            //事件向下分发给子控件，子控件会屏蔽掉父控件的刷新
            return dispatchTouchEventSupper(e);
        }

        return super.dispatchTouchEvent(e);
    }
}


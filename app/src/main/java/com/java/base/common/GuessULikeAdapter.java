package com.java.base.common;

import android.content.Context;

import androidx.annotation.LayoutRes;
import androidx.databinding.ViewDataBinding;

import com.alibaba.android.vlayout.LayoutHelper;
import com.java.base.model.bean.CategoryItemsBean;

import java.util.ArrayList;
import java.util.List;


/**
 * 猜你喜欢
 * @param <T>
 */
public class GuessULikeAdapter<T> extends BaseRecyclerViewAdapter<T, ViewDataBinding> {
    private Context context;
    private ActionULikeInterface mActionInterface;
    private List<CategoryItemsBean> list = new ArrayList<>();


    public GuessULikeAdapter(Context context,LayoutHelper helper, List<T> lists,  @LayoutRes int layoutId){
        super(context,helper,lists,layoutId);
        this.context = context;
    }


    @Override
    protected void onBind(BaseRecyclerViewHolder<ViewDataBinding> holder, T t, int position) {

    }


    /**
     * 分析和添加到购物车的接口
     */
    public interface ActionULikeInterface {
        /**
         * 增加操作
         *
         * @param bean 喜欢的对象
         */
        void doULikeShare(CategoryItemsBean bean);

        void doULikeShopCar(CategoryItemsBean bean);

        void goULikeDetail(CategoryItemsBean bean, int pos);
    }

    public void setActionInterface(ActionULikeInterface actionInterface) {
        mActionInterface = actionInterface;
    }


}

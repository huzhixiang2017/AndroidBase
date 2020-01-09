package com.java.base.adapter;

import android.content.Context;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.databinding.ViewDataBinding;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.java.base.common.BaseRecyclerViewAdapter;
import com.java.base.common.BaseRecyclerViewHolder;
import com.java.base.databinding.HomeItemRecyclerBinding;
import com.java.base.model.ClassifyDetailsModel;
import com.java.base.model.bean.ClassifyDetailsBean;
import java.util.List;

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
public class HomeAdapter<T> extends BaseRecyclerViewAdapter<T, ViewDataBinding> {
    private static final String TAG = HomeAdapter.class.getSimpleName();
    private ClassifyDetailsBean bean = new ClassifyDetailsBean();
    private ClassifyDetailsModel detailsModel = new ClassifyDetailsModel();
    private ActionInterface mActionInterface;
    private Context context;


    public HomeAdapter(Context context,LayoutHelper helper, List<T> lists,  @LayoutRes int layoutId){
        super(context,helper,lists,layoutId);
        this.context = context;
    }

    @Override
    protected void onBind(BaseRecyclerViewHolder<ViewDataBinding> holder, T t, int position) {

        bean = (ClassifyDetailsBean) t;
        detailsModel.setData(bean);
        HomeItemRecyclerBinding binding =(HomeItemRecyclerBinding) holder.dataBing;
        binding.setModel(detailsModel);
        Glide.with(context) // 依赖组件，不要依赖Context，依赖具体的活动(fragment,activiyt) ;glide 会随具体的活动生命周期做活动；防止内存泄漏
             .load(bean.getImage()) //需要加载的地址
             .into( binding.homeDatailsImg); // 需要填充的view

        holder.dataBing.executePendingBindings();//刷新界面


        binding.homeDatailsShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context instanceof HomeAdapter.ActionInterface) {
                    ActionInterface actionInterface = (ActionInterface) context;
                    actionInterface.doShare(bean);
                } else if (mActionInterface!=null) {
                    mActionInterface.doShare(bean);
                }
            }
        });

        binding.homeShoppingcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context instanceof HomeAdapter.ActionInterface) {
                    ActionInterface actionInterface = (ActionInterface) context;
                    actionInterface.doAddToShopCar(bean);
                } else if (mActionInterface!=null) {
                    mActionInterface.doAddToShopCar(bean);
                }
            }
        });

        binding.homeDateilsItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context instanceof HomeAdapter.ActionInterface) {
                    ActionInterface actionInterface = (ActionInterface) context;
                    actionInterface.goDetail(bean,position);
                } else if (mActionInterface!=null) {
                    mActionInterface.goDetail(bean,position);
                }
            }
        });
//        if(listener!=null) {//设置单击事件
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    listener.onItemClick(holder.getDataBing(),position);
//                }
//            });
//            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View view) {
//                    listener.onLongItemClick(holder.getDataBing(),position);
//                    return false;
//                }
//            });
//        }
    }

    /**
     * 分析和添加到购物车的接口
     */
    public interface ActionInterface {
        void doShare(ClassifyDetailsBean bean);              //分享
        void doAddToShopCar(ClassifyDetailsBean bean);       //加入购物车
        void goDetail(ClassifyDetailsBean bean,int position);//item点击
    }

    public void setActionInterface(ActionInterface actionInterface) {
        mActionInterface = actionInterface;
    }
}

package com.java.base.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.java.base.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: AndroidBase
 * @Package: com.java.base.common
 * @ClassName: BaseRecyclerViewAdapter
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/12/7 14:43
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/12/7 14:43
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public abstract class BaseRecyclerViewAdapter<T,D extends ViewDataBinding> extends DelegateAdapter.Adapter<BaseRecyclerViewHolder<D>> {
    private static final String TAG = BaseRecyclerViewAdapter.class.getSimpleName();
    private Context mContext;
    protected int variableId;   //布局内VariableId
    private LayoutHelper helper;//布局ID
    private List<T> lists;      //数据源
    private int viewType;
    private int resouceId;

    public BaseRecyclerViewAdapter(Context context, LayoutHelper helper,List<T> lists,int resouceId){
        this.helper = helper;
        this.mContext = context;
        this.lists = lists;
        this.resouceId = resouceId;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return helper;
    }


    @NonNull
    @Override
    public BaseRecyclerViewHolder<D> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //获取DataBing相当于获取View
        D itemBing = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),resouceId,parent,false);
        //初始化ViewHolder存放View
        BaseRecyclerViewHolder<D>  holder = new BaseRecyclerViewHolder(itemBing);
        return holder;

    }


    @Override
    public void onBindViewHolder(final BaseRecyclerViewHolder<D> holder,final int position) {
        final T data = lists.get(position);//获取数据

        if(listener!=null) {//设置单击事件
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(holder.getDataBing(),position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onLongItemClick(holder.getDataBing(),position);
                    return false;
                }
            });
        }

        onBind(holder, data, position);

    }

    protected abstract void onBind( BaseRecyclerViewHolder<D> holder, T t, int position);


    @Override
    public int getItemCount() {
        LogUtils.d(TAG, "getItemCount: "+lists.size());
        return  lists == null?0:lists.size();
    }



    public List<T> getData() {
        return lists;
    }


    /**
     * 对RecyclerView的数据更新,必须remove掉Item以及DataItem,这样才会触发item改变的动画,
     * 如果直接调用notifyDataSetChanged则不会触发动画的效果。
     *
     * 插入Item，并且更新界面
     * @param t
     * @param position
     */
    public void addItem(T t , int position){
        if(lists == null){
            lists = new ArrayList<>();
        }
        if(position == -1){
            position = lists.size();
        }
        lists.add(position,t);
        notifyItemInserted(position);
    }

    public void addItem(T t){
        addItem(t,-1);
    }

    public void addItems(List<T> ts){
        addItems(ts,-1);
    }

    public void addItems(List<T> ts,int position){
        if(lists == null){
            lists = new ArrayList<>();
        }
        if(position == -1){
            position = lists.size();
        }
        lists.addAll(position,ts);
        notifyItemInserted(position);
    }



    /**
     *  删除对象
     *  public void remove(T t) { this.lists.remove(t); }
     * @param t
     */
    public void removeItem(T t){
        if(lists == null){
            notifyDataSetChanged();
            return ;
        }
        int position = lists.indexOf(t);
        if(position != -1) {
            lists.remove(t);
            notifyItemRemoved(position);
        }
    }

    /**
     *  删除一条
     *  public void remove(int position) {  this.lists.remove(position); }
     * @param position
     */
    public void removeItem(int position){
        if(lists == null){
            notifyDataSetChanged();
            return ;
        }
        if(position>=0 && position<lists.size()) {
            lists.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void removeAll(List<T> ts) {
        this.lists.removeAll(ts);
    }


    public void clear() {
        this.lists.clear();
    }



    /**
     *    自定义item单击事件
     */
    protected OnItemClickListener listener;
    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void onItemClick(ViewDataBinding dataBinding, int position);
        void onLongItemClick(ViewDataBinding dataBinding,int position);
    }

}

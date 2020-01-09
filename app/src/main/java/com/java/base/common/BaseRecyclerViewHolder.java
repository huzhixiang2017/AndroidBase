package com.java.base.common;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @ProjectName: AndroidBase
 * @Package: com.java.base.common
 * @ClassName: BaseRecyclerViewHolder
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/12/7 11:48
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/12/7 11:48
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class BaseRecyclerViewHolder<D extends ViewDataBinding> extends RecyclerView.ViewHolder {
    public D dataBing;

    public BaseRecyclerViewHolder(D dataBing) {
        super(dataBing.getRoot());
        this.dataBing = dataBing;
    }

    public D getDataBing() {
        return dataBing;
    }

    public void setDataBing(D dataBing) {
        this.dataBing = dataBing;
    }

}

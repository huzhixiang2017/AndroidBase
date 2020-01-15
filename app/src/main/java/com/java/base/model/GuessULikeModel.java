package com.java.base.model;

import android.content.Context;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.java.base.model.bean.CategoryItemsBean;

@SuppressWarnings("AlibabaClassMustHaveAuthor")
public class GuessULikeModel extends BaseObservable {
//    private GuessULikeContract.Presenter mPresenter;
    private Context mContext;
    private CategoryItemsBean data;
    public boolean isMember;

//    public GuessULikeModel(Context context, GuessULikeContract.Presenter mPresenter) {
//        this.mPresenter = mPresenter;
//        this.mContext = context;
//    }
    public GuessULikeModel() {
    }
    public void setData(CategoryItemsBean data) {
        this.data = data;
        notifyChange();
    }


    public void setMember(boolean member) {
        isMember = member;
    }
    @Bindable
    public String getGoodsName(){
        return data.shortName;
    }
    @Bindable
    public String getGoodsSpec(){
        return data.spec;
    }
    @Bindable
    public String getSellNum(){
        return "已售:"+data.soldQuantity;
    }
    @Bindable
    public String getGoodsPrice(){
        if(isMember){
//            double coupon=data.retailPrice-data.supplyPrice;
//            return "¥"+DataFormatUtils.getTwoDecimal(data.retailPrice)+"/赚"+ DataFormatUtils.getTwoDecimal(coupon);
            return "¥"+(data.retailPrice - data.supplyPrice) ;
        }else {
            return "¥"+data.retailPrice;
        }
    }
    @Bindable
    public int getShareShow(){
        if(isMember){
            return View.VISIBLE;
        }else {
            return View.GONE;
        }
    }


}

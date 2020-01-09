package com.java.base.model;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.java.base.model.bean.ClassifyDetailsBean;

import java.text.DecimalFormat;

public class ClassifyDetailsModel extends BaseObservable {
    private Context mContext;
    private ClassifyDetailsBean data;
    private boolean isMember = true;


    public ClassifyDetailsModel(Context context) {
        this.mContext = context;
    }
    public ClassifyDetailsModel() {
    }
    public void setData(ClassifyDetailsBean data) {
        this.data = data;
    }


    @Bindable
    public String getName(){
        return data.name;
    }

    public String getDescription() {
        return data.description;
    }

    @Bindable
    public String getShortName(){
            return data.shortName;
    }

    @Bindable
    public String getSpec(){
        return data.spec;
    }

    @Bindable
    public String getRetailPrice(){
        String price = "";
        try {
            //if(SPUtils.isMember(mContext)){
            if(isMember){
                if(TextUtils.isEmpty(data.retailPrice) && TextUtils.isEmpty(data.supplyPrice)){
                    price =  "/赚0.00";
                }else {
                    price =   "/赚" + roundByScale(Double.valueOf(data.retailPrice) - Double.valueOf(data.supplyPrice),2);
                }
            }else if(!isMember){
                price = "";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return price;
    }

    @Bindable
    public String getMsrp(){
        String msrp = "";
        if(TextUtils.isEmpty(data.msrp)){
            msrp = "0.00";
        }else {
            if(isMember){
                msrp =  roundByScale(Double.valueOf(data.msrp),2) ;
            }else {
                msrp =  roundByScale(Double.valueOf(data.msrp),2);
            }
        }
        return msrp;
    }

    @Bindable
    public String getSoldQuantity(){
        return "已售：" + data.soldQuantity;
    }

    @Bindable
    public String getImageNames(){
        return data.imageNames;
    }

    @Bindable
    public int getShareShow(){//是否显示 猜你喜欢 的分享标签
        //if(SPUtils.getBoolean("1")){
        if(isMember){
            return View.VISIBLE;
        }else {
            return View.GONE;
        }

//        return 0;
    }

    /**
     * 将double格式化为指定小数位的String，不足小数位用0补全
     *
     * @param v     需要格式化的数字
     * @param scale 小数点后保留几位
     * @return
     */
    public static String roundByScale(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The   scale   must   be   a   positive   integer   or   zero");
        }
        if(scale == 0){
            return new DecimalFormat("0").format(v);
        }
        String formatStr = "0.";
        for(int i=0;i<scale;i++){
            formatStr = formatStr + "0";
        }
        return new DecimalFormat(formatStr).format(v);
    }

}

package com.java.base.model.bean;

import android.os.Parcel;

import com.java.base.common.BaseModel;

/**
 * Created by chemin on 2018/6/19 10:24.
 * description：
 */
public class ProductCategory extends BaseModel {

    public int code;
    public String name;
    public String imageNames;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.code);
        dest.writeString(this.name);
        dest.writeString(this.imageNames);
    }

    public ProductCategory() {
    }

    protected ProductCategory(Parcel in) {
        super(in);
        this.code = in.readInt();
        this.name = in.readString();
        this.imageNames = in.readString();
    }

    public static final Creator<ProductCategory> CREATOR = new Creator<ProductCategory>() {
        @Override
        public ProductCategory createFromParcel(Parcel source) {
            return new ProductCategory(source);
        }

        @Override
        public ProductCategory[] newArray(int size) {
            return new ProductCategory[size];
        }
    };
}

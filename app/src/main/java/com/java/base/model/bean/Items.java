package com.java.base.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.java.base.common.BaseModel;

/**
 * Created by chemin on 2018/6/19 10:20.
 * description：
 */
public class Items extends BaseModel {


    public String sku;
    public String active;
    public String flavour;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.sku);
        dest.writeString(this.active);
        dest.writeString(this.flavour);
    }

    public Items() {
    }

    protected Items(Parcel in) {
        super(in);
        this.sku = in.readString();
        this.active = in.readString();
        this.flavour = in.readString();
    }

    public static final Parcelable.Creator<Items> CREATOR = new Parcelable.Creator<Items>() {
        @Override
        public Items createFromParcel(Parcel source) {
            return new Items(source);
        }

        @Override
        public Items[] newArray(int size) {
            return new Items[size];
        }
    };
}

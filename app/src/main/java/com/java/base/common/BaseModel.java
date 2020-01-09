package com.java.base.common;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * <b>Project:</b> project_hotclub<br>
 * <b>Create Date:</b> 16/4/25<br>
 * <b>Author:</b> Gordon<br>
 * <b>Description:</b> <br>
 */
@SuppressLint("ParcelCreator")
public class BaseModel implements Parcelable {

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {}

    public BaseModel() {}

    protected BaseModel(Parcel in) {}
}

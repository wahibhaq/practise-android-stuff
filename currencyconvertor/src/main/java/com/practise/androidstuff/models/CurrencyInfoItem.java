package com.practise.androidstuff.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class CurrencyInfoItem implements Parcelable {

    @SerializedName("id")
    private String id;

    @SerializedName("description")
    private String description;

    protected CurrencyInfoItem(Parcel in) {
        id = in.readString();
        description = in.readString();
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(description);
    }

    @SuppressWarnings("unused")
    public static final Creator<CurrencyInfoItem> CREATOR = new Creator<CurrencyInfoItem>() {
        @Override
        public CurrencyInfoItem createFromParcel(Parcel in) {
            return new CurrencyInfoItem(in);
        }

        @Override
        public CurrencyInfoItem[] newArray(int size) {
            return new CurrencyInfoItem[size];
        }
    };
}

package com.practise.androidstuff.models;

import com.google.gson.annotations.SerializedName;

//TODO add autovalue support
public class ConvertedItem {

    @SerializedName("from")
    private String sourceCurrency;

    @SerializedName("to")
    private String targetCurrency;

    @SerializedName("from_amount")
    private int sourceAmount;

    @SerializedName("to_amount")
    private int targetAmount;
}

package com.practise.androidstuff.models;

import com.google.gson.annotations.SerializedName;

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

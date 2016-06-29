package com.practise.androidstuff.models;

import com.google.gson.annotations.SerializedName;

public class ConvertedItem {

    @SerializedName("from")
    private String sourceCurrency;

    @SerializedName("to")
    private String targetCurrency;

    @SerializedName("from_amount")
    private double sourceAmount;

    @SerializedName("to_amount")
    private double targetAmount;

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public double getSourceAmount() {
        return sourceAmount;
    }

    public double getTargetAmount() {
        return targetAmount;
    }
}

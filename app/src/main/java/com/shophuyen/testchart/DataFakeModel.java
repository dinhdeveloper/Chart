package com.shophuyen.testchart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataFakeModel implements Serializable {
    @SerializedName("valueStock")
    @Expose
    private String  valueStock;
    @SerializedName("heightIncome")
    @Expose
    private String heightIncome;
    @SerializedName("valueIncome")
    @Expose
    private String valueIncome;
    @SerializedName("heightStock")
    @Expose
    private String heightStock;
    @SerializedName("title")
    @Expose
    private String title;

    public String getValueStock() {
        return valueStock;
    }

    public void setValueStock(String valueStock) {
        this.valueStock = valueStock;
    }

    public String getHeightIncome() {
        return heightIncome;
    }

    public void setHeightIncome(String heightIncome) {
        this.heightIncome = heightIncome;
    }

    public String getValueIncome() {
        return valueIncome;
    }

    public void setValueIncome(String valueIncome) {
        this.valueIncome = valueIncome;
    }

    public String getHeightStock() {
        return heightStock;
    }

    public void setHeightStock(String heightStock) {
        this.heightStock = heightStock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

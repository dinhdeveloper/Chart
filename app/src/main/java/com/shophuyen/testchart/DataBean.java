package com.shophuyen.testchart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBean {
    private StockBean[] stock;
    private IncomeBean[] income;

    public StockBean[] getStock() {
        return stock;
    }

    public void setStock(StockBean[] stock) {
        this.stock = stock;
    }

    public IncomeBean[] getIncome() {
        return income;
    }

    public void setIncome(IncomeBean[] income) {
        this.income = income;
    }

    public List<StockBean> getListStockBean() {
        if (stock == null) {
            return null;
        }
        else {
            List<StockBean> list = new ArrayList<>();
            list.addAll(Arrays.asList(stock));
            return list;
        }
    }

    public List<IncomeBean> getListIncomeBean() {
        if (income == null) {
            return null;
        }
        else {
            List<IncomeBean> list = new ArrayList<>();
            list.addAll(Arrays.asList(income));
            return list;
        }
    }
}

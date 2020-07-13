package com.shophuyen.testchart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataModel implements Serializable {

    private boolean success;
    private DataBean[] data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataBean[] getData() {
        return data;
    }

    public void setData(DataBean[] data) {
        this.data = data;
    }

    public List<DataBean> getListDataBean() {
        if (data == null) {
            return null;
        }
        else {
            List<DataBean> list = new ArrayList<>();
            list.addAll(Arrays.asList(data));
            return list;
        }
    }

}

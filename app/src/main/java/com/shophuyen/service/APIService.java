package com.shophuyen.service;


import com.shophuyen.testchart.CategoryModel;
import com.shophuyen.testchart.DataFakeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("product/list")
    Call<List<CategoryModel>> getAllCategory();


    @GET("json/get/bVEBfFCIoi?indent=2")
    Call<List<DataFakeModel>> getAll();

}

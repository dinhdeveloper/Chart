package com.shophuyen.testchart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.shophuyen.adapter.ChartAdapter;
import com.shophuyen.adapter.ChartFakeAdapter;
import com.shophuyen.service.APIService;
import com.shophuyen.service.APIUntil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    APIService apiService;
    List<CategoryModel> listAAA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService = APIUntil.getServer();
        final RecyclerView recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
//        apiService.getAllCategory().enqueue(new Callback<List<CategoryModel>>() {
//            @Override
//            public void onResponse(Call<List<CategoryModel>> call, Response<List<CategoryModel>> response) {
//                if (response.isSuccessful()) {
//                    List<CategoryModel> modelList = (List<CategoryModel>) response.body();
//                    try {
//                        ChartAdapter character = new ChartAdapter(modelList, getApplicationContext());
//                        recyclerview.setAdapter(character);
//                        character.notifyDataSetChanged();
//
//                    } catch (NumberFormatException e) {
//                        Log.e("error", e.getMessage());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<CategoryModel>> call, Throwable t) {
//                Log.e("onFailure", t.getMessage());
//            }
//        });

        apiService.getAll().enqueue(new Callback<List<DataFakeModel>>() {
            @Override
            public void onResponse(Call<List<DataFakeModel>> call, Response<List<DataFakeModel>> response) {
                if (response.isSuccessful()) {
                    List<DataFakeModel> list = response.body();
                    //min max stock
                    int minStock = Integer.parseInt(list.get(0).getValueStock());
                    int maxStock = Integer.parseInt(list.get(0).getValueStock());
                    for (int i = 0; i < list.size(); i++) {
                        int number = Integer.parseInt(list.get(i).getValueStock());
                        if (number < minStock) {
                            minStock = number;
                        }
                        if (number > maxStock) {
                            maxStock = number;
                        }
                    }
                    //min max income
                    int minIncome = Integer.parseInt(list.get(0).getValueIncome());
                    int maxIncome = Integer.parseInt(list.get(0).getValueIncome());
                    for (int i = 0; i < list.size(); i++) {
                        int number = Integer.parseInt(list.get(i).getValueIncome());
                        if (number < minIncome) {
                            minIncome = number;
                        }
                        if (number > maxIncome) {
                            maxIncome = number;
                        }
                    }
                    //tim max all
                    int maxAll = 0;
                    if (maxIncome > maxStock) {
                        maxAll = maxIncome;
                    } else {
                        maxAll = maxStock;
                    }

                    int maxHeight = 400;

                    for (int i = 0; i < list.size(); i++) {
                        long heightIncome = (Long.parseLong(list.get(i).getValueIncome()) * maxHeight) / maxAll;
                        long heightStock = (Long.parseLong(list.get(i).getValueStock()) * maxHeight) / maxAll;
                        list.get(i).setHeightIncome(String.valueOf(heightIncome));
                        list.get(i).setHeightStock(String.valueOf(heightStock));
                    }

                    ChartFakeAdapter character = new ChartFakeAdapter(response.body(), getApplicationContext());
                    recyclerview.setAdapter(character);
                    character.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<DataFakeModel>> call, Throwable t) {
                Log.e("onFailure", t.getMessage());
            }
        });

    }
}
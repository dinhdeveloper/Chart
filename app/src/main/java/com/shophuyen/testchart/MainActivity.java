package com.shophuyen.testchart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.shophuyen.adapter.ChartAdapter;
import com.shophuyen.service.APIService;
import com.shophuyen.service.APIUntil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    APIService apiService;
    List<CategoryModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService = APIUntil.getServer();
        final RecyclerView recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        apiService.getAllCategory().enqueue(new Callback<List<CategoryModel>>() {
            @Override
            public void onResponse(Call<List<CategoryModel>> call, Response<List<CategoryModel>> response) {
                if (response.isSuccessful()) {
                    List<CategoryModel> modelList = (List<CategoryModel>) response.body();
                    try {

                        ChartAdapter character = new ChartAdapter(modelList, getApplicationContext());
                        recyclerview.setAdapter(character);
                        character.notifyDataSetChanged();
//                        ArrayList<Integer> aaa = new ArrayList<>();
//                        for (int i = 0; i < modelList.size(); i++) {
//                            int bb = (Integer.parseInt(modelList.get(i).getPriceSale()) * 100);
//                            aaa.add(bb);
//                        }
//                        for (int i = 0; i < aaa.size(); i++) {
//                            int ccc = aaa.get(i);
//                            Log.e("AAAA", (ccc) + "");
//                        }
                    } catch (NumberFormatException e) {
                        Log.e("error", e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<CategoryModel>> call, Throwable t) {
                Log.e("onFailure", t.getMessage());
            }
        });
    }
}
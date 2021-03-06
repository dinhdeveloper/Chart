package com.shophuyen.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shophuyen.testchart.CategoryModel;
import com.shophuyen.testchart.R;

import java.util.ArrayList;
import java.util.List;

public class ChartAdapter extends RecyclerView.Adapter<ChartAdapter.ViewHolder> {

    List<CategoryModel> modelList;
    Context context;

    public ChartAdapter(List<CategoryModel> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryModel categoryModel = modelList.get(position);

        LinearLayout.LayoutParams paramsOne = (LinearLayout.LayoutParams) holder.layout_one.getLayoutParams();
        LinearLayout.LayoutParams paramsTwo = (LinearLayout.LayoutParams) holder.layout_two.getLayoutParams();
        // Changes the height and width to the specified *pixels*
        int minOne = Integer.parseInt(modelList.get(0).getProductPrice());
        int maxOne = Integer.parseInt(modelList.get(0).getProductPrice());

        for (int i = 0; i < modelList.size(); i++) {
            int number = Integer.parseInt(modelList.get(i).getProductPrice());
            if (number < minOne) {
                minOne = number;
            }
            if (number > maxOne) {
                maxOne = number;
            }
        }
        //two
        int minTwo = Integer.parseInt(modelList.get(0).getPriceSale());
        int maxTwo = Integer.parseInt(modelList.get(0).getPriceSale());
        for (int i = 0; i < modelList.size(); i++) {
            int number = Integer.parseInt(modelList.get(i).getPriceSale());
            if (number < minTwo) {
                minTwo = number;
            }
            if (number > maxTwo) {
                maxTwo = number;
            }
        }

        int maxAll = 0;
        if (maxOne>maxTwo){
            maxAll = maxOne;
        }
        else {
            maxAll = maxTwo;
        }


//        long phantramOne = ((Long.parseLong(categoryModel.getProductPrice())*1000)/maxOne)/2;
//        paramsOne.height = Integer.parseInt(String.valueOf(phantramOne));
//        //holder.id_one.setText(phantramOne + "");
//        holder.layout_one.setLayoutParams(paramsOne);
//
//        long phantramTwo = ((Long.parseLong(categoryModel.getPriceSale())*1000)/maxTwo)/2;
//        paramsTwo.height = Integer.parseInt(String.valueOf(phantramTwo));
//        //holder.id_two.setText(phantramTwo + "");
//        holder.layout_two.setLayoutParams(paramsTwo);

        holder.thang.setText("Tháng " + (position + 1));
    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout layout_two;
        LinearLayout layout_one;
        TextView thang;
        TextView id_two;
        TextView id_one;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout_one = itemView.findViewById(R.id.layout_one);
            layout_two = itemView.findViewById(R.id.layout_two);
            thang = itemView.findViewById(R.id.thang);
            id_two = itemView.findViewById(R.id.id_two);
            id_one = itemView.findViewById(R.id.id_one);
        }
    }
}

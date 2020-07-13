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
import com.shophuyen.testchart.DataFakeModel;
import com.shophuyen.testchart.DataModel;
import com.shophuyen.testchart.R;

import java.util.List;

public class ChartFakeAdapter extends RecyclerView.Adapter<ChartFakeAdapter.ViewHolder> {

    List<DataFakeModel> list;
    Context context;

    public ChartFakeAdapter(List<DataFakeModel> list, Context context) {
        this.list = list;
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
        DataFakeModel fakeModel = list.get(position);
//        LinearLayout.LayoutParams paramsOne = (LinearLayout.LayoutParams) holder.layout_one.getLayoutParams();
//        LinearLayout.LayoutParams paramsTwo = (LinearLayout.LayoutParams) holder.layout_two.getLayoutParams();
//
//        paramsOne.height = Integer.parseInt(fakeModel.getHeightStock());
//        paramsTwo.height = Integer.parseInt(fakeModel.getHeightIncome());
//
////        holder.layout_one.setLayoutParams(paramsOne);
//        holder.layout_two.setLayoutParams(paramsTwo);
        holder.thang.setText(fakeModel.getTitle());

        LinearLayout.LayoutParams paramStock = new LinearLayout.LayoutParams(
                40,
                Integer.parseInt(list.get(position).getHeightStock())
        );
        holder.layout_one.setLayoutParams(paramStock);

        LinearLayout.LayoutParams paramIncome = new LinearLayout.LayoutParams(
                40,
                Integer.parseInt(list.get(position).getHeightIncome())
        );
        holder.layout_two.setLayoutParams(paramIncome);
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

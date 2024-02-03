package com.example.lolhanding.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lolhanding.R;
import com.example.lolhanding.entity.LegendInfo;
import com.example.lolhanding.entity.SkinInfo;

import java.util.ArrayList;
import java.util.List;

public class MyLegendAdapter extends RecyclerView.Adapter<MyLegendAdapter.MyHolder> {

    private List<LegendInfo> mLegendInfo = new ArrayList<>();
    public void setLegendInfoList(List<LegendInfo> list) {
        this.mLegendInfo = list;
        //刷新适配器,不可以少
        notifyDataSetChanged();
    }
    static class MyHolder extends RecyclerView.ViewHolder{

        ImageView img;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //创建布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.legend_list_item,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        //绑定数据
        final LegendInfo legendInfo = mLegendInfo.get(position);
        holder.img.setImageResource(legendInfo.getImg());

    }

    @Override
    public int getItemCount() {
        return mLegendInfo.size();
    }


}

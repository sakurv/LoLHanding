package com.example.lolhanding.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lolhanding.R;
import com.example.lolhanding.entity.CarInfo;
import com.example.lolhanding.entity.SkinInfo;

import java.util.ArrayList;
import java.util.List;

public class MySkinAdapter extends RecyclerView.Adapter<MySkinAdapter.MyHolder> {

    private List<SkinInfo> mSkinInfoList = new ArrayList<>();

    public void setSkinInfoList(List<SkinInfo> list) {
        this.mSkinInfoList = list;
        //刷新适配器,不可以少
        notifyDataSetChanged();
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        ImageView img ;
        TextView name;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);

        }
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //加载布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skin_list_item,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        //绑定数据
        final SkinInfo skinInfo = mSkinInfoList.get(position);
        holder.img.setImageResource(skinInfo.getSkin_img());
        holder.name.setText(skinInfo.getName());


    }

    @Override
    public int getItemCount() {
        return mSkinInfoList.size();
    }




}

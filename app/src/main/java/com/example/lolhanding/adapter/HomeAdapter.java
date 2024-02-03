package com.example.lolhanding.adapter;



import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lolhanding.R;
import com.example.lolhanding.entity.HomeInfo;
import com.example.lolhanding.entity.ProductInfo;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyHoleder> {


    private List<HomeInfo> mHomeInfo = new ArrayList<>();

    public void setListData(List<HomeInfo> list){
        this.mHomeInfo = list;
        //要刷新
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MyHoleder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_list_item, null);
        return new MyHoleder(view);
    }


    //绑定数据
    @Override
    public void onBindViewHolder(@NonNull final MyHoleder holder, final int position) {

        final HomeInfo homeInfo = mHomeInfo.get(position);
        holder.image.setImageResource(homeInfo.getHome_img());
        holder.title.setText(homeInfo.getHome_title());
        holder.des.setText(homeInfo.getHome_des());
        holder.url.setText(homeInfo.getHome_url());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null!=mOnItemClickListener){
                    mOnItemClickListener.onItemClick(homeInfo,position);
                }
            }
        });
    }

    private HomeOnclickItemListener mHomeOnclickItemListener;
    public void setmHomeOnclickItemListener(HomeOnclickItemListener mHomeOnclickItemListener){
        this.mHomeOnclickItemListener = mHomeOnclickItemListener;
    }
    public interface HomeOnclickItemListener{
        void onItemClick(int position);
    }
    //接口回调
    private onItemClickListener mOnItemClickListener;
    public void setmOnItemClickListener(onItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;

    }

    public interface onItemClickListener{
        void onItemClick(HomeInfo homeInfo,int position);
    }


    @Override
    public int getItemCount() {
        return mHomeInfo.size();
    }

    static class MyHoleder extends  RecyclerView.ViewHolder{

        ImageView image;
        TextView title;
        TextView des;
        TextView url;
        public MyHoleder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_simple);
            title = itemView.findViewById(R.id.txt_title);
            des = itemView.findViewById(R.id.txt_des);
            url = itemView.findViewById(R.id.txt_url);
        }
    }
}

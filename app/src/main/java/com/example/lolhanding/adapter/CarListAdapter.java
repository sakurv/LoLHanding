package com.example.lolhanding.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lolhanding.R;

import java.util.ArrayList;
import java.util.List;

import com.example.lolhanding.entity.CarInfo;


public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.MyHolder> {

    private List<CarInfo> mCarInfoList = new ArrayList<>();

    public  void setCarInfoList(List<CarInfo> list){
        this.mCarInfoList = list;
        //刷新适配器,不可以少
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //加载布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_list_item, null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {

        //绑定数据
        final CarInfo carInfo = mCarInfoList.get(position);
        holder.picture.setImageResource(carInfo.getProduct_img());
        holder.title.setText(carInfo.getProduct_title());
        holder.price.setText(carInfo.getProduct_pri()+"");//若价格是整数类型，则改为(carInfo.getProduct_pri()+"")即可

        //长按删除
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mOnItemClickListener!= null){
                    mOnItemClickListener.delOnClick(carInfo,position);
                }

                return true;
            }
        });

    }



    @Override
    public int getItemCount() {
        return mCarInfoList.size();
    }

    static class  MyHolder extends RecyclerView.ViewHolder{
        ImageView picture ;
        TextView title;
        TextView price;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            picture = itemView.findViewById(R.id.picture);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }
    }


    private onItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(onItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }
    public interface onItemClickListener{
        void delOnClick(CarInfo carInfo,int position);
    }
}

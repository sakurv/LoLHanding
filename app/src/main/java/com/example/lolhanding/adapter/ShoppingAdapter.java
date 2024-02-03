package com.example.lolhanding.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lolhanding.R;
import com.example.lolhanding.entity.ProductInfo;

import java.util.ArrayList;
import java.util.List;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.MyHolder> {

    private List<String> dataList = new ArrayList<>();
    private List<Integer> imgList = new ArrayList<>();
    private List<String> priceList = new ArrayList<>();
    private List<ProductInfo> mProductInfos = new ArrayList<>();

    public void setListData(List<ProductInfo> list){
        this.mProductInfos = list;
        //要刷新
        notifyDataSetChanged();


    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //加载布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_list_item, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {

        //绑定数据
        final ProductInfo productInfo = mProductInfos.get(position);
        holder.picture.setImageResource(productInfo.getProduct_img());
        holder.title.setText(productInfo.getProduct_title());
        //只能设置文本类型,所以需要加个空串
        holder.price.setText(productInfo.getProdut_price()+"");
        /**
         * //绑定数据
         *         String title= dataList.get(position);
         *         holder.title.setText(title);
         *         Integer img = imgList.get(position);
         *         holder.picture.setImageResource(img);
         *         String price = priceList.get(position);
         *         holder.price.setText(price);
         *
         *         //点击事件
         *         holder.itemView.setOnClickListener(new View.OnClickListener() {
         *             @Override
         *             public void onClick(View v) {
         *                 if(null!=mShoppingOnclickItemListener){
         *                     mShoppingOnclickItemListener.onItemClick(position);
         *                 }
         *             }
         *         });
         */

        //点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null!=mOnItemClickListener){
                    mOnItemClickListener.onItemClick(productInfo,position);
                }
            }
        });

    }

    //获得大小
    @Override
    public int getItemCount() {
        return mProductInfos.size();
    }

    static class MyHolder extends  RecyclerView.ViewHolder{

        ImageView picture;
        TextView title;
        TextView price;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.picture);
            price = itemView.findViewById(R.id.txt_t);
            title = itemView.findViewById(R.id.txt_f);
        }
    }

    //点击事件

    private ShoppingOnclickItemListener mShoppingOnclickItemListener;

    public void setmShoppingOnclickItemListener(ShoppingOnclickItemListener mShoppingOnclickItemListener) {
        this.mShoppingOnclickItemListener = mShoppingOnclickItemListener;
    }

    public interface ShoppingOnclickItemListener{
        void onItemClick(int position);

    }

    //接口回调
    private  onItemClickListener mOnItemClickListener;

    public void setmOnItemClickListener(onItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface onItemClickListener{
        void onItemClick(ProductInfo productInfo,int position);
    }
}

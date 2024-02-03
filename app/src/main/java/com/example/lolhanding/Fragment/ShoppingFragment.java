package com.example.lolhanding.Fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lolhanding.R;
import com.example.lolhanding.Shopping_Details;
import com.example.lolhanding.adapter.ShoppingAdapter;
import com.example.lolhanding.entity.ProductInfo;
import com.example.lolhanding.entity.ShoppingDataServe;

import java.util.ArrayList;
import java.util.List;

public class ShoppingFragment extends Fragment {

    private View rootView;
    private RecyclerView gridView;
    private ShoppingAdapter mShoppingAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_shopping, container, false);

        //初始化控件
        gridView = rootView.findViewById(R.id.grid1);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //创建adapter
        mShoppingAdapter = new ShoppingAdapter();
        gridView.setAdapter(mShoppingAdapter);


        //传入数据
        mShoppingAdapter.setListData(ShoppingDataServe.getListData(getActivity()));

        //recycleView点击事件
        mShoppingAdapter.setmOnItemClickListener(new ShoppingAdapter.onItemClickListener() {
            @Override
            public void onItemClick(ProductInfo productInfo, int position) {
                //跳转传值
                Intent intent = new Intent(getActivity(), Shopping_Details.class);
                //intent传递对象时，实体类一定要实现implements Serializable;
                intent.putExtra("productInfo", productInfo);
                startActivity(intent);

            }
        });
    }
}
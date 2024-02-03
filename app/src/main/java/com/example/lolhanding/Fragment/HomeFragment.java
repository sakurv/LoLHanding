package com.example.lolhanding.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lolhanding.MainActivity;
import com.example.lolhanding.MainActivity2;
import com.example.lolhanding.R;
import com.example.lolhanding.adapter.HomeAdapter;
import com.example.lolhanding.entity.HomeDataServe;
import com.example.lolhanding.entity.HomeInfo;
import com.example.lolhanding.entity.ShoppingDataServe;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.jetbrains.annotations.Nullable;


public class HomeFragment extends Fragment {

    private View rootView;
    private RecyclerView gridView;
    private HomeAdapter mHomeAdapter;
    private Button button;


    //实体数据（adapter）

    //轮播图
    CarouselView carouselView;
    int[] images = {
            R.mipmap.kasha,
            R.mipmap.xinzhigang,
            R.mipmap.bingyuan,
            R.mipmap.tongxingzheng,
            R.mipmap.yunding
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home2, container, false);

        //初始化控件
        gridView = rootView.findViewById(R.id.recycleView);

        carouselView = rootView.findViewById(R.id.carouselView);
        button = rootView.findViewById(R.id.button2);


        return rootView;



    }




    @Override
    public void onActivityCreated(@Nullable Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);

        mHomeAdapter = new HomeAdapter();
        gridView.setAdapter(mHomeAdapter);
        mHomeAdapter.setListData(HomeDataServe.getListData());

        //侧边导航栏点击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

       //轮播图
        final String[] tags = {
                "https://lol.qq.com/act/a20231212headlinerkaisa/index.html?e_code=500130",
                "https://lol.qq.com/act/a20231114heartsteelpass/index.html?e_code=500131",
                "https://lol.qq.com/act/a20231212skincollection/index.html?e_code=500132",
                "https://lol.qq.com/act/a20231208winterblessedpass/?e_code=500133",
                "https://lol.qq.com/act/a20231121remix/index.html?e_code=500134"};
        carouselView = rootView.findViewById(R.id.carouselView);
        //设置轮播图数量
        carouselView.setPageCount(images.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(final int position, ImageView imageView) {
                imageView.setImageResource(images[position]);
                final String tag = tags[position];
                // 设置标签
                imageView.setTag(tag);
                // 为每张图片设置点击事件
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 在这里执行点击事件的操作
                        //轮播图跳转页面
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tag));
                        // 启动 Intent
                        startActivity(intent);
                    }
                });
            }
        });
        //轮播图


        mHomeAdapter.setmOnItemClickListener(new HomeAdapter.onItemClickListener() {
            @Override
            public void onItemClick(HomeInfo homeInfo, int position) {
                String url = homeInfo.getHome_url();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });


    }


}
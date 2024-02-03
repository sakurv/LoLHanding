package com.example.lolhanding;

import static android.app.PendingIntent.getActivity;

import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;


import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.example.lolhanding.Fragment.CarFragment;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class First extends AppCompatActivity {

    private CarFragment mCarFragment;

    //实体数据（adapter）
    private int[] imgs = {R.mipmap.image_1,R.mipmap.image_2,R.mipmap.image_3,R.mipmap.image_4,};
    private String[] tits = {"标题1","标题2","标题3","标题4"};
    private String[] strs={"文本信息1","文本信息2","文本信息3","文本信息4",};
    private String[] urls={"https://www.baidu.com","https://ilive.lenovo.com.cn/","https://lol.qq.com/main.shtml","https://www.mihoyo.com/",};

    //轮播图
    CarouselView carouselView;
    int[] images = {
            R.mipmap.image_1,
            R.mipmap.image_2,
            R.mipmap.image_3,
            R.mipmap.image_4,
            R.mipmap.image_5
    };

    //底部导航栏
    private BottomNavigationView btmNavView;
    private TextView btmNavTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //新闻点击事件
        ListView list2 = findViewById(R.id.list2);
        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 在这里处理点击事件
                // 例如，你可以获取被点击的项目的数据
                HashMap<String, String> item = (HashMap<String, String>) parent.getItemAtPosition(position);
                String url = item.get("urls");
                String description = item.get("strs");
                // 创建一个 Intent 对象
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                // 启动 Intent
                startActivity(intent);

                // 执行你想要的操作，比如显示一个Toast消息
                Toast.makeText(getApplicationContext(), "你点击了：" + url, Toast.LENGTH_SHORT).show();
            }
        });


        final String[] tags = {
                "https://www.baidu.com",
                "https://ilive.lenovo.com.cn/",
                "https://lol.qq.com/main.shtml",
                "https://www.mihoyo.com/",
                "https://www.mihoyo.com/"};
        carouselView =  findViewById(R.id.carouselView);
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
                        Toast.makeText(First.this, "点击了第 " + position + " 张图片"+ tag, Toast.LENGTH_SHORT).show();
                        //轮播图跳转页面
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tag));
                        // 启动 Intent
                        startActivity(intent);
                    }
                });
            }
        });


        //适配器对象，键名和id必须一一对应
        SimpleAdapter adapter =new SimpleAdapter(this,getlist(),R.layout.activity_first_adapter,
                new String[]{"img","title","strs","urls"},
                new int[]{R.id.img_simple,R.id.txt_simple,R.id.txt_simple2,R.id.text_gone});
        //操作节点
       // ListView list2 = findViewById(R.id.list2);
        list2.setAdapter(adapter);


        //底部导航栏
        btmNavView = findViewById(R.id.bottom_navigation_menu);
        //btmNavTextView = findViewById(R.id.text_message);

        btmNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){//查找所点击item的id，根据id进行下面的不同操作
                    case R.id.navigation_home:
                        //btmNavTextView.setText(R.string.title_home);
                        Intent intent = new Intent(First.this,MainActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.navigation_dashboard:

                        return true;
                    case R.id.navigation_notifications:
                        //btmNavTextView.setText(R.string.title_notifications);
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                        if(mCarFragment == null){
                            mCarFragment = new CarFragment();
                            fragmentTransaction.add(R.id.content, mCarFragment);
                        }else {
                            fragmentTransaction.show(mCarFragment);
                        }

                        fragmentTransaction.commit();

                        return true;
                }
                return false;
            }
        });
    }
    //轮播图
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(images[position]);
        }
    };

    private List<? extends Map<String,?>> getlist() {
        ArrayList<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < imgs.length; i++) {
            Map<String, Object> itme = new HashMap<>();
            itme.put("img",imgs[i]);
            itme.put("title",tits[i]);
            itme.put("strs",strs[i]);
            itme.put("urls",urls[i]);
            list.add(itme);
        }
        return list;
    }
}


package com.example.lolhanding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lolhanding.entity.ProductInfo;

import db.CarDbHelper;

public class Shopping_Details extends AppCompatActivity {

    private ImageView picture;
    private TextView price;
    private TextView title;

    private ProductInfo productInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_details);


        //获取传递的数据
        productInfo = (ProductInfo) getIntent().getSerializableExtra("productInfo");

        //初始化控件
        picture = findViewById(R.id.picture);
        price = findViewById(R.id.price);
        title = findViewById(R.id.title);

        //设置数据
        if(null!=productInfo){
            picture.setImageResource(productInfo.getProduct_img());
            price.setText(productInfo.getProdut_price()+"");
            title.setText(productInfo.getProduct_title());
        }



        //返回
        findViewById(R.id.toolbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //加入购物车
                int row = CarDbHelper.getInstance(Shopping_Details.this).addCar("123456",productInfo.getProduct_title(),productInfo.getProduct_img(),productInfo.getProdut_price()+"");
                if(row>0 ){
                    Toast.makeText(Shopping_Details.this,"添加成功",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Shopping_Details.this,"添加失败",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}


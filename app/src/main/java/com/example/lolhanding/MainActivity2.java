package com.example.lolhanding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.lolhanding.Fragment.CarFragment;
import com.example.lolhanding.Fragment.MineFragment;
import com.example.lolhanding.Fragment.ShoppingFragment;
import com.example.lolhanding.Fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import db.CarDbHelper;

public class MainActivity2 extends AppCompatActivity {

    private HomeFragment mHomeFragment;
    private CarFragment mCarFragment;
    private MineFragment mMineFragment;
    private ShoppingFragment mShoppingFragment;
    private CarDbHelper carDbHelper;

    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        carDbHelper = new CarDbHelper(this,"car.db",null,1);
        carDbHelper.getWritableDatabase();

        //初始化控件
        mBottomNavigationView = findViewById(R.id.bottomNavigationView);
        //设置mBottomNavigationView点击事件
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.home){
                    selectedFragment(0);

                } else if (item.getItemId()==R.id.shopping) {
                    selectedFragment(1);

                } else if (item.getItemId()==R.id.car) {
                    selectedFragment(2);

                } else{
                    selectedFragment(3);
                }

                return true;
            }
        });
        //默认选中第一个
        selectedFragment(0);



    }
    //两次退出程序
    private boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "再按一次返回键退出程序", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private  void selectedFragment(int position){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideFragment(fragmentTransaction);

        if(position == 0){
            if(mHomeFragment == null){
                mHomeFragment = new HomeFragment();
                fragmentTransaction.add(R.id.content,mHomeFragment);
            }else{
                fragmentTransaction.show(mHomeFragment);
            }
        } else if (position == 1) {
            if(mShoppingFragment ==null){
                mShoppingFragment =new ShoppingFragment();
                fragmentTransaction.add(R.id.content,mShoppingFragment);
            }else{
                fragmentTransaction.show(mShoppingFragment);
            }
        }else if (position == 2) {
            if(mCarFragment ==null){
                mCarFragment =new CarFragment();
                fragmentTransaction.add(R.id.content,mCarFragment);
            }else{
                fragmentTransaction.show(mCarFragment);
                mCarFragment.loadData();
            }
        }else{
            if(mMineFragment ==null){
                mMineFragment =new MineFragment();
                fragmentTransaction.add(R.id.content,mMineFragment);
            }else{
                fragmentTransaction.show(mMineFragment);
            }
        }

        //必须提交
        fragmentTransaction.commit();


    }

    private void hideFragment(FragmentTransaction fragmentTransaction){

        if(mHomeFragment!=null){
            fragmentTransaction.hide(mHomeFragment);
        }

        if(mCarFragment!=null){
            fragmentTransaction.hide(mCarFragment);
        }

        if(mShoppingFragment!=null){
            fragmentTransaction.hide(mShoppingFragment);
        }

        if(mMineFragment!=null){
            fragmentTransaction.hide(mMineFragment);
        }
    }


}
package com.example.lolhanding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.HashMap;

public class Log extends AppCompatActivity {

    private TextView tv_data;
    private Button btn_get_data; //声明组件
    private Button btn_get_all; //声明组件

    private final Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case 0x11:
                    String s = (String) msg.obj;
                    tv_data.setText(s);
                    break;
                case 0x12:
                    String ss = (String) msg.obj;
                    tv_data.setText(ss);
                    break;
            }
            return true;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 控件的初始化
        btn_get_data = findViewById(R.id.btn_get_data);
        btn_get_all = findViewById(R.id.btn_get_all);
        tv_data = findViewById(R.id.tv_data);

    }



}

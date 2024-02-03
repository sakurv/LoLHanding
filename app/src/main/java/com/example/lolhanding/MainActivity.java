package com.example.lolhanding;

import androidx.appcompat.app.AppCompatActivity;
import db.CarDbHelper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    // 假设已有 CarDbHelper 类来管理数据库
    private CarDbHelper carDbHelper;
    private SQLiteDatabase db;
    private static final long LOGIN_EXPIRATION_TIME = TimeUnit.MINUTES.toMillis(30);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        usernameEditText = findViewById(R.id.Username);
        passwordEditText = findViewById(R.id.Password);
        loginButton = findViewById(R.id.btn_2);

        carDbHelper = new CarDbHelper(this, "car.db", null, 1);
        db = carDbHelper.getWritableDatabase();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "请输入账号和密码", Toast.LENGTH_SHORT).show();
                } else {
                    // 查询数据库中是否存在该账号
                    Cursor cursor = db.query("User", null, "account=?", new String[]{username}, null, null, null);

                    if (cursor.moveToFirst()) {
                        // 如果账号存在，获取数据库中的密码
                        @SuppressLint("Range") String storedPassword = cursor.getString(cursor.getColumnIndex("password"));

                        // 比较输入的密码与数据库中的密码
                        if (password.equals(storedPassword)) {

                            //验证通过之后保存登录状态和时间戳
                            saveLoginStatus();


                            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            // 跳转
                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "账号不存在", Toast.LENGTH_SHORT).show();
                    }

                    cursor.close();



                }
            }
        });



        //在应用启动前检查登录状态和时间戳
        checkLoginStatus();


    }

    private void saveLoginStatus(){
        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn",true);
        editor.putLong("loginTime",System.currentTimeMillis());
        editor.apply();
    }
    private void checkLoginStatus() {
        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        long loginTime = sharedPreferences.getLong("loginTime", 0);

        long currentTime = System.currentTimeMillis();
        long timeDifference = currentTime - loginTime;

        if (isLoggedIn && timeDifference <= LOGIN_EXPIRATION_TIME) {
            // 用户已登录且在指定时间范围内，无需再次登录
            Toast.makeText(MainActivity.this, "登录状态有效", Toast.LENGTH_SHORT).show();
            // 跳转到主界面或其他需要登录的界面
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
            finish();
        } else {
            // 用户未登录或登录已过期，需要重新登录
            Toast.makeText(MainActivity.this, "请登录", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 在活动销毁时关闭数据库连接
        if (db != null && db.isOpen()) {
            db.close();
        }
    }
}
package db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import com.example.lolhanding.entity.CarInfo;
import com.example.lolhanding.entity.LegendInfo;
import com.example.lolhanding.entity.SkinInfo;
import com.example.lolhanding.entity.UserInfo;

public class CarDbHelper extends SQLiteOpenHelper {

    private static CarDbHelper sHelper;
    private static final String DB_NAME = "car.db";   //数据库名
    private static final int VERSION = 1;    //版本号

    //必须实现其中一个构方法
    public CarDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //创建单例，供使用调用该类里面的的增删改查的方法
    public synchronized static CarDbHelper getInstance(Context context) {
        if (null == sHelper) {
            sHelper = new CarDbHelper(context, DB_NAME, null, VERSION);
        }
        return sHelper;
    }

    //构建购物车数据库
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建car_table表
        db.execSQL("create table car_table(_id integer primary key autoincrement, " +
                "username text," +       //用户名
                "product_title text," +      //商品名称
                "product_img integer," +      //商品图片
                "product_pri text," +        //商品价格
                "product_num integer" +          //商品数量
                ")");
        db.execSQL("create table Legend(_id integer primary key autoincrement, " +
                "account text," +       //用户名
                "img integer" +      //英雄图片
                ")");

        db.execSQL("create table User(_id integer primary key autoincrement, " +
                "id integer," +
                "account text," +       //账号
                "password text," +      //密码
                "name text," +      //昵称
                "head integer," +        //头像
                "ticket double," +          //点券
                "blue double" +            //蓝色精粹
                ")");
        // 向User表中插入数据
        db.execSQL("INSERT INTO User (account, password, name,head,ticket,blue) " +
                "VALUES ('123456', '123456','团战要炸',2131558556,9999999,6300)");

        db.execSQL("create table Skin(_id integer primary key autoincrement, " +
                "id integer," +
                "account text," +       //账号
                "name text," +      //皮肤名
                "img integer" +      //皮肤图片
                ")");
        db.execSQL("create table Shop(_id integer primary key autoincrement, " +
                "id integer," +
                "name text," +       //皮肤名
                "price double," +      //皮肤价格
                "img integer" +        //皮肤图片
                ")");




    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //添加到购物车
    public int addCar(String username, String product_title, int product_img, String product_pri) {

        //判断是否添加过商品，如果添加过，提示已添加，
        CarInfo addCar = isAddCar(username,product_title);
        if(addCar == null){
            //获取SQLiteDatabase实例
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            //填充占位符
            values.put("username", username);
            values.put("product_title", product_title);
            values.put("product_img", product_img);
            values.put("product_pri", product_pri);
            values.put("product_num", 1);
            String nullColumnHack = "values(null,?,?,?,?,?)";
            //执行
            int insert = (int) db.insert("car_table", nullColumnHack, values);
            db.close();
            return insert;
        }
        else{
            //Toast.makeText(getApplicationContext(), "您已经添加此商品", Toast.LENGTH_SHORT).show();
            return updateProduct(addCar.getCar_id(),addCar);
        }
    }

    /**
     * 修改购物车
     * **/
    public int updateProduct(int car_id, CarInfo carInfo) {
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getWritableDatabase();
        // 填充占位符
        ContentValues values = new ContentValues();
        values.put("product_num", carInfo.getProduct_num()+1);
        // 执行SQL
        int update = db.update("car_table", values, " _id=?", new String[]{car_id+""});
        // 关闭数据库连接
        db.close();
        return update;

    }

    /**
     * 根据用户名和商品名称来判断是否已经添加
     * **/
    @SuppressLint("Range")
    public CarInfo isAddCar(String username,String product_title) {
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getReadableDatabase();
        CarInfo carInfo = null;
        String sql = "select _id,username,product_title,product_img ,product_pri ,product_num from car_table where username=?  and product_title=?";
        String[] selectionArgs = {username,product_title};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if (cursor.moveToNext()) {
            int car_id = cursor.getInt(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("username"));
            String productTitle = cursor.getString(cursor.getColumnIndex("product_title"));
            int product_img = cursor.getInt(cursor.getColumnIndex("product_img"));
            int product_pri = cursor.getInt(cursor.getColumnIndex("product_pri"));
            int product_num = cursor.getInt(cursor.getColumnIndex("product_num"));
            carInfo = new CarInfo(car_id, name, productTitle,product_img,product_num,product_pri);
        }
        cursor.close();
        db.close();
        return carInfo;
    }

/**
 * 根据用户名去查购物车
 * **/
    @SuppressLint("Range")
    public List<CarInfo> queryCarList(String username) {
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getReadableDatabase();
        List<CarInfo> list = new ArrayList<>();
        String sql = "select _id,username,product_title,product_img ,product_pri ,product_num from car_table where username=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            int car_id = cursor.getInt(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("username"));
            String productTitle = cursor.getString(cursor.getColumnIndex("product_title"));
            int product_img = cursor.getInt(cursor.getColumnIndex("product_img"));
            int product_pri = cursor.getInt(cursor.getColumnIndex("product_pri"));
            int product_num = cursor.getInt(cursor.getColumnIndex("product_num"));
            list.add(new CarInfo(car_id, name, productTitle,product_img,product_num,product_pri));

        }
        cursor.close();
        db.close();
        return list;
    }
    /**
     * 根据用户名去查皮肤
     * **/
    @SuppressLint("Range")
    public List<SkinInfo> querySkinList(String username) {
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getReadableDatabase();
        List<SkinInfo> list = new ArrayList<>();
        String sql = "select _id,account,name,img from Skin where account=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            int Skin_id = cursor.getInt(cursor.getColumnIndex("_id"));
            String account = cursor.getString(cursor.getColumnIndex("account"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int img = cursor.getInt(cursor.getColumnIndex("img"));
            list.add(new SkinInfo(Skin_id, name,name,img));

        }
        cursor.close();
        db.close();
        return list;
    }

    /**
     * 根据用户名去查英雄
     * **/
    @SuppressLint("Range")
    public List<LegendInfo> queryLegendList(String username) {
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getReadableDatabase();
        List<LegendInfo> list = new ArrayList<>();
        String sql = "select _id,account,img from Legend where account=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            String account = cursor.getString(cursor.getColumnIndex("account"));
            int img = cursor.getInt(cursor.getColumnIndex("img"));
            list.add(new LegendInfo(account,img));
        }
        cursor.close();
        db.close();
        return list;
    }

    /**
     * 根据用户名去查名称
     * **/
    @SuppressLint("Range")
    public String selectName(String username) {
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select _id,account,name,head from User where account=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        String name = null;
        while (cursor.moveToNext()) {
            name = cursor.getString(cursor.getColumnIndex("name"));
        }
        cursor.close();
        db.close();
        return name;
    }
    /**
     * 根据用户名去查头像
     * **/
    @SuppressLint("Range")
    public Integer selectHead(String username) {
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select _id,account,name,head from User where account=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        Integer head = null;
        while (cursor.moveToNext()) {
             head = cursor.getInt(cursor.getColumnIndex("head"));
        }
        cursor.close();
        db.close();
        return head;
    }
    //查用户有多少蓝色精粹
    @SuppressLint("Range")
    public Double selectBlue(String account) {
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getReadableDatabase();
        Double userBlue = null;
        String sql = "select blue from User where account=?";
        String[] selectionArgs = {account};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if (cursor.moveToNext()) {
            userBlue = cursor.getDouble(cursor.getColumnIndex("blue"));
        }
        cursor.close();
        db.close();
        return userBlue;
    }

    /**
     * 删除
     * **/
    public int delete(String car_id) {
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getWritableDatabase();
        // 执行SQL
        int delete = db.delete("car_table", " _id=?", new String[]{car_id});
        // 关闭数据库连接
        db.close();
        return delete;
    }

    //查点券是否足够
    @SuppressLint("Range")
    public Double selectTicket(String account) {
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getReadableDatabase();
        Double userTicket = null;
        String sql = "select ticket from User where account=?";
        String[] selectionArgs = {account};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if (cursor.moveToNext()) {
            userTicket = cursor.getDouble(cursor.getColumnIndex("ticket"));
        }
        cursor.close();
        db.close();
        return userTicket;
    }

    /**
     * 从购物车购买商品到用户
     * **/
    @SuppressLint("Range")
    public SkinInfo AddUser(String account, String name,int img) {
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getWritableDatabase();
        SkinInfo skinInfo = null;
        ContentValues values = new ContentValues();
        values.put("account",account);
        values.put("name",name);
        values.put("img",img);
        db.insert("Skin",null,values);
        values.clear();
        db.close();
        return skinInfo;
    }

    /**
     * 用户账户更新
     * **/
    @SuppressLint("Range")
    public UserInfo UpdateUser(String account,double now_money) {
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getWritableDatabase();
        UserInfo userInfo = null;
        ContentValues values = new ContentValues();
        values.put("ticket",now_money);
        db.update("User",values,"account=?",new String[]{account+""});
        values.clear();
        db.close();
        return userInfo;
    }

    /**
     * 清空购物车
     * **/
    @SuppressLint("Range")
    public CarInfo ClearCar(String account) {
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getWritableDatabase();
        CarInfo carInfo = null;
        db.delete("car_table","username=?",new String[]{account+""});
        db.close();
        return null;
    }

    //查皮肤是否已拥有
    @SuppressLint("Range")
    public SkinInfo  isHaving(String account,String name) {
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getReadableDatabase();
        SkinInfo skinInfo = null;
        String sql = "select id,account,name,img from Skin where account=? and name=?";
        String[] selectionArgs = {account,name};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if (cursor.moveToNext()) {
            int id_1 = cursor.getInt(cursor.getColumnIndex("id"));
            String account_1 = cursor.getString(cursor.getColumnIndex("account"));
            String name_1 = cursor.getString(cursor.getColumnIndex("name"));
            int img_1 = cursor.getInt(cursor.getColumnIndex("img"));
            skinInfo = new SkinInfo(id_1,account_1,name_1,img_1);
        }
        cursor.close();
        db.close();
        return skinInfo;

    }





}

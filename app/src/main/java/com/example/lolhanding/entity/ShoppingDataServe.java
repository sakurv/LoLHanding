package com.example.lolhanding.entity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lolhanding.R;

import java.util.ArrayList;
import java.util.List;

import db.CarDbHelper;

public class ShoppingDataServe{
    @SuppressLint("Range")
    public static List<ProductInfo> getListData(Context context){
        List<ProductInfo> list = new ArrayList<>();



        list.add(new ProductInfo(0,R.mipmap.skin_1,"心之钢 奎桑提",7900));
        list.add(new ProductInfo(1,R.mipmap.skin_2,"心之钢 瑟提",7900));
        list.add(new ProductInfo(2,R.mipmap.skin_3,"心之钢 永恩",7900));
        list.add(new ProductInfo(3,R.mipmap.skin_4,"心之钢 厄斐琉斯",7900));
        list.add(new ProductInfo(4,R.mipmap.skin_5,"心之钢 凯隐",7900));
        list.add(new ProductInfo(5,R.mipmap.skin_6,"心之钢 伊泽瑞尔",7900));
        list.add(new ProductInfo(6,R.mipmap.skin_7,"五杀摇滚主唱 卡尔萨斯",7900));
        list.add(new ProductInfo(7,R.mipmap.skin_8,"五杀摇滚主唱 佛耶戈",7900));
        list.add(new ProductInfo(8,R.mipmap.skin_9,"五杀摇滚贝斯手 约里克",7900));
        list.add(new ProductInfo(9,R.mipmap.skin_10,"五杀摇滚键盘手 娑娜",7900));
        list.add(new ProductInfo(11,R.mipmap.skin_11,"五杀摇滚吉他手 莫得感情",7900));
        list.add(new ProductInfo(12,R.mipmap.skin_12,"五杀摇滚鼓手 奥拉夫",7900));
        list.add(new ProductInfo(13,R.mipmap.skin_13,"墨之影舞者 亚索",7900));
        list.add(new ProductInfo(14,R.mipmap.skin_14,"墨之影舞者 卡莎",7900));
        list.add(new ProductInfo(15,R.mipmap.skin_15,"墨影之灵 沃利贝尔",7900));
        list.add(new ProductInfo(16,R.mipmap.skin_16,"墨影舞者 乌迪尔",7900));
        list.add(new ProductInfo(17,R.mipmap.skin_17,"春晖神女 拉克丝",7900));
        list.add(new ProductInfo(18,R.mipmap.skin_18,"春晖大帝 锤石",7900));
        list.add(new ProductInfo(19,R.mipmap.skin_19,"春晖山神 墨菲特",7900));
        list.add(new ProductInfo(20,R.mipmap.skin_20,"北辰之威 内瑟斯",7900));
        list.add(new ProductInfo(21,R.mipmap.skin_21,"南天之怒 沃里克",7900));
        list.add(new ProductInfo(22,R.mipmap.skin_22,"魔女 娜美",7900));
        list.add(new ProductInfo(23,R.mipmap.skin_23,"魔女 尼菈",7900));
        list.add(new ProductInfo(24,R.mipmap.skin_24,"魔女 辛德拉",7900));
        list.add(new ProductInfo(25,R.mipmap.skin_25,"魔女 阿卡丽",7900));
        list.add(new ProductInfo(26,R.mipmap.skin_26,"K/DA 阿狸",7900));
        list.add(new ProductInfo(27,R.mipmap.skin_27,"K/DA 卡莎",7900));
        list.add(new ProductInfo(28,R.mipmap.skin_28,"K/DA 阿卡丽",7900));
        list.add(new ProductInfo(29,R.mipmap.skin_29,"K/DA 伊芙琳",7900));
        list.add(new ProductInfo(30,R.mipmap.skin_30,"K/DA 萨勒芬妮",7900));
        list.add(new ProductInfo(31,R.mipmap.skin_31,"北极星神 赛娜",7900));
        list.add(new ProductInfo(32,R.mipmap.skin_32,"北极星神 黛安娜",7900));
        list.add(new ProductInfo(33,R.mipmap.skin_33,"双鱼星神 娜美",7900));
        list.add(new ProductInfo(34,R.mipmap.skin_34,"水平星神 俄洛伊",7900));
        list.add(new ProductInfo(35,R.mipmap.skin_35,"波江星神 弗拉基米尔",7900));
        list.add(new ProductInfo(36,R.mipmap.skin_36,"胜利女神 奥利安娜",7900));
        list.add(new ProductInfo(37,R.mipmap.skin_37,"胜利枪神 卢锡安",7900));
        list.add(new ProductInfo(38,R.mipmap.skin_38,"胜利女神 瑟庄妮",7900));
        list.add(new ProductInfo(39,R.mipmap.skin_39,"胜利女神 伊莉丝",7900));
        list.add(new ProductInfo(40,R.mipmap.skin_40,"胜利凤凰 艾尼维亚",7900));
        list.add(new ProductInfo(41,R.mipmap.skin_41,"玉剑传说 舞龙卫",7900));
        list.add(new ProductInfo(42,R.mipmap.skin_42,"玉剑传说 武剑仙",7900));
        list.add(new ProductInfo(43,R.mipmap.skin_43,"玉剑传说 机神花火",7900));
        list.add(new ProductInfo(44,R.mipmap.skin_44,"玉剑传说 寒潭夭夭",7900));
        list.add(new ProductInfo(45,R.mipmap.skin_45,"玉剑传说 舞剑仙",7900));
        list.add(new ProductInfo(46,R.mipmap.skin_46,"玉剑传说 琴仙子",7900));
        list.add(new ProductInfo(47,R.mipmap.skin_47,"玉剑传说 星仙子",7900));
        list.add(new ProductInfo(48,R.mipmap.skin_48,"玉剑传说 翼剑仙",7900));
        list.add(new ProductInfo(49,R.mipmap.skin_49,"咖啡甜心 格温",7900));
        list.add(new ProductInfo(50,R.mipmap.skin_50,"咖啡甜心 金克丝",7900));
        list.add(new ProductInfo(51,R.mipmap.skin_51,"咖啡甜心 锤形态小炮",7900));
        list.add(new ProductInfo(52,R.mipmap.skin_52,"咖啡甜心 索拉卡",7900));
        list.add(new ProductInfo(53,R.mipmap.skin_53,"咖啡甜心 希维尔",7900));
        list.add(new ProductInfo(54,R.mipmap.skin_54,"咖啡甜心 安妮",7900));
        list.add(new ProductInfo(55,R.mipmap.skin_55,"灵魂莲华 永恩",7900));
        list.add(new ProductInfo(56,R.mipmap.skin_56,"灵魂莲华 瑟提",7900));
        list.add(new ProductInfo(57,R.mipmap.skin_57,"灵魂莲华 锤石",7900));
        list.add(new ProductInfo(58,R.mipmap.skin_58,"灵魂莲华 千珏",7900));
        list.add(new ProductInfo(59,R.mipmap.skin_59,"灵魂莲华 亚索",7900));
        list.add(new ProductInfo(60,R.mipmap.skin_60,"灵魂莲华 辛德拉",7900));
        list.add(new ProductInfo(61,R.mipmap.skin_61,"灵魂莲华 德莱厄斯",7900));
        list.add(new ProductInfo(62,R.mipmap.skin_62,"灵魂莲华 约里克",7900));
        list.add(new ProductInfo(63,R.mipmap.skin_63,"灵魂莲华 伊芙琳",7900));
        list.add(new ProductInfo(64,R.mipmap.skin_64,"灵魂莲华 瑞文",7900));
        list.add(new ProductInfo(65,R.mipmap.skin_65,"灵魂莲华 莉莉娅",7900));
        list.add(new ProductInfo(66,R.mipmap.skin_66,"灵魂莲华 提莫",7900));
        list.add(new ProductInfo(67,R.mipmap.skin_67,"暗星 锤石",7900));
        list.add(new ProductInfo(68,R.mipmap.skin_68,"暗星 嘉文四世",7900));
        list.add(new ProductInfo(69,R.mipmap.skin_69,"暗星 奥利安娜",7900));
        list.add(new ProductInfo(70,R.mipmap.skin_70,"暗星 墨菲特",7900));
        list.add(new ProductInfo(71,R.mipmap.skin_71,"暗星 萨科",7900));
        list.add(new ProductInfo(72,R.mipmap.skin_72,"暗星 科加斯",7900));
        list.add(new ProductInfo(73,R.mipmap.skin_73,"暗星 拉克丝",7900));
        list.add(new ProductInfo(74,R.mipmap.skin_74,"暗星绝杀 烬",7900));
        list.add(new ProductInfo(75,R.mipmap.skin_75,"未来战士 伊泽瑞尔",7900));
        list.add(new ProductInfo(76,R.mipmap.skin_76,"灵魂守卫 乌迪尔",7900));
        list.add(new ProductInfo(77,R.mipmap.skin_77,"大元素使 拉克丝",7900));
        list.add(new ProductInfo(78,R.mipmap.skin_78,"斗魂觉醒 莎弥拉",7900));
        list.add(new ProductInfo(79,R.mipmap.skin_79,"铁锈斑斑 布里茨",7900));
        list.add(new ProductInfo(80,R.mipmap.skin_80,"垃圾场 特朗德尔",7900));
        list.add(new ProductInfo(81,R.mipmap.skin_81,"山海绘卷 莉莉娅",7900));
        list.add(new ProductInfo(82,R.mipmap.skin_82,"山海绘卷 妮蔻",7900));
        list.add(new ProductInfo(83,R.mipmap.skin_83,"山海绘卷 巴德",7900));
        list.add(new ProductInfo(84,R.mipmap.skin_84,"山海绘卷 塔姆",7900));
        list.add(new ProductInfo(85,R.mipmap.skin_85,"山海绘卷 烬",7900));
        list.add(new ProductInfo(86,R.mipmap.skin_86,"山海绘卷 诺提勒斯",7900));
        list.add(new ProductInfo(87,R.mipmap.skin_87,"山海绘卷 克格莫",7900));
        list.add(new ProductInfo(88,R.mipmap.skin_88,"山海绘卷 科加斯",7900));
        list.add(new ProductInfo(89,R.mipmap.skin_89,"脏兮兮 努努和威朗普",7900));
        list.add(new ProductInfo(90,R.mipmap.skin_90,"iG 洛",7900));
        list.add(new ProductInfo(91,R.mipmap.skin_91,"STK T1 伊丽丝",7900));
        list.add(new ProductInfo(92,R.mipmap.skin_92,"冬季仙境 奥利安娜",7900));
        list.add(new ProductInfo(93,R.mipmap.skin_93,"觅心魔灵 奥利安娜",7900));
        list.add(new ProductInfo(95,R.mipmap.skin_95,"这货不是乌迪尔",7900));
        list.add(new ProductInfo(94,R.mipmap.skin_94,"这货不是周浩",7900));
        list.add(new ProductInfo(96,R.mipmap.skin_96,"这货不是张桓",7900));


        /****
         *  CarDbHelper carDbHelper = new CarDbHelper(context, "car.db", null, 1);
         *         SQLiteDatabase db = carDbHelper.getWritableDatabase();
         *         Cursor cursor = db.query("Shop",null,null,null,null,null,null);
         *         int cnt=0;
         *         if(cursor.moveToFirst()) {
         *             do {
         *                 list.add(new ProductInfo(cnt, cursor.getInt(cursor.getColumnIndex("img")),cursor.getString(cursor.getColumnIndex("name")),cursor.getInt(cursor.getColumnIndex("price"))));
         *                 cnt = cnt +1;
         *             } while (cursor.moveToNext());
         *             cursor.close();
         *         }
         */




        return list;
    }
}

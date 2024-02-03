package com.example.lolhanding.entity;

import com.example.lolhanding.R;

import java.util.ArrayList;
import java.util.List;

public class HomeDataServe {

    public static List<HomeInfo> getListData(){
        List<HomeInfo> list = new ArrayList<>();
        list.add(new HomeInfo(R.mipmap.top_1,"飞机和彗加强","13.24B版本研究所，飞机和彗超级加强，狼狗中野双双起飞！","https://lol.qq.com/v/v2/detail.shtml?docid=16038273580697269425/"));
        list.add(new HomeInfo(R.mipmap.top_2,"Keria冠军皮肤","Keria冠军皮肤确定为【烈娜塔】！","https://lol.qq.com/v/v2/detail.shtml?docid=14614305187364676880"));
        list.add(new HomeInfo(R.mipmap.top_3,"必胜客联动活动来了","100%得皮肤！必胜客联动活动又来了！","https://lol.qq.com/v/v2/detail.shtml?docid=5210143622349734097"));
        list.add(new HomeInfo(R.mipmap.top_4,"Faker冠军皮肤","Faker冠军皮肤选发条","https://lol.qq.com/v/v2/detail.shtml?docid=2495379013099310449"));
        list.add(new HomeInfo(R.mipmap.top_5,"冠军皮肤烈娜塔","Keria冠军皮肤选烈娜塔","https://lol.qq.com/v/v2/detail.shtml?docid=16516310608796664115"));
        list.add(new HomeInfo(R.mipmap.top_6,"LOL新英雄喷火龙","LOL新英雄[喷火龙]将于14.2版本上线!","https://lol.qq.com/v/v2/detail.shtml?docid=1975576627962088064"));
        list.add(new HomeInfo(R.mipmap.top_7,"必胜客活动可以看一下","必胜客活动可以看一下","https://lol.qq.com/v/v2/detail.shtml?docid=771684806047353396"));
        list.add(new HomeInfo(R.mipmap.top_8,"全新龙年炫彩瞎子","全新龙年炫彩一览 这瞎子起码500","https://lol.qq.com/v/v2/detail.shtml?docid=649311060779029893"));
        list.add(new HomeInfo(R.mipmap.top_9,"测试服新增5款龙年限定炫彩皮肤预览！","测试服新增5款龙年限定炫彩皮肤预览！","https://lol.qq.com/v/v2/detail.shtml?docid=4270812943911462850"));
        list.add(new HomeInfo(R.mipmap.top_10,"2023最后一期命定召唤","2023最后一期命定召唤即将来临，不用担心宝石过期了。","https://lol.qq.com/v/v2/detail.shtml?docid=1677442735658808232"));
        return  list;
    }

}

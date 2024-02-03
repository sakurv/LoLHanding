package com.example.lolhanding.Fragment;

import static android.app.ProgressDialog.show;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lolhanding.R;
import com.example.lolhanding.Shopping_Details;
import com.example.lolhanding.adapter.CarListAdapter;

import java.util.ArrayList;
import java.util.List;

import db.CarDbHelper;
import com.example.lolhanding.entity.CarInfo;
import com.example.lolhanding.entity.SkinInfo;

public class CarFragment extends Fragment {

    private View rootView;
    private RecyclerView recycleView;
    private CarListAdapter mCarListAdapter;

    private Button btn_total;
    private TextView total;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView =  inflater.inflate(R.layout.fragment_car,container,false);
        //初始化控件
        recycleView = rootView.findViewById(R.id.recycleView);
        total = rootView.findViewById(R.id.total);
        btn_total = rootView.findViewById(R.id.btn_total);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化mCarListAdapter
        mCarListAdapter = new CarListAdapter();
        //设置适配器
        recycleView.setAdapter(mCarListAdapter);
        //初始化控件
        total = rootView.findViewById(R.id.total);

        //recyclerView点击事件
        mCarListAdapter.setOnItemClickListener(new CarListAdapter.onItemClickListener() {
            @Override
            public void delOnClick(final CarInfo carInfo, int position) {

                new AlertDialog.Builder(getActivity())
                        .setTitle("温馨提示")
                        .setMessage("确认是否要删除")
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                CarDbHelper.getInstance(getActivity()).delete(carInfo.getCar_id()+"");
                                loadData();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();


            }
        });


        //合计点击事件
        btn_total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Double ticket = CarDbHelper.getInstance(getActivity()).selectTicket("123456");
                //Toast.makeText(getActivity(),ticket+"",Toast.LENGTH_SHORT).show();//显示价值
                //Toast.makeText(getActivity(),total.getText()+"",Toast.LENGTH_SHORT).show();//显示商品价值
                String text = (String) total.getText();
                final double value = Double.parseDouble(text);
                //判断是否点券足够
                if(value >= ticket){
                    new AlertDialog.Builder(getActivity())
                            .setTitle("温馨提示")
                            .setMessage("您的点券不足，请充值")

                            .setNegativeButton("关闭", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .show();
                   // Toast.makeText(getActivity(),"点券不足,请充值",Toast.LENGTH_SHORT).show();
                }else{
                    //循环查是否拥有
                    final List<CarInfo> carList = CarDbHelper.getInstance(getActivity()).queryCarList("123456");
                    String title_h="";
                    String title_dh="";
                    int flag = 0;
                    for(int i =0 ; i < carList.size() ; i++){
                        String title = carList.get(i).getProduct_title();
                        SkinInfo sk = CarDbHelper.getInstance(getActivity()).isHaving("123456",title);
                        if(sk != null){
                            title_h = title_h + " " + title;
                            flag = 1;
                        }
                        else{
                            title_dh = title_dh +" "+title;
                        }
                    }


                    if(flag == 1){
                        new AlertDialog.Builder(getActivity())
                                .setTitle("温馨提示")
                                .setMessage("以下皮肤"+title_h+"，您已经拥有,请勿重复购买")

                                .setNegativeButton("关闭", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                })
                                .show();
                        //Toast.makeText(getActivity(),"以下皮肤"+title_h+"，您已经拥有",Toast.LENGTH_SHORT).show();
                    }else{
                        new AlertDialog.Builder(getActivity())
                                .setTitle("温馨提示")
                                .setMessage("您确定购买以下皮肤"+title_dh)
                                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        for(int i =0;i<carList.size();i++){
                                            String title = carList.get(i).getProduct_title();
                                            int img = carList.get(i).getProduct_img();
                                            SkinInfo skin = CarDbHelper.getInstance(getActivity()).AddUser("123456",title,img);
                                            Double now_money = ticket - value;
                                            CarDbHelper.getInstance(getActivity()).UpdateUser("123456",now_money);
                                            CarDbHelper.getInstance(getActivity()).ClearCar("123456");
                                        }
                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("温馨提示")
                                                .setMessage("您已购买成功，虚拟商品已经添加至您的账户")
                                                .setNegativeButton("关闭", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                    }
                                                })
                                                .show();
                                        loadData();
                                    }
                                })

                                .setNegativeButton("我再挑一挑", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                })
                                .show();

                    }



                }

            }
        });
        loadData();
    }

    private void setTotalData(List<CarInfo> list){
        int total_price = 0;
        for(int i =0;i<list.size();i++){
            int price = list.get(i).getProduct_pri();
            total_price = total_price + price;
        }
        //设置数据
        total.setText(total_price+"");

    }

    //实时更新数据
    public void loadData(){
        //获取数据
        List<CarInfo> carList = CarDbHelper.getInstance(getActivity()).queryCarList("123456");
        //设置数据
        mCarListAdapter.setCarInfoList(carList);
        //计算价格
        setTotalData(carList);

    }


}
package com.example.lolhanding.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lolhanding.MainActivity;
import com.example.lolhanding.R;
import com.example.lolhanding.adapter.MyLegendAdapter;
import com.example.lolhanding.adapter.MySkinAdapter;
import com.example.lolhanding.entity.LegendDataServe;
import com.example.lolhanding.entity.LegendInfo;
import com.example.lolhanding.entity.SkinInfo;

import java.util.List;

import db.CarDbHelper;


public class MineFragment extends Fragment {
    private View rootView;
    private RecyclerView recycleSkinView;
    private RecyclerView recycleLegendView;
    private LinearLayoutCompat refresh;
    private MySkinAdapter mMySkinAdapter;
    private MyLegendAdapter mMyLegendAdapter;
    private ImageView userHead;
    private ImageView userExit;
    private TextView userName;
    private TextView userTicket;
    private TextView userBlue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_mine,container,false);

        //初始化
        recycleSkinView = rootView.findViewById(R.id.recycleSkinView);
        recycleLegendView = rootView.findViewById(R.id.recycleLegendView);
        userName = rootView.findViewById(R.id.name);
        userHead = rootView.findViewById(R.id.user_img);
        userBlue = rootView.findViewById(R.id.txt_blue);
        userTicket = rootView.findViewById(R.id.txt_ticket);
        userExit = rootView.findViewById(R.id.exit_btn);

        refresh = rootView.findViewById(R.id.refresh_btn);
        return rootView;
    }




    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化
        mMySkinAdapter = new MySkinAdapter();
        recycleSkinView.setAdapter(mMySkinAdapter);
        mMyLegendAdapter = new MyLegendAdapter();
        recycleLegendView.setAdapter(mMyLegendAdapter);

        //设置英雄
        mMyLegendAdapter.setLegendInfoList(LegendDataServe.getlistData(getActivity()));

        //设置头像与昵称
        int head = CarDbHelper.getInstance(getActivity()).selectHead("123456");
        String name = CarDbHelper.getInstance(getActivity()).selectName("123456");
        Double ticket = CarDbHelper.getInstance(getActivity()).selectTicket("123456");
        Double blue = CarDbHelper.getInstance(getActivity()).selectBlue("123456");
        userTicket.setText(ticket.toString());
        userBlue.setText(blue+"");
        userName.setText(name);
        userHead.setImageResource(head);

        loadData();

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });

        userExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(getActivity())
                        .setTitle("温馨提示")
                        .setMessage("您确定退出登录吗")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("确定",new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                getActivity().finish();
                            }
                        })
                        .show();

            }
        });

    }
    public void loadData(){
        List<SkinInfo> list = CarDbHelper.getInstance(getActivity()).querySkinList("123456");
        mMySkinAdapter.setSkinInfoList(list);
        Double ticket = CarDbHelper.getInstance(getActivity()).selectTicket("123456");
        Double blue = CarDbHelper.getInstance(getActivity()).selectBlue("123456");
        userTicket.setText(ticket.toString());
        userBlue.setText(blue+"");
        //List<LegendInfo> list1 = CarDbHelper.getInstance(getActivity()).queryLegendList("123456");
        //mMyLegendAdapter.setLegendInfoList(list1);

    }
}
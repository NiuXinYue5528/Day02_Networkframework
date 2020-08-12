package com.example.day02_networkframework.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.day02_networkframework.ClassBean.ClassBeans;
import com.example.day02_networkframework.ClassBean.ClassPrams;
import com.example.day02_networkframework.ClassIfyActivity;
import com.example.day02_networkframework.R;
import com.example.day02_networkframework.adapter.ClassAdapterTwo;
import com.example.day02_networkframework.adapter.ClassIfyAdapter;
import com.example.day02_networkframework.callback.ClassIfyCallBack;
import com.example.day02_networkframework.computerbean.ComputerBean;
import com.example.day02_networkframework.computerbean.ComputerCallBack;
import com.example.http_library.client.HttpClient;
import com.example.http_library.utils.JsonUtils;
import com.example.http_library.utils.LogUtils;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifyFragment extends Fragment {

    private RecyclerView rv;
    private ClassIfyAdapter classIfyAdapter;
    private ArrayList<ClassBeans> list;
    private RecyclerView rv_phone;
    private ArrayList<ComputerBean> datas;
    private ClassAdapterTwo classAdapterTwo;
    private ClassPrams classPrams;
    private ClassPrams categoryPrams;
    private TextView tv_title;
    private ImageView iv_img;
    private TextView tv_re;


//    @BindView(R.id.tab)
//    VerticalTabLayout tab;
//    @BindView(R.id.vp)
//    ViewPager vp;

    public ClassifyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_classify, container, false);


        initView(inflate);
        initData();
        initDatascomputer(categoryPrams);
        return inflate;
    }

    private void initDatascomputer(ClassPrams categoryPrams) {

        new HttpClient.Builder()
                .setApiUrl("category/getCategory")
                .post()
                .setJsonBody(JsonUtils.classToJson(categoryPrams), true)
                .build().request(new ComputerCallBack<List<ComputerBean>>() {
            @Override
            public void onError(String message, int code) {
               // onError(message, code);
            }

            @Override
            public void cancle() {
            }

            @Override
            public void onSuccess(List<ComputerBean> computerBeans) {
                datas.clear();
                datas.addAll(computerBeans);
                classAdapterTwo.notifyDataSetChanged();
            }

            @Override
            public List<ComputerBean> convert(JsonElement result) {
                return JsonUtils.jsonToClassList(result, ComputerBean.class);
            }
        });
    }

    private void initView(View inflate) {

        categoryPrams = new ClassPrams();
        categoryPrams.setParentId("1");

        classPrams = new ClassPrams();
        classPrams.setParentId("0");
//
//        categoryPrams = new ClassPrams();
//        categoryPrams.setParentId("0");

        rv = inflate.findViewById(R.id.rv);
        rv_phone = inflate.findViewById(R.id.rv_phone);
        iv_img = inflate.findViewById(R.id.iv_img);
        tv_re = inflate.findViewById(R.id.tv_re);
        tv_title = inflate.findViewById(R.id.tv_title);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.addItemDecoration(new DividerItemDecoration(getContext(), RecyclerView.VERTICAL));

        list = new ArrayList<>();
        classIfyAdapter = new ClassIfyAdapter(getContext(), list);
        rv.setAdapter(classIfyAdapter);


        rv_phone.setLayoutManager(new GridLayoutManager(getContext(), 3));
        datas = new ArrayList<>();
        classAdapterTwo = new ClassAdapterTwo(getContext(), datas);
        rv_phone.setAdapter(classAdapterTwo);
        classIfyAdapter.setOnItemClick(new ClassIfyAdapter.OnItemClick() {
            @Override
            public void onClick(int position) {
                if (position == 0) {
                    categoryPrams.setParentId((position + 1) + "");
                    initDatascomputer(categoryPrams);
                    classIfyAdapter.notifyDataSetChanged();
                    tv_title.setVisibility(View.GONE);
                    iv_img.setVisibility(View.VISIBLE);
                    tv_re.setVisibility(View.VISIBLE);
                } else if (position == 1) {
                    categoryPrams.setParentId((position + 1) + "");
                    initDatascomputer(categoryPrams);
                    classIfyAdapter.notifyDataSetChanged();
                    tv_title.setVisibility(View.GONE);
                    iv_img.setVisibility(View.VISIBLE);
                    tv_re.setVisibility(View.VISIBLE);
                } else {
                    datas.clear();
                    tv_title.setVisibility(View.VISIBLE);
                    iv_img.setVisibility(View.GONE);
                    tv_re.setVisibility(View.GONE);
                }
                //  把点击的下标回传给适配器 确定下标
                classIfyAdapter.setmPosition(position);
                classIfyAdapter.notifyDataSetChanged();
            }
        });
        classAdapterTwo.setOnItemClick(new ClassAdapterTwo.OnItemClick() {
            @Override
            public void onClick(int position) {
                //点击条目跳转到另一个页面
                    Intent intent = new Intent(getContext(), ClassIfyActivity.class);
                    intent.putExtra("id", list.get(position).getId());
                    startActivity(intent);
            }
        });

    }

    private void initData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("Content-Type", "application/json");

        new HttpClient.Builder()
                .setApiUrl("category/getCategory")
                //.setLifecycleProvider((LifecycleProvider) getLifecycle())
                .setJsonBody(JsonUtils.classToJson(classPrams), true)
                .post()
                .build()
                .request(new ClassIfyCallBack<List<ClassBeans>>() {
                    @Override
                    public void onError(String message, int code) {
                        LogUtils.e(message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<ClassBeans> classBeans) {
                        list.addAll(classBeans);
                        Log.e("111", "onSuccess: " + classBeans.get(0).getCategoryName());
                        classIfyAdapter.notifyDataSetChanged();


//                        ArrayList<Fragment> list = new ArrayList<>();
//                        ArrayList<String> titles = new ArrayList<>();
//                        for (int i = 0; i < classBeans.size(); i++) {
//                            //list.add(new )
//                            titles.add(classBeans.get(i).getCategoryName());
//                            Log.e("111", "onSuccess: "+classBeans.get(i).getCategoryName() );
//                        }
//                        ClassIfyAdapter classIfyAdapter = new ClassIfyAdapter(getChildFragmentManager(), list, titles);
//                        vp.setAdapter(classIfyAdapter);
//                        tab.setupWithViewPager(vp);
                    }

                    @Override
                    public List<ClassBeans> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, ClassBeans.class);
                    }
                });
    }


/*
    @Override
    public void showClassIfy(List<ClassBeans> beans) {
          ArrayList<Fragment> list = new ArrayList<>();
          ArrayList<String> titles = new ArrayList<>();
          for (int i = 0; i < beans.size(); i++) {
              //list.add(new )
              titles.add(beans.get(i).getCategoryName());
          }
          ClassIfyAdapter classIfyAdapter = new ClassIfyAdapter(getChildFragmentManager(), list, titles);

      }
*/


}

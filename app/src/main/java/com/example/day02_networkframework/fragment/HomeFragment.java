package com.example.day02_networkframework.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.day02_networkframework.R;
import com.example.day02_networkframework.RvAdapter;
import com.example.day02_networkframework.adapter.VpAdapter;
import com.example.day02_networkframework.constant.Mainconstant;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import me.crosswall.lib.coverflow.CoverFlow;
import me.crosswall.lib.coverflow.core.PagerContainer;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private Banner banner;
    private EditText et_name;
    private ViewFlipper vf;
    private RecyclerView rv;
    private ViewPager vp;
    private PagerContainer container;
    private View inflate1;
    private String images1="https://img14.360buyimg.com/n0/jfs/t3157/231/5756125504/98807/97ab361d/588084a1N06efb01d.jpg";
    private String images2="https://img10.360buyimg.com/n7/jfs/t5905/106/1120548052/61075/6eafa3a5/592f8f7bN763e3d30.jpg";
    private String images3=   "https://img10.360buyimg.com/n7/jfs/t5584/99/6135095454/371625/423b9ba5/59681d91N915995a7.jpg";
    private String images4=   "https://img11.360buyimg.com/n7/jfs/t4447/301/1238553109/193354/13c7e995/58db19a7N25101fe4.jpg";
    private String images5=      "https://img14.360buyimg.com/n1/s190x190_jfs/t7525/189/155179632/395056/e200017f/598fb8a4N7800dee6.jpg";

//    @BindView(R.id.et_name)
//    EditText etName;
   /* @BindView(R.id.vf)
    ViewFlipper vf;*/

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initView(inflate);
        initBanner(inflate);
        initNew();
        initVp();
        return inflate;
    }

    private void initVp() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <4 ; i++) {
            list.add("");
        }
        VpAdapter vpAdapter = new VpAdapter(getContext(), list);
        vp.setAdapter(vpAdapter);
        new CoverFlow.Builder().with(vp).scale(0.3f).pagerMargin(-30.0f).spaceSize(0.0f).build();
    }

    private void initView(View inflate) {
        banner = inflate.findViewById(R.id.banenr);
        vf = inflate.findViewById(R.id.vf);
        rv = inflate.findViewById(R.id.rv);
        container=inflate.findViewById(R.id.container);
        vp=inflate.findViewById(R.id.vp);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        rv.setLayoutManager(layoutManager);
        ArrayList<String> list = new ArrayList<>();

        list.add(images1);
        list.add(images2);
        list.add(images3);
        list.add(images4);
        list.add(images5);
        RvAdapter rvAdapter = new RvAdapter(getContext(), list);
        rv.setAdapter(rvAdapter);
    }

    private void initNew() {

        //第一种：
//        vf.addView(View.inflate(getContext(), R.layout.item_new, null));
//        vf.addView(View.inflate(getContext(), R.layout.item_new1, null));
        //第二种：
        ArrayList<String> list = new ArrayList<>();
        list.add("新用户立领1000元优惠券");
        list.add("夏日炎炎，第一波福利还有30秒到达战场");

        for (int i = 0; i <list.size() ; i++) {
            inflate1 = LayoutInflater.from(getContext()).inflate(R.layout.item_new, null);
            TextView tv_title = inflate1.findViewById(R.id.tv_title);
            tv_title.setText(list.get(i));
            vf.addView(inflate1);
        }
        //公告

        // vf.showNext();
    }

    private void initBanner(View inflate) {

        ArrayList<String> list = new ArrayList<>();
        Mainconstant mainconstant = new Mainconstant();
        list.add(mainconstant.HOME_BANNER_FOUR);
        list.add(mainconstant.HOME_BANNER_ONE);
        list.add(mainconstant.HOME_BANNER_THREE);
        list.add(mainconstant.HOME_BANNER_TWO);
        banner.
                setImages(list)
                .setBannerAnimation(Transformer.Accordion)
                .setDelayTime(2000)
                //设置指示器位置（当banner模式中有指示器时）
                .setIndicatorGravity(BannerConfig.RIGHT)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(path).into(imageView);
                    }
                }).start();

    }

}

package com.example.day02_networkframework;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.example.day02_networkframework.fragment.ClassifyFragment;
import com.example.day02_networkframework.fragment.HomeFragment;
import com.example.day02_networkframework.fragment.MeFragment;
import com.example.day02_networkframework.fragment.MessageFragment;
import com.example.day02_networkframework.fragment.ShppingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    @BindView(R.id.fl_contaier)
    FrameLayout flContaier;
    @BindView(R.id.bottom_nv)
    BottomNavigationBar bottomNv;
    private TextBadgeItem textBadgeItem;
    private HomeFragment homeFragment;
    private ClassifyFragment classifyFragment;
    private ShppingFragment shppingFragment;
    private MessageFragment messageFragment;
    private MeFragment meFragment;
    private FragmentManager fm;
    private Fragment mfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        //获取管理器

       fm  = getSupportFragmentManager();
        //获取对象
        homeFragment = new HomeFragment();
        classifyFragment = new ClassifyFragment();
        shppingFragment = new ShppingFragment();
        messageFragment = new MessageFragment();
        meFragment = new MeFragment();
        //开启事务  添加cantainer     //提交事务
        fm.beginTransaction().add(R.id.fl_contaier, homeFragment)
        .add(R.id.fl_contaier, classifyFragment)
        .add(R.id.fl_contaier, shppingFragment)
        .add(R.id.fl_contaier, messageFragment)
        .add(R.id.fl_contaier, meFragment)
                .hide(classifyFragment)
                .hide(shppingFragment)
                .hide(messageFragment)
                .hide(meFragment).commit();

//        textBadgeItem = new TextBadgeItem();
        //添加导航按钮
        bottomNv.
                addItem(new BottomNavigationItem(R.drawable.btn_nav_home_normal, "主页"))
                .addItem(new BottomNavigationItem(R.drawable.btn_nav_category_normal, "分类"))
                .addItem(new BottomNavigationItem(R.drawable.btn_nav_cart_normal, "购物车"))
                .addItem(new BottomNavigationItem(R.drawable.btn_nav_msg_normal, "消息"))
                .addItem(new BottomNavigationItem(R.drawable.btn_nav_user_normal, "我的"))
                .setMode(BottomNavigationBar.MODE_DEFAULT)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)//没有水波纹效果
                .setBarBackgroundColor(R.color.common_blue)//背景颜色
                .setFirstSelectedPosition(0)
                .setActiveColor(R.color.common_blue_dark)//选中的状态
                .initialise();//initialise 一定要放在 所有设置的最后一项

        //底部选中的状态
        bottomNv.setTabSelectedListener(this);

    }

    //设置选中逻辑
    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
               // fm.beginTransaction().replace(R.id.fl_contaier, homeFragment).commit();
              fm.beginTransaction().show(homeFragment)
                    .hide(classifyFragment)
                    .hide(shppingFragment)
                    .hide(messageFragment)
                    .hide(meFragment)
                      .commit();
                break;
            case 1:
                fm.beginTransaction().show(classifyFragment)
                        .hide(homeFragment)
                        .hide(shppingFragment)
                        .hide(messageFragment)
                        .hide(meFragment)
                        .commit();
                //用replace  是替换  比较慢
              //  fm.beginTransaction().replace(R.id.fl_contaier, classifyFragment).commit();
                break;
            case 2:
                fm.beginTransaction().show(shppingFragment)
                        .hide(classifyFragment)
                        .hide(homeFragment)
                        .hide(messageFragment)
                        .hide(meFragment)
                        .commit();
                //fm.beginTransaction().replace(R.id.fl_contaier, shppingFragment).commit();
                break;
            case 3:
                fm.beginTransaction().show(messageFragment)
                        .hide(classifyFragment)
                        .hide(shppingFragment)
                        .hide(homeFragment)
                        .hide(meFragment)
                        .commit();
               // fm.beginTransaction().replace(R.id.fl_contaier, messageFragment).commit();
                break;
            case 4:
                fm.beginTransaction().show(meFragment)
                        .hide(classifyFragment)
                        .hide(shppingFragment)
                        .hide(messageFragment)
                        .hide(homeFragment)
                        .commit();
                //fm.beginTransaction().replace(R.id.fl_contaier, meFragment).commit();
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

   /* private void switchFragment(Fragment fragment) {
        //判断当前显示的Fragment是不是切换的Fragment
        if (mfragment != fragment) {
            //判断切换的Fragment是否已经添加过
            if (!fragment.isAdded()) {
                //如果没有，则先把当前的Fragment隐藏，把切换的Fragment添加上
                getSupportFragmentManager().beginTransaction().hide(mfragment)
                        .add(R.id.fl_contaier, fragment).commit();
            } else {
                //如果已经添加过，则先把当前的Fragment隐藏，把切换的Fragment显示出来
                getSupportFragmentManager().beginTransaction().hide(mfragment).show(fragment).commit();
            }
            mfragment = fragment;
        }
    }*/


  /*
    fm = getSupportFragmentManager();//从新导入fragmentManager
        fm.beginTransaction()
                .add(R.id.fl_contaier, homeFragment)
                .commit();
    mfragment = homeFragment;*/
}

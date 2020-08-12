package com.example.day02_networkframework;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day02_networkframework.ClassMvp.ClassIfyPresonter;
import com.example.day02_networkframework.ClassMvp.ClassifyView;
import com.example.day02_networkframework.classtwo.ClassIfyBeanTwo;
import com.example.day02_networkframework.classtwo.ClassIfyParmsTwo;
import com.example.day02_networkframework.mvp.MainPresontion;
import com.example.day02_networkframework.mvp.MainView;
import com.example.mvp_library.base.BaseMvpActivity;
import com.example.mvp_library.base.BaseMvpFragment;

import java.util.ArrayList;
import java.util.List;

public class ClassIfyActivity extends BaseMvpActivity<ClassifyView, ClassIfyPresonter> implements ClassifyView {

    private RecyclerView rv;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_ify);
    }

    @Override
    protected void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);

        if (id==0){

        }
        ArrayList<ClassIfyBeanTwo> list = new ArrayList<>();
        new
    }


    @Override
    protected void initData() {

    }

    @Override
    protected int initLayoutId() {
        return R.layout.activity_class_ify;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initListData() {
        ClassIfyParmsTwo classIfyParmsTwo = new ClassIfyParmsTwo();
        classIfyParmsTwo.setCategoryId(24);
        classIfyParmsTwo.setPageNo(1);
        mPresonter.setData(classIfyParmsTwo);
    }
    @Override
    public void onSuccess(List<ClassIfyBeanTwo> classIfyBeanTwo) {

    }

    @Override
    public void onFail(String error) {

    }
    @Override
    protected ClassIfyPresonter initPresonter() {
        return new ClassIfyPresonter();
    }
}

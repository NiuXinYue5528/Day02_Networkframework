package com.example.day02_networkframework;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.example.day02_networkframework.ClassBean.ClassBeans;
import com.example.day02_networkframework.Wanandroid.PlayCallBack;
import com.example.day02_networkframework.Wanandroid.WanAndroidBean;
import com.example.day02_networkframework.adapter.RvAdapter;
import com.example.day02_networkframework.demo.DemosBean;
import com.example.day02_networkframework.food.FoodBean;
import com.example.day02_networkframework.food.FoodCallBack;
import com.example.day02_networkframework.mvp.MainPresontion;
import com.example.day02_networkframework.mvp.MainView;
import com.example.http_library.client.HttpClient;
import com.example.http_library.utils.JsonUtils;
import com.example.http_library.utils.LogUtils;
import com.example.mvp_library.base.BaseMvpActivity;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseMvpActivity<MainView, MainPresontion> implements MainView {
  /*  @BindView(R.id.fl_contaier)
    FrameLayout flContaier;
    @BindView(R.id.bottom_nv)
    BottomNavigationBar bottomNv;*/

    //  private val mStack =Stack<Fragment>()

    private Disposable disposable;
    private RvAdapter rvAdapter;
    private ArrayList<Demo.DataBean.DatasBean> list;
    private RecyclerView rv;
//    @SuppressLint("CheckResult")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
    //setContentView(R.layout.activity_main);

    // initData();
    //initData1();
    // initData2();


    @Override
    protected void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        list = new ArrayList<>();
        rvAdapter = new RvAdapter(this, list);
        rv.setAdapter(rvAdapter);

    }

    @Override
    protected void initData() {
        mPresonter.getData();
    }


    @Override
    protected int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initListData() {

    }

    @Override
    protected MainPresontion initPresonter() {
        return new MainPresontion();
    }

//    @Override
//    public void showDemo(DemosBean demo) {
//       // list.addAll(demo);
//        rvAdapter.notifyDataSetChanged();
//        Log.e("111", "showDemo: "+demo.toString() );
//        LogUtils.e(demo.toString());
//    }

  /*  @Override
    public void showDemo(List<Demo> demo) {
        list.addAll(demo.get(0).getData().getDatas());
        rvAdapter.notifyDataSetChanged();
        LogUtils.e(demo.toString());
    }*/


    private void initData2() {
        new HttpClient.Builder()
                .get()
                .setApiUrl("project/list/1/json?cid=294")

                .build()
                .request(new PlayCallBack<WanAndroidBean>() {
                    @Override
                    public void onError(String message, int code) {
                        Log.i("111", "onError: " + message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(WanAndroidBean wanAndroidBean) {
                        Log.e("111", "onSuccess: " + wanAndroidBean.toString());
                    }

                    @Override
                    public WanAndroidBean convert(JsonElement result) {
                        return new Gson().fromJson(result, WanAndroidBean.class);
                    }
                });
    }

    private void initData1() {
        new HttpClient.Builder()
                .setApiUrl("cf/dish_list.php?stage_id=1&limit=20&page=1")
                .get()
                .build()
                .request(new FoodCallBack<List<FoodBean>>() {
                    @Override
                    public void onError(String message, int code) {
                        Log.e("111", "onError: " + message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<FoodBean> foodBeans) {
                        Log.e("111", "onSuccess: " + foodBeans.toString());
                    }

                    @Override
                    public List<FoodBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, FoodBean.class);
                    }
                });
    }

    @Override
    public void showDemo(Demo demo) {

    }

    @Override
    public void showClassIfy(List<ClassBeans> beans) {

    }















   /* private void initData() {
        new HttpClient.Builder()
                .setApiUrl("article/list/0/json")
                .get()
                .build()
                .request(new HttpCallBack<Demo>() {
                    @Override
                    public void onError(String message, int code) {
                        Log.e("111", "onError: "+message );
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(Demo demo) {
                        Log.i("111", "onSuccess: "+demo.toString());
                    }

                    @Override
                    public Demo convert(JsonElement result) {
                        String s = new Gson().toJson(result);
                        return new Gson().fromJson(s, Demo.class);
                    }
                });*/
    // }
    /*

        //get请求
        Retrofit retrofit = HttpManager.getInstance().getRetrofit("https://www.wanandroid.com/", 5, TimeUnit.SECONDS);
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<JsonElement> observable = apiService.get("article/list/0/json", new HashMap<String, Object>(), new HashMap<String, Object>());
        observable.delay(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends JsonElement>>() {
                    @Override
                    public ObservableSource<? extends JsonElement> apply(Throwable throwable) throws Exception {
                        return Observable.error(new Exception("网络错误"));
                    }
                })
                .doOnDispose(new Action() {
            @Override
            public void run() throws Exception {
                Log.e("111", "run: " + "取消订阅");
            }
        });


*/


    /*.map(new Function<JsonElement, ResponseBean>() {
            @Override
            public ResponseBean apply(JsonElement jsonElement) throws Exception {
                ResponseBean responseBean = new Gson().fromJson(jsonElement.toString(), ResponseBean.class);
                return responseBean;
            }
        }).map(new Function<ResponseBean, Demo>() {
            @Override
            public Demo apply(ResponseBean responseBean) throws Exception {
                String s = new Gson().toJson(responseBean.getData());
                return new Gson().fromJson(s, Demo.class);
            }
        })
                .subscribe(new Observer<Demo>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable=d;
                    }

                    @Override
                    public void onNext(Demo demo) {
                        Log.e("111", "onNext: "+demo.toString() );
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("111", "onError: "+ e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("111", "onComplete: " );
                    }
                });*/


     /*  //post请求
        Retrofit retrofit = HttpManager.getInstance().getRetrofit("http://api.t.ergedd.com/", 5, TimeUnit.SECONDS);
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<JsonElement> observable = apiService.post("getUpgrade", new HashMap<String, Object>(), new HashMap<String, Object>());
        observable
                .delay(3, TimeUnit.SECONDS)//延时网络
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends JsonElement>>() {
            @Override
            public ObservableSource<? extends JsonElement> apply(Throwable throwable) throws Exception {
                return Observable.error(new Exception("错误网络"));
            }
        }).doOnDispose(new Action() {
            @Override
            public void run() throws Exception {
                Log.i("111", "run: "+"取消订阅");
            }
        }).map(new Function<JsonElement, PostBean>() {
            @Override
            public PostBean apply(JsonElement jsonElement) throws Exception {
                PostBean postBean = new Gson().fromJson(jsonElement.toString(), PostBean.class);
                Log.i("111", "apply: "+jsonElement.toString());
                return postBean;
            }
        }).map(new Function<PostBean, Post>() {
            @Override
            public Post apply(PostBean postBean) throws Exception {
                String s = new Gson().toJson(postBean.getRecord());
                return new Gson().fromJson(s, Post.class);
            }
        }).subscribe(new Observer<Post>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable=d;
            }

            @Override
            public void onNext(Post post) {
                Log.i("111", "onNext: "+post.toString());
            }

            @Override
            public void onError(Throwable e) {
                Log.i("111", "onError: "+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.i("111", "onComplete: ");
            }
        });
*/
//    }

}

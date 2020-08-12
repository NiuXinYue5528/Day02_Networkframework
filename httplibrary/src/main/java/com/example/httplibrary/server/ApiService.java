package com.example.httplibrary.server;

import com.google.gson.JsonElement;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface ApiService {

    //get请求
    @GET
    Observable<JsonElement> get(@Url String url, @QueryMap Map<String,Object> map,
                               @HeaderMap Map<String,Object> headermap
                                );
    //post表单请求
    @GET
    @FormUrlEncoded
    Observable<JsonElement> post(@Url String url, @FieldMap Map<String, Object> map,
                                               @HeaderMap Map<String,Object> headermap
    );
    //post上传json
    @POST
    Observable<JsonElement> postJson(@Url String url, RequestBody requestBody,
                                     @HeaderMap Map<String,Object> headermap
    );
    //上传文件
    @POST
    @Multipart
    Observable<JsonElement> postPart(@Url String url, @PartMap Map<String, Object> map,
                                 List<MultipartBody.Part> parts
    );
    //下载文件
    @GET
    @Streaming
    Observable<JsonElement> dwon(@Url String url, @QueryMap Map<String,Object> map,
                                 @HeaderMap Map<String,Object> headermap);
    //删除
    @DELETE
    Observable<JsonElement> delete(@Url String url, @QueryMap Map<String, Object> map,
                                     @HeaderMap Map<String,Object> headermap
    );
    //put   @FieldMap post请求需要用的注解
    @PUT
    @FormUrlEncoded
    Observable<JsonElement> put(@Url String url, @FieldMap Map<String, Object> map,
                                   @HeaderMap Map<String,Object> headermap//请求头
    );
}

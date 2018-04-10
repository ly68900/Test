package com.example.lidenghui1_os.test.Retrofit;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by lidenghui1-os on 2018/3/15.
 */

public interface GetRequest_Interface {

//    @GET("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1520948454351&di=940429886ae42dd0c821e4ee7860db7c&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fc75c10385343fbf2f7da8133bc7eca8065388f2f.jpg")
//    Call<ResponseBody> getcall();


    @GET
    Call<ResponseBody> getdata(@Url String url);
}

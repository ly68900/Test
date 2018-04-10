package com.example.lidenghui1_os.test.AsyncTask;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.lidenghui1_os.test.MainActivity;
import com.example.lidenghui1_os.test.Retrofit.GetRequest_Interface;
import com.example.lidenghui1_os.test.security.IRC4;
import com.example.lidenghui1_os.test.security.RC4Factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lidenghui1-os on 2018/3/13.
 */

public class MyAsyncTask  extends AsyncTask<Void,Void,String> {
    private ArrayList<String> list;
    private String Result = "";

    public MyAsyncTask( ArrayList<String> list) {
        this.list = list;

    }
    public String getResult(){
        return Result;
    }



    @Override
    protected String doInBackground(Void... voids) {

        final String Key = list.get(0);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        IRC4 irc4 = RC4Factory.create(list.get(0));
        byte[] result = irc4.encrypt(list.get(1).getBytes());

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, result);


        Log.e("RC++++", Arrays.toString(result) + "");
        Request request = new Request.Builder().post(body).url(list.get(2)).build();
        okhttp3.Response response=null;


        try {
            response=okHttpClient.newCall(request).execute();
            byte[] body1 = response.body().bytes();
            IRC4 sIrc4 = RC4Factory.create(Key);
            String result1 = new String(sIrc4.decrypt(body1));
            Result=result1;
            Log.e("RC++++", result1);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
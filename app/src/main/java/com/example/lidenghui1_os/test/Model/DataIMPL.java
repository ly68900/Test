package com.example.lidenghui1_os.test.Model;

import android.app.Activity;
import android.os.AsyncTask;

import com.example.lidenghui1_os.test.AsyncTask.MyAsyncTask;
import com.example.lidenghui1_os.test.MainActivity;

import java.util.ArrayList;

/**
 * Created by lidenghui1-os on 2018/4/10.
 */

public class DataIMPL implements IData {
    private MyAsyncTask asyncTask;
    public DataIMPL(ArrayList<String> data){
        this.asyncTask=new MyAsyncTask(data);
    }
    @Override
    public void SendData() {
        asyncTask.execute();
    }

    @Override
    public String getResult() {
        return asyncTask.getResult();
    }

}

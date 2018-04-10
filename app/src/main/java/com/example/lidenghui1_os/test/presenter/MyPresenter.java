package com.example.lidenghui1_os.test.presenter;

import com.example.lidenghui1_os.test.MainActivity;
import com.example.lidenghui1_os.test.Model.DataIMPL;
import com.example.lidenghui1_os.test.view.IView;

import java.util.ArrayList;

/**
 * Created by lidenghui1-os on 2018/4/10.
 */

public class MyPresenter  {
    private DataIMPL mdataIMPL;
    private IView iView;

    public MyPresenter(IView iView,ArrayList<String> arrayList){
        mdataIMPL=new DataIMPL(arrayList);
        this.iView=iView;
    }

    public void senddata(){
        mdataIMPL.SendData();
        iView.settext(mdataIMPL.getResult());
    }
}

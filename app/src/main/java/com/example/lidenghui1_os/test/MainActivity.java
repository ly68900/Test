package com.example.lidenghui1_os.test;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lidenghui1_os.test.AsyncTask.MyAsyncTask;
import com.example.lidenghui1_os.test.presenter.MyPresenter;
import com.example.lidenghui1_os.test.view.IView;

import java.util.ArrayList;



public class MainActivity extends Activity implements IView{
//    public static final String KEY="77caf548f9e4ab73d6bddf349937a460";
//    public static final String DATA="{\"packageName\":[\"com.gotokeep.keep\",\"com.tencent.weishi\"]}";
//    public static final String URL = "http://test.comp.360os.com/qikucms/openapi/file/getFileLinks.action";
    private MyPresenter myPresenter;
    public TextView textView;
    private EditText data;
    private EditText url;
    private EditText key;
    private TextView clean;
    ArrayList<String> list=new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPresenter=new MyPresenter(this,list);
        Button button=findViewById(R.id.download);
        textView=findViewById(R.id.Result);
        data=findViewById(R.id.editText3);
        url=findViewById(R.id.editText);
        key=findViewById(R.id.editText2);
        clean=findViewById(R.id.clean);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!key.getText().toString().equals("")&&!url.getText().toString().equals("")&&!data.getText().toString().equals("")){
                    list.add(key.getText().toString());
                    list.add(data.getText().toString());
                    list.add(url.getText().toString());

                }else {
                    Toast.makeText(getApplicationContext(),"参数不能为空",Toast.LENGTH_LONG).show();
                }


//                list.add(KEY);
//                list.add(DATA);
//                list.add(URL);
//                new MyAsyncTask(MainActivity.this,list).execute();

            }
        });
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textView.getText().equals("")){
                    textView.setText("");
                }

            }
        });
    }

    @Override
    public void settext(String text) {

    }
}

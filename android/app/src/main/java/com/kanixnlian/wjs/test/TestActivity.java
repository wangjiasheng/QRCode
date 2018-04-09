package com.kanixnlian.wjs.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.client.android.Intents;
import com.kaixinlian.wjs.com.CaptureActivity;
import com.kaixinlian.wjs.com.R;

/**
 * Created by Wang on 2018/4/9.
 */

public class TestActivity extends Activity {
    public static final int REQUEST_CODE=10001;
    private TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testlayout);
        info=findViewById(R.id.info);
    }
    public void clickButton(View button){
        Intent intent = new Intent(this, CaptureActivity.class);
        //intent.setAction(Intents.Scan.ACTION);
       // intent.putExtra(Intents.Scan.FORMATS, "QR_CODE");
        startActivityForResult(intent, REQUEST_CODE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE&&resultCode==RESULT_OK){
            Bundle bundle=data.getExtras();
            String str1=bundle.getString("ReturnString");
            String str2=data.getStringExtra("ReturnString");
            //Toast.makeText(TestActivity.this,str1+""+str2,Toast.LENGTH_SHORT).show();
            info.setText(str2+""+str1);
        }
    }
}

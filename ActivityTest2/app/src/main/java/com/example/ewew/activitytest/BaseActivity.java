package com.example.ewew.activitytest;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity",getClass().getSimpleName());
    }
}

package com.example.ewew.uiwidgettest;

import android.app.ProgressDialog;
import android.preference.DialogPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
public class UIWidgetTest extends AppCompatActivity implements View.OnClickListener{
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiwidget_test);
        Button button=(Button) findViewById(R.id.button);
        editText=(EditText) findViewById(R.id.edit_text);
        imageView=(ImageView) findViewById(R.id.image_view);
        progressBar=(ProgressBar) findViewById(R.id.progress_bar);
        button.setOnClickListener(this);
    }
     @Override
       public void onClick(View v){
       switch (v.getId()){
       case R.id.button:
           ProgressDialog progressDialog=new ProgressDialog(UIWidgetTest.this);
           progressDialog.setTitle("this is ProgressDialog");
           progressDialog.setMessage("Loading");
           progressDialog.setCancelable(true);
           progressDialog.show();
      }
    }
}

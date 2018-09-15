package com.example.ewew.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button creatrDatabase=(Button)findViewById(R.id.create_database);
        creatrDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LitePal.getDatabase();
            }
        });
        Button addData =(Button)findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book=new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(16.96);
                book.setPress("Unknow");
                book.save();
            }
        });
        Button queryButton=(Button)findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Book>books= DataSupport.findAll(Book.class);

            }
        });
    }
}

package com.example.ewew.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager=new
                StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter=new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }
    private void initFruits(){
        for (int i=0;i<10;i++){
            Fruit apple=new Fruit(getRandomLengthName("Apple"),R.drawable.c5c5da0df3b58dec953af6945c571e9a);
            fruitList.add(apple);
            Fruit banana=new Fruit(getRandomLengthName("Banana"),R.drawable.dbf91882cb3c940944924780412efec7);
            fruitList.add(banana);
        }
    }

    private String getRandomLengthName(String name) {
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<length;i++){
            builder.append(name);
        }
        return builder.toString();
    }
}

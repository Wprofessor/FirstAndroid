package com.example.ewew.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ewew.listviewtest.Fruit;
import com.example.ewew.listviewtest.R;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit>{
    private int resourceId;
    public FruitAdapter(Context context, int textViewRescourcrId, List<Fruit> objects){
        super(context,textViewRescourcrId,objects);
        resourceId=textViewRescourcrId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Fruit fruit=  getItem(position);
        View view;
        if (convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }
        else {
            view=convertView;
        }
        ImageView fruitImage=(ImageView)view.findViewById(R.id.fruit_image);
        TextView fruitName=(TextView)view.findViewById(R.id.fruit_name);
        fruitImage.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());
        return view;
    }
}

package com.example.ewew.mapinhand;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

//import com.example.ewew.MapinHand.R;

public class GuideActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewpage;

    private List<View>mList=new ArrayList<>();
    private View view1,view2,view3;

    private ImageView point1,point2,point3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initView();
    }
    private void initView(){
        point1=(ImageView)findViewById(R.id.point_1);
        point2=(ImageView)findViewById(R.id.point_2);
        point3=(ImageView)findViewById(R.id.point_3);

        setPointImg(true,false,false);
        mViewpage=(ViewPager)findViewById(R.id.mviewpage);
        view1=View.inflate(this,R.layout.page_one,null);
        view2=View.inflate(this,R.layout.page_two,null);
        view3=View.inflate(this,R.layout.page_three,null);

        view3.findViewById(R.id.start).setOnClickListener(this);
        mList.add(view1);
        mList.add(view2);
        mList.add(view3);

        mViewpage.setAdapter(new GuideAdapter());
        //监听
        mViewpage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }
            //Page切换
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        setPointImg(true,false,false);
                        break;
                    case 1:
                        setPointImg(false,true,false);
                        break;
                    case 2:
                        setPointImg(false,false,true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start:
                startActivity(new Intent(this,MainActivity.class));
                finish();
                break;
        }
    }

    class GuideAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view==o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ((ViewPager)container).addView(mList.get(position));
            return mList.get(position);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            ((ViewPager)container).removeView(mList.get(position));
//            super.destroyItem(container, position, object);
        }
    }

    private void setPointImg(boolean ischeck1,boolean ischeck2,boolean ischeck3){

        if (ischeck1)
            point1.setBackgroundResource(R.drawable.point_on);
        else point1.setBackgroundResource(R.drawable.point_off);
        if (ischeck2)
            point2.setBackgroundResource(R.drawable.point_on);
        else point2.setBackgroundResource(R.drawable.point_off);
        if (ischeck3)
            point3.setBackgroundResource(R.drawable.point_on);
        else point3.setBackgroundResource(R.drawable.point_off);

    }
}

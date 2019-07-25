package com.kotlin.xhb;

import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.kotlin.xhb.okio.Timeout;
import com.kotlin.xhb.数据类型.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

//https://github.com/fengzhizi715/kotlin_tutorial
//Kotlin 教程
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

//        List<? extends Object> list = new ArrayList<>();
//        list.add("adf"); //in List cannot be applied 无法应用在列表中
//        list.add(new Object()); //in List cannot be applied 无法应用在列表中
//        list.add(null);  //可以
//        Object o = list.get(1);

        List a = new ArrayList<Object>();
        List<? super HashMap> b = a;
        b.add(new LinkedHashMap()); //不行
//        //总是可以读取为Object，然而这并没有太多意义
//        Object s = b.get(0);
    }


    static class MyAdapter extends FragmentStatePagerAdapter {
        ArrayList<HomeFragment> fragments = new ArrayList<>();
        {
            for (int i = 0; i < 20; i++) {
                fragments.add(HomeFragment.create(String.format("第%s个", String.valueOf(i))));
            }
        }
        public MyAdapter(FragmentManager fm) { super(fm); }
        @Override
        public Fragment getItem(int position) { return fragments.get(position); }
        @Override
        public int getCount() { return fragments.size(); }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }
    }
}

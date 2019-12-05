package com.example.local_serendipity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class PastActivity extends AppCompatActivity {
    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past);


        /*Recycler View 적용
        ArrayList<String> list = new ArrayList<>();
        for (int i=0; i<100; i++) {
            list.add(String.format("사용자", i)) ;
        }

        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        RecyclerView recyclerView = findViewById(R.id.recyclerView) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)) ;

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        RecyclerAdapter adapter = new RecyclerAdapter(list) ;
        recyclerView.setAdapter(adapter) ;*/


        //ViewPager 적용
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new PastActivity.MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);


    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        // getCount() : 뷰페이저의 전체 페이지 수 결정
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        // getItem() : 해당하는 페이지의 프래그먼트 생성 후 리턴
        @Override
        public Fragment getItem(int position) {
            return new PastFragment();
            /*
            switch (position) {
                case 0:
                    return new PastFragment();
                case 1:
                    return new PastFragment();
                case 2:
                    return new PastFragment();
                default:
                    return null;
            }*/
        }
    }
}

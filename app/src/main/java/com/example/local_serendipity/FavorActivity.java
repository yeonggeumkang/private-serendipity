package com.example.local_serendipity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class FavorActivity extends AppCompatActivity {
    FragmentPagerAdapter adapterViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favor);


        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new FavorActivity.MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(vpPager);



    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 4;
        ArrayList<String> contentsList1 = new ArrayList<String>();
        ArrayList<String> contentsList2 = new ArrayList<String>();
        ArrayList<String> contentsList3 = new ArrayList<String>();
        ArrayList<String> contentsList4 = new ArrayList<String>();

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
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    contentsList1.add("비흡연자");
                    contentsList1.add("드물게 피운다");
                    contentsList1.add("종종 피운다");
                    contentsList1.add("자주 피운다");
                    contentsList1.add("애연가");
                    return FavorFragment.newInstance("당신은 흡연을\n하시나요?\uD83E\uDD14", contentsList1);
                case 1:
                    contentsList2.add("전혀 마시지 않는다");
                    contentsList2.add("거의 마시지 않는다");
                    contentsList2.add("종종 즐긴다");
                    contentsList2.add("자주 즐긴다");
                    contentsList2.add("매우 즐긴다");
                    return FavorFragment.newInstance("술을 얼마나\n즐기시나요?\uD83E\uDD14", contentsList2);
                case 2:
                    contentsList3.add("채식을 즐기지 않는다");
                    contentsList3.add("드물게 채식을 즐긴다");
                    contentsList3.add("종종 채식을 즐긴다");
                    contentsList3.add("플렉시테리언이다");
                    contentsList3.add("채식주의자다");
                    return FavorFragment.newInstance("채식주의자\n인가요?\uD83E\uDD14", contentsList3);
                case 3:
                    contentsList4.add("종교없음");
                    contentsList4.add("기독교");
                    contentsList4.add("천주교");
                    contentsList4.add("불교");
                    contentsList4.add("기타");
                    return FavorFragment.newInstance("당신은 종교가 \n있나요?\uD83E\uDD14", contentsList4);
                default:
                    return null;
            }
        }
    }
}

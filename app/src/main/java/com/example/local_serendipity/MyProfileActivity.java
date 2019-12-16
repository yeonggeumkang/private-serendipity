package com.example.local_serendipity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class MyProfileActivity extends AppCompatActivity {

    ArrayList user = new ArrayList();
    int count = 0;
    FragmentPagerAdapter adapterViewPager;

    boolean folded = true;
    String intro2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile_rel);

        //Set Setting Button
        Button btnSetting = (Button)findViewById(R.id.btn_setting);
        btnSetting.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyProfileActivity.this, EditProfileActivity.class);
                startActivity(intent);
            }
        });

        //기본정보 작성 index 0-3
        user.add("강영금");
        user.add("24");
        user.add("서울");
        user.add("여");

        //Favor(About Me) index 4-7
        user.add("비흡연자");
        user.add("종종 즐긴다");
        user.add("드물게 채식을 즐긴다");
        user.add("무교");

        //자기소개 index 8
        user.add(null);
        /*user.add("안녕하세요 저희는 성균관대학교 교육학과에서 현대학습이론 과목을 수강하며" +
                " 발표불안에 대한 탐구를 진행중입니다. 이에 여러분들의 발표불안에 대한 개인적인 " +
                "생각을 듣고자 본 설문을 진행하게 되었습니다. 본인의 주관적인 생각을 솔직하게 " +
                "답변해주시면 감사하겠습니다. 번호를 남겨주시면 추첨을 통해 소정의 기프티콘을 지급하도록 하겠습니다. 감사합니다! :D ");*/

        //진실거짓 index 9-11
        user.add("리버풀 만세");
        user.add("나의사랑 인천에프시나의사랑 인천에프시나의사랑 인천에프시나의사랑 인천에프시나의사랑 인천에프시나의사랑 인천에프시 ");
        user.add("수원삼성 만세");

        //성격/가치관 index 12-13
        user.add("미어캣");
        user.add("판다");

        //SET 기본정보 0-3
        TextView tvUserName = (TextView)findViewById(R.id.tv_user_name);
        tvUserName.setText((String) user.get(0));

        TextView tvUserAge = (TextView)findViewById(R.id.tv_age);
        tvUserAge.setText((String)user.get(1));

        TextView tvRegion = (TextView)findViewById(R.id.tv_region);
        tvRegion.setText((String) user.get(2));

        TextView tvGender = (TextView)findViewById(R.id.tv_gender);
        tvGender.setText((String) user.get(3));


        //SET FAVOR 4-7
        TextView tvContent1 = (TextView)findViewById(R.id.tv_content1);
        tvContent1.setText((String) user.get(4));

        TextView tvContent2 = (TextView)findViewById(R.id.tv_content2);
        tvContent2.setText((String) user.get(5));

        TextView tvContent3 = (TextView)findViewById(R.id.tv_content3);
        tvContent3.setText((String) user.get(6));

        TextView tvContent4 = (TextView)findViewById(R.id.tv_content4);
        tvContent4.setText((String) user.get(7));


        //SET INTRODUCTION (index 8)
        final TextView tvIntroduction = (TextView)findViewById(R.id.tv_intro);
        Button btnIntroduction = (Button)findViewById(R.id.btn_submit_intro);
        String intro = (String)user.get(8);

        final Button btnFold = (Button)findViewById(R.id.btn_fold);
        btnFold.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(folded==false){
                    //접어야함
                    btnFold.setRotationX(180);
                    tvIntroduction.setText(intro2+"…");
                    folded=true;
                } else {
                    // 펴야함
                    btnFold.setRotationX(180);
                    tvIntroduction.setText((String)user.get(8));
                    folded=false;
                }

            }
        });

        if(user.get(8) == null) {
            tvIntroduction.setVisibility(View.GONE);
            btnFold.setVisibility(View.GONE);
        } else if(intro.length()>72){
            intro2 = intro.substring(0, 70);
            tvIntroduction.setText(intro2+"…");
            btnIntroduction.setVisibility(View.GONE);
        } else {
            tvIntroduction.setText(intro);
            btnIntroduction.setVisibility(View.GONE);
            btnFold.setVisibility(View.GONE);
        }
        btnIntroduction.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MyProfileActivity.this, MyStoryActivity.class);
                    startActivity(intent);
                }
            });



        //SET true or false (index 9-11)
        GridLayout gridTF = (GridLayout)findViewById(R.id.grid_tf);
        ImageView ivTFNone = (ImageView)findViewById(R.id.iv_tf_none);
        TextView tvTFNone = (TextView)findViewById(R.id.tv_tf_none);

        TextView tvTF1 = (TextView)findViewById(R.id.tv_tf1);
        TextView tvTF2 = (TextView)findViewById(R.id.tv_tf2);
        TextView tvTF3 = (TextView)findViewById(R.id.tv_tf3);

        //if문 세부수정 필요 !!!!!
        if(user.get(9)==null && user.get(10)==null && user.get(11)==null ){
            gridTF.setVisibility(View.GONE);
        } else {
            ivTFNone.setVisibility(View.GONE);
            tvTFNone.setVisibility(View.GONE);

            tvTF1.setText((String)user.get(9));
            tvTF2.setText((String)user.get(10));
            tvTF3.setText((String)user.get(11));
        }

        //성격 레포트
        GridLayout gridPerson = (GridLayout)findViewById(R.id.grid_personality);
        Button btnPerson = (Button)findViewById(R.id.btn_personality);

        if(user.get(12)==null){
            gridPerson.setVisibility(View.GONE);
        } else {
            btnPerson.setVisibility(View.GONE);
        }

        //가치관 레포트
        GridLayout gridValues = (GridLayout)findViewById(R.id.grid_values);
        Button btnValues = (Button)findViewById(R.id.btn_values);

        if(user.get(13)==null){
            gridValues.setVisibility(View.GONE);
        } else {
            btnValues.setVisibility(View.GONE);
        }


        Button btnMorePer = (Button)findViewById(R.id.btn_more_per);
        btnMorePer.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyProfileActivity.this, ReportActivity.class);
                startActivity(intent);
            }
        });

        Button btnBack = (Button)findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        //ViewPager 적용
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyProfileActivity.MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(vpPager);

        /* 리사이클러뷰에 표시할 데이터 리스트 생성.
        ArrayList<String> list = new ArrayList<>();
        list.add("자전거");
        list.add("요가/필라테스");
        list.add("레슬링");
        list.add("3대운동 300");

        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        RecyclerView recyclerView = findViewById(R.id.recycler1) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)) ;

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        RecyclerAdapter adapter = new RecyclerAdapter(list) ;
        recyclerView.setAdapter(adapter) ; */

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
            return new InterestFragment();
        }
    }
}

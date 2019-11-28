package com.example.local_serendipity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class StoryActivity extends AppCompatActivity {

    private ClaimDialog mClaimDialog;
    ImageView ivProfileScore;
    TextView tvAvgScore;
    TextView tvScore;

    ImageView ivLine;
    LinearLayout layoutProfile;
    LinearLayout layoutScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        //점수 없는 케이스
        ivLine = (ImageView)findViewById(R.id.horizontal_line);
        layoutProfile = (LinearLayout)findViewById(R.id.layout_profile);
        //setInvisible(ivLine, layoutProfile);

        //점수 있는 케이스
        ivProfileScore = (ImageView)findViewById(R.id.iv_profile_score);
        tvAvgScore = (TextView)findViewById(R.id.tv_avg_score);
        tvScore = (TextView)findViewById(R.id.tv_score);
        setInvisible(ivProfileScore, tvAvgScore, tvScore);

        layoutScore = (LinearLayout)findViewById(R.id.layout_score);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();

        stars.getDrawable(2).setColorFilter(ContextCompat.getColor(this,
                R.color.colorRoyalBlue2), PorterDuff.Mode.SRC_ATOP);

        ratingBar.setOnRatingBarChangeListener(new Listener());


    }

    // Show Claim Dialog
    private View.OnClickListener backListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "신고 취소", Toast.LENGTH_SHORT).show();
            mClaimDialog.dismiss();
        }
    };

    private View.OnClickListener completeListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "신고 완료", Toast.LENGTH_SHORT).show();
            mClaimDialog.dismiss();
        }
    };

    public void OnClickHandlerClaim(View view){
        mClaimDialog = new ClaimDialog(this, backListener, completeListener);
        mClaimDialog.show();
    }

    private void setInvisible(View view1, View view2){
        view1.setVisibility(View.GONE);
        view2.setVisibility(View.GONE);
    }

    private void setInvisible(View view1, View view2, View view3){
        view1.setVisibility(View.GONE);
        view2.setVisibility(View.GONE);
        view3.setVisibility(View.GONE);
    }

    class Listener implements RatingBar.OnRatingBarChangeListener {

        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            layoutScore.setVisibility(View.GONE);
        }
    }
}

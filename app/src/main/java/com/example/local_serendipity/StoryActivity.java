package com.example.local_serendipity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StoryActivity extends AppCompatActivity {

    private ClaimDialog mClaimDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

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
}

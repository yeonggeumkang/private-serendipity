package com.example.local_serendipity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class ClaimDialog extends Dialog {

    private Button mBtnBack;
    private Button mBtnComplete;

    private View.OnClickListener mBackClickListener;
    private View.OnClickListener mCompleteClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);

        setContentView(R.layout.activity_claim_dialog);

        mBtnBack = (Button) findViewById(R.id.btn_close);
        mBtnComplete = (Button) findViewById(R.id.btn_submit);


        // 클릭 이벤트 셋팅
            mBtnBack.setOnClickListener(mBackClickListener);
            mBtnComplete.setOnClickListener(mCompleteClickListener);
    }


    // 클릭버튼이 확인과 취소 두개일때 생성자 함수로 이벤트를 받는다
    public ClaimDialog(Context context, View.OnClickListener backListener, View.OnClickListener completeListener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.mBackClickListener = backListener;
        this.mCompleteClickListener = completeListener;
    }
}
package com.example.local_serendipity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class CustomDialogChat extends Dialog {

    private Button mSendButton;
    private Button mCancelButton;
    
    private View.OnClickListener mSendClickListener;
    private View.OnClickListener mCancelClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);

        setContentView(R.layout.activity_custom_dialog_chat);


        mSendButton = (Button) findViewById(R.id.btn_send);
        mCancelButton = (Button) findViewById(R.id.btn_cancel);


        // 클릭 이벤트 셋팅
        mSendButton.setOnClickListener(mSendClickListener);
        mCancelButton.setOnClickListener(mCancelClickListener);

    }


    // 클릭버튼이 확인과 취소 두개일때 생성자 함수로 이벤트를 받는다
    public CustomDialogChat(Context context, View.OnClickListener sendListener,
                            View.OnClickListener cancelListener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.mSendClickListener = sendListener;
        this.mCancelClickListener = cancelListener;
    }
}
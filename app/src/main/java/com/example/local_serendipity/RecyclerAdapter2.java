package com.example.local_serendipity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.ViewHolder> {

    private ArrayList<String> mData = null ;

    // 아이템 뷰를 저장하는 클래스 : 뷰홀더
    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btnItem ;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체 참조
            btnItem = itemView.findViewById(R.id.btn_item) ;
        }
    }

    // (1) 생성자
    RecyclerAdapter2(ArrayList<String> list) {
        mData = list ;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.layout_interest_item, parent, false) ;
        ViewHolder vh = new ViewHolder(view) ;

        return vh ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String text = mData.get(position) ;
        holder.btnItem.setText(text);

        int len = mData.get(position).length(); //단어의 길이.
        ViewGroup.LayoutParams param = holder.btnItem.getLayoutParams();
        switch(len){
            case 2:
                param.width = 165;
                break;
            case 3:
                param.width = 190;
                break;
            case 4:
                param.width = 220;
                break;
            case 5:
                param.width = 260;
                break;
            case 6:
                param.width = 300;
                break;
            case 7:
                param.width = 310;
                break;
            case 8:
                param.width = 345;
                break;
        }
        holder.btnItem.setLayoutParams(param);
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() ;
    }
}
package com.example.app.rst;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app.R;

import java.util.List;

/**
 * List를 띄워주는 느낌
 * 텍스트 뷰의 아이디에 객체 속성값을 하나하나 넣어주는 느낌
 * 받아온 데이터 중, RecyclerView에 넣어 줄 것을 정의함.
 */


public class RstAdapter extends RecyclerView.Adapter<RstAdapter.ViewHolder> {
    //  RecyclerView의 NestedClass인 Adapter클래스를 상속받음.


    private List<Rst> rsts;

    public RstAdapter(List<Rst> rsts) {
        this.rsts = rsts;
    }

    @Override
    public RstAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RstAdapter.ViewHolder viewHolder, int i) {

        viewHolder.rst_name.setText(rsts.get(i).getRst_name());
        viewHolder.catag_nm.setText(rsts.get(i).getCatag_nm());
        viewHolder.rst_loc.setText(rsts.get(i).getLoc());

    }

    @Override
    public int getItemCount() {
        return rsts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView rst_name, catag_nm, rst_loc;

        public ViewHolder(View view) {
            super(view);

            rst_name = (TextView)view.findViewById(R.id.rst_name);
            catag_nm = (TextView)view.findViewById(R.id.catag_nm);
            rst_loc = (TextView)view.findViewById(R.id.rst_loc);

        }
    }
}
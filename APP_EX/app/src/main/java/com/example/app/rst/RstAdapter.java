package com.example.app.rst;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * List를 띄워주는 느낌
 * 텍스트 뷰의 아이디에 객체 속성값을 하나하나 넣어주는 느낌
 * 받아온 데이터 중, RecyclerView에 넣어 줄 것을 정의함.
 */

public class RstAdapter extends RecyclerView.Adapter<RstAdapter.ViewHolder> {
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

        viewHolder.tv_name.setText(rsts.get(i).getRst_name());
        viewHolder.tv_version.setText(rsts.get(i).getLoc_dtl());
        viewHolder.tv_api_level.setText(rsts.get(i).getLoc());
    }

    @Override
    public int getItemCount() {
        return rsts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name,tv_version,tv_api_level;
        public ViewHolder(View view) {
            super(view);

            tv_name = (TextView)view.findViewById(R.id.tv_name);
            tv_version = (TextView)view.findViewById(R.id.tv_version);
            tv_api_level = (TextView)view.findViewById(R.id.tv_api_level);

        }
    }
}

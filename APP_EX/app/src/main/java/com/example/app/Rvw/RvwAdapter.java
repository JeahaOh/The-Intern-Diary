package com.example.app.Rvw;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app.R;

import java.util.List;


public class RvwAdapter extends RecyclerView.Adapter<RvwAdapter.ViewHolder> {

    private List<Rvw> rvws;
    private Rvw rvw;
    private String rst_nm;

    public RvwAdapter(List<Rvw> rvws) {
        this.rvws = rvws;
    }

    @Override
    public RvwAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i ) {

        View view = LayoutInflater
                .from( viewGroup.getContext() )
                .inflate( R.layout.rvw_card, viewGroup, false );

        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, final int position ) {
        //  Adapter에게 받았던 ViewHolder 객체와 리스트에서 해당 ViewHolder의 위치를 인자로 전달받음.
        //  ViewHolder 안의 View에 데이터를 넣어줌.
        //  View에 들어 가는 내용을 정의 해 줌.
        viewHolder.user_id.setText( rvws.get(position).getId() );
        viewHolder.cont.setText( rvws.get(position).getCont() );
        viewHolder.cdt.setText( rvws.get(position).getCdt() );

        viewHolder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rvwIntent = new Intent(v.getContext(), RvwDetail.class);
                rvw = rvws.get(position);
                rvwIntent.putExtra("rvw", rvw);
                rvwIntent.putExtra("rst_name", rst_nm );
                v.getContext().startActivity( rvwIntent );
            }
        });

        switch ( rvws.get(position).getScore() ) {
            case 1 :
                viewHolder.score.setText( "최악이예요" );
                return;
            case 2 :
                viewHolder.score.setText( "별로예요" );
                return;
            case 3 :
                viewHolder.score.setText( "무난해요" );
                return;
            case 4 :
                viewHolder.score.setText( "맛있어요" );
                return;
            case 5 :
                viewHolder.score.setText( "강추해요" );
                return;
        }
    }

    @Override
    public int getItemCount() {
        return rvws.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView user_id, cont, score, cdt;
        public ViewHolder( View view ) {
            super( view );
            user_id = view.findViewById( R.id.user_id );
            cont    = view.findViewById( R.id.cont );
            score   = view.findViewById( R.id.score );
            cdt     = view.findViewById( R.id.cdt );
        }
    }

    public void setRst_nm(String rst_nm) {
        this.rst_nm = rst_nm;
    }
}
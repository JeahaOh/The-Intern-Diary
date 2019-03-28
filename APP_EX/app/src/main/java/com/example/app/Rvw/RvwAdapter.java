package com.example.app.Rvw;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app.R;

import java.util.List;


public class RvwAdapter extends RecyclerView.Adapter<RvwAdapter.ViewHolder> {
    //  RecyclerView의 NestedClass인 Adapter클래스를 상속받음.

    private List<Rvw> rvws;
    private Rvw rvw;

    public RvwAdapter(List<Rvw> rvws) {
        this.rvws = rvws;

        Log.v("ADAPTER RVWS SIZE", Integer.toString( rvws.size() ) );
    }

    @Override
    public RvwAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i ) {

        View view = LayoutInflater
                .from( viewGroup.getContext() )
                .inflate( R.layout.rvw_card, viewGroup, false );

        return new ViewHolder( view );
    }


    @Override
    public void onBindViewHolder( ViewHolder viewHolder, final int i ) {
        //  Adapter에게 받았던 ViewHolder 객체와 리스트에서 해당 ViewHolder의 위치를 인자로 전달받음.
        //  ViewHolder 안의 View에 데이터를 넣어줌.
        //  View에 들어 가는 내용을 정의 해 줌.
        viewHolder.user_id.setText( rvws.get(i).getId() );
        viewHolder.cont.setText( rvws.get(i).getCont() );
        viewHolder.cdt.setText( rvws.get(i).getCdt() );
        rvw = rvws.get(i);

        viewHolder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent rvwIntent = new Intent(v.getContext(), RvwDetail.class);
                rvwIntent.putExtra("rvw", rvw);
//                rvwIntent.putExtra("rvw_name", rvw_name);
                rvwIntent.putExtra("index", i);
                v.getContext().startActivity(rvwIntent);

            }
        });


        switch ( rvws.get(i).getScore() ) {
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
            user_id = (TextView)view.findViewById( R.id.user_id );
            cont = (TextView)view.findViewById( R.id.cont );
            score = (TextView)view.findViewById( R.id.score );
            cdt = (TextView)view.findViewById( R.id.cdt );
        }
    }
}
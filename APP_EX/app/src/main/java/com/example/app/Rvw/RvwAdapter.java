package com.example.app.Rvw;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.Request.RetrofitClient;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RvwAdapter extends RecyclerView.Adapter<RvwAdapter.ViewHolder> {
    //  RecyclerView의 NestedClass인 Adapter클래스를 상속받음.

    private List<Rvw> rvws;

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

        viewHolder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(), i+"", Toast.LENGTH_SHORT).show();
//                Intent rvwDetail = new Intent( context, RvwDetail.class );
//
//                System.out.println("itemView.onClick()");
//                Log.v("itemView.onClick()", i + "");
//                Rvw rvw = rvws.get(i);
//
//                rvwDetail.putExtra("rvw", rvw);
//                System.out.println(rvw.toString());
//
//
//                v.getContext().startActivities(rvwDetail);
            }
        });
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
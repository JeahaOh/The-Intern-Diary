package com.example.app.Rst;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.MainActivity;
import com.example.app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * List를 띄워주는 느낌
 * 텍스트 뷰의 아이디에 객체 속성값을 하나하나 넣어주는 느낌
 * 받아온 데이터 중, RecyclerView에 넣어 줄 것을 정의함.
 *
 * Adapter란 무엇인가
 * Android APIs' Reference에 따르면
 * 'Adapter' 자체는 하나의 Object(객체)로서,
 * 보여지는 View와 그 View에 올릴 Data를 연결하는 일종의 Bridge라고 한다.
 *
 * 데이터의 원본을 받아서 관리하고, 어댑터뷰가 출력할 수 있는 형태로 데이터를 제공하는 중간 객체.
 *
 * 그래서 그런지 ListView Adapter에 대한 예시에서도, GalleryAdapter에 대한 예시에서도
 * 해당 Adapter의 생성자에서 Data를 연결하고 나서
 * getView() method에서 해당 position에 올라갈 TextView나 ImageView를 setting 해 View로서 뿌려주는 모양이다.
 */

//  RecyclerView의 NestedClass인 Adapter클래스를 상속받음.
public class RstAdapter extends RecyclerView.Adapter<RstAdapter.ViewHolder> {

    //  최초에 서버에서 받아올 rstList
    private List<Rst> originRstList;
    //  화면에 보여줄 rstList
    private ArrayList<Rst> showList;
    private Rst rst;


    public RstAdapter( List<Rst> originRstList) {
        this.originRstList = originRstList;
        showList = new ArrayList<Rst>();
        showList.addAll(originRstList);
    }

    @Override
    public RstAdapter.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i ) {
        /** ViewHolder Pattern :
         * 리스트 뷰의 유연한 동작을 위해 나타남.
         * TextView를 생성 하기 위해 매번 findByViewId() 호출 하는 것을 해결하기 위해 나온 녀석.
         * 각 View의 객체를 ViewHolder에 hold 시켜서 리소스를 절약함.
         */

        View view = LayoutInflater
                /** LayoutInflater :
                 * XML에 정의된 Resource(자원) 들을 View의 형태로 반환해 줌.
                 * 보통 자바 코드에서 View, ViewGroup 을 사용하거나,
                 * Adpter의 getview() 또는 Dialog, Popup 구현시
                 * 배경화면이 될 Layout을 만들어 놓고 View의 형태로 반환 받아 Acitivity에서 실행 함.
                 *
                 * 우리가 보통 Activity를 만들면 onCreate() 메서드에 기본으로 추가되는
                 * setContentView( R.layout.activity_main ) 메서드와 같은 원리라고 생각하시면 됩니다.
                 * 이 메서드 또한 activity_main.xml 파일을 View로 만들어서 Activity 위에 보여주고 있습니다.
                 * 사용자의 화면에 보여지는 것들은 Activity 위에 있는 View라는 점을 잊지 말아 주세요.
                 */
                .from( viewGroup.getContext() )
                .inflate( R.layout.card_row, viewGroup, false );

        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, final int i ) {
        //  Adapter에게 받았던 ViewHolder 객체와 리스트에서 해당 ViewHolder의 위치를 인자로 전달받음.
        //  ViewHolder 안의 View에 데이터를 넣어줌.
        //  View에 들어 가는 내용을 정의 해 줌.
        rst = showList.get(i);

        viewHolder.rst_name.setText( rst.getRst_name() );
        viewHolder.catag_nm.setText( rst.getCatag_nm() );
        viewHolder.rst_loc.setText( rst.getLoc() );
        viewHolder.star.setText( rst.getStarGrade() );

//        viewHolder.rst_name.setText( showList.get(i).getRst_name() );
//        viewHolder.catag_nm.setText( showList.get(i).getCatag_nm() );
//        viewHolder.rst_loc.setText( showList.get(i).getLoc() );
//        viewHolder.star.setText( showList.get(i).getStarGrade() );

        //  onClickListener와 원하는 화면을 넘겨주는 Intent를 넣어?
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //  인텐트 선언.
            Intent intent = new Intent(v.getContext(), RstDetail.class);

            //  rst_detail 인텐트에 넘겨줄 데이터 정의 해야함.
            intent.putExtra("rst", rst);

//            intent.putExtra( "rst_no", showList.get(i).getRst_no() );
//            intent.putExtra( "rst_name", showList.get(i).getRst_name() );
//            intent.putExtra( "loc_dtl", showList.get(i).getLoc_dtl() );
//            intent.putExtra( "opn_tm", showList.get(i).getOpn_tm() );
//            intent.putExtra( "brck_tm", showList.get(i).getBrck_tm() );
//            intent.putExtra( "dnnr_tm", showList.get(i).getDnnr_tm() );
//            intent.putExtra( "lo_tm", showList.get(i).getLo_tm() );
//            intent.putExtra( "rst_phot", showList.get(i).getRst_phot() );
//            intent.putExtra( "starGrade", showList.get(i).getStarGrade() );
//            intent.putExtra( "tel", showList.get(i).getTel() );

            // 인텐트 시작
            v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //  얼마나 많은 데이터가 있는지 Adapter에게 알려줘야 해서 핋요한 메소드
        return showList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView rst_name, catag_nm, rst_loc, star;

        public ViewHolder( View view ) {
            super( view );

            rst_name = (TextView)view.findViewById( R.id.rst_name );
            catag_nm = (TextView)view.findViewById( R.id.catag_nm );
            rst_loc = (TextView)view.findViewById( R.id.rst_loc );
            star = (TextView)view.findViewById( R.id.star );

        }
    }

    //  List를 min_price로 filter하는 메소드
    public void filter( ArrayList<Integer> selectList ){
        Log.d("filter recieve \n=>", selectList.toString() );
        //  필터 메소드를 호출 할 경우 화면에 보이는 rstList를 비움.
        showList.clear();

        //  가격대를 선택하지 않으면 모든 가격대의 식당을 보여줌
        if( selectList.size() == 0 ) {
            showList.addAll( originRstList );
        }   else {
            //  전체 식당 리스트의 식당이
            for( Rst rst : originRstList ) {
                //  가격 조건과 맞다면
                if( selectList.contains( rst.getMin_price() ) ){
                    //  화면에 보여줌.
                    showList.add(rst);
                }
                //  5만원 이상을 선택 할 경우
                if(selectList.contains(5)) {
                    if(  rst.getMin_price() >= 6 ){
                        showList.add(rst);
                    }
                }
            }
        }
        //  화면에 보여줄 item 갯수가 변하였으므로 다시 count
        getItemCount();
        //  화면에 보여주는 list가 바뀌었음을 알려줌
        notifyDataSetChanged();
    }
}
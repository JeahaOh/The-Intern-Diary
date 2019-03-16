package com.example.app.rst;

public class Rst {
    private int rst_no;         //  레스토랑 번호
    private String rst_name;    //  레스토랑 이름
    private int star;           //  미슐렝 별점
    private String loc;         //  지역
    private String loc_dtl;     //  상세 주소
    private int upper_no;       //  요리 대분류 코드
    private String upper_nm;    //  요리 대분류 이름
    private int catag_no;       //  요리 소분류 코드
    private String catag_nm;    //  요리 소분류 이름
    private String tel;         //  전화번호
    private String opn_tm;      //  오픈 시간
    private String brck_tm;     //  점심 쉬는 시간
    private String dnnr_tm;     //  저녁 장사 시작 시간
    private String lo_tm;       //  주문 마감 시간


    public int getRst_no()      { return  rst_no; }
    public String getRst_name() {
        return rst_name;
    }
    public int getStar()        { return star; }
    public String getLoc()      { return loc; }
    public String getLoc_dtl()  { return loc_dtl; }
    public int getUpper_no()    { return upper_no; }
    public String getUpper_nm() { return upper_nm; }
    public int getCatag_no()    { return catag_no; }
    public String getCatag_nm() { return catag_nm; }
    public String getTel()      { return tel; }
    public String getOpn_tm()   { return opn_tm; }
    public String getBrck_tm()  { return brck_tm; }
    public String getDnnr_tm()  { return dnnr_tm; }
    public String getLo_tm()    { return lo_tm; }
}

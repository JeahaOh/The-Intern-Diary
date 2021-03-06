package com.example.app.Rst;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Spring com.yummy의 Rst와 맞대응 하는 VO 객체.
 */
public class Rst implements Serializable {
    private static final long serialVersionUID = 1L;

    @Expose
    @SerializedName("rst_no")
    private int rst_no;         //  레스토랑 번호

    @Expose
    @SerializedName("rst_name")
    private String rst_name;    //  레스토랑 이름

    @Expose
    @SerializedName("star")
    private int star;           //  미슐렝 별점

    @Expose
    @SerializedName("starGrade")
    private String starGrade;   //  미슐렝 별점의 문자열

    @Expose
    @SerializedName("loc")
    private String loc;         //  지역

    @Expose
    @SerializedName("loc_dtl")
    private String loc_dtl;     //  상세 주소

    @Expose
    @SerializedName("upper_nm")
    private String upper_nm;    //  요리 대분류 이름

    @Expose
    @SerializedName("catag_no")
    private int catag_no;       //  요리 소분류 코드

    @Expose
    @SerializedName("catag_nm")
    private String catag_nm;    //  요리 소분류 이름

    @Expose
    @SerializedName("tel")
    private String tel;         //  전화번호

    @Expose
    @SerializedName("opn_tm")
    private String opn_tm;      //  오픈 시간

    @Expose
    @SerializedName("brck_tm")
    private String brck_tm;     //  점심 쉬는 시간

    @Expose
    @SerializedName("dnnr_tm")
    private String dnnr_tm;     //  저녁 장사 시작 시간

    @Expose
    @SerializedName("lo_tm")
    private String lo_tm;       //  주문 마감 시간

    @Expose
    @SerializedName("rst_phot")
    private String rst_phot;    //  사진 이름

    @Expose
    @SerializedName("min_price")
    private int min_price;      //  메뉴 최저 가격

    public String getLoc() {
        if( loc == null || loc.equals("") ) {
            return "분당구";
        }
        return loc;
    }

    public String getLoc_dtl() {
        if( loc_dtl == null || loc_dtl.equals("") || loc_dtl.length() < 3 ) {
            return "성남대로 925번길 41";
        }
        return loc_dtl;
    }

    public int getRst_no()      { return  rst_no; }
    public String getRst_name() {
        return rst_name;
    }
    public int getStar()        { return star; }
    public String getStarGrade(){ return starGrade; }
    public String getCatag_nm() { return catag_nm; }
    public String getTel()      { return tel; }
    public String getOpn_tm()   { return opn_tm; }
    public String getBrck_tm()  { return brck_tm; }
    public String getDnnr_tm()  { return dnnr_tm; }
    public String getLo_tm()    { return lo_tm; }
    public String getRst_phot() { return rst_phot; }
    public int getMin_price()   { return min_price; }
}

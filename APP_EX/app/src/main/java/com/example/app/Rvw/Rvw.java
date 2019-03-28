package com.example.app.Rvw;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rvw {
    @Expose
    @SerializedName("rvw_no")
    int rvw_no;   //  리뷰 번호
    @Expose
    @SerializedName("rst_no")
    int rst_no;   //  레스토랑 번호
    @Expose
    @SerializedName("id")
    String id;    //  게시자 아이디
    @Expose
    @SerializedName("cont")
    String cont;  //  리뷰 내용
    @Expose
    @SerializedName("cdt")
    String cdt;   //  리뷰 생성일
    @Expose
    @SerializedName("score")
    int score;    //  리뷰 평점
    @Expose
    @SerializedName("rvw_phot")
    String rvw_phot;

    public Rvw () { }
    public Rvw(int rst_no, String id, String cont, int score) {}

    public Rvw(int rvw_no, int rst_no, String id, String cont, String cdt, int score) {
        this.rvw_no = rvw_no;
        this.rst_no = rst_no;
        this.id = id;
        this.cont = cont;
        this.cdt = cdt;
        this.score = score;
    }

    public int getRvw_no() {
        return rvw_no;
    }

    public int getRst_no() {
        return rst_no;
    }

    public String getId() {
        return id;
    }

    public String getCont() {
        return cont;
    }

    public String getCdt() {
        return cdt;
    }

    public int getScore() {
        return score;
    }

    public String getRvw_phot() {
        return rvw_phot;
    }

    @Override
    public String toString() {
        return "Rvw{" +
                "rvw_no=" + rvw_no +
                ", rst_no=" + rst_no +
                ", id='" + id + '\'' +
                ", cont='" + cont + '\'' +
                ", cdt='" + cdt + '\'' +
                ", score=" + score +
                ", rvw_phot=" + rvw_phot +
                '}';
    }
}

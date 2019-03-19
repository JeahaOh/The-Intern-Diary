package com.example.app.Rvw;

public class Rvw {
    int rvw_no;   //  리뷰 번호
    int rst_no;   //  레스토랑 번호
    String id;    //  게시자 아이디
    String cont;  //  리뷰 내용
    String cdt;   //  리뷰 생성일
    int score;    //  리뷰 평점

    public Rvw () { }
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

    @Override
    public String toString() {
        return "Rvw{" +
                "rvw_no=" + rvw_no +
                ", rst_no=" + rst_no +
                ", id='" + id + '\'' +
                ", cont='" + cont + '\'' +
                ", cdt='" + cdt + '\'' +
                ", score=" + score +
                '}';
    }
}

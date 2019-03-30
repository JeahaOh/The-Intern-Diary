package com.example.app.Memb;

/**
 * 회원 가입 기능을 만들기에 시간이 부족함으로
 * Singleton Pattern의 Memb 객체로 대체함.
 */

public class Memb {
    String id;      //  회원 아이디
    String pwd;     //  회원 비밀번호
    Boolean adm;    //  관리자 여부

    private static Memb memb;

    private Memb( ) { }

    public static Memb getMemb() {
        if( memb == null ) {
            memb = new Memb();
            memb.id = "asdf1020";
            memb.pwd = null;
            memb.adm = true;
        }
        return memb;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Memb{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", adm=" + adm +
                '}';
    }
}

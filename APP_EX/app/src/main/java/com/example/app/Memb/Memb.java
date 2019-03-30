package com.example.app.Memb;

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

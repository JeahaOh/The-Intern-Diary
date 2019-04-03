package com.example.app.Menu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Menu {

//    @Expose
//    @SerializedName("mn_no")
//    int mn_no;    //  메뉴 번호
//
//    @Expose
//    @SerializedName("rst_no")
//    int rst_no;   //  메뉴를 가지고 있는 식당 번호

    @Expose
    @SerializedName("menu")
    String menu;  //  메뉴

    @Expose
    @SerializedName("price")
    int price;    //  메뉴 가격

    public Menu() { }

//    public int getMn_no() { return mn_no; }
//    public int getRst_no() { return rst_no; }
    public String getMenu() { return menu; }
    public int getPrice() { return price; }
}

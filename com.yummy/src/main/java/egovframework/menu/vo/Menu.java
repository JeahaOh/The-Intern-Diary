package egovframework.menu.vo;

public class Menu {
  int mn_no;    //  메뉴 번호
  int rst_no;   //  메뉴를 가지고 있는 식당 번호
  String menu;  //  메뉴
  int price;    //  메뉴 가격
  
  public Menu() {   }
  
  public Menu(int mn_no, int rst_no, String menu, int price) {
    super();
    this.mn_no = mn_no;
    this.rst_no = rst_no;
    this.menu = menu;
    this.price = price;
  }
  
  public int getMn_no() {
    return mn_no;
  }
  public void setMn_no(int mn_no) {
    this.mn_no = mn_no;
  }
  public int getRst_no() {
    return rst_no;
  }
  public void setRst_no(int rst_no) {
    this.rst_no = rst_no;
  }
  public String getMenu() {
    return menu;
  }
  public void setMenu(String menu) {
    this.menu = menu;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  
  @Override
  public String toString() {
    return "Menu [menu = " + menu + ", price = " + price + ", mn_no=" + mn_no + ", rst_no=" + rst_no + "]";
  }
}

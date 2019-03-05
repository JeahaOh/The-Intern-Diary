package egovframework.catag.vo;

public class Catag {
  int catag_no;
  int upper_no;
  String catag_nm;
  
  public Catag() { super(); }

  public Catag(int catag_no, int upper_no, String catag_nm) {
    super();
    this.catag_no = catag_no;
    this.upper_no = upper_no;
    this.catag_nm = catag_nm;
  }

  public int getCatag_no() {
    return catag_no;
  }

  public void setCatag_no(int catag_no) {
    this.catag_no = catag_no;
  }

  public int getUpper_no() {
    return upper_no;
  }

  public void setUpper_no(int upper_no) {
    this.upper_no = upper_no;
  }

  public String getCatag_nm() {
    return catag_nm;
  }

  public void setCatag_nm(String catag_nm) {
    this.catag_nm = catag_nm;
  }

  @Override
  public String toString() {
    return "Catag [catag_no=" + catag_no + ", upper_no=" + upper_no + ", catag_nm=" + catag_nm
        + "]";
  }
}

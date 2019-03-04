package egovframework.rst.vo;

public class Rst {
  int rst_no;
  String rst_name;
  int star;
  String loc;
  String loc_dtl;
  int catag_no;
  String catag_name;
  String tel;
  String opn_tm;
  String brck_tm;
  String dnnr_tm;
  String lo_tm;
  
  public Rst() {}

  public Rst(int rst_no, String rst_name, int star, String loc, String loc_dtl, int catag_no,
      String catag_name, String tel, String opn_tm, String brck_tm, String dnnr_tm, String lo_tm) {
    super();
    this.rst_no = rst_no;
    this.rst_name = rst_name;
    this.star = star;
    this.loc = loc;
    this.loc_dtl = loc_dtl;
    this.catag_no = catag_no;
    this.catag_name = catag_name;
    this.tel = tel;
    this.opn_tm = opn_tm;
    this.brck_tm = brck_tm;
    this.dnnr_tm = dnnr_tm;
    this.lo_tm = lo_tm;
  }

  public int getRst_no() {
    return rst_no;
  }

  public void setRst_no(int rst_no) {
    this.rst_no = rst_no;
  }

  public String getRst_name() {
    return rst_name;
  }

  public void setRst_name(String rst_name) {
    this.rst_name = rst_name;
  }

  public int getStar() {
    return star;
  }

  public void setStar(int star) {
    this.star = star;
  }

  public String getLoc() {
    return loc;
  }

  public void setLoc(String loc) {
    this.loc = loc;
  }

  public String getLoc_dtl() {
    return loc_dtl;
  }

  public void setLoc_dtl(String loc_dtl) {
    this.loc_dtl = loc_dtl;
  }

  public int getCatag_no() {
    return catag_no;
  }

  public void setCatag_no(int catag_no) {
    this.catag_no = catag_no;
  }

  public String getCatag_name() {
    return catag_name;
  }

  public void setCatag_name(String catag_name) {
    this.catag_name = catag_name;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getOpn_tm() {
    return opn_tm;
  }

  public void setOpn_tm(String opn_tm) {
    this.opn_tm = opn_tm;
  }

  public String getBrck_tm() {
    return brck_tm;
  }

  public void setBrck_tm(String brck_tm) {
    this.brck_tm = brck_tm;
  }

  public String getDnnr_tm() {
    return dnnr_tm;
  }

  public void setDnnr_tm(String dnnr_tm) {
    this.dnnr_tm = dnnr_tm;
  }

  public String getLo_tm() {
    return lo_tm;
  }

  public void setLo_tm(String lo_tm) {
    this.lo_tm = lo_tm;
  }

  @Override
  public String toString() {
    return "Rst [rst_no=" + rst_no + ", rst_name=" + rst_name + ", star=" + star + ", loc=" + loc
        + ", loc_dtl=" + loc_dtl + ", catag_no=" + catag_no + ", catag_name=" + catag_name
        + ", tel=" + tel + ", opn_tm=" + opn_tm + ", brck_tm=" + brck_tm + ", dnnr_tm=" + dnnr_tm
        + ", lo_tm=" + lo_tm + "]";
  }
}

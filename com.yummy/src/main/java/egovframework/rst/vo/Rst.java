package egovframework.rst.vo;

public class Rst {
  int rst_no;
  String rst_name;
  int star;
  String loc;
  String loc_dtl;
  int upper_no;
  int catag_no;
  String catag_nm;
  String tel;
  String opn_tm;
  String brck_tm;
  String dnnr_tm;
  String lo_tm;
  
  //String[] pht_nm;
  
  public Rst() {}

  public Rst(int rst_no, String rst_name, int star, String loc, String loc_dtl, int catag_no, int upper_no,
      String catag_nm, String tel, String opn_tm, String brck_tm, String dnnr_tm, String lo_tm) {
    super();
    this.rst_no = rst_no;
    this.rst_name = rst_name;
    this.star = star;
    this.loc = loc;
    this.loc_dtl = loc_dtl;
    this.catag_no = catag_no;
    this.catag_nm = catag_nm;
    this.upper_no = upper_no;
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
  
  public int getUpper_no() {
    return upper_no;
  }

  public void setUpper_no(int upper_no) {
    this.upper_no = upper_no;
  }

  public String getcatag_nm() {
    return catag_nm;
  }

  public void setcatag_nm(String catag_nm) {
    this.catag_nm = catag_nm;
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
    if ( opn_tm == "" || opn_tm == null || opn_tm.length() < 0 ) {
      this.opn_tm = "00:00";
    } else {
      this.opn_tm = opn_tm;
    }
  }

  public String getBrck_tm() {
    if( brck_tm == dnnr_tm ) {
      brck_tm = "00:00";
    }
    return brck_tm;
  }

  public void setBrck_tm(String brck_tm) {
    if ( brck_tm == "" || brck_tm == null || brck_tm.length() < 0 ) {
      this.brck_tm = "00:00";
    } else {
      this.brck_tm = brck_tm;
    }
  }

  public String getDnnr_tm() {
    if( brck_tm == dnnr_tm ) {
      dnnr_tm = "00:00";
    }
    return dnnr_tm;
  }

  public void setDnnr_tm(String dnnr_tm) {
    if ( dnnr_tm == "" || dnnr_tm == null  || dnnr_tm.length() < 0 ) {
      this.dnnr_tm = "00:00";
    } else {
      this.dnnr_tm = dnnr_tm;
    }
    
  }

  public String getLo_tm() {
    return lo_tm;
  }

  public void setLo_tm(String lo_tm) {
    if ( lo_tm == "" || lo_tm == null || lo_tm.length() < 0) {
      this.lo_tm = "00:00";
    } else {
      this.lo_tm = lo_tm;
    }
  }

  @Override
  public String toString() {
    return "\nRst\t==>>\t[rst_no=" + rst_no + ", rst_name=" + rst_name + ", star=" + star + ", loc=" + loc
        + ", loc_dtl=" + loc_dtl + ", catag_no=" + catag_no + ", upper_no=" + upper_no + ", catag_nm=" + catag_nm
        + ", tel=" + tel + ", opn_tm=" + opn_tm + ", brck_tm=" + brck_tm + ", dnnr_tm=" + dnnr_tm
        + ", lo_tm=" + lo_tm + "]";
  }
}
/*
    if( this.getStar() == -1 ) {
      this.star_name = "Bib Groumand";
    } else if ( this.getStar() == -2 ) {
      this.star_name = "The Plate";
    } else {
      this.star_name = Integer.toString(this.getStar());
    }
*/

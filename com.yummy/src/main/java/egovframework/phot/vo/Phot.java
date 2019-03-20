package egovframework.phot.vo;

public class Phot {
  //  DB설계시 int 형인줄 알고 no라고 이름을 붙였으나 String였음..
  //  차후에 알게되어 이름을 바꾸지 않았음..
  //  phot의 이름. primary key
  String phot_no;
  int rst_no;
  int rvw_no;
  
  
  public Phot( ) {  }

  public Phot(String phot_no, int rst_no, int rvw_no) {
    super();
    this.phot_no = phot_no;
    this.rst_no = rst_no;
    this.rvw_no = rvw_no;
  }

  public String getPhot_no() {
    return phot_no;
  }

  public void setPhot_no(String phot_no) {
    this.phot_no = phot_no;
  }

  public int getRst_no() {
    return rst_no;
  }

  public void setRst_no(int rst_no) {
    this.rst_no = rst_no;
  }

  public int getRvw_no() {
    return rvw_no;
  }

  public void setRvw_no(int rvw_no) {
    this.rvw_no = rvw_no;
  }

  @Override
  public String toString() {
    return "\nPhot [phot_no=" + phot_no + ", rst_no=" + rst_no + ", rvw_no=" + rvw_no + "]";
  }
  
}

package egovframework.rvw.vo;

public class Rvw {
  int rvw_no;
  int rst_no;
  String id;
  String cont;
  String cdt;
  int score;
  char useyn;
  
  public Rvw() {  }
  public Rvw(int rvw_no, int rst_no, String id, String cont, String cdt, int score, char useyn) {
    super();
    this.rvw_no = rvw_no;
    this.rst_no = rst_no;
    this.id = id;
    this.cont = cont;
    this.cdt = cdt;
    this.score = score;
    this.useyn = useyn;
  }
  
  public int getRvw_no() {
    return rvw_no;
  }
  public void setRvw_no(int rvw_no) {
    this.rvw_no = rvw_no;
  }
  public int getRst_no() {
    return rst_no;
  }
  public void setRst_no(int rst_no) {
    this.rst_no = rst_no;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getCont() {
    return cont;
  }
  public void setCont(String cont) {
    this.cont = cont;
  }
  public String getCdt() {
    return cdt;
  }
  public void setCdt(String cdt) {
    this.cdt = cdt;
  }
  public int getScore() {
    return score;
  }
  public void setScore(int score) {
    this.score = score;
  }
  public char getUseyn() {
    return useyn;
  }
  public void setUseyn(char useyn) {
    this.useyn = useyn;
  }
  @Override
  public String toString() {
    return "Rvw [rvw_no=" + rvw_no + ", rst_no=" + rst_no + ", id=" + id + ", cont=" + cont
        + ", cdt=" + cdt + ", score=" + score + ", useyn=" + useyn + "]";
  }
}

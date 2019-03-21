package egovframework.rvw.vo;

import egovframework.dflt.DefaultVO;

public class Rvw extends DefaultVO {
  
  private static final long serialVersionUID = 1L;
  
  int rvw_no;       //  리뷰 번호
  int rst_no;       //  레스토랑 번호
  String id;        //  게시자 아이디
  String cont;      //  리뷰 내용
  String cdt;       //  리뷰 생성일
  int score;        //  리뷰 평점
  char useyn;       //  사용 여부
  String rvw_phot;   //  사진 이름
  
  public Rvw() {  }
  public Rvw(
      int rvw_no, int rst_no, String id, String cont, String cdt, int score, char useyn, String rvw_phot
      ) {
    super();
    this.rvw_no = rvw_no;
    this.rst_no = rst_no;
    this.id = id;
    this.cont = cont;
    this.cdt = cdt;
    this.score = score;
    this.useyn = useyn;
    this.rvw_phot = rvw_phot;
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
  public String getRvw_phot() {
    return rvw_phot;
  }
  public void setRvw_phot( String rvw_phot ) {
    this.rvw_phot = rvw_phot;
  }
  
  @Override
  public String toString() {
    return "\n\tRvw [rvw_no=" + rvw_no + ", rst_no=" + rst_no + ", id=" + id + ", cont=" + cont
        + ", cdt=" + cdt + ", score=" + score + ", useyn=" + useyn + ", rvw_phot=" + rvw_phot + "]";
  }
}

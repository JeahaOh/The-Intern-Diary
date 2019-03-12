package egovframework.memb.vo;

public class Memb {
  String id;      //  회원 아이디
  String pwd;     //  회원 비밀번호
  String nick;    //  회원 닉네임
  Boolean adm;    //  관리자 여부
  Boolean useyn;  //  계정 사용 여부
  
  public Memb() { }
  
  public Memb(String id, String pwd, String nick, Boolean adm, Boolean useyn) {
    super();
    this.id = id;
    this.pwd = pwd;
    this.nick = nick;
    this.adm = adm;
    this.useyn = useyn;
  }
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getPwd() {
    return pwd;
  }
  public void setPwd(String pwd) {
    this.pwd = pwd;
  }
  public String getNick() {
    return nick;
  }
  public void setNick(String nick) {
    this.nick = nick;
  }
  public Boolean getadm() {
    return adm;
  }
  public void setadm(Boolean adm) {
    this.adm = adm;
  }
  public Boolean getUseyn() {
    return useyn;
  }
  public void setUseyn(Boolean useyn) {
    this.useyn = useyn;
  }
  
  @Override
  public String toString() {
    return "Memb [id=" + id + ", pwd=" + pwd + ", nick=" + nick + ", adm=" + adm + ", useyn="
        + useyn + "]";
  }
}

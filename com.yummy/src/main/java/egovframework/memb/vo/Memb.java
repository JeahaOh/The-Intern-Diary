package egovframework.memb.vo;

public class Memb {
  String id;
  String pwd;
  String nick;
  Boolean admin;
  Boolean useyn;
  
  public Memb() { }
  
  public Memb(String id, String pwd, String nick, Boolean admin, Boolean useyn) {
    super();
    this.id = id;
    this.pwd = pwd;
    this.nick = nick;
    this.admin = admin;
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
  public Boolean getAdmin() {
    return admin;
  }
  public void setAdmin(Boolean admin) {
    this.admin = admin;
  }
  public Boolean getUseyn() {
    return useyn;
  }
  public void setUseyn(Boolean useyn) {
    this.useyn = useyn;
  }
  
  @Override
  public String toString() {
    return "Memb [id=" + id + ", pwd=" + pwd + ", nick=" + nick + ", admin=" + admin + ", useyn="
        + useyn + "]";
  }
}

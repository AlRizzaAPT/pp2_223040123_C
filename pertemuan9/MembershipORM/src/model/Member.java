package model;

public class Member {
  private String id;
  private String nama;
  private String JenisMemberId;
  private JenisMember jenisMember;

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
  
  public void setNama(String nama) {
    this.nama = nama;
  }

  public String getNama() {
    return nama;
  }

  public void setJenisMemberId(String JenisMemberId) {
    this.JenisMemberId = JenisMemberId;
  }

  public String getJenisMemberId() {
    return JenisMemberId;
  }

  public void setJenisMember(JenisMember jenisMember) {
    this.jenisMember = jenisMember;
  }

  public JenisMember getJenisMember() {
    return jenisMember;
  }

}
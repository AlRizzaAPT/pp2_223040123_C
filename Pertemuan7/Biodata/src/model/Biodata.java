package model;


public class Biodata {
  private String id;
  private String nama;
  private String nrp;
  private String jurusan;
  private String alamat;

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
  
  public void setNrp(String nrp) {
    this.nrp = nrp;
}

public String getNrp() {
  return nrp;
}
  public void setJurusan(String jurusan) {
    this.jurusan = jurusan;
}

public String getJurusan() {
  return jurusan;
}

public void setAlamat(String alamat) {
  this.alamat = alamat;
}

public String getAlamat() {
  return alamat;
}
}
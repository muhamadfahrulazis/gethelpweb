package com.jasa.gethelpweb.dto;

public class PetugasDto {
    private String nama;
    private String jenisKelamin;
    private String email;
    private String password;
    private String jabatan;
    private String noHp;
    private String statusPetugas;
    private long nip;

    public PetugasDto() {
    }

    public PetugasDto(String nama, String jenisKelamin,
                      String email, String password, String jabatan, String noHp, long nip, String statusPetugas) {
        super();
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.email = email;
        this.password = password;
        this.jabatan = jabatan;
        this.noHp = noHp;
        this.nip = nip;
        this.statusPetugas = statusPetugas;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getNip() {
        return nip;
    }

    public void setNip(long nip) {
        this.nip = nip;
    }

    public String getStatusPetugas() {
        return statusPetugas;
    }

    public void setStatusPetugas(String statusPetugas) {
        this.statusPetugas = statusPetugas;
    }
}

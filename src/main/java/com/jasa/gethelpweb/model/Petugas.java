package com.jasa.gethelpweb.model;

import javax.persistence.*;

@Entity
@Table(name = "_petugas", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Petugas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long nip;

    @Column(name = "nama_petugas")
    private String nama;

    @Column(name = "jenis_kelamin_petugas")
    private String jenisKelamin;

    @Column(name = "jabatan_petugas")
    private String jabatan;

    @Column(name = "no_hp_petugas")
    private String noHp;

    @Column(name = "status_petugas")
    private String statusPetugas;

    private String email;

    private String password;

    public Petugas(){

    }

    public Petugas(String nama, String jenisKelamin, String email, String password,
                   String jabatan, String noHp, String statusPetugas) {
        super();
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.email = email;
        this.password = password;
        this.jabatan = jabatan;
        this.noHp = noHp;
        this.statusPetugas = statusPetugas;
    }

    public long getNip() {
        return nip;
    }

    public void setNip(long nip) {
        this.nip = nip;
    }

    public String getNoHp() {

        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
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

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getStatusPetugas() {
        return statusPetugas;
    }

    public void setStatusPetugas(String statusPetugas) {
        this.statusPetugas = statusPetugas;
    }
}

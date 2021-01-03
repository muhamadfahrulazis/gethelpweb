package com.jasa.gethelpweb.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "petugas")
public class Petugas {

    @Id
    @GenericGenerator(name = "nip",strategy = "com.jasa.gethelpweb.model.generator")
    @GeneratedValue(generator = "nip")
    @Column(name = "nip")
    private String nip;

    @Column(name = "nama")
    private String nama;

    @Column(name = "jenis_kelamin")
    private String jenisKelamin;

    @Column(name = "role")
    private String jabatan;

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
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

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
}

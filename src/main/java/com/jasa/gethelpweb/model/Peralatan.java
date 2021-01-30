package com.jasa.gethelpweb.model;

import javax.persistence.*;

@Entity
@Table(name = "_peralatan")
public class Peralatan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_peralatan;

    @Column(name = "nama_peralatan")
    private String namaPeralatan;

    @Column(name = "kode_peralatan")
    private String kodePeralatan;

    @Column(name = "deskripsi_peralatan")
    private String deskripsiPeralatan;

    public String getKodePeralatan() {
        return kodePeralatan;
    }

    public void setKodePeralatan(String kodePeralatan) {
        this.kodePeralatan = kodePeralatan;
    }

    public long getId_peralatan() {
        return id_peralatan;
    }

    public void setId_peralatan(long id_peralatan) {
        this.id_peralatan = id_peralatan;
    }

    public String getNamaPeralatan() {
        return namaPeralatan;
    }

    public void setNamaPeralatan(String namaPeralatan) {
        this.namaPeralatan = namaPeralatan;
    }

    public String getDeskripsiPeralatan() {
        return deskripsiPeralatan;
    }

    public void setDeskripsiPeralatan(String deskripsiPeralatan) {
        this.deskripsiPeralatan = deskripsiPeralatan;
    }
}

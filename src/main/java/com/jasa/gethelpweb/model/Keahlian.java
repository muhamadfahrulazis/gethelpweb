package com.jasa.gethelpweb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Data
@Entity
@Table(name = "_keahlian")
public class Keahlian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_keahlian;

    public Keahlian() {
    }

    public Keahlian(String kodeKeahlian, String namaKeahlian, String deskripsiKeahlian) {
        this.kodeKeahlian = kodeKeahlian;
        this.namaKeahlian = namaKeahlian;
        this.deskripsiKeahlian = deskripsiKeahlian;
    }

    @Column(name = "kode_keahlian")
    private String kodeKeahlian;

    @Column(name = "nama_keahlian")
    private String namaKeahlian;

    @Column(name = "deskripsi_keahlian")
    private String deskripsiKeahlian;

}

package com.jasa.gethelpweb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Data
@Entity
@Table(name = "_proses_calonmitra")
public class ProsesCalonMitra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_proses_calonmitra;

    @Column(name = "nip_petugas_verifikasi")
    private long nipPetugasVerifikasi;

    @Column(name = "nip_petugas_training")
    private long nipPetugasTraining;

    @Column(name = "nip_petugas_onboarding")
    private long nipPetugasOnboarding;

    @Column(name = "tanggal_verifikasi")
    private Date tanggalVerifikasi;

    @Column(name = "tanggal_training")
    private Date tanggalTraining;

    @Column(name = "tanggal_onboarding")
    private Date tanggalOnboarding;

    @Column(name = "alasan_gagal")
    private String alasanGagal;

    @ManyToOne
    @JoinColumn(name = "id_calonmitra")
    private CalonMitra calonMitra;

    @Column(name = "kode_proses")
    private String kode_proses;

    public ProsesCalonMitra(){

    }

    public ProsesCalonMitra(long nipPetugasVerifikasi, long nipPetugasTraining, long nipPetugasOnboarding, Date tanggalVerifikasi, Date tanggalTraining, Date tanggalOnboarding, String alasanGagal, CalonMitra calonMitra, String kode_proses) {
        this.nipPetugasVerifikasi = nipPetugasVerifikasi;
        this.nipPetugasTraining = nipPetugasTraining;
        this.nipPetugasOnboarding = nipPetugasOnboarding;
        this.tanggalVerifikasi = tanggalVerifikasi;
        this.tanggalTraining = tanggalTraining;
        this.tanggalOnboarding = tanggalOnboarding;
        this.alasanGagal = alasanGagal;
        this.calonMitra = calonMitra;
        this.kode_proses = kode_proses;
    }
}

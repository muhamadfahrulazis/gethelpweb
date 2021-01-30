package com.jasa.gethelpweb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = " _calonmitra")
public class CalonMitra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_calonmitra;

    @Column(name = "nama_calonmitra")
    private String namaCalonMitra;

    @Column(name = "jenis_kelamin_calonmitra")
    private String jenisKelaminCalonMitra;

    @Column(name = "nik_ktp_calonmitra")
    private String nikKtpCalonMitra;

    @Column(name = "no_hp_calonmitra")
    private String noHpCalonMitra;

    @Column(name = "email_calonmitra")
    private String emailCalonMitra;

    @Column(name = "domisili_calonmitra")
    private String domisiliCalonMitra;

    @Column(name = "kelurahan_calonmitra")
    private String kelurahanCalonMitra;

    @Column(name = "kecamatan_calonmitra")
    private String kecamatanCalonMitra;

    @Column(name = "kabupaten_calonmitra")
    private String kabupatenCalonMitra;

    @Column(name = "provinsi_calonmitra")
    private String provinsiCalonMitra;

    @Column(name = "nama_file_ktp_calonmitra")
    private String namaFileKtpCalonMitra;

    @Column(name = "nama_file_selfiektp_calonmitra")
    private String namaFileSelfiektpCalonMitra;

    @Column(name = "pengalaman_kerja_calonmitra")
    private String pengalamanKerjaCalonMitra;

    @Column(name = "pekerjaan_saat_ini_calonmitra")
    private String pekerjaanSaatIniCalonMitra;

    @Column(name = "layanan_calonmitra")
    private String layananCalonMitra;

    @Column(name = "nama_kontak_darurat_calonmitra")
    private String namaKontakDaruratCalonMitra;

    @Column(name = "no_hp_kontak_darurat_calonmitra")
    private String noHpKontakDaruratCalonMitra;

    @Column(name = "hub_kontak_darurat_calonmitra")
    private String hubKontakDaruratCalonMitra;

    @Column(name = "is_new_registrant")
    private String isNewRegistrant;

    public long getId_calonmitra() {
        return id_calonmitra;
    }

    public void setId_calonmitra(long id_calonmitra) {
        this.id_calonmitra = id_calonmitra;
    }

    @Transient
    public String getNamaFileKtpCalonMitra() {
//        if (namaFileKtpCalonMitra == null) return null;
//        return "file_registrant/ktp/" + id_calonmitra + "/" + namaFileKtpCalonMitra;
        return namaFileKtpCalonMitra;
    }

    public void setNamaFileKtpCalonMitra(String namaFileKtpCalonMitra) {
        this.namaFileKtpCalonMitra = namaFileKtpCalonMitra;
    }

    @Transient
    public String getNamaFileSelfiektpCalonMitra() {
//        if(namaFileSelfiektpCalonMitra == null) return null;
//        return "file_registrant/selfie_ktp/" + id_calonmitra + "/" + namaFileSelfiektpCalonMitra;
        return namaFileSelfiektpCalonMitra;
    }

    public void setNamaFileSelfiektpCalonMitra(String namaFileSelfiektpCalonMitra) {
        this.namaFileSelfiektpCalonMitra = namaFileSelfiektpCalonMitra;
    }

    public String getPengalamanKerjaCalonMitra() {
        return pengalamanKerjaCalonMitra;
    }

    public void setPengalamanKerjaCalonMitra(String pengalamanKerjaCalonMitra) {
        this.pengalamanKerjaCalonMitra = pengalamanKerjaCalonMitra;
    }

    public String getPekerjaanSaatIniCalonMitra() {
        return pekerjaanSaatIniCalonMitra;
    }

    public void setPekerjaanSaatIniCalonMitra(String pekerjaanSaatIniCalonMitra) {
        this.pekerjaanSaatIniCalonMitra = pekerjaanSaatIniCalonMitra;
    }

    public String getNamaCalonMitra() {
        return namaCalonMitra;
    }

    public void setNamaCalonMitra(String namaCalonMitra) {
        this.namaCalonMitra = namaCalonMitra;
    }

    public String getJenisKelaminCalonMitra() {
        return jenisKelaminCalonMitra;
    }

    public void setJenisKelaminCalonMitra(String jenisKelaminCalonMitra) {
        this.jenisKelaminCalonMitra = jenisKelaminCalonMitra;
    }

    public String getNikKtpCalonMitra() {
        return nikKtpCalonMitra;
    }

    public void setNikKtpCalonMitra(String nikKtpCalonMitra) {
        this.nikKtpCalonMitra = nikKtpCalonMitra;
    }

    public String getNoHpCalonMitra() {
        return noHpCalonMitra;
    }

    public void setNoHpCalonMitra(String noHpCalonMitra) {
        this.noHpCalonMitra = noHpCalonMitra;
    }

    public String getEmailCalonMitra() {
        return emailCalonMitra;
    }

    public void setEmailCalonMitra(String emailCalonMitra) {
        this.emailCalonMitra = emailCalonMitra;
    }

    public String getDomisiliCalonMitra() {
        return domisiliCalonMitra;
    }

    public void setDomisiliCalonMitra(String domisiliCalonMitra) {
        this.domisiliCalonMitra = domisiliCalonMitra;
    }

    public String getKabupatenCalonMitra() {
        return kabupatenCalonMitra;
    }

    public void setKabupatenCalonMitra(String kabupatenCalonMitra) {
        this.kabupatenCalonMitra = kabupatenCalonMitra;
    }

    public String getLayananCalonMitra() {
        return layananCalonMitra;
    }

    public void setLayananCalonMitra(String layananCalonMitra) {
        this.layananCalonMitra = layananCalonMitra;
    }

    public String getKelurahanCalonMitra() {
        return kelurahanCalonMitra;
    }

    public void setKelurahanCalonMitra(String kelurahanCalonMitra) {
        this.kelurahanCalonMitra = kelurahanCalonMitra;
    }

    public String getKecamatanCalonMitra() {
        return kecamatanCalonMitra;
    }

    public void setKecamatanCalonMitra(String kecamatanCalonMitra) {
        this.kecamatanCalonMitra = kecamatanCalonMitra;
    }

    public String getProvinsiCalonMitra() {
        return provinsiCalonMitra;
    }

    public void setProvinsiCalonMitra(String provinsiCalonMitra) {
        this.provinsiCalonMitra = provinsiCalonMitra;
    }

    public String getNamaKontakDaruratCalonMitra() {
        return namaKontakDaruratCalonMitra;
    }

    public void setNamaKontakDaruratCalonMitra(String namaKontakDaruratCalonMitra) {
        this.namaKontakDaruratCalonMitra = namaKontakDaruratCalonMitra;
    }

    public String getNoHpKontakDaruratCalonMitra() {
        return noHpKontakDaruratCalonMitra;
    }

    public void setNoHpKontakDaruratCalonMitra(String noHpKontakDaruratCalonMitra) {
        this.noHpKontakDaruratCalonMitra = noHpKontakDaruratCalonMitra;
    }

    public String getHubKontakDaruratCalonMitra() {
        return hubKontakDaruratCalonMitra;
    }

    public void setHubKontakDaruratCalonMitra(String hubKontakDaruratCalonMitra) {
        this.hubKontakDaruratCalonMitra = hubKontakDaruratCalonMitra;
    }

    public String getIsNewRegistrant() {
        return isNewRegistrant;
    }

    public void setIsNewRegistrant(String isNewRegistrant) {
        this.isNewRegistrant = isNewRegistrant;
    }
}

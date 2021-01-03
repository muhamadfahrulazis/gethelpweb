package com.jasa.gethelpweb.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "registrant")
public class Registrant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "nik_ktp")
    private String nikKtp;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "kelurahan")
    private String kelurahan;

    @Column(name = "kecamatan")
    private String kecamatan;

    @Column(name = "kabupaten")
    private String kabupaten;

    @Column(name = "provinsi")
    private String provinsi;

    @Column(name = "url_photo_ktp")
    private String urlPhotoKtp;

    @Column(name = "url_selfie_ktp")
    private String urlSelfieKtp;

    @Column(name = "working_experience")
    private String workingExperience;

    @Column(name = "current_job")
    private String currentJob;

    @Column(name = "service")
    private String service;

    @Column(name = "emergency_name")
    private String emergencyName;

    @Column(name = "emergency_phone_number")
    private String emergencyPhoneNumber;

    @Column(name = "emergency_relationship")
    private String emergencyRelationship;

    public Registrant() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Transient
    public String getUrlPhotoKtp() {
        if (urlPhotoKtp == null) return null;
        return "file_registrant/ktp/" + id + "/" + urlPhotoKtp;
    }

    public void setUrlPhotoKtp(String urlPhotoKtp) {
        this.urlPhotoKtp = urlPhotoKtp;
    }

    @Transient
    public String getUrlSelfieKtp() {
        if(urlSelfieKtp == null) return null;
        return "file_registrant/selfie_ktp/" + id + "/" + urlSelfieKtp;
    }

    public void setUrlSelfieKtp(String urlSelfieKtp) {
        this.urlSelfieKtp = urlSelfieKtp;
    }

    public String getWorkingExperience() {
        return workingExperience;
    }

    public void setWorkingExperience(String workingExperience) {
        this.workingExperience = workingExperience;
    }

    public String getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(String currentJob) {
        this.currentJob = currentJob;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNikKtp() {
        return nikKtp;
    }

    public void setNikKtp(String nikKtp) {
        this.nikKtp = nikKtp;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public String getEmergencyPhoneNumber() {
        return emergencyPhoneNumber;
    }

    public void setEmergencyPhoneNumber(String emergencyPhoneNumber) {
        this.emergencyPhoneNumber = emergencyPhoneNumber;
    }

    public String getEmergencyRelationship() {
        return emergencyRelationship;
    }

    public void setEmergencyRelationship(String emergencyRelationship) {
        this.emergencyRelationship = emergencyRelationship;
    }
}

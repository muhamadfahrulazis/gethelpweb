package com.jasa.gethelpweb.service;

import com.jasa.gethelpweb.model.ProsesCalonMitra;

import java.util.Date;
import java.util.List;

public interface ProsesCalonMitraService {
    void verifikasiCalonMitra(String alasanGagal, long nipPetugasOnboarding,
                                          long nipPetugasTraining, long nipPetugasVerifikasi,
                                          Date tanggalOnboarding, Date tanggalTraining, Date tanggalVerifikasi,
                                          long id_calonmitra, String kode_proses);

    List<ProsesCalonMitra> getAllTrainingCalonMitra();

    void trainingCalonMitra(String alasanGagal, long nipPetugasTraining,
                            Date tanggalTraining, String kode_proses, long id_calonmitra);

    void onboardingCalonMitra(String alasanGagal, long nipPetugasOnboarding,
                              Date tanggalOnboarding, String kode_proses, long id_calonmitra);

    List<ProsesCalonMitra> getAllOnboardingCalonMitra();

    List<ProsesCalonMitra> getAllGagalCalonMitra();

    ProsesCalonMitra getMitraGagalById(long id);

    List<ProsesCalonMitra> getAllMitraAktif();

    ProsesCalonMitra getMitraAktifById(long id);

    void deleteProsesCalonMitra(long id_calonmitra);

}

package com.jasa.gethelpweb.repository;

import com.jasa.gethelpweb.model.CalonMitra;
import com.jasa.gethelpweb.model.ProsesCalonMitra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProsesCalonMitraRepository extends JpaRepository<ProsesCalonMitra, Long> {


    @Transactional
    @Modifying
    @Query(value = "DELETE FROM _proses_calonmitra WHERE id_calonmitra = ?1",
            nativeQuery = true)
    void deleteProsesCalonMitra(long id_calonmitra);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO _proses_calonmitra (alasan_gagal, nip_petugas_onboarding, nip_petugas_training, nip_petugas_verifikasi, tanggal_onboarding, tanggal_training, tanggal_verifikasi, id_calonmitra, kode_proses) VALUES(?1,?2,?3,?4,?5,?6,?7,?8,?9)",
            nativeQuery = true)
    void verifikasiCalonMitra(String alasanGagal, long nipPetugasOnboarding,
                              long nipPetugasTraining, long nipPetugasVerifikasi,
                              Date tanggalOnboarding, Date tanggalTraining, Date tanggalVerifikasi,
                              long id_calonmitra, String kode_proses);

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM _proses_calonmitra WHERE kode_proses = '11'",
            nativeQuery = true)
    List<ProsesCalonMitra> getAllTrainingCalonMitra();

    @Transactional
    @Modifying
    @Query(value = "UPDATE _proses_calonmitra SET alasan_gagal = ?1, nip_petugas_training = ?2, tanggal_training = ?3, kode_proses = ?4 WHERE id_calonmitra = ?5",
            nativeQuery = true)
    void trainingCalonMitra(String alasanGagal, long nipPetugasTraining,
                            Date tanggalTraining, String kode_proses, long id_calonmitra);

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM _proses_calonmitra WHERE kode_proses = '12'",
            nativeQuery = true)
    List<ProsesCalonMitra> getAllOnboardingCalonMitra();

    @Transactional
    @Modifying
    @Query(value = "UPDATE _proses_calonmitra SET alasan_gagal = ?1, nip_petugas_onboarding = ?2, tanggal_onboarding = ?3, kode_proses = ?4 WHERE id_calonmitra = ?5",
            nativeQuery = true)
    void onboardingCalonMitra(String alasanGagal, long nipPetugasOnboarding,
                            Date tanggalOnboarding, String kode_proses, long id_calonmitra);

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM _proses_calonmitra WHERE kode_proses in  ('21', '22', '23')",
            nativeQuery = true)
    List<ProsesCalonMitra> getAllGagalCalonMitra();

    @Transactional
    @Query(value = "SELECT * FROM _proses_calonmitra WHERE id_calonmitra = ?1 AND kode_proses in  ('21', '22', '23')",
            nativeQuery = true)
    Optional<ProsesCalonMitra> getMitraGagalById(long id);

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM _proses_calonmitra WHERE kode_proses = '13'",
            nativeQuery = true)
    List<ProsesCalonMitra> getAllMitraAktif();

    @Transactional
    @Query(value = "SELECT * FROM _proses_calonmitra WHERE id_calonmitra = ?1 AND kode_proses = '13'",
            nativeQuery = true)
    Optional<ProsesCalonMitra> getMitraAktifById(long id);


    @Transactional
    @Query(value = "SELECT COUNT(*) FROM _proses_calonmitra WHERE kode_proses = '11'",
            nativeQuery = true)
    int getTotalCalonMitraTraining();

    @Transactional
    @Query(value = "SELECT COUNT(*) FROM _proses_calonmitra WHERE kode_proses = '12'",
            nativeQuery = true)
    int getTotalCalonMitraOnboarding();

    @Transactional
    @Query(value = "SELECT COUNT(*) FROM _proses_calonmitra WHERE kode_proses in  ('21', '22', '23')",
            nativeQuery = true)
    int getTotalCalonMitraGagal();
}

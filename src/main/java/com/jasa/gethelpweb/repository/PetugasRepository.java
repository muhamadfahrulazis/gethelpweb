package com.jasa.gethelpweb.repository;

import com.jasa.gethelpweb.model.Petugas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetugasRepository extends JpaRepository<Petugas, Long> {

    Petugas findByEmail(String email);

//    @Query(value = "SELECT nip, nama, jenis_kelamin, no_hp, email, jabatan, status_petugas FROM petugas WHERE jabatan NOT IN ('Supervisor')", nativeQuery = true)
    @Query(value = "SELECT * FROM _petugas", nativeQuery = true)
    List<Petugas> getAllPetugas();

    @Transactional
    @Modifying
    @Query(value = "UPDATE _petugas p SET nama_petugas = ?1, jenis_kelamin_petugas = ?2, no_hp_petugas = ?3, email = ?4, jabatan_petugas = ?5, status_petugas = ?6 WHERE nip = ?7",
    nativeQuery = true)
    void updatePetugas(String nama, String jenisKelamin, String noHp, String email, String jabatan, String statusPetugas, long nip);

    @Transactional
    @Modifying
    @Query(value = "UPDATE _petugas p SET nama_petugas = ?1, jenis_kelamin_petugas = ?2, no_hp_petugas = ?3, email = ?4 WHERE nip = ?5",
            nativeQuery = true)
    void updateProfile(String nama, String jenisKelamin, String noHp, String email, long nip);
}

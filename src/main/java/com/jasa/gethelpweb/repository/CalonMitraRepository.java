package com.jasa.gethelpweb.repository;

import com.jasa.gethelpweb.model.CalonMitra;
import com.jasa.gethelpweb.model.ProsesCalonMitra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CalonMitraRepository extends JpaRepository<CalonMitra, Long> {

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM _calonmitra WHERE is_new_registrant = 1",
            nativeQuery = true)
    List<CalonMitra> getAllVerifikasi();

    @Transactional
    @Modifying
    @Query(value = "UPDATE _calonmitra p SET is_new_registrant = 0 WHERE id_calonmitra = ?1",
            nativeQuery = true)
    void updateVerifikasi(long id_calonmitra);

    @Transactional
    @Query(value = "SELECT COUNT(*) FROM _calonmitra WHERE is_new_registrant = 1",
            nativeQuery = true)
    int getTotalCalonMitraBaru();
}

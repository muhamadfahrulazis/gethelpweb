package com.jasa.gethelpweb.repository;

import com.jasa.gethelpweb.model.KeahlianCalonMitra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface KeahlianCalonMitraRepository extends JpaRepository<KeahlianCalonMitra, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO _keahlian_calonmitra (id_calonmitra, id_keahlian) VALUES(?1,?2)",
            nativeQuery = true)
    void keahlianCalonMitra(long id_calonmitra, long id_keahlian);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM _keahlian_calonmitra WHERE id_calonmitra = ?1",
            nativeQuery = true)
    void deleteKeahlianCalonMitra(long id_calonmitra);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM _keahlian_calonmitra WHERE id_keahlian = ?1",
            nativeQuery = true)
    void deleteKeahlianFirst(long id_keahlian);
}

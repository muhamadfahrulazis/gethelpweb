package com.jasa.gethelpweb.repository;

import com.jasa.gethelpweb.model.Keahlian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeahlianRepository extends JpaRepository<Keahlian, Long> {
}

package com.jasa.gethelpweb.repository;

import com.jasa.gethelpweb.model.Peralatan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeralatanRepository extends JpaRepository<Peralatan, Long> {
}

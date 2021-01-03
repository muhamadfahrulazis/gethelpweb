package com.jasa.gethelpweb.repository;

import com.jasa.gethelpweb.model.Registrant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrantRepository extends JpaRepository<Registrant, Long> {
}

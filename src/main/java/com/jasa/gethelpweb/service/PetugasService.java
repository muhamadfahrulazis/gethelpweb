package com.jasa.gethelpweb.service;

import com.jasa.gethelpweb.dto.PetugasDto;
import com.jasa.gethelpweb.model.Petugas;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface PetugasService extends UserDetailsService {
    Petugas save(PetugasDto petugasDto);
    List<Petugas> getAllPetugas();
    Petugas getPetugasById(long nip);
    void deletePetugasById(long nip);
    void updatePetugas(String nama, String jenisKelamin, String noHp, String email, String jabatan, String statusPetugas, long nip);
    void updateProfile(String nama, String jenisKelamin, String noHp, String email, long nip);
}

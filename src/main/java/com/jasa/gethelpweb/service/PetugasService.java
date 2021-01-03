package com.jasa.gethelpweb.service;

import com.jasa.gethelpweb.model.Petugas;

import java.util.List;

public interface PetugasService {
    Petugas savePetugas(Petugas petugas);
    List<Petugas> getAllPetugas();
    Petugas getPetugasById(String nip);
    void deletePetugasById(String nip);
}

package com.jasa.gethelpweb.service;

import com.jasa.gethelpweb.model.Petugas;
import com.jasa.gethelpweb.repository.PetugasRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PetugasServiceImpl implements PetugasService{

    @Autowired
    PetugasRepository petugasRepository;

    @Override
    public Petugas savePetugas(Petugas petugas) {
        return petugasRepository.save(petugas);
    }

    @Override
    public List<Petugas> getAllPetugas() {
        return petugasRepository.findAll();
    }

    @Override
    public Petugas getPetugasById(String nip) {
        Optional<Petugas> optional = petugasRepository.findById(nip);
        Petugas petugas = null;
        if (optional.isPresent()){
            petugas = optional.get();
        }else {
            throw new RuntimeException("Petugas not found for id :: " + nip);
        }
        return petugas;
    }

    @Override
    public void deletePetugasById(String nip) {
        petugasRepository.deleteById(nip);
    }
}

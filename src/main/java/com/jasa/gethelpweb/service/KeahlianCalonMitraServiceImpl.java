package com.jasa.gethelpweb.service;

import com.jasa.gethelpweb.model.KeahlianCalonMitra;
import com.jasa.gethelpweb.repository.KeahlianCalonMitraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeahlianCalonMitraServiceImpl implements KeahlianCalonMitraService {

    @Autowired
    KeahlianCalonMitraRepository keahlianCalonMitraRepository;

    @Override
    public KeahlianCalonMitra save(KeahlianCalonMitra keahlianCalonMitra) {
        return keahlianCalonMitraRepository.save(keahlianCalonMitra);
    }

    @Override
    public List<KeahlianCalonMitra> getAllKeahlianCalonMitra() {
        return keahlianCalonMitraRepository.findAll();
    }

    @Override
    public KeahlianCalonMitra getKeahlianCalonMitraById(long id_keahlian) {
        Optional<KeahlianCalonMitra> optional = keahlianCalonMitraRepository.findById(id_keahlian);
        KeahlianCalonMitra keahlianCalonMitra = null;

        if (optional.isPresent()){
            keahlianCalonMitra = optional.get();
        }else {
            throw new RuntimeException("CalonMitraKeahlian tidak ditemukan untuk id :: " + id_keahlian);
        }
        return keahlianCalonMitra;
    }

    @Override
    public void deleteKeahlianCalonMitraById(long id_keahlian) {
        keahlianCalonMitraRepository.deleteById(id_keahlian);
    }

    @Override
    public void keahlianCalonMitra(long id_calonmitra, long id_keahlian) {
        keahlianCalonMitraRepository.keahlianCalonMitra(id_calonmitra, id_keahlian);
    }

    @Override
    public void deleteKeahlianCalonMitra(long id_calonmitra) {
        keahlianCalonMitraRepository.deleteKeahlianCalonMitra(id_calonmitra);
    }
}

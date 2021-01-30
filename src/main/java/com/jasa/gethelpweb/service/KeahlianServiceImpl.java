package com.jasa.gethelpweb.service;

import com.jasa.gethelpweb.model.CalonMitra;
import com.jasa.gethelpweb.model.Keahlian;
import com.jasa.gethelpweb.repository.KeahlianRepository;
import com.jasa.gethelpweb.utils.EnkripsiDekripsiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KeahlianServiceImpl implements KeahlianService {

    @Autowired
    KeahlianRepository keahlianRepository;

    @Override
    public Keahlian save(Keahlian keahlian) {
        return keahlianRepository.save(EnkripsiDekripsiUtil.enkripsiKeahlian(keahlian));
    }

    @Override
    public List<Keahlian> getAllKeahlian() {
        List<Keahlian> keahlianList = keahlianRepository.findAll();
        List<Keahlian> keahlianListDekripsi = new ArrayList<>();
        for (Keahlian keahlian : keahlianList){
            keahlianListDekripsi.add(EnkripsiDekripsiUtil.dekripsiKeahlian(keahlian));
        }
        return keahlianListDekripsi;
    }

    @Override
    public Keahlian getKeahlianById(long id_layanan) {
        Optional<Keahlian> optional = keahlianRepository.findById(id_layanan);
        Keahlian keahlian = null;

        if (optional.isPresent()){
            keahlian = optional.get();
        }else {
            throw new RuntimeException("Keahlian tidak ditemukan untuk id :: " + id_layanan);
        }
        return EnkripsiDekripsiUtil.dekripsiKeahlian(keahlian);
    }

    @Override
    public void deleteKeahlianById(long id_layanan) {
        keahlianRepository.deleteById(id_layanan);
    }
}

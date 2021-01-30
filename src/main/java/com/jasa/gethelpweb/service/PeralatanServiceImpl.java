package com.jasa.gethelpweb.service;

import com.jasa.gethelpweb.model.Peralatan;
import com.jasa.gethelpweb.repository.PeralatanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeralatanServiceImpl implements PeralatanService{

    @Autowired
    PeralatanRepository peralatanRepository;

    @Override
    public Peralatan save(Peralatan peralatan) {
        return peralatanRepository.save(peralatan);
    }

    @Override
    public List<Peralatan> getAllPeralatan() {
        return peralatanRepository.findAll();
    }

    @Override
    public Peralatan getPeralatanById(long id_peralatan) {
        Optional<Peralatan> optional = peralatanRepository.findById(id_peralatan);
        Peralatan peralatan = null;

        if (optional.isPresent()){
            peralatan = optional.get();
        }else {
            throw new RuntimeException("Peralatan tidak ditemukan untuk id :: " + id_peralatan);
        }
        return peralatan;
    }

    @Override
    public void deletePeralatanById(long id_peralatan) {
        peralatanRepository.deleteById(id_peralatan);
    }
}

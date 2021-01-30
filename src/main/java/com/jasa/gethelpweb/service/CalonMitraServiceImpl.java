package com.jasa.gethelpweb.service;

import com.jasa.gethelpweb.model.CalonMitra;
import com.jasa.gethelpweb.repository.CalonMitraRepository;
import com.jasa.gethelpweb.utils.AES256;
import com.jasa.gethelpweb.utils.EnkripsiDekripsiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CalonMitraServiceImpl implements CalonMitraService {

    @Autowired
    private CalonMitraRepository calonMitraRepository;


    @Override
    public CalonMitra saveCalonMitra(CalonMitra calonMitra) {
        if (calonMitra.getNoHpCalonMitra().startsWith("0")){
            String phoneNumber = calonMitra.getNoHpCalonMitra().substring(1);
            calonMitra.setNoHpCalonMitra(phoneNumber);
        }

        if (calonMitra.getNoHpKontakDaruratCalonMitra().startsWith("0")){
            String phoneNumber = calonMitra.getNoHpKontakDaruratCalonMitra().substring(1);
            calonMitra.setNoHpKontakDaruratCalonMitra(phoneNumber);
        }

        return calonMitraRepository.save(EnkripsiDekripsiUtil.enkripsiCalonMitra(calonMitra));
    }

    @Override
    public List<CalonMitra> getAllCalonMitra() {
        List<CalonMitra> calonMitraList = calonMitraRepository.findAll();
        List<CalonMitra> calonMitraListDekripsi = new ArrayList<CalonMitra>();
        for (CalonMitra calonMitra : calonMitraList){
            calonMitraListDekripsi.add(EnkripsiDekripsiUtil.dekripsiCalonMitra(calonMitra));
        }
        return calonMitraListDekripsi;
    }

    @Override
    public CalonMitra getCalonMitraById(long id) {
        Optional <CalonMitra> optional = calonMitraRepository.findById(id);
        CalonMitra calonMitra = null;
        if (optional.isPresent()){
            calonMitra = optional.get();
        }else {
            throw new RuntimeException(" Calon Mitra tidak ditemukan untuk id :: " + id);
        }
        return EnkripsiDekripsiUtil.dekripsiCalonMitra(calonMitra);
    }

    @Override
    public void deleteCalonMitraById(long id) {
        calonMitraRepository.deleteById(id);
    }

    @Override
    public List<CalonMitra> getAllVerifikasi() {
        List<CalonMitra> calonMitraList = calonMitraRepository.getAllVerifikasi();
        List<CalonMitra> verifikasiListDekripsi = new ArrayList<>();
        for (CalonMitra calonMitra : calonMitraList){
            verifikasiListDekripsi.add(EnkripsiDekripsiUtil.dekripsiCalonMitra(calonMitra));
        }
        return verifikasiListDekripsi;
    }

    @Override
    public void updateVerifikasi(long id) {
        calonMitraRepository.updateVerifikasi(id);
    }
}

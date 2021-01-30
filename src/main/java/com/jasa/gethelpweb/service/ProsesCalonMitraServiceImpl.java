package com.jasa.gethelpweb.service;

import com.jasa.gethelpweb.model.CalonMitra;
import com.jasa.gethelpweb.model.Keahlian;
import com.jasa.gethelpweb.model.ProsesCalonMitra;
import com.jasa.gethelpweb.repository.CalonMitraRepository;
import com.jasa.gethelpweb.repository.ProsesCalonMitraRepository;
import com.jasa.gethelpweb.utils.AES256;
import com.jasa.gethelpweb.utils.EnkripsiDekripsiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProsesCalonMitraServiceImpl implements ProsesCalonMitraService {

    @Autowired
    private ProsesCalonMitraRepository prosesCalonMitraRepository;

    @Override
    public void verifikasiCalonMitra(String alasanGagal, long nipPetugasOnboarding, long nipPetugasTraining, long nipPetugasVerifikasi, Date tanggalOnboarding, Date tanggalTraining, Date tanggalVerifikasi, long id_calonmitra, String kode_proses) {
        String eAlasanGagal = null;
        if (!alasanGagal.isEmpty()){
            AES256.encrypt(alasanGagal);
        }
        prosesCalonMitraRepository.verifikasiCalonMitra(
                eAlasanGagal,
                nipPetugasOnboarding,
                nipPetugasTraining,
                nipPetugasVerifikasi,
                tanggalOnboarding,
                tanggalTraining,
                tanggalVerifikasi,
                id_calonmitra,
                kode_proses);
    }

    @Override
    public List<ProsesCalonMitra> getAllTrainingCalonMitra() {
        List<ProsesCalonMitra> prosesCalonMitraList = prosesCalonMitraRepository.getAllTrainingCalonMitra();
        List<ProsesCalonMitra> prosesCalonMitraListDekripsi = new ArrayList<>();
        for (ProsesCalonMitra prosesCalonMitra : prosesCalonMitraList){
            prosesCalonMitraListDekripsi.add(EnkripsiDekripsiUtil.dekripsiProsesCalonMitra(prosesCalonMitra));
        }
        return prosesCalonMitraListDekripsi;
    }

    @Override
    public void trainingCalonMitra(String alasanGagal, long nipPetugasTraining, Date tanggalTraining, String kode_proses, long id_calonmitra) {
        String eAlasanGagal = null;
        if (!alasanGagal.isEmpty()){
            AES256.encrypt(alasanGagal);
        }
        prosesCalonMitraRepository.trainingCalonMitra(
                eAlasanGagal,
                nipPetugasTraining,
                tanggalTraining,
                kode_proses,
                id_calonmitra);
    }

    @Override
    public void onboardingCalonMitra(String alasanGagal, long nipPetugasOnboarding, Date tanggalOnboarding, String kode_proses, long id_calonmitra) {
        String eAlasanGagal = null;
        if (!alasanGagal.isEmpty()){
            AES256.encrypt(alasanGagal);
        }

        prosesCalonMitraRepository.onboardingCalonMitra(
                eAlasanGagal,
                nipPetugasOnboarding,
                tanggalOnboarding,
                kode_proses,
                id_calonmitra);
    }

    @Override
    public List<ProsesCalonMitra> getAllOnboardingCalonMitra() {
        List<ProsesCalonMitra> prosesCalonMitraList = prosesCalonMitraRepository.getAllOnboardingCalonMitra();
        List<ProsesCalonMitra> prosesCalonMitraListDekripsi = new ArrayList<>();
        for (ProsesCalonMitra prosesCalonMitra : prosesCalonMitraList){
            prosesCalonMitraListDekripsi.add(EnkripsiDekripsiUtil.dekripsiProsesCalonMitra(prosesCalonMitra));
        }
        return prosesCalonMitraListDekripsi;
    }

    @Override
    public List<ProsesCalonMitra> getAllGagalCalonMitra() {
        List<ProsesCalonMitra> prosesCalonMitraList = prosesCalonMitraRepository.getAllGagalCalonMitra();
        List<ProsesCalonMitra> prosesCalonMitraListDekripsi = new ArrayList<>();
        for (ProsesCalonMitra prosesCalonMitra : prosesCalonMitraList){
            prosesCalonMitraListDekripsi.add(EnkripsiDekripsiUtil.dekripsiProsesCalonMitra(prosesCalonMitra));
        }
        return prosesCalonMitraListDekripsi;
    }

    @Override
    public ProsesCalonMitra getMitraGagalById(long id) {
        Optional<ProsesCalonMitra> optional = prosesCalonMitraRepository.getMitraGagalById(id);
        ProsesCalonMitra prosesCalonMitra = null;
        if (optional.isPresent()){
            prosesCalonMitra = optional.get();
        }else {
            throw new RuntimeException(" Calon Mitra gagal tidak ditemukan untuk id :: " + id);
        }
        return EnkripsiDekripsiUtil.dekripsiProsesCalonMitra(prosesCalonMitra);
    }

    @Override
    public List<ProsesCalonMitra> getAllMitraAktif() {
        List<ProsesCalonMitra> prosesCalonMitraList = prosesCalonMitraRepository.getAllMitraAktif();
        List<ProsesCalonMitra> prosesCalonMitraListDekripsi = new ArrayList<>();
        for (ProsesCalonMitra prosesCalonMitra : prosesCalonMitraList){
            prosesCalonMitraListDekripsi.add(EnkripsiDekripsiUtil.dekripsiProsesCalonMitra(prosesCalonMitra));
        }
        return prosesCalonMitraListDekripsi;
    }

    @Override
    public ProsesCalonMitra getMitraAktifById(long id) {
        Optional<ProsesCalonMitra> optional = prosesCalonMitraRepository.getMitraAktifById(id);
        ProsesCalonMitra prosesCalonMitra = null;
        if (optional.isPresent()){
            prosesCalonMitra = optional.get();
        }else {
            throw new RuntimeException(" Calon Mitra gagal tidak ditemukan untuk id :: " + id);
        }
        return EnkripsiDekripsiUtil.dekripsiProsesCalonMitra(prosesCalonMitra);
    }

    @Override
    public void deleteProsesCalonMitra(long id_calonmitra) {
        prosesCalonMitraRepository.deleteProsesCalonMitra(id_calonmitra);
    }
}

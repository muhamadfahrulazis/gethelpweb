package com.jasa.gethelpweb.service;

import com.jasa.gethelpweb.dto.PetugasDto;
import com.jasa.gethelpweb.model.CalonMitra;
import com.jasa.gethelpweb.model.Petugas;
import com.jasa.gethelpweb.repository.PetugasRepository;
import com.jasa.gethelpweb.utils.AES256;
import com.jasa.gethelpweb.utils.EnkripsiDekripsiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetugasServiceImpl implements PetugasService {
    private final PetugasRepository petugasRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public PetugasServiceImpl(PetugasRepository petugasRepository) {
        super();
        this.petugasRepository = petugasRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String eUsername = AES256.encrypt(username);
        Petugas petugas = petugasRepository.findByEmail(eUsername);
        if (petugas == null){
            throw new UsernameNotFoundException("Email atau password salah");
        }
        String dEmail = AES256.decrypt(petugas.getEmail());
        String dJabatan = AES256.decrypt(petugas.getJabatan());

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        GrantedAuthority roleClient = new SimpleGrantedAuthority(dJabatan);
        authorities.add(roleClient);

        return new org.springframework.security.core.userdetails.User(
                dEmail,
                petugas.getPassword(),
                authorities);
    }

    @Override
    public Petugas save(PetugasDto petugasDto) {
        String eNama = AES256.encrypt(petugasDto.getNama());
        String eJenisKelamin = AES256.encrypt(petugasDto.getJenisKelamin());
        String eEmail = AES256.encrypt(petugasDto.getEmail());
        String eNoHp = AES256.encrypt(petugasDto.getNoHp());
        String eJabatan = AES256.encrypt(petugasDto.getJabatan());
        String eStatus = AES256.encrypt(petugasDto.getStatusPetugas());
        Petugas petugas = new Petugas(
                eNama,
                eJenisKelamin,
                eEmail,
                passwordEncoder.encode(petugasDto.getPassword()),
                eJabatan,
                eNoHp,
                eStatus);
        return petugasRepository.save(petugas);
    }

    @Override
    public List<Petugas> getAllPetugas() {
        List<Petugas> petugasList = petugasRepository.getAllPetugas();
        List<Petugas> petugasListDekripsi = new ArrayList<>();
        for (Petugas petugas : petugasList){
            petugasListDekripsi.add(EnkripsiDekripsiUtil.dekripsiPetugas(petugas));
        }
        return petugasListDekripsi;
    }

    @Override
    public Petugas getPetugasById(long nip) {
        Optional<Petugas> optional = petugasRepository.findById(nip);
        Petugas petugas = null;
        if (optional.isPresent()){
            petugas = optional.get();
        }else {
            throw new RuntimeException("Calon Mitra tidak ditemukan untuk id :: " + nip);
        }
        return EnkripsiDekripsiUtil.dekripsiPetugas(petugas);
    }

    @Override
    public void deletePetugasById(long nip) {
        petugasRepository.deleteById(nip);
    }

    @Override
    public void updatePetugas(String nama, String jenisKelamin, String noHp, String email, String jabatan, String statusPetugas, long nip) {

        petugasRepository.updatePetugas(
                AES256.encrypt(nama),
                AES256.encrypt(jenisKelamin),
                AES256.encrypt(noHp),
                AES256.encrypt(email),
                AES256.encrypt(jabatan),
                AES256.encrypt(statusPetugas),
                nip);
    }

    @Override
    public void updateProfile(String nama, String jenisKelamin, String noHp, String email, long nip) {
        petugasRepository.updateProfile(
                AES256.encrypt(nama),
                AES256.encrypt(jenisKelamin),
                AES256.encrypt(noHp),
                AES256.encrypt(email),
                nip);
    }

}

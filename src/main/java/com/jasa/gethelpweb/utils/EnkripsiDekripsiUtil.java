package com.jasa.gethelpweb.utils;

import com.jasa.gethelpweb.model.CalonMitra;
import com.jasa.gethelpweb.model.Keahlian;
import com.jasa.gethelpweb.model.Petugas;
import com.jasa.gethelpweb.model.ProsesCalonMitra;

public class EnkripsiDekripsiUtil {

    public static CalonMitra enkripsiCalonMitra(CalonMitra calonMitra){
        String namaCM = AES256.encrypt(calonMitra.getNamaCalonMitra());
        String jenisKelaminCM = AES256.encrypt(calonMitra.getJenisKelaminCalonMitra());
        String nikKtpCM = AES256.encrypt(calonMitra.getNikKtpCalonMitra());
        String noHpCM = AES256.encrypt(calonMitra.getNoHpCalonMitra());
        String emailCM = AES256.encrypt(calonMitra.getEmailCalonMitra());
        String domisiliCM = AES256.encrypt(calonMitra.getDomisiliCalonMitra());
        String kelurahanCM = AES256.encrypt(calonMitra.getKelurahanCalonMitra());
        String kecamatanCM = AES256.encrypt(calonMitra.getKecamatanCalonMitra());
        String kabupatenCM = AES256.encrypt(calonMitra.getKabupatenCalonMitra());
        String provinsiCM = AES256.encrypt(calonMitra.getProvinsiCalonMitra());
        String pengalamanKerjaCM = AES256.encrypt(calonMitra.getPengalamanKerjaCalonMitra());
        String pekerjaanSaatIniCM = AES256.encrypt(calonMitra.getPekerjaanSaatIniCalonMitra());
        String namaKontakDaruratCM = AES256.encrypt(calonMitra.getNamaKontakDaruratCalonMitra());
        String noHpKontakDaruratCM = AES256.encrypt(calonMitra.getNoHpKontakDaruratCalonMitra());
        String hubKontakDaruratCM = AES256.encrypt(calonMitra.getHubKontakDaruratCalonMitra());
        String namaFileKtpCM = AES256.encrypt(calonMitra.getNamaFileKtpCalonMitra());
        String namaFileSelfieKtpCM = AES256.encrypt(calonMitra.getNamaFileSelfiektpCalonMitra());
        String layananCM = AES256.encrypt(calonMitra.getLayananCalonMitra());

        CalonMitra calonMitraEnkripsi = new CalonMitra();
        if (calonMitra.getId_calonmitra() != 0){
            calonMitraEnkripsi.setId_calonmitra(calonMitra.getId_calonmitra());
        }
        calonMitraEnkripsi.setNamaCalonMitra(namaCM);
        calonMitraEnkripsi.setJenisKelaminCalonMitra(jenisKelaminCM);
        calonMitraEnkripsi.setNikKtpCalonMitra(nikKtpCM);
        calonMitraEnkripsi.setNoHpCalonMitra(noHpCM);
        calonMitraEnkripsi.setEmailCalonMitra(emailCM);
        calonMitraEnkripsi.setDomisiliCalonMitra(domisiliCM);
        calonMitraEnkripsi.setKelurahanCalonMitra(kelurahanCM);
        calonMitraEnkripsi.setKecamatanCalonMitra(kecamatanCM);
        calonMitraEnkripsi.setKabupatenCalonMitra(kabupatenCM);
        calonMitraEnkripsi.setProvinsiCalonMitra(provinsiCM);
        calonMitraEnkripsi.setPengalamanKerjaCalonMitra(pengalamanKerjaCM);
        calonMitraEnkripsi.setPekerjaanSaatIniCalonMitra(pekerjaanSaatIniCM);
        calonMitraEnkripsi.setNamaKontakDaruratCalonMitra(namaKontakDaruratCM);
        calonMitraEnkripsi.setNoHpKontakDaruratCalonMitra(noHpKontakDaruratCM);
        calonMitraEnkripsi.setHubKontakDaruratCalonMitra(hubKontakDaruratCM);
        calonMitraEnkripsi.setNamaFileKtpCalonMitra(namaFileKtpCM);
        calonMitraEnkripsi.setNamaFileSelfiektpCalonMitra(namaFileSelfieKtpCM);
        calonMitraEnkripsi.setLayananCalonMitra(layananCM);
        calonMitraEnkripsi.setIsNewRegistrant(calonMitra.getIsNewRegistrant());

        return calonMitraEnkripsi;
    }

    public static CalonMitra dekripsiCalonMitra(CalonMitra calonMitra){
        CalonMitra calonMitraDekripsi = new CalonMitra();

        String namaCM = AES256.decrypt(calonMitra.getNamaCalonMitra());
        String jenisKelaminCM = AES256.decrypt(calonMitra.getJenisKelaminCalonMitra());
        String nikKtpCM = AES256.decrypt(calonMitra.getNikKtpCalonMitra());
        String noHpCM = AES256.decrypt(calonMitra.getNoHpCalonMitra());
        String emailCM = AES256.decrypt(calonMitra.getEmailCalonMitra());
        String domisiliCM = AES256.decrypt(calonMitra.getDomisiliCalonMitra());
        String kelurahanCM = AES256.decrypt(calonMitra.getKelurahanCalonMitra());
        String kecamatanCM = AES256.decrypt(calonMitra.getKecamatanCalonMitra());
        String kabupatenCM = AES256.decrypt(calonMitra.getKabupatenCalonMitra());
        String provinsiCM = AES256.decrypt(calonMitra.getProvinsiCalonMitra());
        String pengalamanKerjaCM = AES256.decrypt(calonMitra.getPengalamanKerjaCalonMitra());
        String pekerjaanSaatIniCM = AES256.decrypt(calonMitra.getPekerjaanSaatIniCalonMitra());
        String namaKontakDaruratCM = AES256.decrypt(calonMitra.getNamaKontakDaruratCalonMitra());
        String noHpKontakDaruratCM = AES256.decrypt(calonMitra.getNoHpKontakDaruratCalonMitra());
        String hubKontakDaruratCM = AES256.decrypt(calonMitra.getHubKontakDaruratCalonMitra());
        String namaFileKtpCM = AES256.decrypt(calonMitra.getNamaFileKtpCalonMitra());
        String namaFileSelfieKtpCM = AES256.decrypt(calonMitra.getNamaFileSelfiektpCalonMitra());
        String layananCM = AES256.decrypt(calonMitra.getLayananCalonMitra());

        calonMitraDekripsi.setId_calonmitra(calonMitra.getId_calonmitra());
        calonMitraDekripsi.setNamaCalonMitra(namaCM);
        calonMitraDekripsi.setJenisKelaminCalonMitra(jenisKelaminCM);
        calonMitraDekripsi.setNikKtpCalonMitra(nikKtpCM);
        calonMitraDekripsi.setNoHpCalonMitra(noHpCM);
        calonMitraDekripsi.setEmailCalonMitra(emailCM);
        calonMitraDekripsi.setDomisiliCalonMitra(domisiliCM);
        calonMitraDekripsi.setKelurahanCalonMitra(kelurahanCM);
        calonMitraDekripsi.setKecamatanCalonMitra(kecamatanCM);
        calonMitraDekripsi.setKabupatenCalonMitra(kabupatenCM);
        calonMitraDekripsi.setProvinsiCalonMitra(provinsiCM);
        calonMitraDekripsi.setPengalamanKerjaCalonMitra(pengalamanKerjaCM);
        calonMitraDekripsi.setPekerjaanSaatIniCalonMitra(pekerjaanSaatIniCM);
        calonMitraDekripsi.setNamaKontakDaruratCalonMitra(namaKontakDaruratCM);
        calonMitraDekripsi.setNoHpKontakDaruratCalonMitra(noHpKontakDaruratCM);
        calonMitraDekripsi.setHubKontakDaruratCalonMitra(hubKontakDaruratCM);
        calonMitraDekripsi.setNamaFileKtpCalonMitra(namaFileKtpCM);
        calonMitraDekripsi.setNamaFileSelfiektpCalonMitra(namaFileSelfieKtpCM);
        calonMitraDekripsi.setLayananCalonMitra(layananCM);
        calonMitraDekripsi.setIsNewRegistrant(calonMitra.getIsNewRegistrant());

        return calonMitraDekripsi;
    }

    public static Petugas dekripsiPetugas(Petugas petugas){
        Petugas petugasDekripsi = new Petugas(
                AES256.decrypt(petugas.getNama()),
                AES256.decrypt(petugas.getJenisKelamin()),
                AES256.decrypt(petugas.getEmail()),
                petugas.getPassword(),
                AES256.decrypt(petugas.getJabatan()),
                AES256.decrypt(petugas.getNoHp()),
                AES256.decrypt(petugas.getStatusPetugas())
        );

        petugasDekripsi.setNip(petugas.getNip());

        return petugasDekripsi;
    }

    public static Keahlian dekripsiKeahlian(Keahlian keahlian){
        Keahlian keahlianDekripsi = new Keahlian(
                AES256.decrypt(keahlian.getKodeKeahlian()),
                AES256.decrypt(keahlian.getNamaKeahlian()),
                AES256.decrypt(keahlian.getDeskripsiKeahlian())
        );

        keahlianDekripsi.setId_keahlian(keahlian.getId_keahlian());

        return keahlianDekripsi;
    }

    public static Keahlian enkripsiKeahlian(Keahlian keahlian){
        Keahlian keahlianEnkripsi = new Keahlian(
                AES256.encrypt(keahlian.getKodeKeahlian()),
                AES256.encrypt(keahlian.getNamaKeahlian()),
                AES256.encrypt(keahlian.getDeskripsiKeahlian())
        );

        if (keahlian.getId_keahlian() != 0){
            keahlianEnkripsi.setId_keahlian(keahlian.getId_keahlian());
        }

        return keahlianEnkripsi;
    }

    public static ProsesCalonMitra dekripsiProsesCalonMitra(ProsesCalonMitra prosesCalonMitra){
        String eAlasanGagal = "";
        System.out.println("Alasan:" + prosesCalonMitra.getAlasanGagal());
        if (prosesCalonMitra.getAlasanGagal() != null){
            eAlasanGagal = AES256.decrypt(prosesCalonMitra.getAlasanGagal());
        }

        ProsesCalonMitra prosesCalonMitraDekripsi = new ProsesCalonMitra(
                prosesCalonMitra.getNipPetugasVerifikasi(),
                prosesCalonMitra.getNipPetugasTraining(),
                prosesCalonMitra.getNipPetugasOnboarding(),
                prosesCalonMitra.getTanggalVerifikasi(),
                prosesCalonMitra.getTanggalTraining(),
                prosesCalonMitra.getTanggalOnboarding(),
                eAlasanGagal,
                dekripsiCalonMitra(prosesCalonMitra.getCalonMitra()),
                prosesCalonMitra.getKode_proses()
        );

        prosesCalonMitraDekripsi.setId_proses_calonmitra(prosesCalonMitra.getId_proses_calonmitra());

        return prosesCalonMitraDekripsi;
    }

    public static ProsesCalonMitra enkripsiProsesCalonMitra(ProsesCalonMitra prosesCalonMitra){

        return new ProsesCalonMitra(
                prosesCalonMitra.getNipPetugasVerifikasi(),
                prosesCalonMitra.getNipPetugasTraining(),
                prosesCalonMitra.getNipPetugasOnboarding(),
                prosesCalonMitra.getTanggalVerifikasi(),
                prosesCalonMitra.getTanggalTraining(),
                prosesCalonMitra.getTanggalOnboarding(),
                AES256.encrypt(prosesCalonMitra.getAlasanGagal()),
                enkripsiCalonMitra(prosesCalonMitra.getCalonMitra()),
                prosesCalonMitra.getKode_proses()
        );
    }
}

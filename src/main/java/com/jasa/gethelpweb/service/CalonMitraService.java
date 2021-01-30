package com.jasa.gethelpweb.service;

import com.jasa.gethelpweb.model.CalonMitra;

import java.util.List;

public interface CalonMitraService {
    CalonMitra saveCalonMitra(CalonMitra calonMitra);
    List<CalonMitra> getAllCalonMitra();
    CalonMitra getCalonMitraById(long id);
    void deleteCalonMitraById(long id);
    List<CalonMitra> getAllVerifikasi();
    void updateVerifikasi(long id);
}

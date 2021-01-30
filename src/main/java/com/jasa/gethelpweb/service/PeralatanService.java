package com.jasa.gethelpweb.service;

import com.jasa.gethelpweb.model.Peralatan;

import java.util.List;

public interface PeralatanService {
    Peralatan save(Peralatan peralatan);
    List<Peralatan> getAllPeralatan();
    Peralatan getPeralatanById(long id_peralatan);
    void deletePeralatanById(long id_peralatan);
}

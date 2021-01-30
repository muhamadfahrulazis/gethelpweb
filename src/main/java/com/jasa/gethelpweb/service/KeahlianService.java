package com.jasa.gethelpweb.service;

import com.jasa.gethelpweb.model.Keahlian;

import java.util.List;

public interface KeahlianService {
    Keahlian save(Keahlian keahlian);
    List<Keahlian> getAllKeahlian();
    Keahlian getKeahlianById(long id_layanan);
    void deleteKeahlianById(long id_layanan);
}

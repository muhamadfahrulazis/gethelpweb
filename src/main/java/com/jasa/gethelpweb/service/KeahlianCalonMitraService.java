package com.jasa.gethelpweb.service;

import com.jasa.gethelpweb.model.KeahlianCalonMitra;

import java.util.List;

public interface KeahlianCalonMitraService {
    KeahlianCalonMitra save(KeahlianCalonMitra keahlian);
    List<KeahlianCalonMitra> getAllKeahlianCalonMitra();
    KeahlianCalonMitra getKeahlianCalonMitraById(long id_keahlian);
    void deleteKeahlianCalonMitraById(long id_keahlian);
    void keahlianCalonMitra(long id_calonmitra, long id_keahlian);
    void deleteKeahlianCalonMitra(long id_calonmitra);
}

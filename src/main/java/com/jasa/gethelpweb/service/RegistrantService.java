package com.jasa.gethelpweb.service;

import com.jasa.gethelpweb.model.Registrant;

import java.util.List;

public interface RegistrantService {
    Registrant saveRegistrant(Registrant registrant);
    List<Registrant> getAllRegistrant();
    Registrant getRegistrantById(long id);
    void deleteRegistrantById(long id);
}

package com.jasa.gethelpweb.service;

import com.jasa.gethelpweb.model.Registrant;
import com.jasa.gethelpweb.repository.RegistrantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrantServiceImpl implements RegistrantService {

    @Autowired
    private RegistrantRepository registrantRepository;


    @Override
    public Registrant saveRegistrant(Registrant registrant) {
        if (registrant.getPhoneNumber().startsWith("0")){
            String phoneNumber = registrant.getPhoneNumber().substring(1);
            registrant.setPhoneNumber(phoneNumber);
        }

        if (registrant.getEmergencyPhoneNumber().startsWith("0")){
            String phoneNumber = registrant.getEmergencyPhoneNumber().substring(1);
            registrant.setEmergencyPhoneNumber(phoneNumber);
        }
        return registrantRepository.save(registrant);
    }

    @Override
    public List<Registrant> getAllRegistrant() {
        return registrantRepository.findAll();
    }

    @Override
    public Registrant getRegistrantById(long id) {
        Optional <Registrant> optional = registrantRepository.findById(id);
        Registrant registrant = null;
        if (optional.isPresent()){
            registrant = optional.get();
        }else {
            throw new RuntimeException(" Calon Mitre tidak ditemukan untuk id :: " + id);
        }
        return registrant;
    }

    @Override
    public void deleteRegistrantById(long id) {
        registrantRepository.deleteById(id);
    }
}

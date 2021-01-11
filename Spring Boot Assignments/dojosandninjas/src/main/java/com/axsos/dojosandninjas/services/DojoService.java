package com.axsos.dojosandninjas.services;


import org.springframework.stereotype.Service;

import com.axsos.dojosandninjas.models.Dojo;
import com.axsos.dojosandninjas.repositories.DojoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DojoService {
    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }

    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if (optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }


}


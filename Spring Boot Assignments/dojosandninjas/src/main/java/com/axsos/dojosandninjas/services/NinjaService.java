package com.axsos.dojosandninjas.services;


import org.springframework.stereotype.Service;

import com.axsos.dojosandninjas.models.Ninja;
import com.axsos.dojosandninjas.repositories.NinjaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }

    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if (optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }

    public Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }



}


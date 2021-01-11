package com.axsos.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.relationships.models.License;
import com.axsos.relationships.repositories.LicenseRepository;


@Service
public class LicenseServices {
    private final LicenseRepository licenseRepository;

    public LicenseServices(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    public List<License> allLicenses() {
        return licenseRepository.findAll();
    }

    public License findLicense(Long id) {
        Optional<License> optionalLicense = licenseRepository.findById(id);
        if (optionalLicense.isPresent()) {
            return optionalLicense.get();
        } else {
            return null;
        }
    }

    
    public License createLicense(License license) {
    	if (allLicenses().size()<1) {
    		license.setNumber(000001);
    	}
    	else {
    		List<License> list = licenseRepository.findByOrderByNumberDesc();
    		License oldLicense = list.get(0);
    		license.setNumber(oldLicense.getNumber() + 1);
    	}
        return licenseRepository.save(license);
    }


}

package com.axsos.relationships.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.relationships.models.License;

import java.util.List;

@Repository
public interface LicenseRepository extends CrudRepository<License,Long> {
List<License> findAll();
List<License> findByOrderByNumberDesc();
}

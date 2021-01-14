package com.axsos.dojooverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.dojooverflow.models.Connection;

@Repository
public interface ConnectionRepository extends CrudRepository<Connection, Long>{

}

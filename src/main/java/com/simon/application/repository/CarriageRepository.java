package com.simon.application.repository;

import com.simon.application.entity.Carriage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarriageRepository extends CrudRepository<Carriage, Long> {

}

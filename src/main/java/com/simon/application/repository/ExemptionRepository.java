package com.simon.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExemptionRepository extends CrudRepository<Exception, Long> {

}

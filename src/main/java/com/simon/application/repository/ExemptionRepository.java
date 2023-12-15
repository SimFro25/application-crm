package com.simon.application.repository;

import com.simon.application.entity.Exemption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExemptionRepository extends CrudRepository<Exemption, Long> {

}

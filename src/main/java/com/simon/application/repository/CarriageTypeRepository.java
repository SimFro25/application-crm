package com.simon.application.repository;

import com.simon.application.entity.CarriageType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarriageTypeRepository extends CrudRepository<CarriageType, Long> {

}

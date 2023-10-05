package com.simon.application.repository;

import com.simon.application.entity.RailwayStop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RailwayStopRepository extends CrudRepository<RailwayStop, Long> {

}

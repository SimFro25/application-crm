package com.simon.application.repository;

import com.simon.application.entity.Train;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends CrudRepository<Train, Long> {
}

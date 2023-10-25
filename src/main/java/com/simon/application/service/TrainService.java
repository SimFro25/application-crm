package com.simon.application.service;

import com.simon.application.entity.Train;
import com.simon.application.form.TrainForm;
import com.simon.application.repository.TrainRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE, makeFinal = true)
public class TrainService {

    RouteService routeService;
    TrainRepository trainRepository;

    public List<Train> getAllTrains() {
        List<Train> trains = new ArrayList<>();

        for (Train train : trainRepository.findAll()) {
            trains.add(train);
        }

        return trains;
    }

    public Train findTrainById(long id) {
       return trainRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException(String.format("Train with id %d doesn't exists", id)));
    }

    public void create(TrainForm trainForm) {
        Train entity = Train.builder()
                .name(trainForm.getName())
                .route(routeService.getRouteById(trainForm.getRoute()))
                .build();
        trainRepository.save(entity);
    }

    public void update(long id, TrainForm trainForm) {
        Train entity = findTrainById(id);

        entity.setName(trainForm.getName());
        entity.setRoute(routeService.getRouteById(trainForm.getRoute()));

        trainRepository.save(entity);
    }

    public void delete(long id) {
        trainRepository.deleteById(id);
    }
}

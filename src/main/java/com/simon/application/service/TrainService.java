package com.simon.application.service;

import com.simon.application.entity.RailwayStop;
import com.simon.application.entity.Route;
import com.simon.application.entity.Train;
import com.simon.application.form.TrainForm;
import com.simon.application.mapper.TrainMapper;
import com.simon.application.repository.TrainRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE, makeFinal = true)
public class TrainService {

    RouteService routeService;
    TrainMapper trainMapper;
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
        Train entity = trainMapper.mapFormToEntity(trainForm);
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

    public LocalTime getTimeOfDepart(Train train) throws IllegalArgumentException {
        Route route = Optional.ofNullable(train.getRoute())
                .orElseThrow(() -> new IllegalArgumentException(String.format("Train with id %d hasn't any route", train.getId())));

        return route.getRailwayStops()
                .stream()
                .min(Comparator.comparingLong(RailwayStop::getId))
                .map(RailwayStop::getTimeOfArrival)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Train with id %d hasn't any railway stops in it's route", train.getId())));
    }

    public LocalTime getTimeOfArrival(Train train) throws IllegalArgumentException {
        Route route = Optional.ofNullable(train.getRoute())
                .orElseThrow(() -> new IllegalArgumentException(String.format("Train with id %d hasn't any route", train.getId())));

        return route.getRailwayStops()
                .stream()
                .max(Comparator.comparingLong(RailwayStop::getId))
                .map(RailwayStop::getTimeOfArrival)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Train with id %d hasn't any railway stops in it's route", train.getId())));
    }
}

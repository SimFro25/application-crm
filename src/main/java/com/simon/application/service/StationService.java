package com.simon.application.service;

import com.simon.application.entity.Station;
import com.simon.application.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StationService {

    @Autowired
    StationRepository stationRepository;

    public List<Station> getAllStations() {
        List<Station> stations = new ArrayList<>();

        for (Station station : stationRepository.findAll()) {
            stations.add(station);
        }

        return stations;
    }

    public Station getStationById(long id) {
        Station station = stationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Station with id %s isn't exists", id)));
        return station;
    }

    public void create(String name, double latitude, double longitude) {
        Station station = Station.builder().name(name).latitude(latitude).longitude(longitude).build();
        stationRepository.save(station);
    }

    public void update(long id, String name, double latitude, double longitude) {
        Station station = getStationById(id);

        station.setName(name);
        station.setLatitude(latitude);
        station.setLongitude(longitude);

        stationRepository.save(station);
    }

    public void remove(long id) {
        stationRepository.deleteById(id);
    }
}

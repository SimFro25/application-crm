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

    public void create(Station station) {
        stationRepository.save(station);
    }

    public void update(long id, Station stationForm) {
        Station station = getStationById(id);

        station.setName(stationForm.getName());
        station.setLatitude(stationForm.getLatitude());
        station.setLongitude(stationForm.getLongitude());

        stationRepository.save(station);
    }

    public void remove(long id) {
        stationRepository.deleteById(id);
    }
}

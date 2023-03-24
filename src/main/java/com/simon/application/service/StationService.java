package com.simon.application.service;

import com.simon.application.model.Station;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StationService {

    List<Station> stations = new ArrayList<>();
    Long sequence = 1L;

    public List<Station> getAllStations() {
        return stations;
    }

    public Station getStationById(long id) {
        for (Station station : stations) {
            if (station.getId() == id) {
                return station;
            }
         }

        return null;
    }

    public void create(String name, double latitude, double longitude) {
        stations.add(new Station(sequence++, name, latitude, longitude));
    }

    public void update(long id, String name, double latitude, double longitude) {
        Station station = getStationById(id);
        int index = stations.indexOf(station);

        station.setName(name);
        station.setLongitude(longitude);
        station.setLatitude(latitude);

        stations.set(index, station);
    }

    public void remove(long id) {
        Station station = getStationById(id);
        stations.remove(station);
    }

}

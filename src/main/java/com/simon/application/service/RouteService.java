package com.simon.application.service;

import com.simon.application.entity.RailwayStop;
import com.simon.application.entity.Route;
import com.simon.application.entity.Station;
import com.simon.application.form.RailwayStopForm;
import com.simon.application.form.RouteForm;
import com.simon.application.mapper.RailwayStopMapper;
import com.simon.application.mapper.RouteMapper;
import com.simon.application.repository.RailwayStopRepository;
import com.simon.application.repository.RouteRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RouteService {

    StationService stationService;
    RouteMapper routeMapper;
    RailwayStopMapper railwayStopMapper;
    RouteRepository routeRepository;
    RailwayStopRepository railwayStopRepository;

    public List<Route> getAll() {
        List<Route> routes = new ArrayList<>();

        for (Route route : routeRepository.findAll()) {
            routes.add(route);
        }

        return routes;
    }

    public Route getRouteById(long id) {
        return routeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Route with id %s isn't exists", id)));
    }

    public void create(RouteForm routeForm) {
        Route route = routeMapper.mapFormToEntity(routeForm);
        routeRepository.save(route);
    }

    public void edit(long id, RouteForm routeForm) {
        Route route = getRouteById(id);
        route.setName(routeForm.getName());
        route.setDistancePrice(routeForm.getDistancePrice());
        routeRepository.save(route);
    }

    public void delete(long id) {
        routeRepository.deleteById(id);
    }

    public RailwayStop getStopById(long railwayStopId) {
        return railwayStopRepository.findById(railwayStopId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Railway stop with id %d isn't exists", railwayStopId)));
    }

    public void createStop(long routeId, RailwayStopForm railwayStopForm) {
        Route route = getRouteById(routeId);
        Station station = stationService.getStationById(railwayStopForm.getStation());

        RailwayStop railwayStop = railwayStopMapper.mapFormToEntity(railwayStopForm)
                .setStation(station)
                .setRoute(route);
        railwayStopRepository.save(railwayStop);
    }

    public void editStop(long stopId, RailwayStopForm railwayStopForm) {
        RailwayStop railwayStop = getStopById(stopId);

        railwayStop.setOrder(railwayStopForm.getOrder());
        railwayStop.setStation(stationService.getStationById(railwayStopForm.getStation()));
        railwayStop.setTimeOfArrival(railwayStopForm.getTimeOfArrival());
        railwayStop.setTimeOfDepart(railwayStopForm.getTimeOfDepart());

        railwayStopRepository.save(railwayStop);
    }

    public void deleteStop(long stopId) {
        RailwayStop railwayStop = getStopById(stopId);
        railwayStopRepository.delete(railwayStop);
    }
}

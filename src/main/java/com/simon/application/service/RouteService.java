package com.simon.application.service;

import com.simon.application.entity.Route;
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

    RouteRepository routeRepository;

    public List<Route> getAll() {
        List<Route> routes = new ArrayList<>();

        for (Route route : routeRepository.findAll()) {
            routes.add(route);
        }

        return routes;
    }

    public Route getRouteById(long id) {
        return routeRepository.findById(id)
                .get();
    }

    public void create(Route route) {
        routeRepository.save(route);
    }

    public void edit(long id, Route routeForm) {
        Route route = getRouteById(id);
        route.setName(routeForm.getName());
        routeRepository.save(route);
    }

    public void delete(long id) {
        routeRepository.deleteById(id);
    }
}

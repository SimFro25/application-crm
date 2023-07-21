package com.simon.application.controller;

import com.simon.application.entity.Route;
import com.simon.application.service.RouteService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("route")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RouteController {

    RouteService routeService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("routes", routeService.getAll());
        return "route/list";
    }

    @GetMapping("create")
    public String create(Model model) {
        return "route/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Route route) {
        routeService.create(route);
        return "redirect:/route";
    }

    @GetMapping("{id}")
    public String view(Model model, @PathVariable long id) {
        model.addAttribute("route", routeService.getRouteById(id));
        return "route/view";
    }

    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("route", routeService.getRouteById(id));
        return "route/edit";
    }

    @PostMapping("{id}/edit")
    public String edit(@PathVariable long id, @ModelAttribute Route route) {
        routeService.edit(id, route);
        return "redirect:/route";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable long id) {
        routeService.delete(id);
        return "redirect:/route";
    }
}

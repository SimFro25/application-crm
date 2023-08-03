package com.simon.application.controller;

import com.simon.application.form.RouteForm;
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
    public String create(@ModelAttribute RouteForm routeForm) {
        routeService.create(routeForm);
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
    public String edit(@PathVariable long id, @ModelAttribute RouteForm routeForm) {
        routeService.edit(id, routeForm);
        return "redirect:/route";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable long id) {
        routeService.delete(id);
        return "redirect:/route";
    }
}

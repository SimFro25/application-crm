package com.simon.application.controller;

import com.simon.application.entity.Station;
import com.simon.application.service.StationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("station")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StationController {

    StationService stationService;

    @GetMapping("")
    public String viewAllStations(Model model) {
        model.addAttribute("stations", stationService.getAllStations());
        return "station/all";
    }

    @GetMapping("create")
    public String create(Model model) {
        return "station/create";
    }

    @PostMapping("create")
    public String create(Model model, @ModelAttribute Station station) {
        stationService.create(station);
        return "redirect:/station";
    }

    @GetMapping("{id}")
    public String view(Model model, @PathVariable long id) {
        model.addAttribute("station", stationService.getStationById(id));
        return "station/view";
    }

    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("station", stationService.getStationById(id));
        return "station/edit";
    }

    @PostMapping("{id}/edit")
    public String edit(Model model, @PathVariable long id, @ModelAttribute Station station)  {
        stationService.update(id, station);
        return "redirect:/station";
    }

    @GetMapping("{id}/remove")
    public String remove(Model model, @PathVariable long id) {
        stationService.remove(id);
        return "redirect:/station";
    }

}

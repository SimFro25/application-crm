package com.simon.application.controller;

import com.simon.application.service.StationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.Name;

@Controller
@RequestMapping("station")
public class StationController {

    @Autowired
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
    public String create(Model model, @RequestParam("name") String name, @RequestParam("latitude") double latitude, @RequestParam("longitude") double longitude) {
        stationService.create(name, latitude, longitude);
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
    public String edit(Model model,
                       @PathVariable long id,
                       @RequestParam("name") String name,
                       @RequestParam("latitude") double latitude,
                       @RequestParam("longitude") double longitude)  {
        stationService.update(id, name, latitude, longitude);
        return "redirect:/station";
    }

    @GetMapping("{id}/remove")
    public String remove(Model model, @PathVariable long id) {
        stationService.remove(id);
        return "redirect:/station";
    }

}

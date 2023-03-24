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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.lang.model.element.Name;

@Controller
public class StationController {

    @Autowired
    StationService stationService;

    @GetMapping("")
    public String viewAllStations(Model model) {
        model.addAttribute("stations", stationService.getAllStations());
        return "stations";
    }

    @GetMapping("create")
    public String create(Model model) {
        return "create";
    }

    @PostMapping("create")
    public String create(Model model, @RequestParam("name") String name, @RequestParam("latitude") double latitude, @RequestParam("longitude") double longitude) {
        stationService.create(name, latitude, longitude);
        return "redirect:/";
    }

    @GetMapping("view/{id}")
    public String view(Model model, @PathVariable long id) {
        model.addAttribute("station", stationService.getStationById(id));
        return "view";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("station", stationService.getStationById(id));
        return "edit";
    }

    @PostMapping("edit/{id}")
    public String edit(Model model,
                       @PathVariable long id,
                       @RequestParam("name") String name,
                       @RequestParam("latitude") double latitude,
                       @RequestParam("longitude") double longitude)  {
        stationService.update(id, name, latitude, longitude);
        return "redirect:/";
    }

    @GetMapping("remove/{id}")
    public String remove(Model model, @PathVariable long id) {
        stationService.remove(id);
        return "redirect:/";
    }

}

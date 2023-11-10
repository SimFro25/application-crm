package com.simon.application.controller;

import com.simon.application.entity.Train;
import com.simon.application.form.CarriageForm;
import com.simon.application.form.TrainForm;
import com.simon.application.service.CarriageService;
import com.simon.application.service.TrainService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("train")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TrainController {

    TrainService trainService;
    CarriageService carriageService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("trains", trainService.getAllTrains());
        return "train/list";
    }

    @GetMapping("{id}")
    public String view(Model model, @PathVariable long id) {
        Train train = trainService.findTrainById(id);
        model.addAttribute("train", train);

        try {
            model.addAttribute("departAt", trainService.getTimeOfDepart(train));
            model.addAttribute("arrivalAt", trainService.getTimeOfArrival(train));
        } catch (IllegalArgumentException e) {
            model.addAttribute("departAt", "-");
            model.addAttribute("arrivalAt", "-");

        }

        return "train/view";
    }

    @GetMapping("create")
    public String create() {
        return "train/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute TrainForm trainForm) {
        trainService.create(trainForm);
        return "redirect:/train";
    }

    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("train", trainService.findTrainById(id));
        return "train/edit";
    }

    @PostMapping("{id}/edit")
    public String edit(@PathVariable long id, @ModelAttribute TrainForm trainForm) {
        trainService.update(id, trainForm);
        return "redirect:/train";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable long id) {
        trainService.delete(id);
        return "redirect:/train";
    }

    @GetMapping("{trainId}/carriage/create")
    public String createCarriage(@PathVariable long trainId) {
        return "carriage/create";
    }

    @PostMapping("{trainId}/carriage/create")
    public String createCarriage(@PathVariable long trainId, @ModelAttribute CarriageForm carriageForm) {
        carriageService.create(trainId, carriageForm);
        return "redirect:/train/" + trainId;
    }

    @GetMapping({"{trainId}/carriage/{carriageId}/edit"})
    public String editCarriage(Model model, @PathVariable long trainId, @PathVariable long carriageId) {
        model.addAttribute("carriage", carriageService.getCarriageById(carriageId));
        return "carriage/edit";
    }

    @PostMapping({"{trainId}/carriage/{carriageId}/edit"})
    public String editCarriage(@PathVariable long trainId, @PathVariable long carriageId,
                               @ModelAttribute CarriageForm carriageForm) {
        carriageService.edit(carriageId, carriageForm);
        return "redirect:/train/" + trainId;
    }

    @GetMapping("{trainId}/carriage/{carriageId}/delete")
    public String deleteCarriage(@PathVariable long trainId, @PathVariable long carriageId) {
        carriageService.delete(carriageId);
        return "redirect:/train/" + trainId;
    }
}

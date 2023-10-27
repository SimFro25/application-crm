package com.simon.application.controller;

import com.simon.application.form.TrainForm;
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

    @GetMapping
    public String list(Model model) {
        model.addAttribute("trains", trainService.getAllTrains());
        return "train/list";
    }

    @GetMapping("{id}")
    public String view(Model model, @PathVariable long id) {
        model.addAttribute("train", trainService.findTrainById(id));
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
}

package com.simon.application.controller;

import com.simon.application.form.CarriageTypeForm;
import com.simon.application.service.CarriageTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("carriageType")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CarriageTypeController {

    CarriageTypeService carriageTypeService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("carriageTypes", carriageTypeService.getAllCarriageTypes());
        return "carriageType/list";
    }

    @GetMapping("{id}")
    public String view(Model model, @PathVariable long id) {
        model.addAttribute("carriageType", carriageTypeService.getCarriageTypeById(id));
        return "carriageType/view";
    }

    @GetMapping("create")
    public String create() {
        return "carriageType/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute CarriageTypeForm carriageTypeForm) {
        carriageTypeService.create(carriageTypeForm);
        return "redirect:/carriageType";
    }

    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("carriageType", carriageTypeService.getCarriageTypeById(id));
        return "carriageType/edit";
    }

    @PostMapping("{id}/edit")
    public String edit(@PathVariable long id, @ModelAttribute CarriageTypeForm carriageTypeForm) {
        carriageTypeService.edit(id, carriageTypeForm);
        return "redirect:/carriageType";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable long id) {
        carriageTypeService.remove(id);
        return "redirect:/carriageType";
    }
}

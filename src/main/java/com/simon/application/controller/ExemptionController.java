package com.simon.application.controller;

import com.simon.application.form.ExemptionForm;
import com.simon.application.service.ExemptionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("exemption")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExemptionController {

    ExemptionService exemptionService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("exemptions", exemptionService.getAll());
        return "exemption/list";
    }

    @GetMapping("{id}")
    public String view(Model model, @PathVariable long id) {
        model.addAttribute("exemption", exemptionService.getExemptionById(id));
        return "exemption/view";
    }

    @GetMapping("create")
    public String create(Model model) {
        return "exemption/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute ExemptionForm exemptionForm) {
        exemptionService.create(exemptionForm);
        return "redirect:/exemption";
    }

    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("exemption", exemptionService.getExemptionById(id));
        return "exemption/edit";
    }

    @PostMapping("{id}/edit")
    public String edit(@PathVariable long id, @ModelAttribute ExemptionForm exemptionForm) {
        exemptionService.edit(id, exemptionForm);
        return "redirect:/exemption";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable long id) {
        exemptionService.delete(id);
        return "redirect:/exemption";
    }

}

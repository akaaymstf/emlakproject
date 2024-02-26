package com.project.emlak.controller;

import com.project.emlak.entity.Isyeri;
import com.project.emlak.service.IsyeriService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/isyeri")
public class IsyeriController {

    private IsyeriService isyeriService;

    public IsyeriController(IsyeriService theIsyeriService) {
        isyeriService = theIsyeriService;
    }

    @GetMapping("/isyerilist")
    public String listIsyeri(Model theModel) {
        List<Isyeri> theIsyeri = isyeriService.findAll();
        theModel.addAttribute("isyeri", theIsyeri);
        return "list-isyeri";
    }

    @PostMapping("/isyerisave")
    public String saveIsyeri(@ModelAttribute("isyeri") Isyeri theIsyeri) {
        isyeriService.save(theIsyeri);
        return "redirect:/isyeri/isyerilist";
    }

    @PostMapping("/showFormForIsyeriUpdate")
    public String showFormForIsyeriUpdate(@RequestParam("id") int theId, Model theModel) {
        Isyeri theIsyeri = isyeriService.findById(theId);
        theModel.addAttribute("isyeri", theIsyeri);
        return "isyeri-form";
    }

    @PostMapping("/isyeridelete")
    public String deleteIsyeri(@RequestParam("id") int theId) {
        isyeriService.deleteById(theId);
        return "redirect:/isyeri/isyerilist";
    }
}

package com.project.emlak.controller;

import com.project.emlak.entity.Musteri;
import com.project.emlak.service.MusteriService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/musteri")
public class MusteriController {

    private MusteriService musteriService;

    public MusteriController(MusteriService theMusteriService) {
        musteriService = theMusteriService;
    }

    @GetMapping("/musterilist")
    public String listMusteri(Model theModel) {
        List<Musteri> theMusteri = musteriService.findAll();
        theModel.addAttribute("musteri", theMusteri);
        return "list-musteri";
    }

    @PostMapping("/musterisave")
    public String saveMusteri(@ModelAttribute("musteri") Musteri theMusteri) {
        musteriService.save(theMusteri);
        return "redirect:/musteri/musterilist";
    }

    @PostMapping("/showFormForMusteriUpdate")
    public String showFormForMusteriUpdate(@RequestParam("id") int theId, Model theModel) {
        Musteri theMusteri = musteriService.findById(theId);
        theModel.addAttribute("musteri", theMusteri);
        return "musteri-form";
    }

    @PostMapping("/musteridelete")
    public String deleteMusteri(@RequestParam("id") int theId) {
        musteriService.deleteById(theId);
        return "redirect:/musteri/musterilist";
    }
}

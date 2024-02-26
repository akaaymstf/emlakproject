package com.project.emlak.controller;

import com.project.emlak.entity.Emlak;
import com.project.emlak.service.EmlakService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/emlak")
public class EmlakController {

    private EmlakService emlakService;

    public EmlakController(EmlakService theEmlakService) {
        emlakService = theEmlakService;
    }

    @GetMapping("/emlaklist")
    public String listEmlak(Model theModel) {
        List<Emlak> theEmlak = emlakService.findAll();
        theModel.addAttribute("emlak", theEmlak);
        return "list-emlak";
    }

    @GetMapping("/emlakSorguList")
    public String sorguEmlak(Model theModel, Emlak theEmlak) {
        List<Emlak> theEmlaks = emlakService.findEmlakByCriteria(theEmlak.getAdres(), theEmlak.getFiyat(), theEmlak.getBoyut(), theEmlak.getOda(), theEmlak.getDurum(), theEmlak.getTur());
        theModel.addAttribute("emlak", theEmlaks);
        return "list-emlak";
    }

    @PostMapping("/emlaksave")
    public String saveEmlak(@ModelAttribute("emlak") Emlak theEmlak) {
        emlakService.save(theEmlak);
        return "redirect:/emlak/emlaklist";
    }

    @PostMapping("/showFormForEmlakUpdate")
    public String showFormForEmlakUpdate(@RequestParam("id") int theId, Model theModel) {
        Emlak theEmlak = emlakService.findById(theId);
        theModel.addAttribute("emlak", theEmlak);
        return "emlak-form";
    }

    @PostMapping("/emlakdelete")
    public String deleteEmlak(@RequestParam("id") int theId) {
        emlakService.deleteById(theId);
        return "redirect:/emlak/emlaklist";
    }
}

package com.project.emlak.controller;

import com.project.emlak.entity.Emlak;
import com.project.emlak.entity.Isyeri;
import com.project.emlak.entity.Musteri;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @GetMapping
    public String menu(Model theModel) {
        return "menu";
    }

    @GetMapping("/showFormForEmlakAdd")
    public String showFormForEmlakAdd(Model theModel) {
        Emlak theEmlak = new Emlak();
        theModel.addAttribute("emlak", theEmlak);
        return "emlak-form";
    }

    @GetMapping("/showFormForIsyeriAdd")
    public String showFormForIsyeriAdd(Model theModel) {
        Isyeri theIsyeri = new Isyeri();
        theModel.addAttribute("isyeri", theIsyeri);
        return "isyeri-form";
    }

    @GetMapping("/showFormForMusteriAdd")
    public String showFormForMusteriAdd(Model theModel) {
        Musteri theMusteri = new Musteri();
        theModel.addAttribute("musteri", theMusteri);
        return "musteri-form";
    }

    @GetMapping("/showFormForEmlakSelect")
    public String showFormForEmlakSelect(Model theModel) {
        Emlak theEmlak = new Emlak();
        theModel.addAttribute("emlak", theEmlak);
        return "sorgula-form";
    }
}

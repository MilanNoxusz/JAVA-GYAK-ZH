package com.example.zhgyak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Vezerlo {
    @Autowired private StationRepo stationRepo; // Dependency injection
    // Részenként párhuzamosan nézni a Nézetekkel
// Főoldal
    @GetMapping("/")
    public String Fooldal(Model model) { // Dependency injection
        model.addAttribute("stations", stationRepo.findAll());
        return "index";
    }

    // Új dolgozó hozzáadása oldal meghívása
    @GetMapping("/uj")
    public String UjAllomasOldal(Model model) { // Dependency injection
        model.addAttribute("stations", new Station());
        return "ujstation";
    }
    // Új dolgozó hozzáadása: mentés az adatbázisba
// "redirect:/"; így tudunk átmenni útvonalak között
    @PostMapping(value = "/ment")
    public String mentAllomas(@ModelAttribute Station stations) {
        stationRepo.save(stations);
        return "redirect:/";
    }
}

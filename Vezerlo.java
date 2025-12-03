package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Vezerlo {
    @Autowired private StationRepo stationRepo; // Dependency injection
    // Részenként párhuzamosan nézni a Nézetekkel
// Főoldal
    @GetMapping("/")
    public String Fooldal(Model model, String uzenet) { // Dependency injection
        model.addAttribute("stations", stationRepo.findAll());
        model.addAttribute("uzenet", model.getAttribute("uzenet"));
        return "index";
    }

    // Új dolgozó hozzáadása oldal meghívása
    @GetMapping("/uj")
    public String UjAllomasOldal(Model model) { // Dependency injection
        model.addAttribute("stations", new Station());
        return "ujstation";
    }
    @PostMapping(value = "/ment")

    public String mentDolgozo(@ModelAttribute Station stations) {
        stationRepo.save(stations);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String torolAllomas(@PathVariable(name = "id") int id, RedirectAttributes redirAttr) {
        redirAttr.addFlashAttribute("uzenet","Állomás törölve! ID="+stationRepo.findById(id).get().getId());
        stationRepo.delete(stationRepo.findById(id).get());
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String modositAllomas(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("allomas", stationRepo.findById(id));
        return "modosit";
    }
    @PostMapping(value = "/modosit")
    public String modositAllomas(@ModelAttribute Station stations, RedirectAttributes redirAttr) {
        stationRepo.save(stations);
        redirAttr.addFlashAttribute("uzenet","Állomás módosítva! ID="+stations.getId());
        return "redirect:/";
    }
}

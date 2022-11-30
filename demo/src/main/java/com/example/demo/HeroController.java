package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HeroController {

    @Autowired
    private HeroService heroService;

    @Autowired
    private QuestService questService;

    @GetMapping("/heroes")
    public String getHeroes(Model model) {
        ArrayList<Hero> heroesList = heroService.getHeroes();
        model.addAttribute("heroesList", heroesList);
        return "heroesPage";
    }

    @PostMapping("/heroes")
    public String addHero(@RequestParam String heroName) {
        heroService.addHero(heroName);
        return "redirect:/heroes";
    }

    @GetMapping("/heroes/{heroName}")
    public String getHeroInfo(@PathVariable String heroName, Model model) {
        Hero hero = heroService.findHeroByName(heroName);
        model.addAttribute("hero", hero);

        ArrayList<Quest> quests = questService.getQuests();
        model.addAttribute("quests", quests);

        return "heroPage";
    }

    @PostMapping("tryquest")
    public String tryQuest(@RequestParam String heroName, String questName) {
        heroService.tryQuest(heroName, questName);
        return "redirect:/heroes/" + heroName;
    }
}

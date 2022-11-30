package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroService {

    @Autowired
    QuestService questService;

    private ArrayList<Hero> heroes;

    public HeroService() {
        System.out.println("HeroService Constructor");
        this.heroes = new ArrayList<>();
        Hero h = new Hero("nootnoot", "cleaning the ship", 10, 5, 2000);
        this.heroes.add(h);
        this.heroes.add(new Hero("Rick", "going on a bender", 100, 200, 20000));
        this.heroes.add(new Hero("Morty", "cbeing all nervous", 3, 20, 10));
    }

    public ArrayList<Hero> getHeroes() {
        return this.heroes;
    }

    public void addHero(String heroName) {
        Hero h = new Hero(heroName);
        this.heroes.add(h);
    }

    public Hero findHeroByName(String heroName) {
        for (Hero h : this.heroes) {
            if (h.getName().equals(heroName)) {
                return h;
            }
        }
        return heroes.get(0);
    }

    public void tryQuest(String heroName, String questName) {
        Hero hero = this.findHeroByName(heroName);
        Quest quest = questService.findQuestByName(questName);

        for (int i = 0; i < hero.getLevel(); i++) {
            int x = (int) (Math.random() * 20) + 1;

            if (x > quest.getDifficulty()) {
                hero.completeQuest();
                return;
            }
        }

        hero.failQuest();
    }

}

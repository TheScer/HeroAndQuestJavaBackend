package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestController {

    @Autowired
    private QuestService questService;

    @GetMapping("/quests")
    public String getQuestsName(Model model) {
        ArrayList<Quest> quests = questService.getQuests();
        model.addAttribute("quests", quests);
        return "questsPage";
    }

    @PostMapping("/quests")
    public String addQuest(@RequestParam String questName, int questDifficulty) {
        questService.addQuest(questName, questDifficulty);
        return "redirect:/quests";
    }

    @PostMapping("/deletequest")
    public String deleteQuest(@RequestParam String questName) {
        questService.deleteQuestByName(questName);
        return "redirect:/quests";
    }
}

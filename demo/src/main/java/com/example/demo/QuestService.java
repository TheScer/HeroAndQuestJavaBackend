package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class QuestService {
    private ArrayList<Quest> quests = new ArrayList<>();

    public QuestService() {
        System.out.println("Quest Service Constructor");
        this.quests.add(new Quest("fly to the moon", 16));
        this.quests.add(new Quest("get saved by the princess", 1));
        this.quests.add(new Quest("burn down the dark forest", 8));
        this.quests.add(new Quest("colonize mars", 100));
    }

    public ArrayList<Quest> getQuests() {
        return this.quests;
    }

    public void addQuest(Quest quest) {
        this.quests.add(quest);
    }

    public void addQuest(String name, int difficulty) {
        Quest q = new Quest(name, difficulty);
        // this.addQuest(q) //will also work actually! since it'll call the other one
        // once we create the quest
        this.quests.add(q);
    }

    public Quest findQuestByName(String name) {
        for (Quest q : this.quests) {
            if (q.getName().equals(name)) {
                return q;
            }
        }
        return quests.get(0);
    }

    public void deleteQuestByName(String name) {
        Quest quest = findQuestByName(name);
        this.quests.remove(quest);
    }
}

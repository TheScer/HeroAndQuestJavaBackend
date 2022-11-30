package com.example.demo;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hero extends AbstractPersistable<Long> {
    private String name;
    private String status;
    private int level;
    private int health;
    private int gold;

    public Hero(String name) {
        this.name = name;
        this.status = "freshly born out of his mother";
        this.level = 1;
        this.health = 4;
        this.gold = -1000;

    }

    public void completeQuest() {
        this.gold += 100;
        this.level += 1;
        this.status = "completed a quest";
    }

    public void failQuest() {
        this.gold = 0;
        this.health -= 1;

        if (this.health == 0) {
            this.status = "disasterrr ... hero died!";
        } else {
            this.status = "Failed in the quest... lolllll";
        }
    }

}

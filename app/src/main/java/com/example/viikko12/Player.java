package com.example.viikko12;

public class Player {
    private int damage = 10;
    private int score = 0;

    public Player() {
        this.damage = damage;
        this.score = score;
    }

    public void attack(Monster monster) {
        monster.takeDamage(damage);
        score += 10;
        if (monster.getLife() <= 0) {
            GameManager.getInstance().generateMonster();
        }
    }

    public int getScore() {
        return score;
    }
}

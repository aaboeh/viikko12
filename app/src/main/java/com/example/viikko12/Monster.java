package com.example.viikko12;

public abstract class Monster {
    protected String name;
    protected int life;
    protected int maxLife;
    protected int monsterImage;

    public Monster(int maxLife, String name) {
        this.name = name;
        this.life = maxLife;
        this.maxLife = maxLife;
    }

    public void takeDamage(int damage) {
        life -= damage;
    }

    public int getLife() {
        return life;
    }

    public String getName() {
        return name;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public int getMonsterImage() {
        return monsterImage;
    }

}

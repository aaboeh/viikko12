package com.example.viikko12;

import java.util.Random;

public class Vampire extends Monster{
    private String[] names = {"Kreivi", "Valdemaar", "Dracula", "Vlad", "Silvester"};
    Random random = new Random();

    public Vampire() {
        super(0, " ");
        super.maxLife = random.nextInt(100) + 1;
        super.life = maxLife;
        super.name = names[random.nextInt(names.length)];
        monsterImage = R.drawable.vampire;
    }

}

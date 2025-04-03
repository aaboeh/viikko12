package com.example.viikko12;

import java.util.Random;

public class Skeleton extends Monster{
    private String[] names = {"Luukas", "Kallo-Kalle", "Luuviulu", "Naksu", "Luupertti"};
    private Random random = new Random();

    public Skeleton() {
        super(0, " ");
        super.maxLife = random.nextInt(100) + 1;
        super.life = maxLife;
        super.name = names[random.nextInt(names.length)];
        monsterImage = R.drawable.skeleton;
    }
}

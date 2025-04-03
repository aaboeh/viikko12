package com.example.viikko12;

import java.util.Random;

public class GameManager {
    private static GameManager gameManager;
    private Player player;
    private Monster latestMonster;
    private Random random;

    private GameManager() {
        player = new Player();
        random = new Random();
    }

    public static GameManager getInstance() {
        if (gameManager == null) {
            gameManager = new GameManager();
        }
        return gameManager;
    }
    public Player getPlayer() {
        return player;
    }

    public Monster generateMonster() {
        if (random.nextBoolean()) {
            latestMonster = new Skeleton();
        } else {
            latestMonster = new Vampire();
        }
        return latestMonster;
    }

    public Monster getLatestMonster() {
        return latestMonster;
    }
}

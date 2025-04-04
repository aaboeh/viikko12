package com.example.viikko12;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView playerScoreText;
    private Button fightMonstersActivityButton;
    private GameManager gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameManager = GameManager.getInstance();
        playerScoreText = findViewById(R.id.PlayerScoreText);
        fightMonstersActivityButton = findViewById(R.id.FightMonstersActivityButton);

        updateScoreUI();

        fightMonstersActivityButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, FightMonstersActivity.class);
            startActivity(intent);
        });

    }

    public void updateScoreUI() {
        playerScoreText.setText("Pisteet: " + gameManager.getPlayer().getScore());
    }
}
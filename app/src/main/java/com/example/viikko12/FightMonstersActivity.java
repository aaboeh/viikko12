package com.example.viikko12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.viikko12.fragments.BossFightFragment;
import com.example.viikko12.fragments.ShowMonsterFragment;

public class FightMonstersActivity extends AppCompatActivity {
    private Button showMonsterFragmentButton, bossFightFragmentButton, returnFromFightButton;
    private GameManager gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_monsters);

        gameManager = GameManager.getInstance();

        showMonsterFragmentButton = findViewById(R.id.ShowMonsterFragmentButton);
        bossFightFragmentButton = findViewById(R.id.BossFightFragmentButton);
        returnFromFightButton = findViewById(R.id.ReturnFromFightButton);

        bossFightFragmentButton.setEnabled(false);

        showMonsterFragmentButton.setOnClickListener(listener);
        bossFightFragmentButton.setOnClickListener(listener);

        returnFromFightButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        updateBossButtonState();

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment;

            if (view.getId() == R.id.ShowMonsterFragmentButton) {
                fragment = new ShowMonsterFragment();
            } else if (view.getId() == R.id.BossFightFragmentButton) {
                fragment = new BossFightFragment();
            } else {
                fragment = new Fragment();
            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.FightMonstersFrame, fragment)
                    .commit();
        }
    };

    public void updateBossButtonState() {
        if (gameManager.getPlayer().getScore() >= 100) {
            bossFightFragmentButton.setEnabled(true);
        }
    }

}
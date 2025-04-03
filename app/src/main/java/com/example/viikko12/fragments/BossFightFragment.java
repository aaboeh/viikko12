package com.example.viikko12.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.viikko12.GameManager;
import com.example.viikko12.Monster;
import com.example.viikko12.R;


public class BossFightFragment extends Fragment {
    private ImageView bossImage;
    private TextView bossText;
    private Button attackBossButton;
    private Monster boss;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_boss_fight, container, false);

        bossImage = view.findViewById(R.id.BossImage);
        bossText = view.findViewById(R.id.BossText);
        attackBossButton = view.findViewById(R.id.AttackBossButton);

        boss = new Monster(200, "Pääjehu") {
            @Override
            public void takeDamage(int damage) {
                super.takeDamage(damage);
                if (boss.getLife() < boss.getMaxLife()/2) {
                    super.takeDamage(-getMaxLife());
                }
            }
        };

        updateBossUI();

        attackBossButton.setOnClickListener(v -> {
            GameManager.getInstance().getPlayer().attack(boss);
            updateBossUI();
        });

        return view;
    }

    private void updateBossUI() {
        bossText.setText(boss.getName() + ": " + boss.getLife() + "/" + boss.getMaxLife());
    }
}
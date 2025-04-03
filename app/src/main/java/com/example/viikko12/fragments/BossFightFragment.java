package com.example.viikko12.fragments;

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

        boss = new Monster(200, "Pääjehu") {
            private boolean healed = false;
            @Override
            public void takeDamage(int damage) {
                if (this.getLife() - damage <= 0) {
                    super.takeDamage(this.getLife());
                } else {
                    super.takeDamage(damage);
                    if (!healed && this.getLife() < this.getMaxLife()/2) {
                        healed = true;
                        super.takeDamage(-(this.getMaxLife()-this.getLife()));
                    }

                }
            }
        };
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_boss_fight, container, false);

        bossText = view.findViewById(R.id.BossText);
        attackBossButton = view.findViewById(R.id.AttackBossButton);

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
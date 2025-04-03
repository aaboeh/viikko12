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

import com.example.viikko12.FightMonstersActivity;
import com.example.viikko12.GameManager;
import com.example.viikko12.MainActivity;
import com.example.viikko12.Monster;
import com.example.viikko12.R;

public class ShowMonsterFragment extends Fragment {
    private ImageView monsterImage;
    private TextView monsterNameText, monsterLifeText;
    private Button attackMonsterButton;
    private Monster monster;

    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_monster, container, false);

        monsterImage = view.findViewById(R.id.MonsterImage);
        monsterNameText = view.findViewById(R.id.MonsterNameText);
        monsterLifeText = view.findViewById(R.id.MonsterLifeText);
        attackMonsterButton = view.findViewById(R.id.AttackMonsterButton);

        updateMonster();

        attackMonsterButton.setOnClickListener(v -> {
            GameManager.getInstance().getPlayer().attack(monster);
            updateMonsterUI();
            if (monster.getLife() <= 0) {
                updateMonster();
            }

            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).updateScoreUI();
            }
        });

        return view;
    }

    private void updateMonster() {
        monster = GameManager.getInstance().generateMonster();
        updateMonsterUI();
    }

    private void updateMonsterUI() {
        if (monster != null) {
            monsterImage.setImageResource(monster.getMonsterImage());
            monsterNameText.setText(monster.getName());
            monsterLifeText.setText(monster.getLife() + "/" + monster.getMaxLife());
        }
    }
}
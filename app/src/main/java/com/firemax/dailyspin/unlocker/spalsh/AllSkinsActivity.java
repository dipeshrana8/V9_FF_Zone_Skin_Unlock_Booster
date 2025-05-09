package com.firemax.dailyspin.unlocker.spalsh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firemax.dailyspin.unlocker.databinding.ActivityAllSkinBinding;

import java.util.HashMap;
import java.util.Map;

public class AllSkinsActivity extends BaseActivity {


    ActivityAllSkinBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        toolbarHeaderText = "All Skins";


        super.onCreate(savedInstanceState);
        binding = ActivityAllSkinBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupToolbar(
                binding.toolbarLayout.headerTitle,
                binding.toolbarLayout.btnBack,
                binding.toolbarLayout.btnSettings
        );
        binding.toolbarLayout.btnBack.setOnClickListener(v -> myBackActivity());
        Map<View, Class<?>> guideMap = new HashMap<>();


        View.OnClickListener guideClickListener = v -> {
            Class<?> target = guideMap.get(v);
            if (target != null) {
                startActivity(new Intent(this, target));
            }
        };

        for (View view : guideMap.keySet()) {
            view.setOnClickListener(guideClickListener);
        }
        binding.btnCharacter.setOnClickListener(v -> {
            Intent intent = new Intent(AllSkinsActivity.this, CharacterListActivity.class);
            intent.putExtra("category", "Character");
            startActivity(intent);
        });
        binding.btnPet.setOnClickListener(v -> {
            Intent intent = new Intent(AllSkinsActivity.this, CharacterListActivity.class);
            intent.putExtra("category", "Pet");
            startActivity(intent);
        });

        binding.btnWeapons.setOnClickListener(v -> {
            Intent intent = new Intent(AllSkinsActivity.this, CharacterListActivity.class);
            intent.putExtra("category", "Weapons");
            startActivity(intent);
        });
        binding.btnParachute.setOnClickListener(v -> {
            Intent intent = new Intent(AllSkinsActivity.this, CharacterListActivity.class);
            intent.putExtra("category", "Parachute");
            startActivity(intent);
        });

        binding.btnEmotes.setOnClickListener(v -> {
            Intent intent = new Intent(AllSkinsActivity.this, EmotesActivity.class);
            startActivity(intent);
        });

        binding.btnVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllSkinsActivity.this, CharacterListActivity.class);
                intent.putExtra("category", "Vehicles");
                startActivity(intent);
            }
        });


    }


    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}
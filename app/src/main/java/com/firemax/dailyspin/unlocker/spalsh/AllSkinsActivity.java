package com.firemax.dailyspin.unlocker.spalsh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firemax.dailyspin.unlocker.databinding.ActivityAllSkinBinding;

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


        binding.btnDailyDiamondGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllSkinsActivity.this, DiamondGuideActivity.class);
                intent.putExtra("category", "Guide");
                startActivity(intent);
            }
        });

        binding.btnCharacter.setOnClickListener(v -> {
            Intent intent = new Intent(AllSkinsActivity.this, CharacterListActivity.class);
            intent.putExtra("category", "Character");
            startActivity(intent);
        });
        binding.btnGlooWall.setOnClickListener(v -> {
            Intent intent = new Intent(AllSkinsActivity.this, CharacterListActivity.class);
            intent.putExtra("category", "Gloo Wall");
            startActivity(intent);
        });

        binding.btnParachute.setOnClickListener(v -> {
            Intent intent = new Intent(AllSkinsActivity.this, CharacterListActivity.class);
            intent.putExtra("category", "Parachutes");
            startActivity(intent);
        });
        binding.btnPet.setOnClickListener(v -> {
            Intent intent = new Intent(AllSkinsActivity.this, CharacterListActivity.class);
            intent.putExtra("category", "Pet");
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
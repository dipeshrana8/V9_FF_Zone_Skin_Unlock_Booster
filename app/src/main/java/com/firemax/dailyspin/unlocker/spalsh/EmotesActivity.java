package com.firemax.dailyspin.unlocker.spalsh;

import android.content.Intent;
import android.os.Bundle;

import com.firemax.dailyspin.unlocker.databinding.ActivityEmotesBinding;

public class EmotesActivity extends BaseActivity {

    ActivityEmotesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        toolbarHeaderText = "Emotes";
        super.onCreate(savedInstanceState);


        binding = ActivityEmotesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupToolbar(
                binding.toolbarLayout.headerTitle,
                binding.toolbarLayout.btnBack,
                binding.toolbarLayout.btnSettings
        );
        binding.toolbarLayout.btnBack.setOnClickListener(v -> myBackActivity());


        binding.btnNormalEmotes.setOnClickListener(v -> {
            Intent intent = new Intent(EmotesActivity.this, CharacterListActivity.class);
            intent.putExtra("category", "Normal");
            startActivity(intent);
        });


        binding.btnRareEmotes.setOnClickListener(v -> {
            Intent intent = new Intent(EmotesActivity.this, CharacterListActivity.class);
            intent.putExtra("category", "Rare");
            startActivity(intent);
        });

        binding.btnSpecialEmotes.setOnClickListener(v -> {
            Intent intent = new Intent(EmotesActivity.this, CharacterListActivity.class);
            intent.putExtra("category", "Advance");
            startActivity(intent);
        });


    }

    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}
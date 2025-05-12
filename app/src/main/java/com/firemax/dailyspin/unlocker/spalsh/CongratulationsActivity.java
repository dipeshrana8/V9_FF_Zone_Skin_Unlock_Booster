package com.firemax.dailyspin.unlocker.spalsh;

import android.os.Bundle;

import com.firemax.dailyspin.unlocker.databinding.ActivityCongratulationsBinding;

public class CongratulationsActivity extends BaseActivity {

    ActivityCongratulationsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbarHeaderText = "Congratulations";

        binding = ActivityCongratulationsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.toolbarLayout.btnBack.setOnClickListener(v -> myBackActivity());

        setupToolbar(
                binding.toolbarLayout.headerTitle,
                binding.toolbarLayout.btnBack,
                binding.toolbarLayout.btnSettings
        );
        binding.btnNext.setOnClickListener(v -> {

            finish();
        });
    }

    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}
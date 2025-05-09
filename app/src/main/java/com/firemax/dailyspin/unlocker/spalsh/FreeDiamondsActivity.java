package com.firemax.dailyspin.unlocker.spalsh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.firemax.dailyspin.unlocker.databinding.ActivityGetDailyDiamondBinding;

import java.util.HashMap;
import java.util.Map;

public class FreeDiamondsActivity extends BaseActivity {

    ActivityGetDailyDiamondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        toolbarHeaderText = "Free Diamonds";


        super.onCreate(savedInstanceState);


        binding = ActivityGetDailyDiamondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnBack.setOnClickListener(v -> myBackActivity());


        Map<View, Class<?>> navMap = new HashMap<>();

        navMap.put(binding.btnSpinWin, SpinActivity.class);
        navMap.put(binding.btnSurpriseReward, SurpriseBoxActivity.class);
        navMap.put(binding.btnReferEarn, ReferEarnActivity.class);


        View.OnClickListener smartClick = v -> {
            if (navMap.containsKey(v)) {
                showInterstitialAds = true;
                startActivity(new Intent(this, navMap.get(v)));
                showInterstitialAds = false;
            }
        };


        for (View view : navMap.keySet()) {
            view.setOnClickListener(smartClick);
        }


    }

    @Override
    public void onBackPressed() {
        myBackActivity();


    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        int totalReward = sharedPreferences.getInt("reward_value", 0);


        binding.txtCountEarn.setText("Total : " + totalReward);
    }
}
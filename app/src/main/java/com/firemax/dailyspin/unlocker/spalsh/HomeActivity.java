package com.firemax.dailyspin.unlocker.spalsh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firemax.dailyspin.unlocker.databinding.ActivityHomeBinding;

import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends BaseActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        toolbarHeaderText = "Main Hub";
        showBackButton = false;

        super.onCreate(savedInstanceState);


        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Map<View, Class<?>> navMap = new HashMap<>();

        navMap.put(binding.btnDiamondGuide, AllSkinsActivity.class);
        navMap.put(binding.btnFreeDiamond, SpinActivity.class);
        navMap.put(binding.btnCalculator, DiamondCalActivity.class);

        navMap.put(binding.btnQuiz, Quiz_1_Activity.class);


        Map<View, Runnable> actionMap = new HashMap<>();


        View.OnClickListener smartClick = v -> {
            if (navMap.containsKey(v)) {
                showInterstitialAds = true;
                startActivity(new Intent(this, navMap.get(v)));
                showInterstitialAds = false;
            } else if (actionMap.containsKey(v)) {
                showInterstitialAds = false;
                actionMap.get(v).run();
            }
        };


        for (View view : navMap.keySet()) {
            view.setOnClickListener(smartClick);
        }
        for (View view : actionMap.keySet()) {
            view.setOnClickListener(smartClick);
        }


        binding.btnRareEmotes.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CharacterListActivity.class);
            intent.putExtra("category", "Rare");
            startActivity(intent);
        });
        binding.btnTipsAndTricks.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, DiamondGuideActivity.class);
            intent.putExtra("category", "Tips");
            startActivity(intent);

        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(HomeActivity.this, A7_ExitActivity.class);
        startActivity(intent);


    }


}
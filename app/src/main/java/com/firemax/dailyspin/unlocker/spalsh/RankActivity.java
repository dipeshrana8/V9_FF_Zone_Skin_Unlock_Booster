package com.firemax.dailyspin.unlocker.spalsh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.firemax.dailyspin.unlocker.databinding.ActivityRankBinding;

import java.util.HashMap;
import java.util.Map;

public class RankActivity extends BaseActivity {

    ActivityRankBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toolbarHeaderText = "Select Player Rank";


        binding = ActivityRankBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarLayout.btnBack.setOnClickListener(v -> myBackActivity());
        Map<ImageView, Integer> rankMap = new HashMap<>();

        // Map buttons to rank index
        rankMap.put(binding.btnRank0, 0);
        rankMap.put(binding.btnRank1, 1);
        rankMap.put(binding.btnRank2, 2);
        rankMap.put(binding.btnRank3, 3);
        rankMap.put(binding.btnRank4, 4);
        rankMap.put(binding.btnRank5, 5);

        // Set a single listener for all
        View.OnClickListener listener = v -> {
            Intent intent = new Intent(this, PlayerCategoryActivity.class);
            startActivity(intent);
            finish();
        };

        for (ImageView btn : rankMap.keySet()) {
            btn.setOnClickListener(listener);
        }

    }

    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}
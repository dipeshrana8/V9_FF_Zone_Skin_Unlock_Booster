package com.firemax.dailyspin.unlocker.spalsh;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.firemax.dailyspin.unlocker.databinding.ActivityAppGuideBinding;

public class ReferEarnActivity extends BaseActivity {

    ActivityAppGuideBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        toolbarHeaderText = "Refer And Earn";


        binding = ActivityAppGuideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupToolbar(
                binding.toolbarLayout.headerTitle,
                binding.toolbarLayout.btnBack,
                binding.toolbarLayout.btnSettings
        );
        binding.toolbarLayout.btnBack.setOnClickListener(v -> myBackActivity());


        binding.frameCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Copied Text", "AABBCC123");
                clipboard.setPrimaryClip(clip);

                Toast.makeText(getApplicationContext(), "ID copied!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}
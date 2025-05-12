package com.firemax.dailyspin.unlocker.spalsh;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.firemax.dailyspin.unlocker.R;
import com.firemax.dailyspin.unlocker.databinding.ActivityQuiz5Binding;
import com.firemax.dailyspin.unlocker.model.QuizScoreManager;
import com.firemax.dailyspin.unlocker.myAds.WebNavigationUtils;

public class Quiz_5_Activity extends BaseActivity {

    ActivityQuiz5Binding binding;
    private TextView selectedTextView;
    private boolean isCorrect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbarHeaderText = "Quiz";

        binding = ActivityQuiz5Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.toolbarLayout.btnBack.setOnClickListener(v -> myBackActivity());
        setupToolbar(
                binding.toolbarLayout.headerTitle,
                binding.toolbarLayout.btnBack,
                binding.toolbarLayout.btnSettings
        );
        setClick(binding.txtAns1, false);
        setClick(binding.txtAns2, true);
        setClick(binding.txtAns3, false);
        setClick(binding.txtAns4, false);

        binding.btnNext.setOnClickListener(v -> {
            if (isCorrect) {
                QuizScoreManager.addPoint(this);
            }

            int score = QuizScoreManager.getScore(this);
            QuizScoreManager.resetScore(this);

            if (score >= 3) {


                congrats();
            } else {
                tryAgain();
            }
        });
    }

    private void congrats() {
        View dialogView = LayoutInflater.from(Quiz_5_Activity.this).inflate(R.layout.dialog_congrates, null);
        AlertDialog dialog = new AlertDialog.Builder(Quiz_5_Activity.this)
                .setView(dialogView)
                .create();

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        dialogView.findViewById(R.id.btnOkay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                WebNavigationUtils.WebInterstitial(Quiz_5_Activity.this);
                startActivity(new Intent(Quiz_5_Activity.this, CongratulationsActivity.class));
                finish();
                dialog.dismiss();


            }
        });

        dialog.show();
    }

    private void tryAgain() {
        View dialogView = LayoutInflater.from(Quiz_5_Activity.this).inflate(R.layout.dialog_missed, null);
        AlertDialog dialog = new AlertDialog.Builder(Quiz_5_Activity.this)
                .setView(dialogView)
                .create();

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        dialogView.findViewById(R.id.btnOkay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                WebNavigationUtils.WebInterstitial(Quiz_5_Activity.this);
                dialog.dismiss();
                finish();


            }
        });

        dialog.show();
    }

    private void setClick(TextView textView, boolean correct) {
        textView.setOnClickListener(v -> {
            resetAllOptions();
            selectedTextView = textView;
            selectedTextView.setBackgroundResource(R.drawable.bg_country_select);
            isCorrect = correct;
        });
    }

    private void resetAllOptions() {
        binding.txtAns1.setBackgroundResource(R.drawable.bg_country_unselect);
        binding.txtAns2.setBackgroundResource(R.drawable.bg_country_unselect);
        binding.txtAns3.setBackgroundResource(R.drawable.bg_country_unselect);
        binding.txtAns4.setBackgroundResource(R.drawable.bg_country_unselect);
    }
}
package com.firemax.dailyspin.unlocker.spalsh;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.firemax.dailyspin.unlocker.R;
import com.firemax.dailyspin.unlocker.databinding.ActivityQuiz2Binding;
import com.firemax.dailyspin.unlocker.model.QuizScoreManager;

public class Quiz_2_Activity extends BaseActivity {

    ActivityQuiz2Binding binding;
    private TextView selectedTextView;
    private boolean isCorrect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbarHeaderText = "Quiz";

        binding = ActivityQuiz2Binding.inflate(getLayoutInflater());
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
            startActivity(new Intent(this, Quiz_3_Activity.class));
            finish();
        });
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

    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}
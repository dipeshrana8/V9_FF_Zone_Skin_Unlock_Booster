package com.firemax.dailyspin.unlocker.model;

import android.content.Context;
import android.content.SharedPreferences;

public class QuizScoreManager {
    private static final String PREF_NAME = "quiz_prefs";
    private static final String KEY_SCORE = "total_score";

    public static void addPoint(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        int current = prefs.getInt(KEY_SCORE, 0);
        prefs.edit().putInt(KEY_SCORE, current + 1).apply();
    }

    public static int getScore(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getInt(KEY_SCORE, 0);
    }

    public static void resetScore(Context context) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit().putInt(KEY_SCORE, 0).apply();
    }
}

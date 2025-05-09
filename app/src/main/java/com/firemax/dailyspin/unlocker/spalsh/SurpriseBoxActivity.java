package com.firemax.dailyspin.unlocker.spalsh;

import android.os.Bundle;
import android.os.Handler;

import com.firemax.dailyspin.unlocker.R;
import com.firemax.dailyspin.unlocker.databinding.ActivityLuckyLifafaBinding;


public class SurpriseBoxActivity extends BaseActivity {

    private static final String PREF_NAME = "lucky_lifafa_pref";
    private static final String KEY_LAST_OPEN_TIME = "last_open_time";
    private static final long EIGHT_HOURS_MILLIS = 8 * 60 * 60 * 1000; // 8 hours in milliseconds
    ActivityLuckyLifafaBinding binding;


    private boolean isOpened = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLuckyLifafaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBack.setOnClickListener(v -> myBackActivity());

        binding.btnOpenNow.setOnClickListener(v -> {

//            if (isOpened) {
//                binding.imgPreview.setImageResource(R.drawable.img_try_later);
//                binding.txtOpen.setImageResource(R.drawable.img_try_later_txt);
//                Toast.makeText(this, "Try after 8 hours", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
            long lastOpenTime = getSharedPreferences(PREF_NAME, MODE_PRIVATE).getLong(KEY_LAST_OPEN_TIME, 0);
            long currentTime = System.currentTimeMillis();
//
//            if ((currentTime - lastOpenTime) < EIGHT_HOURS_MILLIS) {
//                binding.imgPreview.setImageResource(R.drawable.img_try_later);
//                binding.txtOpen.setImageResource(R.drawable.img_try_later_txt);
//                Toast.makeText(this, "Try after 8 hours", Toast.LENGTH_SHORT).show();
//            } else {
//                // Delay the image update by 2 seconds
//                new Handler().postDelayed(() -> {
//                    binding.imgPreview.setImageResource(R.drawable.img_cong_latifa);
//                    binding.txtOpen.setImageResource(R.drawable.img_open1);
//                    binding.btnOpenNow.setImageResource(R.drawable.img_claim);
//                    isOpened = true;
//
//                    // Save the current time as last open time
//                    getSharedPreferences(PREF_NAME, MODE_PRIVATE)
//                            .edit()
//                            .putLong(KEY_LAST_OPEN_TIME, currentTime)
//                            .apply();
//
//                }, 2000);
//            }


            new Handler().postDelayed(() -> {
                binding.imgPreview.setImageResource(R.drawable.img_cong_latifa);
                binding.txtOpen.setImageResource(R.drawable.img_open1);
                binding.btnOpenNow.setImageResource(R.drawable.img_claim);
                isOpened = true;

                // Save the current time as last open time
//                getSharedPreferences(PREF_NAME, MODE_PRIVATE)
//                        .edit()
//                        .putLong(KEY_LAST_OPEN_TIME, currentTime)
//                        .apply();

            }, 2000);
        });

    }

    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}

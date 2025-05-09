package com.firemax.dailyspin.unlocker.spalsh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firemax.dailyspin.unlocker.R;
import com.firemax.dailyspin.unlocker.databinding.ActivitySelectModeBinding;
import com.firemax.dailyspin.unlocker.myAds.WebNavigationUtils;

import java.util.Arrays;
import java.util.List;

public class SelectTimeActivity extends BaseActivity {

    List<String> gameModes = Arrays.asList(
            "Flexible",
            "Morning",
            "Afternoon",
            "Night Time"
    );

    ActivitySelectModeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        toolbarHeaderText = "Select Time";
        super.onCreate(savedInstanceState);

        binding = ActivitySelectModeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBack.setOnClickListener(v -> myBackActivity());

        binding.recyclerModes.setLayoutManager(new GridLayoutManager(this, 1));

        GameModeAdapter adapter = new GameModeAdapter(gameModes);
        binding.recyclerModes.setAdapter(adapter);
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                View dialogView = LayoutInflater.from(SelectTimeActivity.this).inflate(R.layout.dialog_active, null);
                AlertDialog dialog = new AlertDialog.Builder(SelectTimeActivity.this)
                        .setView(dialogView)
                        .create();

                if (dialog.getWindow() != null) {
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
                TextView etCal = dialogView.findViewById(R.id.txtCollect);
                etCal.setText("Your Claim Activated in 24 to 48 Hours.");
                dialogView.findViewById(R.id.btnOkay).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                        prefs.edit().putBoolean("spin_dialog_shown", true).apply();


                        boolean alreadyShown = prefs.getBoolean("spin_shown", false);
                        if (!alreadyShown) {
                            dialog.dismiss();
                            Intent intent = new Intent(SelectTimeActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                            overridePendingTransition(0, 0);
                        } else {
                            WebNavigationUtils.WebInterstitial(SelectTimeActivity.this);
                            dialog.dismiss();
                            finish();
                            overridePendingTransition(0, 0);
                        }

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        myBackActivity();
    }

    public class GameModeAdapter extends RecyclerView.Adapter<GameModeAdapter.ViewHolder> {

        private final List<String> modeList;
        private int selectedPosition = 0;

        public GameModeAdapter(List<String> modeList) {
            this.modeList = modeList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_language, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            String mode = modeList.get(position);
            holder.txtMode.setText(mode);

            if (selectedPosition == position) {
                holder.itemLayout.setBackgroundResource(R.drawable.bg_country_select);
                holder.imgSelect.setImageResource(R.drawable.ic_selected);

            } else {
                holder.itemLayout.setBackgroundResource(R.drawable.bg_country_unselect);
                holder.imgSelect.setImageResource(R.drawable.ic_unselected);

            }

            holder.itemLayout.setOnClickListener(v -> {
                selectedPosition = holder.getAdapterPosition();
                notifyDataSetChanged();
            });
        }

        @Override
        public int getItemCount() {
            return modeList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView txtMode;
            LinearLayout itemLayout;
            ImageView imgSelect;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                txtMode = itemView.findViewById(R.id.languageName);
                itemLayout = itemView.findViewById(R.id.itemLayout);
                imgSelect = itemView.findViewById(R.id.imgSelect);
            }
        }
    }
}
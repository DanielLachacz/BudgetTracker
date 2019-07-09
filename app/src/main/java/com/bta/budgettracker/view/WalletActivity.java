package com.bta.budgettracker.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.bta.budgettracker.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class WalletActivity extends AppCompatActivity {

    private FloatingActionButton fabButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallet_activity);

        fabButton = findViewById(R.id.fab_button);

        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddFragment();

            }
        });

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.wallet_activity,
                new DayFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.day_nav:
                            selectedFragment = new DayFragment();
                            break;

                        case R.id.month_nav:
                            selectedFragment = new MonthFragment();
                            break;

                        case R.id.total_nav:
                            selectedFragment = new TotalFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.wallet_activity, selectedFragment).commit();

                    return true;
                }
            };

    public void openAddFragment() {
        OptionsFragment fragment = new OptionsFragment();
        fragment.show(getSupportFragmentManager(), "OptionsFragment");
    }

    public FloatingActionButton getFabButton() {
        return fabButton;
    }

    @Override
    public void onBackPressed() {
        if (fabButton != null) {
            fabButton.show();
        }
        super.onBackPressed();
    }

}

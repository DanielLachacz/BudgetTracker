package com.example.budgettracker.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.budgettracker.R;
import com.example.budgettracker.data.model.Expense;
import com.example.budgettracker.data.model.Income;
import com.example.budgettracker.viewmodel.TotalFragmentViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

public class TotalFragment extends Fragment {

    private TextView expenseTextView, incomeTextView, balanceTextView;
    private FloatingActionButton floatingActionButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.total_fragment, container, false);

        TotalFragmentViewModel totalFragmentViewModel = ViewModelProviders.of(this).get(TotalFragmentViewModel.class);

        floatingActionButton = ((WalletActivity) getActivity()).getFabButton();

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());

        ViewPager viewPager = v.findViewById(R.id.total_viewpager);
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    floatingActionButton.show();
                    if (floatingActionButton != null) {
                        floatingActionButton.show();
                    }
                }
                else if (position == 1) {
                    floatingActionButton.hide();
                    if (floatingActionButton != null) {
                        floatingActionButton.hide();
                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        TabLayout tabLayout = v.findViewById(R.id.total_tab);
        tabLayout.setupWithViewPager(viewPager);

        expenseTextView = v.findViewById(R.id.total_expense_text_view);
        incomeTextView = v.findViewById(R.id.total_income_text_view);
        balanceTextView = v.findViewById(R.id.total_balance_text_view);

        totalFragmentViewModel.getTotalExpenseValue().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                if (aDouble == null) {
                    Double n = 0.0;
                    expenseTextView.setText(String.valueOf(n));
                }
                else {
                    expenseTextView.setText(String.valueOf(aDouble));
                }
            }
        });

        totalFragmentViewModel.getTotalIncomeValue().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                if (aDouble == null) {
                    Double n = 0.0;
                    incomeTextView.setText(String.valueOf(n));
                }
                else {
                    incomeTextView.setText(String.valueOf(aDouble));
                }
            }
        });

        totalFragmentViewModel.getTotalBalance().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                if (aDouble == null) {
                    Double n = 0.0;
                    balanceTextView.setText(String.valueOf(n));
                }
                else {
                    balanceTextView.setText(String.valueOf(aDouble));
                }
            }
        });

        return v;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new TotalListFragment();
                    break;
                case 1:
                    fragment = new TotalStatsFragment();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "List";
                case 1:
                    return "Statistics";

            }
            return null;
        }
    }
}

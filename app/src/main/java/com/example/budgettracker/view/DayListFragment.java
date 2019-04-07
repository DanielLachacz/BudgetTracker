package com.example.budgettracker.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.example.budgettracker.R;
import com.example.budgettracker.adapter.DailyAdapter;
import com.example.budgettracker.data.model.Expense;
import com.example.budgettracker.data.model.Income;
import com.example.budgettracker.viewmodel.DayListViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DayListFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.day_list_fragment, container, false);

        DayListViewModel dayListViewModel = ViewModelProviders.of(this).get(DayListViewModel.class);

        List<Expense> mExpenses = new ArrayList<>();
        List<Income> mIncomes = new ArrayList<>();

        RecyclerView recyclerView = v.findViewById(R.id.day_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        final DailyAdapter dailyAdapter = new DailyAdapter(getContext(), mExpenses, mIncomes);
        recyclerView.setAdapter(dailyAdapter);

        dayListViewModel.getAllExpensesLastDay().observe(getViewLifecycleOwner(), new Observer<List<Expense>>() {
            @Override
            public void onChanged(List<Expense> expenses) {
                dailyAdapter.setExpenses(expenses);
            }
        });

        dayListViewModel.getAllIncomesLastDay().observe(getViewLifecycleOwner(), new Observer<List<Income>>() {
            @Override
            public void onChanged(List<Income> incomes) {
                dailyAdapter.setIncomes(incomes);
            }
        });

        return v;
    }

    private void closeKeyboard(Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(Objects.requireNonNull(((Activity) mContext).getWindow()
                .getCurrentFocus()).getWindowToken(), 0);
    }

}

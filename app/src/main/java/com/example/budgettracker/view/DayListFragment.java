package com.example.budgettracker.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.budgettracker.R;
import com.example.budgettracker.adapter.DailyAdapter;
import com.example.budgettracker.data.model.Expense;
import com.example.budgettracker.data.model.Income;
import com.example.budgettracker.viewmodel.DayListViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DayListFragment extends Fragment {

    private FloatingActionButton floatingActionButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.day_list_fragment, container, false);

        DayListViewModel dayListViewModel = ViewModelProviders.of(this).get(DayListViewModel.class);

        floatingActionButton = ((WalletActivity) getActivity()).getFabButton();

        List<Expense> mExpenses = new ArrayList<>();
        List<Income> mIncomes = new ArrayList<>();

        RecyclerView recyclerView = v.findViewById(R.id.day_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        final DailyAdapter dailyAdapter = new DailyAdapter(getContext(), mExpenses, mIncomes);
        recyclerView.setAdapter(dailyAdapter);

        dayListViewModel.getAllExpensesDay().observe(getViewLifecycleOwner(), new Observer<List<Expense>>() {
            @Override
            public void onChanged(List<Expense> expenses) {
                dailyAdapter.setExpenses(expenses);
            }
        });

        dayListViewModel.getAllIncomesDay().observe(getViewLifecycleOwner(), new Observer<List<Income>>() {
            @Override
            public void onChanged(List<Income> incomes) {
                dailyAdapter.setIncomes(incomes);
            }
        });

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (floatingActionButton != null) {
            floatingActionButton.show();
        }
    }
}

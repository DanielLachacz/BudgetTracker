package com.example.budgettracker.viewmodel;

import android.app.Application;

import com.example.budgettracker.data.ExpenseRepository;
import com.example.budgettracker.data.IncomeRepository;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class TotalStatsViewModel extends AndroidViewModel {

    private ExpenseRepository expenseRepository;
    private IncomeRepository incomeRepository;
    private LiveData<Double> totalExpenseValue;
    private LiveData<Double> totalIncomeValue;
    private LiveData<List<Double>> totalType;


    public TotalStatsViewModel(@NonNull Application application) {
        super(application);
        expenseRepository = new ExpenseRepository(application);
        incomeRepository = new IncomeRepository(application);
        totalExpenseValue = expenseRepository.getTotalValue();
        totalIncomeValue = incomeRepository.getTotalValue();
        totalType = expenseRepository.getTotalType();
    }

    public LiveData<Double> getTotalExpenseValue() {
        return totalExpenseValue;
    }

    public LiveData<Double> getTotalIncomeValue() {
        return totalIncomeValue;
    }

    public LiveData<List<Double>> getTotalType() {
        return totalType;
    }

}

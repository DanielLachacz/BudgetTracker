package com.example.budgettracker.viewmodel;

import android.app.Application;
import android.util.Log;

import com.example.budgettracker.data.ExpenseRepository;
import com.example.budgettracker.data.IncomeRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class WalletActivityViewModel extends AndroidViewModel {

    private ExpenseRepository expenseRepository;
    private IncomeRepository incomeRepository;
    private LiveData<Double> totalExpenseValue;
    private LiveData<Double> totalIncomeValue;


    public WalletActivityViewModel(@NonNull Application application) {
        super(application);
        expenseRepository = new ExpenseRepository(application);
        incomeRepository = new IncomeRepository(application);
        totalExpenseValue = expenseRepository.getTotalValue();
        totalIncomeValue = incomeRepository.getTotalValue();
    }

    public LiveData<Double> getTotalExpenseValue() {
        return totalExpenseValue;
    }

    public LiveData<Double> getTotalIncomeValue() {
        return totalIncomeValue;
    }
}

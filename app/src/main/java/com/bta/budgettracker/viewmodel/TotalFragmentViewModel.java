package com.bta.budgettracker.viewmodel;

import android.app.Application;

import com.bta.budgettracker.data.ExpenseRepository;
import com.bta.budgettracker.data.IncomeRepository;
import com.bta.budgettracker.data.SharedRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class TotalFragmentViewModel extends AndroidViewModel {

    private LiveData<Double> totalExpenseValue;
    private LiveData<Double> totalIncomeValue;
    private LiveData<Double> totalBalance;

    public TotalFragmentViewModel(@NonNull Application application) {
        super(application);
        ExpenseRepository expenseRepository = new ExpenseRepository(application);
        IncomeRepository incomeRepository = new IncomeRepository(application);
        SharedRepository sharedRepository = new SharedRepository(application);
        totalExpenseValue = expenseRepository.getTotalValue();
        totalIncomeValue = incomeRepository.getTotalValue();
        totalBalance = sharedRepository.getTotalBalance();
    }

    public LiveData<Double> getTotalExpenseValue() {
        return totalExpenseValue;
    }

    public LiveData<Double> getTotalIncomeValue() {
        return totalIncomeValue;
    }

    public LiveData<Double> getTotalBalance() {
        return totalBalance;
    }

}

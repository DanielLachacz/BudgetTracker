package com.example.budgettracker.viewmodel;

import android.app.Application;

import com.example.budgettracker.data.ExpenseRepository;
import com.example.budgettracker.data.IncomeRepository;
import com.example.budgettracker.data.SharedRepository;
import com.example.budgettracker.data.model.Expense;
import com.example.budgettracker.data.model.Income;


import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class DayFragmentViewModel extends AndroidViewModel {

    private LiveData<Double> totalExpenseValueDay;
    private LiveData<Double> totalIncomeValueDay;
    private LiveData<Double> totalBalanceDay;

    public DayFragmentViewModel(@NonNull Application application) {
        super(application);
        ExpenseRepository expenseRepository = new ExpenseRepository(application);
        IncomeRepository incomeRepository = new IncomeRepository(application);
        SharedRepository sharedRepository = new SharedRepository(application);
        totalExpenseValueDay = expenseRepository.getTotalValueDay();
        totalIncomeValueDay = incomeRepository.getTotalValueDay();
        totalBalanceDay = sharedRepository.getTotalBalanceDay();
    }

    public LiveData<Double> getTotalExpenseValueDay() {
        return totalExpenseValueDay;
    }

    public LiveData<Double> getTotalIncomeValueDay() {
        return totalIncomeValueDay;
    }

    public LiveData<Double> getTotalBalanceDay() {
        return totalBalanceDay;
    }

}

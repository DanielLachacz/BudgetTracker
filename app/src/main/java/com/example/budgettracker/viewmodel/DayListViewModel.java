package com.example.budgettracker.viewmodel;

import android.app.Application;

import com.example.budgettracker.data.ExpenseRepository;
import com.example.budgettracker.data.IncomeRepository;
import com.example.budgettracker.data.model.Expense;
import com.example.budgettracker.data.model.Income;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class DayListViewModel extends AndroidViewModel {

    private ExpenseRepository expenseRepository;
    private IncomeRepository incomeRepository;
    private LiveData<List<Expense>> allExpenses;
    private LiveData<List<Income>> allIncomes;

    public DayListViewModel(@NonNull Application application) {
        super(application);
        expenseRepository = new ExpenseRepository(application);
        incomeRepository = new IncomeRepository(application);
        allExpenses = expenseRepository.getAllExpensesLastDay();
        allIncomes = incomeRepository.getAllIncomesLastDay();
    }

    public LiveData<List<Expense>> getAllExpensesLastDay() {
        return allExpenses;
    }

    public LiveData<List<Income>> getAllIncomesLastDay() {
        return allIncomes;
    }
}

package com.example.budgettracker.viewmodel;

import android.app.Application;

import com.example.budgettracker.data.ExpenseRepository;
import com.example.budgettracker.data.model.Expense;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class AddExpenseViewModel extends AndroidViewModel {

    private ExpenseRepository expenseRepository;

    public AddExpenseViewModel(@NonNull Application application) {
        super(application);
        expenseRepository = new ExpenseRepository(application);
    }

    public void insertExpense(Expense expense) {
        expenseRepository.insertExpense(expense);
    }
}

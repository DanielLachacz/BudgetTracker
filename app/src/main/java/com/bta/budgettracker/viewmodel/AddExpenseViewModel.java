package com.bta.budgettracker.viewmodel;

import android.app.Application;

import com.bta.budgettracker.data.ExpenseRepository;
import com.bta.budgettracker.data.model.Expense;

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

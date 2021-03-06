package com.bta.budgettracker.viewmodel;

import android.app.Application;

import com.bta.budgettracker.data.ExpenseRepository;
import com.bta.budgettracker.data.IncomeRepository;
import com.bta.budgettracker.data.model.Expense;
import com.bta.budgettracker.data.model.Income;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class TotalListViewModel extends AndroidViewModel {

    private ExpenseRepository expenseRepository;
    private IncomeRepository incomeRepository;
    private LiveData<List<Expense>> allExpenses;
    private LiveData<List<Income>> allIncomes;

    public TotalListViewModel(@NonNull Application application) {
        super(application);
        expenseRepository = new ExpenseRepository(application);
        incomeRepository = new IncomeRepository(application);
        allExpenses = expenseRepository.getAllExpenses();
        allIncomes = incomeRepository.getAllIncomes();
    }

    public LiveData<List<Expense>> getAllExpenses() {
        return allExpenses;
    }

    public LiveData<List<Income>> getAllIncomes() {
        return allIncomes;
    }
}

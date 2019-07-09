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

public class DayListViewModel extends AndroidViewModel {

    private LiveData<List<Expense>> allExpensesDay;
    private LiveData<List<Income>> allIncomesDay;

    public DayListViewModel(@NonNull Application application) {
        super(application);
        ExpenseRepository expenseRepository = new ExpenseRepository(application);
        IncomeRepository incomeRepository = new IncomeRepository(application);
        allExpensesDay = expenseRepository.getAllExpensesDay();
        allIncomesDay = incomeRepository.getAllIncomesDay();
    }

    public LiveData<List<Expense>> getAllExpensesDay() {
        return allExpensesDay;
    }

    public LiveData<List<Income>> getAllIncomesDay() {
        return allIncomesDay;
    }
}

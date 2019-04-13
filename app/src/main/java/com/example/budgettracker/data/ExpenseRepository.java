package com.example.budgettracker.data;

import android.app.Application;
import android.os.AsyncTask;


import com.example.budgettracker.data.db.ExpenseIncomeDatabase;
import com.example.budgettracker.data.db.ExpenseDao;
import com.example.budgettracker.data.model.Expense;

import java.util.List;

import androidx.lifecycle.LiveData;

public class ExpenseRepository {

    private ExpenseDao expenseDao;
    private LiveData<List<Expense>> allExpensesDay;
    private LiveData<List<Expense>> allExpensesMonth;
    private LiveData<List<Expense>> allExpenses;
    private LiveData<Double> totalValue;
    private LiveData<Double> totalValueDay;
    private LiveData<Double> totalValueMonth;

    public ExpenseRepository(Application application) {
        ExpenseIncomeDatabase database = ExpenseIncomeDatabase.getInstance(application);
        expenseDao = database.expenseDao();
        allExpenses = expenseDao.getAllExpenses();
        allExpensesDay = expenseDao.getExpensesDay();
        allExpensesMonth = expenseDao.getExpensesMonth();
        totalValueDay = expenseDao.getTotalValueDay();
        totalValueMonth = expenseDao.getTotalValueMonth();
        totalValue = expenseDao.getTotalValue();
    }

    public void insertExpense(Expense expense) {
        new InsertExpenseAsyncTask(expenseDao).execute(expense);
    }

    public LiveData<List<Expense>> getAllExpensesDay() {
        return allExpensesDay;
    }

    public LiveData<List<Expense>> getAllExpensesMonth() {
        return allExpensesMonth;
    }

    public LiveData<List<Expense>> getAllExpenses() {
        return allExpenses;
    }

    public LiveData<Double> getTotalValueDay() {
        return totalValueDay;
    }

    public LiveData<Double> getTotalValueMonth() {
        return totalValueMonth;
    }

    public LiveData<Double> getTotalValue() {
        return totalValue;
    }

    private static class InsertExpenseAsyncTask extends AsyncTask<Expense, Void, Void> {
        private ExpenseDao expenseDao;

        private InsertExpenseAsyncTask(ExpenseDao expenseDao) {
            this.expenseDao = expenseDao;
        }

        @Override
        protected Void doInBackground(Expense... expenses) {
            expenseDao.insertExpense(expenses[0]);
            return null;
        }
    }

}
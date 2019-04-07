package com.example.budgettracker.data;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;


import com.example.budgettracker.data.db.ExpenseIncomeDatabase;
import com.example.budgettracker.data.db.ExpenseDao;
import com.example.budgettracker.data.db.IncomeDao;
import com.example.budgettracker.data.model.Expense;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;

public class ExpenseRepository {

    private ExpenseDao expenseDao;
    private LiveData<List<Expense>> allExpensesLastDay;
    private LiveData<List<Expense>> allExpenses;
    private LiveData<Double> totalValue;
    private LiveData<Double> totalValueDay;
    private LiveData<List<Double>> totalType;
    private String type = "Car";



    public ExpenseRepository(Application application) {
        ExpenseIncomeDatabase database = ExpenseIncomeDatabase.getInstance(application);
        expenseDao = database.expenseDao();
        allExpenses = expenseDao.getAllExpenses();
        allExpensesLastDay = expenseDao.getExpensesByDay();
        totalValueDay = expenseDao.getTotalValueDay();
        totalValue = expenseDao.getTotalValue();
        totalType = expenseDao.getTotalType(type);
    }


    public void insertExpense(Expense expense) {
        new InsertExpenseAsyncTask(expenseDao).execute(expense);
    }

    public LiveData<List<Expense>> getAllExpensesLastDay() {
        return allExpensesLastDay;
    }

    public LiveData<List<Expense>> getAllExpenses() {
        return allExpenses;
    }

    public LiveData<Double> getTotalValueDay() {
        return totalValueDay;
    }

    public LiveData<Double> getTotalValue() {
        return totalValue;
    }

    public LiveData<List<Double>> getTotalType() {
        return totalType;
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
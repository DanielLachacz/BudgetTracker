package com.example.budgettracker.data;

import android.app.Application;
import android.os.AsyncTask;

import com.example.budgettracker.data.db.ExpenseIncomeDatabase;
import com.example.budgettracker.data.db.IncomeDao;
import com.example.budgettracker.data.model.Income;

import java.util.List;

import androidx.lifecycle.LiveData;

public class IncomeRepository {

    private IncomeDao incomeDao;
    private LiveData<List<Income>> allIncomes;
    private LiveData<List<Income>> allIncomesDay;
    private LiveData<List<Income>> allIncomesMonth;
    private LiveData<Double> totalValueDay;
    private LiveData<Double> totalValueMonth;
    private LiveData<Double> totalValue;

    public IncomeRepository(Application application) {
        ExpenseIncomeDatabase database = ExpenseIncomeDatabase.getInstance(application);
        incomeDao = database.incomeDao();
        allIncomes = incomeDao.getAllIncomes();
        allIncomesDay = incomeDao.getIncomesDay();
        allIncomesMonth = incomeDao.getIncomesMonth();
        totalValueDay = incomeDao.getTotalValueDay();
        totalValueMonth = incomeDao.getTotalValueMonth();
        totalValue = incomeDao.getTotalValue();
    }

    public void insertIncome(Income income) {
        new InsertIncomeAsyncTask(incomeDao).execute(income);
    }

    public LiveData<List<Income>> getAllIncomesDay() {
        return allIncomesDay;
    }

    public LiveData<List<Income>> getAllIncomesMonth() {
        return allIncomesMonth;
    }

    public LiveData<List<Income>> getAllIncomes() {
        return allIncomes;
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

    private static class InsertIncomeAsyncTask extends AsyncTask<Income, Void, Void> {
        private IncomeDao incomeDao;

        private InsertIncomeAsyncTask(IncomeDao incomeDao) {
            this.incomeDao = incomeDao;
        }

        @Override
        protected Void doInBackground(Income... incomes) {
            incomeDao.insertIncome(incomes[0]);
            return null;
        }
    }

}

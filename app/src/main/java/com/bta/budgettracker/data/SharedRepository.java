package com.bta.budgettracker.data;

import android.app.Application;
import android.os.AsyncTask;

import com.bta.budgettracker.data.db.ExpenseIncomeDatabase;
import com.bta.budgettracker.data.db.SharedDao;
import com.bta.budgettracker.data.model.Expense;
import com.bta.budgettracker.data.model.Income;

import androidx.lifecycle.LiveData;

public class SharedRepository {

    private SharedDao sharedDao;
    private LiveData<Double> totalBalanceDay;
    private LiveData<Double> totalBalanceMonth;
    private LiveData<Double> totalBalance;

    public SharedRepository(Application application) {
        ExpenseIncomeDatabase database = ExpenseIncomeDatabase.getInstance(application);
        sharedDao = database.sharedDao();
        totalBalance = sharedDao.getTotalBalance();
        totalBalanceDay = sharedDao.getTotalBalanceDay();
        totalBalanceMonth = sharedDao.getTotalBalanceMonth();
    }

    public void deleteAllData() {
        new DeleteIncomeAsyncTask(sharedDao).execute();
        new DeleteExpenseAsyncTask(sharedDao).execute();
    }

    public LiveData<Double> getTotalBalanceDay() {
        return totalBalanceDay;
    }

    public LiveData<Double> getTotalBalanceMonth() {
        return totalBalanceMonth;
    }

    public LiveData<Double> getTotalBalance() {
        return totalBalance;
    }

    private static class DeleteExpenseAsyncTask extends AsyncTask<Expense, Void, Void> {
        private SharedDao sharedDao;

        private DeleteExpenseAsyncTask(SharedDao sharedDao) {
            this.sharedDao = sharedDao;
        }

        @Override
        protected Void doInBackground(Expense... expenses) {
            sharedDao.deleteAllExpenses();
            return null;
        }
    }

    private static class DeleteIncomeAsyncTask extends AsyncTask<Income, Void, Void> {
        private SharedDao sharedDao;

        private DeleteIncomeAsyncTask(SharedDao sharedDao) {
            this.sharedDao = sharedDao;
        }

        @Override
        protected Void doInBackground(Income... incomes) {
            sharedDao.deleteAllIncomes();
            return null;
        }
    }
}

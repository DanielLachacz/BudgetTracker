package com.bta.budgettracker.data;

import android.app.Application;
import android.os.AsyncTask;

import com.bta.budgettracker.data.db.ExpenseIncomeDatabase;
import com.bta.budgettracker.data.db.IncomeDao;
import com.bta.budgettracker.data.model.Income;

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
    private LiveData<Double> totalAwards, totalInvestments, totalSalary, totalRefund, totalRental, totalOthers;
    private LiveData<Double> totalAwardsDay, totalInvestmentsDay, totalSalaryDay, totalRefundDay, totalRentalDay, totalOthersDay;
    private LiveData<Double> totalAwardsMonth, totalInvestmentsMonth, totalSalaryMonth, totalRefundMonth, totalRentalMonth, totalOthersMonth;
    private String awards = "Awards", investments = "Investments", salary = "Salary", refund = "Refund", rental = "Rental", others = "Others";

    public IncomeRepository(Application application) {
        ExpenseIncomeDatabase database = ExpenseIncomeDatabase.getInstance(application);
        incomeDao = database.incomeDao();
        allIncomes = incomeDao.getAllIncomes();
        allIncomesDay = incomeDao.getIncomesDay();
        allIncomesMonth = incomeDao.getIncomesMonth();
        totalValueDay = incomeDao.getTotalValueDay();
        totalValueMonth = incomeDao.getTotalValueMonth();
        totalValue = incomeDao.getTotalValue();

        totalAwards = incomeDao.getTotalIncome(awards);
        totalInvestments = incomeDao.getTotalIncome(investments);
        totalSalary = incomeDao.getTotalIncome(salary);
        totalRefund = incomeDao.getTotalIncome(refund);
        totalRental = incomeDao.getTotalIncome(rental);
        totalOthers = incomeDao.getTotalIncome(others);

        totalAwardsDay = incomeDao.getTotalIncomeDay(awards);
        totalInvestmentsDay = incomeDao.getTotalIncomeDay(investments);
        totalSalaryDay = incomeDao.getTotalIncomeDay(salary);
        totalRefundDay = incomeDao.getTotalIncomeDay(refund);
        totalRentalDay = incomeDao.getTotalIncomeDay(rental);
        totalOthersDay = incomeDao.getTotalIncomeDay(others);

        totalAwardsMonth = incomeDao.getTotalIncomeMonth(awards);
        totalInvestmentsMonth = incomeDao.getTotalIncomeMonth(investments);
        totalSalaryMonth = incomeDao.getTotalIncomeMonth(salary);
        totalRefundMonth = incomeDao.getTotalIncomeMonth(refund);
        totalRentalMonth = incomeDao.getTotalIncomeMonth(rental);
        totalOthersMonth = incomeDao.getTotalIncomeMonth(others);
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

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public LiveData<Double> getTotalAwards() {
        return totalAwards;
    }

    public LiveData<Double> getTotalInvestments() {
        return totalInvestments;
    }

    public LiveData<Double> getTotalSalary() {
        return totalSalary;
    }

    public LiveData<Double> getTotalRefund() {
        return totalRefund;
    }

    public LiveData<Double> getTotalRental() {
        return totalRental;
    }

    public LiveData<Double> getTotalOthers() {
        return totalOthers;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public LiveData<Double> getTotalAwardsDay() {
        return totalAwardsDay;
    }

    public LiveData<Double> getTotalInvestmentsDay() {
        return totalInvestmentsDay;
    }

    public LiveData<Double> getTotalSalaryDay() {
        return totalSalaryDay;
    }

    public LiveData<Double> getTotalRefundDay() {
        return totalRefundDay;
    }

    public LiveData<Double> getTotalRentalDay() {
        return totalRentalDay;
    }

    public LiveData<Double> getTotalOthersDay() {
        return totalOthersDay;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////


    public LiveData<Double> getTotalAwardsMonth() {
        return totalAwardsMonth;
    }

    public LiveData<Double> getTotalInvestmentsMonth() {
        return totalInvestmentsMonth;
    }

    public LiveData<Double> getTotalSalaryMonth() {
        return totalSalaryMonth;
    }

    public LiveData<Double> getTotalRefundMonth() {
        return totalRefundMonth;
    }

    public LiveData<Double> getTotalRentalMonth() {
        return totalRentalMonth;
    }

    public LiveData<Double> getTotalOthersMonth() {
        return totalOthersMonth;
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

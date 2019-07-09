package com.bta.budgettracker.data;

import android.app.Application;
import android.os.AsyncTask;


import com.bta.budgettracker.data.db.ExpenseIncomeDatabase;
import com.bta.budgettracker.data.db.ExpenseDao;
import com.bta.budgettracker.data.model.Expense;

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
    private LiveData<Double> totalBills, totalClothes, totalEntertainment, totalEducation, totalElectronics, totalFood,
            totalHealth, totalHome, totalPet, totalShopping, totalTransport, totalTravel, totalOthers;
    private LiveData<Double> totalBillsDay, totalClothesDay, totalEntertainmentDay, totalEducationDay, totalElectronicsDay, totalFoodDay,
            totalHealthDay, totalHomeDay, totalPetDay, totalShoppingDay, totalTransportDay, totalTravelDay, totalOthersDay;
    private LiveData<Double> totalBillsMonth, totalClothesMonth, totalEntertainmentMonth, totalEducationMonth, totalElectronicsMonth, totalFoodMonth,
            totalHealthMonth, totalHomeMonth, totalPetMonth, totalShoppingMonth, totalTransportMonth, totalTravelMonth, totalOthersMonth;
    private String bills = "Bills", clothes = "Clothes", entertainment = "Entertainment", education = "Education",
            electronics = "Electronics", food = "Food", health = "Health", home = "Home", pet = "Pet", shopping = "Shopping",
            transport = "Transport", travel = "Travel", others = "Others";

    public ExpenseRepository(Application application) {
        ExpenseIncomeDatabase database = ExpenseIncomeDatabase.getInstance(application);
        expenseDao = database.expenseDao();
        allExpenses = expenseDao.getAllExpenses();
        allExpensesDay = expenseDao.getExpensesDay();
        allExpensesMonth = expenseDao.getExpensesMonth();
        totalValueDay = expenseDao.getTotalValueDay();
        totalValueMonth = expenseDao.getTotalValueMonth();
        totalValue = expenseDao.getTotalValue();

        totalBills = expenseDao.getTotalExpense(bills);
        totalClothes = expenseDao.getTotalExpense(clothes);
        totalEntertainment = expenseDao.getTotalExpense(entertainment);
        totalEducation = expenseDao.getTotalExpense(education);
        totalElectronics = expenseDao.getTotalExpense(electronics);
        totalFood = expenseDao.getTotalExpense(food);
        totalHealth = expenseDao.getTotalExpense(health);
        totalHome = expenseDao.getTotalExpense(home);
        totalPet = expenseDao.getTotalExpense(pet);
        totalShopping = expenseDao.getTotalExpense(shopping);
        totalTransport = expenseDao.getTotalExpense(transport);
        totalTravel = expenseDao.getTotalExpense(travel);
        totalOthers = expenseDao.getTotalExpense(others);

        totalBillsDay = expenseDao.getTotalExpenseDay(bills);
        totalClothesDay = expenseDao.getTotalExpenseDay(clothes);
        totalEntertainmentDay = expenseDao.getTotalExpenseDay(entertainment);
        totalEducationDay = expenseDao.getTotalExpenseDay(education);
        totalElectronicsDay = expenseDao.getTotalExpenseDay(electronics);
        totalFoodDay = expenseDao.getTotalExpenseDay(food);
        totalHealthDay = expenseDao.getTotalExpenseDay(health);
        totalHomeDay = expenseDao.getTotalExpenseDay(home);
        totalPetDay = expenseDao.getTotalExpenseDay(pet);
        totalShoppingDay = expenseDao.getTotalExpenseDay(shopping);
        totalTransportDay = expenseDao.getTotalExpenseDay(transport);
        totalTravelDay = expenseDao.getTotalExpenseDay(travel);
        totalOthersDay = expenseDao.getTotalExpenseDay(others);

        totalBillsMonth = expenseDao.getTotalExpenseMonth(bills);
        totalClothesMonth = expenseDao.getTotalExpenseMonth(clothes);
        totalEntertainmentMonth = expenseDao.getTotalExpenseMonth(entertainment);
        totalEducationMonth = expenseDao.getTotalExpenseMonth(education);
        totalElectronicsMonth = expenseDao.getTotalExpenseMonth(electronics);
        totalFoodMonth = expenseDao.getTotalExpenseMonth(food);
        totalHealthMonth = expenseDao.getTotalExpenseMonth(health);
        totalHomeMonth = expenseDao.getTotalExpenseMonth(home);
        totalPetMonth = expenseDao.getTotalExpenseMonth(pet);
        totalShoppingMonth = expenseDao.getTotalExpenseMonth(shopping);
        totalTransportMonth = expenseDao.getTotalExpenseMonth(transport);
        totalTravelMonth = expenseDao.getTotalExpenseMonth(travel);
        totalOthersMonth = expenseDao.getTotalExpenseMonth(others);
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

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public LiveData<Double> getTotalBills() {
        return totalBills;
    }

    public LiveData<Double> getTotalClothes() {
        return totalClothes;
    }

    public LiveData<Double> getTotalEntertainment() {
        return totalEntertainment;
    }

    public LiveData<Double> getTotalEducation() {
        return totalEducation;
    }

    public LiveData<Double> getTotalElectronics() {
        return totalElectronics;
    }

    public LiveData<Double> getTotalFood() {
        return totalFood;
    }

    public LiveData<Double> getTotalHealth() {
        return totalHealth;
    }

    public LiveData<Double> getTotalHome() {
        return totalHome;
    }

    public LiveData<Double> getTotalPet() {
        return totalPet;
    }

    public LiveData<Double> getTotalShopping() {
        return totalShopping;
    }

    public LiveData<Double> getTotalTransport() {
        return totalTransport;
    }

    public LiveData<Double> getTotalTravel() {
        return totalTravel;
    }

    public LiveData<Double> getTotalOthers() {
        return totalOthers;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public LiveData<Double> getTotalBillsDay() {
        return totalBillsDay;
    }

    public LiveData<Double> getTotalClothesDay() {
        return totalClothesDay;
    }

    public LiveData<Double> getTotalEntertainmentDay() {
        return totalEntertainmentDay;
    }

    public LiveData<Double> getTotalEducationDay() {
        return totalEducationDay;
    }

    public LiveData<Double> getTotalElectronicsDay() {
        return totalElectronicsDay;
    }

    public LiveData<Double> getTotalFoodDay() {
        return totalFoodDay;
    }

    public LiveData<Double> getTotalHealthDay() {
        return totalHealthDay;
    }

    public LiveData<Double> getTotalHomeDay() {
        return totalHomeDay;
    }

    public LiveData<Double> getTotalPetDay() {
        return totalPetDay;
    }

    public LiveData<Double> getTotalShoppingDay() {
        return totalShoppingDay;
    }

    public LiveData<Double> getTotalTransportDay() {
        return totalTransportDay;
    }

    public LiveData<Double> getTotalTravelDay() {
        return totalTravelDay;
    }

    public LiveData<Double> getTotalOthersDay() {
        return totalOthersDay;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public LiveData<Double> getTotalBillsMonth() {
        return totalBillsMonth;
    }

    public LiveData<Double> getTotalClothesMonth() {
        return totalClothesMonth;
    }

    public LiveData<Double> getTotalEntertainmentMonth() {
        return totalEntertainmentMonth;
    }

    public LiveData<Double> getTotalEducationMonth() {
        return totalEducationMonth;
    }

    public LiveData<Double> getTotalElectronicsMonth() {
        return totalElectronicsMonth;
    }

    public LiveData<Double> getTotalFoodMonth() {
        return totalFoodMonth;
    }

    public LiveData<Double> getTotalHealthMonth() {
        return totalHealthMonth;
    }

    public LiveData<Double> getTotalHomeMonth() {
        return totalHomeMonth;
    }

    public LiveData<Double> getTotalPetMonth() {
        return totalPetMonth;
    }

    public LiveData<Double> getTotalShoppingMonth() {
        return totalShoppingMonth;
    }

    public LiveData<Double> getTotalTransportMonth() {
        return totalTransportMonth;
    }

    public LiveData<Double> getTotalTravelMonth() {
        return totalTravelMonth;
    }

    public LiveData<Double> getTotalOthersMonth() {
        return totalOthersMonth;
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
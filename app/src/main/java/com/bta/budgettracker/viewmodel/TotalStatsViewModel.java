package com.bta.budgettracker.viewmodel;

import android.app.Application;

import com.bta.budgettracker.data.ExpenseRepository;
import com.bta.budgettracker.data.IncomeRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class TotalStatsViewModel extends AndroidViewModel {

    private LiveData<Double> totalExpenseValue;
    private LiveData<Double> totalIncomeValue;
    private LiveData<Double> totalBills, totalClothes, totalEntertainment, totalEducation, totalElectronics, totalFood,
            totalHealth, totalHome, totalPet, totalShopping, totalTransport, totalTravel, totalOthers;
    private LiveData<Double> totalAwards, totalInvestments, totalSalary, totalRefund, totalRental, totalOthers2;


    public TotalStatsViewModel(@NonNull Application application) {
        super(application);
        ExpenseRepository expenseRepository = new ExpenseRepository(application);
        IncomeRepository incomeRepository = new IncomeRepository(application);
        totalExpenseValue = expenseRepository.getTotalValue();
        totalIncomeValue = incomeRepository.getTotalValue();

        totalBills = expenseRepository.getTotalBills();
        totalClothes = expenseRepository.getTotalClothes();
        totalEntertainment = expenseRepository.getTotalEntertainment();
        totalEducation = expenseRepository.getTotalEducation();
        totalElectronics = expenseRepository.getTotalElectronics();
        totalFood = expenseRepository.getTotalFood();
        totalHealth = expenseRepository.getTotalHealth();
        totalHome = expenseRepository.getTotalHome();
        totalPet = expenseRepository.getTotalPet();
        totalShopping = expenseRepository.getTotalShopping();
        totalTransport = expenseRepository.getTotalTransport();
        totalTravel = expenseRepository.getTotalTravel();
        totalOthers = expenseRepository.getTotalOthers();

        totalAwards = incomeRepository.getTotalAwards();
        totalInvestments = incomeRepository.getTotalInvestments();
        totalSalary = incomeRepository.getTotalSalary();
        totalRefund = incomeRepository.getTotalRefund();
        totalRental = incomeRepository.getTotalRental();
        totalOthers2 = incomeRepository.getTotalOthers();
    }

    public LiveData<Double> getTotalExpenseValue() {
        return totalExpenseValue;
    }

    public LiveData<Double> getTotalIncomeValue() {
        return totalIncomeValue;
    }

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

    public LiveData<Double> getTotalOthers2() {
        return totalOthers2;
    }
}

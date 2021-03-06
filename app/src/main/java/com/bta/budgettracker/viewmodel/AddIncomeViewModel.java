package com.bta.budgettracker.viewmodel;

import android.app.Application;

import com.bta.budgettracker.data.IncomeRepository;
import com.bta.budgettracker.data.model.Income;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class AddIncomeViewModel extends AndroidViewModel {

    private IncomeRepository incomeRepository;

    public AddIncomeViewModel(@NonNull Application application) {
        super(application);
        incomeRepository = new IncomeRepository(application);
    }

    public void insertIncome(Income income) {
        incomeRepository.insertIncome(income);
    }
}

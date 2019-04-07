package com.example.budgettracker.data.db;

import com.example.budgettracker.data.model.Income;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface IncomeDao {

    @Insert
    void insertIncome(Income income);

    @Query("SELECT * FROM income_table WHERE day = strftime('%d', 'now')")
    LiveData<List<Income>> getIncomesByDay();

    @Query("SELECT * FROM income_table")
    LiveData<List<Income>> getAllIncomes();

    @Query("SELECT COALESCE(sum(COALESCE(value,0)), 0) From income_table WHERE day = strftime('%d', 'now')")
    LiveData<Double> getTotalValueDay();

    @Query("SELECT COALESCE(sum(COALESCE(value,0)), 0) From income_table")
    LiveData<Double> getTotalValue();
}

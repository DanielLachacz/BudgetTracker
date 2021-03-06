package com.bta.budgettracker.data.db;

import com.bta.budgettracker.data.model.Income;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface IncomeDao {

    @Insert
    void insertIncome(Income income);

    @Query("SELECT * FROM income_table WHERE day = strftime('%d', 'now')")
    LiveData<List<Income>> getIncomesDay();

    @Query("SELECT * FROM income_table WHERE month = strftime('%m', 'now')")
    LiveData<List<Income>> getIncomesMonth();

    @Query("SELECT * FROM income_table")
    LiveData<List<Income>> getAllIncomes();

    @Query("SELECT COALESCE(sum(COALESCE(value,0)), 0) From income_table WHERE day = strftime('%d', 'now')")
    LiveData<Double> getTotalValueDay();

    @Query("SELECT COALESCE(sum(COALESCE(value,0)), 0) From income_table WHERE month = strftime('%m', 'now')")
    LiveData<Double> getTotalValueMonth();

    @Query("SELECT COALESCE(sum(COALESCE(value,0)), 0) From income_table")
    LiveData<Double> getTotalValue();

    @Query("SELECT COALESCE(sum(COALESCE(value,0)), 0) FROM income_table WHERE type = :type")
    LiveData<Double> getTotalIncome(String type);

    @Query("SELECT COALESCE(sum(COALESCE(value,0)), 0) FROM income_table WHERE type = :type AND day = strftime('%d', 'now')")
    LiveData<Double> getTotalIncomeDay(String type);

    @Query("SELECT COALESCE(sum(COALESCE(value,0)), 0) FROM income_table WHERE type = :type AND month = strftime('%m', 'now')")
    LiveData<Double> getTotalIncomeMonth(String type);
}

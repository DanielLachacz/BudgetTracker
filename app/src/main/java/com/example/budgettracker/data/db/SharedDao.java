package com.example.budgettracker.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface SharedDao {

    @Query("DELETE FROM expense_table")
    void deleteAllExpenses();

    @Query("DELETE FROM income_table")
    void deleteAllIncomes();

    @Query("SELECT (SELECT sum(value) FROM income_table WHERE day = strftime('%d', 'now')) - (SELECT SUM(value) FROM expense_table WHERE day = strftime('%d', 'now'))")
    LiveData<Double> getTotalBalanceDay();

    @Query("SELECT (SELECT sum(value) FROM income_table WHERE month = strftime('%m', 'now')) - (SELECT SUM(value) FROM expense_table WHERE month = strftime('%m', 'now'))")
    LiveData<Double> getTotalBalanceMonth();

    @Query("SELECT (SELECT sum(value) FROM income_table) - (SELECT SUM(value) FROM expense_table)")
    LiveData<Double> getTotalBalance();
}

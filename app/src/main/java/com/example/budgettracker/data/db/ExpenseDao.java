package com.example.budgettracker.data.db;

import com.example.budgettracker.data.model.Expense;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


@Dao
public interface ExpenseDao {

    @Insert
    void insertExpense(Expense expense);

    @Query("SELECT * FROM expense_table WHERE day = strftime('%d', 'now')")
    LiveData<List<Expense>> getExpensesByDay();

    @Query("SELECT * FROM expense_table")
    LiveData<List<Expense>> getAllExpenses();

    @Query("SELECT COALESCE(sum(COALESCE(value,0)), 0) FROM expense_table WHERE day = strftime('%d', 'now')")
    LiveData<Double> getTotalValueDay();

    @Query("SELECT COALESCE(sum(COALESCE(value,0)), 0) FROM expense_table")
    LiveData<Double> getTotalValue();

    @Query("SELECT SUM(value) FROM expense_table WHERE type = :type")
    LiveData<List<Double>> getTotalType(String type);

}

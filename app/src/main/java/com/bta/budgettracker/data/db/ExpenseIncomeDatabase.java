package com.bta.budgettracker.data.db;

import android.content.Context;

import com.bta.budgettracker.data.model.Expense;
import com.bta.budgettracker.data.model.Income;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Expense.class, Income.class}, version = 11)
public abstract class ExpenseIncomeDatabase extends RoomDatabase {

    private static ExpenseIncomeDatabase instance;

    public abstract ExpenseDao expenseDao();
    public abstract IncomeDao incomeDao();
    public abstract SharedDao sharedDao();

    public static synchronized ExpenseIncomeDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ExpenseIncomeDatabase.class, "expense_income_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

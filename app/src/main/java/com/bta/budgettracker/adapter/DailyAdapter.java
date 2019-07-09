package com.bta.budgettracker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bta.budgettracker.R;
import com.bta.budgettracker.data.model.Expense;
import com.bta.budgettracker.data.model.Income;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DailyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int EXPENSE_ITEM = 0;
    private static final int INCOME_ITEM = 1;

    private Context mContext;
    private List<Expense> mExpenses;
    private List<Income> mIncomes;

    public DailyAdapter(Context context, List<Expense> expenses, List<Income> incomes) {
        this.mContext = context;
        this.mExpenses = expenses;
        this.mIncomes = incomes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == EXPENSE_ITEM) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_recyclerview_item, parent, false);
            return new DailyHolder(itemView);
        }
        else if (viewType == INCOME_ITEM) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_recyclerview_item2, parent, false);
            return new DailyHolder2(itemView);
        }
        else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof DailyHolder) {
            ((DailyHolder) holder).populate(mExpenses.get(position));
        }
        if (holder instanceof DailyHolder2) {
            ((DailyHolder2) holder).populate(mIncomes.get(position - mExpenses.size()));
        }

    }

    @Override
    public int getItemCount() {
        return mExpenses.size() + mIncomes.size();
                //mCombinedList == null ? 0 : mCombinedList.size();
    }

    @Override
    public int getItemViewType(int position) {
       if (position < mExpenses.size()) {
           return EXPENSE_ITEM;
       }
       else if (position - mExpenses.size() < mIncomes.size()) {
           return INCOME_ITEM;
       }
       else {
           return -1;
       }
    }

    public void setExpenses(List<Expense> expenses) {
        this.mExpenses = expenses;
        notifyDataSetChanged();
    }

    public void setIncomes(List<Income> incomes) {
        this.mIncomes = incomes;
        notifyDataSetChanged();
    }

    class DailyHolder extends RecyclerView.ViewHolder {
        private TextView numberTextView;
        private TextView dayTextView;
        private TextView dateTextView;
        private TextView typeTextView;
        private TextView noteTextView;
        private TextView valueTextView;

        public DailyHolder(@NonNull View itemView) {
            super(itemView);
            numberTextView = itemView.findViewById(R.id.number_daily_text_view);
            dayTextView = itemView.findViewById(R.id.day_daily_text_view);
            dateTextView = itemView.findViewById(R.id.date_daily_text_view);
            typeTextView = itemView.findViewById(R.id.type_daily_text_view);
            noteTextView = itemView.findViewById(R.id.note_daily_text_view);
            valueTextView = itemView.findViewById(R.id.value_daily_text_view);
        }

        public void populate(Expense expense) {
            numberTextView.setText(String.valueOf(expense.getDay()));
            dayTextView.setText(expense.getWeekDay());
            dateTextView.setText(expense.getDate());
            typeTextView.setText(expense.getType());
            noteTextView.setText(expense.getNote());
            valueTextView.setText(String.valueOf(expense.getValue()));
        }
    }

    class DailyHolder2 extends RecyclerView.ViewHolder {
        private TextView numberTextView2;
        private TextView dayTextView2;
        private TextView dateTextView2;
        private TextView typeTextView2;
        private TextView noteTextView2;
        private TextView valueTextView2;

        public DailyHolder2(@NonNull View itemView) {
            super(itemView);
            numberTextView2 = itemView.findViewById(R.id.number_daily_text_view2);
            dayTextView2 = itemView.findViewById(R.id.day_daily_text_view2);
            dateTextView2 = itemView.findViewById(R.id.date_daily_text_view2);
            typeTextView2 = itemView.findViewById(R.id.type_daily_text_view2);
            noteTextView2 = itemView.findViewById(R.id.note_daily_text_view2);
            valueTextView2 = itemView.findViewById(R.id.value_daily_text_view2);
        }

        public void populate(Income income) {
            numberTextView2.setText(String.valueOf(income.getDay()));
            dayTextView2.setText(income.getWeekDay());
            dateTextView2.setText(income.getDate());
            typeTextView2.setText(income.getType());
            noteTextView2.setText(income.getNote());
            valueTextView2.setText(String.valueOf(income.getValue()));
        }
    }

}

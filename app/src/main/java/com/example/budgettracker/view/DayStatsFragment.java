package com.example.budgettracker.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.budgettracker.R;
import com.example.budgettracker.viewmodel.DayStatsViewModel;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class DayStatsFragment extends Fragment {

    private PieChart pieChart;
    private ArrayList<PieEntry> entries = new ArrayList<>();
    private PieDataSet pieDataSet;
    private PieData data;
    private DayStatsViewModel dayStatsViewModel;
    private Legend legend;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.day_stats_fragment, container, false);

        dayStatsViewModel = ViewModelProviders.of(this).get(DayStatsViewModel.class);

        dayStatsViewModel.getTotalExpenseValueDay().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Expense"));
                pieChart.setData(data);
                pieChart.invalidate();
            }
        });

        dayStatsViewModel.getTotalIncomeValueDay().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Income"));
                pieChart.setData(data);
                pieChart.invalidate();
            }
        });

        pieChart = v.findViewById(R.id.day_pie_chart);

        return v;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {

            pieDataSet = new PieDataSet(entries, "");
            pieChart.setEntryLabelTextSize(16f);
            pieChart.setUsePercentValues(true);
            pieChart.setCenterText("Balance");
            pieChart.setCenterTextSize(23f);
            Description x = null;
            pieChart.setDescription(x);

            ArrayList<PieEntry> entries = new ArrayList<>();

            pieDataSet = new PieDataSet(entries, "");
            pieDataSet.setColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.green));
            pieDataSet.setValueTextSize(20f);
            pieDataSet.setFormSize(20f);
            pieDataSet.setValueTextColor(getResources().getColor(R.color.white));

            data = new PieData(pieDataSet);
            data.setValueFormatter(new PercentFormatter(pieChart));

            legend = pieChart.getLegend();
            legend.setTextSize(14f);

            dayStatsViewModel.getTotalExpenseValueDay().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                    entries.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Expense"));
                    pieChart.setData(data);
                }
            });

            dayStatsViewModel.getTotalIncomeValueDay().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                    entries.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Income"));
                    pieChart.setData(data);
                }
            });

            pieChart.invalidate();
        }
    }
}

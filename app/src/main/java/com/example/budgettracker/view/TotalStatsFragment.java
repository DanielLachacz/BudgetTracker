package com.example.budgettracker.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.budgettracker.R;
import com.example.budgettracker.viewmodel.TotalStatsViewModel;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class TotalStatsFragment extends Fragment {

    private PieChart pieChart;
    private ArrayList<PieEntry> entries = new ArrayList<>();
    private PieDataSet pieDataSet;
    private PieData data;
    private TotalStatsViewModel totalStatsViewModel;
    private Legend legend;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.total_stats_fragment, container, false);

        totalStatsViewModel = ViewModelProviders.of(this).get(TotalStatsViewModel.class);

        totalStatsViewModel.getTotalExpenseValue().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Expense"));
                pieChart.setData(data);
                pieChart.invalidate();
            }
        });

        totalStatsViewModel.getTotalIncomeValue().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Income"));
                pieChart.setData(data);
                pieChart.invalidate();
            }
        });

        pieChart = v.findViewById(R.id.total_pie_chart);

        PieChart pieChart2 = v.findViewById(R.id.total_expense_pie_chart);
        pieChart2.setEntryLabelTextSize(16f);
        //pieChart2.setUsePercentValues(true);
        pieChart2.setCenterText("Expenses");
        pieChart2.setCenterTextSize(23f);

        ArrayList<PieEntry> entries2 = new ArrayList<>();

        PieDataSet pieDataSet2 = new PieDataSet(entries2, "");
        pieDataSet2.setColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.green));
        pieDataSet2.setValueTextSize(20f);
        pieDataSet2.setFormSize(20f);

        pieDataSet2.setValueTextColor(getResources().getColor(R.color.white));

        PieData data2 = new PieData(pieDataSet2);
        pieChart2.invalidate();

        Legend legend2 = pieChart2.getLegend();
        legend2.setTextSize(14f);

        totalStatsViewModel.getTotalType().observe(getViewLifecycleOwner(), new Observer<List<Double>>() {
            @Override
            public void onChanged(List<Double> doubles) {
                Log.d("TSF ", String.valueOf(doubles.get(0).toString()));
            }
        });

        return v;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){

            pieDataSet = new PieDataSet(entries, "");
            pieChart.setEntryLabelTextSize(16f);
            pieChart.setUsePercentValues(true);
            pieChart.setCenterText("Balance");
            pieChart.setCenterTextSize(23f);

            ArrayList<PieEntry> entries = new ArrayList<>();

            pieDataSet = new PieDataSet(entries, "");
            pieDataSet.setColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.green));
            pieDataSet.setValueTextSize(20f);
            pieDataSet.setFormSize(20f);

            pieDataSet.setValueTextColor(getResources().getColor(R.color.white));

            data = new PieData(pieDataSet);

            legend = pieChart.getLegend();
            legend.setTextSize(14f);

            totalStatsViewModel.getTotalExpenseValue().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                    entries.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Expense"));
                    pieChart.setData(data);
                }
            });

            totalStatsViewModel.getTotalIncomeValue().observe(getViewLifecycleOwner(), new Observer<Double>() {
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
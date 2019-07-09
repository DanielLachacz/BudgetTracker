package com.bta.budgettracker.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bta.budgettracker.R;
import com.bta.budgettracker.viewmodel.TotalStatsViewModel;
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

public class TotalStatsFragment extends Fragment {

    private PieChart pieChart, pieChart2, pieChart3;
    private ArrayList<PieEntry> entries = new ArrayList<>();
    private ArrayList<PieEntry> entries2 = new ArrayList<>();
    private ArrayList<PieEntry> entries3 = new ArrayList<>();
    private PieDataSet pieDataSet, pieDataSet2, pieDataSet3;
    private PieData data, data2, data3;
    private TotalStatsViewModel totalStatsViewModel;
    private Legend legend, legend2, legend3;

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

        ////////////////////////////////////////////////////////////////////////////////////////////

        totalStatsViewModel.getTotalBills().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Bills"));
                pieChart2.setData(data2);
                pieChart2.invalidate();
            }
        });

        totalStatsViewModel.getTotalEntertainment().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Entertainment"));
                pieChart2.setData(data2);
                pieChart2.invalidate();
            }
        });

        totalStatsViewModel.getTotalEducation().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Education"));
                pieChart2.setData(data2);
                pieChart2.invalidate();
            }
        });

        totalStatsViewModel.getTotalElectronics().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Electronics"));
                pieChart2.setData(data2);
                pieChart2.invalidate();
            }
        });

        totalStatsViewModel.getTotalFood().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Electronics"));
                pieChart2.setData(data2);
                pieChart2.invalidate();
            }
        });

        totalStatsViewModel.getTotalHealth().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Health"));
                pieChart2.setData(data2);
                pieChart2.invalidate();
            }
        });

        totalStatsViewModel.getTotalHome().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Home"));
                pieChart2.setData(data2);
                pieChart2.invalidate();
            }
        });

        totalStatsViewModel.getTotalPet().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Pet"));
                pieChart2.setData(data2);
                pieChart2.invalidate();
            }
        });

        totalStatsViewModel.getTotalShopping().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Shopping"));
                pieChart2.setData(data2);
                pieChart2.invalidate();
            }
        });

        totalStatsViewModel.getTotalTransport().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Transport"));
                pieChart2.setData(data2);
                pieChart2.invalidate();
            }
        });

        totalStatsViewModel.getTotalTravel().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Travel"));
                pieChart2.setData(data2);
                pieChart2.invalidate();
            }
        });

        totalStatsViewModel.getTotalOthers().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Others"));
                pieChart2.setData(data2);
                pieChart2.invalidate();
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////

        totalStatsViewModel.getTotalAwards().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries3.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Awards"));
                pieChart3.setData(data3);
                pieChart3.invalidate();
            }
        });

        totalStatsViewModel.getTotalInvestments().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries3.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Investments"));
                pieChart3.setData(data3);
                pieChart3.invalidate();
            }
        });

        totalStatsViewModel.getTotalSalary().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries3.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Salary"));
                pieChart3.setData(data3);
                pieChart3.invalidate();
            }
        });

        totalStatsViewModel.getTotalRefund().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries3.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Refund"));
                pieChart3.setData(data3);
                pieChart3.invalidate();
            }
        });

        totalStatsViewModel.getTotalRental().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries3.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Rental"));
                pieChart3.setData(data3);
                pieChart3.invalidate();
            }
        });

        totalStatsViewModel.getTotalOthers2().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                entries3.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Others"));
                pieChart3.setData(data3);
                pieChart3.invalidate();
            }
        });

        pieChart = v.findViewById(R.id.total_pie_chart);
        pieChart2 = v.findViewById(R.id.total_expense_pie_chart);
        pieChart3 = v.findViewById(R.id.total_income_pie_chart);

        return v;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){

            pieDataSet = new PieDataSet(entries, "");
            pieChart.setEntryLabelTextSize(0f);
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

            ////////////////////////////////////////////////////////////////////////////////////////

            pieDataSet2 = new PieDataSet(entries2, "");
            pieChart2.setEntryLabelTextSize(0f);
            pieChart2.setUsePercentValues(true);
            pieChart2.setCenterText("Expenses");
            pieChart2.setCenterTextSize(23f);
            Description x2 = null;
            pieChart2.setDescription(x2);

            ArrayList<PieEntry> entries2 = new ArrayList<>();

            pieDataSet2 = new PieDataSet(entries2, "");
            pieDataSet2.setColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.green),
                    getResources().getColor(R.color.colorPrimary), getResources().getColor(R.color.yellow),
                    getResources().getColor(R.color.azure), getResources().getColor(R.color.black), getResources().getColor(R.color.mint),
                    getResources().getColor(R.color.brown), getResources().getColor(R.color.grey), getResources().getColor(R.color.lightBlue),
                    getResources().getColor(R.color.orange), getResources().getColor(R.color.pink), getResources().getColor(R.color.purple));
            pieDataSet2.setValueTextSize(20f);
            pieDataSet2.setFormSize(20f);
            pieDataSet2.setValueTextColor(getResources().getColor(R.color.white));

            data2 = new PieData(pieDataSet2);
            data2.setValueFormatter(new PercentFormatter(pieChart2));

            legend2 = pieChart2.getLegend();
            legend2.setTextSize(14f);
            legend2.setWordWrapEnabled(true);
            legend2.setXEntrySpace(5f);
            legend2.setYEntrySpace(5f);

            totalStatsViewModel.getTotalBills().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                    if (aDouble > 0) {
                        entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Bills"));
                        pieChart2.setData(data2);
                        pieChart2.invalidate();
                    }
                }
            });

            totalStatsViewModel.getTotalClothes().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                   if (aDouble > 0) {
                       entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Clothes"));
                       pieChart2.setData(data2);
                       pieChart2.invalidate();
                   }
                }
            });

            totalStatsViewModel.getTotalEntertainment().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                    if (aDouble > 0) {
                        entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Entertainment"));
                        pieChart2.setData(data2);
                        pieChart2.invalidate();
                    }
                }
            });

            totalStatsViewModel.getTotalEducation().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                    if (aDouble > 0) {
                        entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Education"));
                        pieChart2.setData(data2);
                        pieChart2.invalidate();
                    }
                }
            });

            totalStatsViewModel.getTotalElectronics().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                   if (aDouble > 0) {
                       entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Electronics"));
                       pieChart2.setData(data2);
                       pieChart2.invalidate();
                   }
                }
            });

            totalStatsViewModel.getTotalFood().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                   if (aDouble > 0) {
                       entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Food"));
                       pieChart2.setData(data2);
                       pieChart2.invalidate();
                   }
                }
            });

            totalStatsViewModel.getTotalHealth().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                   if (aDouble > 0) {
                       entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Health"));
                       pieChart2.setData(data2);
                       pieChart2.invalidate();
                   }
                }
            });

            totalStatsViewModel.getTotalHome().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                   if (aDouble > 0) {
                       entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Home"));
                       pieChart2.setData(data2);
                       pieChart2.invalidate();
                   }
                }
            });

            totalStatsViewModel.getTotalPet().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                   if (aDouble > 0) {
                       entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Pet"));
                       pieChart2.setData(data2);
                       pieChart2.invalidate();
                   }
                }
            });

            totalStatsViewModel.getTotalShopping().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                   if (aDouble > 0) {
                       entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Shopping"));
                       pieChart2.setData(data2);
                       pieChart2.invalidate();
                   }
                }
            });

            totalStatsViewModel.getTotalTransport().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                    if (aDouble > 0) {
                        entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Transport"));
                        pieChart2.setData(data2);
                        pieChart2.invalidate();
                    }
                }
            });

            totalStatsViewModel.getTotalTravel().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                   if (aDouble > 0) {
                       entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Travel"));
                       pieChart2.setData(data2);
                       pieChart2.invalidate();
                   }
                }
            });

            totalStatsViewModel.getTotalOthers().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                   if (aDouble > 0) {
                       entries2.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Others"));
                       pieChart2.setData(data2);
                       pieChart2.invalidate();
                   }
                }
            });

            ////////////////////////////////////////////////////////////////////////////////////////

            pieDataSet3 = new PieDataSet(entries3, "");
            pieChart3.setEntryLabelTextSize(0f);
            pieChart3.setUsePercentValues(true);
            pieChart3.setCenterText("Incomes");
            pieChart3.setCenterTextSize(23f);
            Description x3 = null;
            pieChart3.setDescription(x3);

            ArrayList<PieEntry> entries3 = new ArrayList<>();

            pieDataSet3 = new PieDataSet(entries3, "");
            pieDataSet3.setColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.green),
                    getResources().getColor(R.color.colorPrimary), getResources().getColor(R.color.yellow),
                    getResources().getColor(R.color.azure), getResources().getColor(R.color.purple));
            pieDataSet3.setValueTextSize(20f);
            pieDataSet3.setFormSize(20f);
            pieDataSet3.setValueTextColor(getResources().getColor(R.color.white));
            pieDataSet3.setSliceSpace(0f);

            data3 = new PieData(pieDataSet3);
            data3.setValueFormatter(new PercentFormatter(pieChart3));

            legend3 = pieChart3.getLegend();
            legend3.setTextSize(14f);
            legend3.setWordWrapEnabled(true);
            legend3.setXEntrySpace(5f);
            legend3.setYEntrySpace(5f);

            totalStatsViewModel.getTotalAwards().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                   if (aDouble > 0) {
                       entries3.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Awards"));
                       pieChart3.setData(data3);
                       pieChart3.invalidate();
                   }
                }
            });

            totalStatsViewModel.getTotalInvestments().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                    if (aDouble > 0) {
                        entries3.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Investments"));
                        pieChart3.setData(data3);
                        pieChart3.invalidate();
                    }
                }
            });

            totalStatsViewModel.getTotalSalary().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                    if (aDouble > 0) {
                        entries3.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Salary"));
                        pieChart3.setData(data3);
                        pieChart3.invalidate();
                    }
                }
            });

            totalStatsViewModel.getTotalRefund().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                   if (aDouble > 0) {
                       entries3.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Refund"));
                       pieChart3.setData(data3);
                       pieChart3.invalidate();
                   }
                }
            });

            totalStatsViewModel.getTotalRental().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                    if (aDouble > 0) {
                        entries3.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Rental"));
                        pieChart3.setData(data3);
                        pieChart3.invalidate();
                    }
                }
            });

            totalStatsViewModel.getTotalOthers2().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                    if (aDouble > 0) {
                        entries3.add(new PieEntry(Float.valueOf(String.valueOf(aDouble)), "Others"));
                        pieChart3.setData(data3);
                        pieChart3.invalidate();
                    }
                }
            });
        }
    }
}

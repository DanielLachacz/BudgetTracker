package com.example.budgettracker.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.budgettracker.R;
import com.example.budgettracker.viewmodel.OptionsFragmentViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

public class OptionsFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_fragment, container, false);

        OptionsFragmentViewModel optionsFragmentViewModel = ViewModelProviders.of(this).get(OptionsFragmentViewModel.class);

        FloatingActionButton fabCancel = v.findViewById(R.id.fab_cancel_button);
        FloatingActionButton fabExpense = v.findViewById(R.id.fab_expense_button);
        FloatingActionButton fabIncome = v.findViewById(R.id.fab_income_button);
        FloatingActionButton fabDelete = v.findViewById(R.id.fab_delete_button);

        fabCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        fabExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          Fragment fragment = new AddExpenseFragment();
          FragmentManager fragmentManager = getFragmentManager();
          FragmentTransaction transaction = fragmentManager.beginTransaction();
          transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
          transaction.addToBackStack(null);
          transaction.add(R.id.wallet_activity, fragment);
          transaction.commit();
          getDialog().dismiss();
            }
        });

        fabIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new AddIncomeFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                transaction.addToBackStack(null);
                transaction.add(R.id.wallet_activity, fragment);
                transaction.commit();
                getDialog().dismiss();

            }
        });

        fabDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //optionsFragmentViewModel.deleteAllData();

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                builder.setMessage("Are you sure you want to delete data")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                optionsFragmentViewModel.deleteAllData();
                            }
                        })

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        return v;
    }


}

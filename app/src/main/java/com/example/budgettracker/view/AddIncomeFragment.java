package com.example.budgettracker.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.budgettracker.R;
import com.example.budgettracker.data.model.Income;
import com.example.budgettracker.viewmodel.AddIncomeViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;


public class AddIncomeFragment extends Fragment {

    private EditText valueEditText, noteEditText;
    private String type;
    private AddIncomeViewModel addIncomeViewModel;
    private String[] incomes = {"Awards", "Investments", "Salary", "Refund", "Rental", "Others"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_income_fragment, container, false);

        addIncomeViewModel = ViewModelProviders.of(this).get(AddIncomeViewModel.class);

        ImageButton backButton = v.findViewById(R.id.back_button);
        FloatingActionButton addIncomeButton = v.findViewById(R.id.add_income_button);
        valueEditText = v.findViewById(R.id.income_value_edit_text);
        noteEditText = v.findViewById(R.id.income_note_edit_text);

        FloatingActionButton floatingActionButton = ((WalletActivity) getActivity()).getFabButton();
        if (floatingActionButton != null) {
            floatingActionButton.hide();
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
                hideKeyboard(v.getContext());
            }
        });

        Spinner spinner = v.findViewById(R.id.income_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.spinner_item, incomes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addIncomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valueEditText.getText().toString().trim().isEmpty() && noteEditText.getText().toString().isEmpty()) {
                    String text = "Value and Note are empty!";
                    SpannableStringBuilder biggerText = new SpannableStringBuilder(text);
                    biggerText.setSpan(new RelativeSizeSpan(1.35f), 0, text.length(), 0);
                    Toast toast = Toast.makeText(getActivity(), biggerText, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    return;
                }
                else if (noteEditText.getText().toString().trim().isEmpty()) {
                    String text = "Note is empty!";
                    SpannableStringBuilder biggerText = new SpannableStringBuilder(text);
                    biggerText.setSpan(new RelativeSizeSpan(1.35f), 0, text.length(), 0);
                    Toast toast = Toast.makeText(getActivity(), biggerText, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    return;
                }
                else if (valueEditText.getText().toString().trim().isEmpty()) {
                    String text = "Value is empty!";
                    SpannableStringBuilder biggerText = new SpannableStringBuilder(text);
                    biggerText.setSpan(new RelativeSizeSpan(1.35f), 0, text.length(), 0);
                    Toast toast = Toast.makeText(getActivity(), biggerText, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    return;
                }

                saveIncome();

                valueEditText.setText("");
                noteEditText.setText("");
            }
        });

        return v;
    }

    private void saveIncome() {
        Double value = Double.parseDouble(valueEditText.getText().toString());
        String note = noteEditText.getText().toString();

        Income income = new Income(value, note, type);
        addIncomeViewModel.insertIncome(income);

        String text = "Income saved";
        SpannableStringBuilder biggerText = new SpannableStringBuilder(text);
        biggerText.setSpan(new RelativeSizeSpan(1.35f), 0, text.length(), 0);
        Toast toast = Toast.makeText(getActivity(), biggerText, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }

    public static void hideKeyboard(Context mContext) {

        try {

            View view = ((Activity) mContext).getWindow().getCurrentFocus();

            if (view != null && view.getWindowToken() != null) {

                IBinder binder = view.getWindowToken();

                InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(binder, 0);

            }

        } catch (NullPointerException e) {

            e.printStackTrace();

        }
    }

}

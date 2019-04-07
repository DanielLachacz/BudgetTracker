package com.example.budgettracker.viewmodel;

import android.app.Application;

import com.example.budgettracker.data.SharedRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class OptionsFragmentViewModel extends AndroidViewModel {

    private SharedRepository sharedRepository;

    public OptionsFragmentViewModel(@NonNull Application application) {
        super(application);
        sharedRepository = new SharedRepository(application);
    }

    public void deleteAllData() {
        sharedRepository.deleteAllData();
    }
}

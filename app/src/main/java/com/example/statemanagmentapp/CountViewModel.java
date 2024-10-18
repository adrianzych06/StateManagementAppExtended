package com.example.statemanagmentapp;

import androidx.lifecycle.ViewModel;


public class CountViewModel extends ViewModel {
    private int count = 0; // zmienna do przechowywania wartosci licznika

    public int getCount() {
        return count; // zwroc aktualna wartosc licznika
    }

    public void incrementCount() {
        count++; // zwieksz wartosc licznika
    }
}

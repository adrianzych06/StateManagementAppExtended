package com.example.statemanagmentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProvider;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    CheckBox ch;
    EditText editText;
    private CountViewModel countViewModel;
    private TextView textViewCount;
    private Switch switch1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        CheckBox ch = findViewById(R.id.checkBox);
        textViewCount = findViewById(R.id.textViewCount);
        Button buttonIncrement = findViewById(R.id.buttonIncrement);
        editText = findViewById(R.id.EditText);
        Switch switch1 = findViewById(R.id.switch1);
        TextView TextView2 = findViewById(R.id.TextView2);



        ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    TextView2.setVisibility(View.VISIBLE);
                }else {
                    TextView2.setVisibility(View.GONE);
                }
            }
        });



        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });



        countViewModel = new ViewModelProvider(this) .get(CountViewModel.class);
        updateCountText();
        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countViewModel.incrementCount();

                updateCountText();
            }
        });

    }



    private void updateCountText() {
        textViewCount.setText("Licznik: " + countViewModel.getCount());

    }
}

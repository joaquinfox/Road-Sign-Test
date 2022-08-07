package com.joaquin.roadsigntest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.util.Log;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tView = findViewById(R.id.textView);
        RadioGroup rg = findViewById(R.id.radioGroup);
        RadioButton checkedRadioButton = (RadioButton) rg.findViewById(rg.getCheckedRadioButtonId());

        String answer;
        answer = renderRandomImage(tView);
        // Event listener on radio group and child buttons
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(id);
            }
        });

        renderRandomImage(tView);
    }

    public String renderRandomImage(View view) {
        Random random = new Random();
        int rand = random.nextInt(4);
        String correctResponse = "";
        switch (rand) {
            case 0:
                view.setBackgroundResource(R.drawable.divided_lane);
                correctResponse = "Divided Lane";
                break;
            case 1:
                view.setBackgroundResource(R.drawable.double_turn);
                correctResponse = "Double Turn";

                break;
            case 2:
                view.setBackgroundResource(R.drawable.lane_ends);
                correctResponse = "Lane Ends";

                break;
            case 3:
                view.setBackgroundResource(R.drawable.swerving_car);
                correctResponse = "Swerving Car";
                break;
            default:
                Log.i(TAG, "Something horrible has happened");
        }

        return correctResponse;
    }
}
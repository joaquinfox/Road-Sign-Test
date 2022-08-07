package com.joaquin.roadsigntest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tView = findViewById(R.id.textView);
        RadioGroup rg = findViewById(R.id.radioGroup);
        RadioButton checkedRadioButton = (RadioButton) rg.findViewById(rg.getCheckedRadioButtonId());

        String correctAnswer;
        correctAnswer = renderRandomImage(tView);
        // Event listener on radio group and child buttons
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(id);
                String userAnswer = checkedRadioButton.getText().toString();

                evaluateAnswer(correctAnswer, userAnswer);
            }
        });

    }

    public String renderRandomImage(View view) {
        Random random = new Random();
        int rand = random.nextInt(4);
        String correctResponse = "";
//        Log.i(TAG, "rand: " + rand);
        switch (rand) {
            case 0:
                view.setBackgroundResource(R.drawable.swerving_car);
                correctResponse = "Swerving Car";
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
                view.setBackgroundResource(R.drawable.divided_lane);
                correctResponse = "Divided Lane";
                break;
            default:
                Log.i(TAG, "Something horrible has happened");
        }
//        Log.i(TAG, " " + correctResponse);
        return correctResponse;
    }

    public void evaluateAnswer(String correctAnswer, String userAnswer) {
        Context context = getApplicationContext();
        CharSequence ifCorrect = "Correct";
        CharSequence ifWrong = "Try again";
        int duration = Toast.LENGTH_SHORT;
        if (correctAnswer.equals(userAnswer)) {
            Toast.makeText(context, ifCorrect, duration).show();
        } else {
            Toast.makeText(context, ifWrong, duration).show();
        }
        Log.i(TAG, "userAnswer: " + userAnswer + " correctAnswer: " + correctAnswer);
    }
}
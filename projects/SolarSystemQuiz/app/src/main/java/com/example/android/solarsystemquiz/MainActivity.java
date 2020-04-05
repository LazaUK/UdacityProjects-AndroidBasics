package com.example.android.solarsystemquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double mScore1 = 0;
    double mScore2 = 0;
    double mScore3 = 0;
    double mScore4_1 = 0;
    double mScore4_2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioQ1Clicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Assign the score to this question
        if (checked) {
            if (view.getId() == R.id.q1_b) {
                mScore1 = 25;
            } else {
                mScore1 = 0;
            }
        }
        Log.v("MainActivity", "Score for question 1 is " + mScore1);
    }

    public void onRadioQ2Clicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Assign the score to this question
        if (checked) {
            if (view.getId() == R.id.q2_b) {
                mScore2 = 25;
            } else {
                mScore2 = 0;
            }
        }
        Log.v("MainActivity", "Score for question 2 is " + mScore2);
    }

    public void onRadioQ3Clicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Assign the score to this question
        if (checked) {
            if (view.getId() == R.id.q3_c) {
                mScore3 = 25;
            } else {
                mScore3 = 0;
            }
        }
        Log.v("MainActivity", "Score for question 3 is " + mScore3);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.q4_b:
                if (checked) {
                    mScore4_1 = 12.5;
                } else {
                    mScore4_1 = 0;
                }
                break;
            case R.id.q4_d:
                if (checked) {
                    mScore4_2 = 12.5;
                } else {
                    mScore4_2 = 0;
                }
                break;
        }
        Log.v("MainActivity", "Score for question 4 is " + (mScore4_1 + mScore4_2));
    }

    public void onButtonClicked(View view) {
        // Check the total score
        double totalScore = mScore1 + mScore2 + mScore3 + mScore4_1 + mScore4_2;
        boolean highestScore = totalScore > 90;
        CharSequence textExtra = "";
        if (highestScore) {
            textExtra = " Well done!";
        } else {
            textExtra = " You could do better, please try again!";
        }

        // Create toast message
        Context context = getApplicationContext();
        CharSequence textToast = "Your total score is " + totalScore + "% " + textExtra;
        int durationToast = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, textToast, durationToast);
        toast.show();

        Log.v("MainActivity", "Total score is " + totalScore);
        Log.v("MainActivity", "Is this the highest score: " + highestScore);
    }
}

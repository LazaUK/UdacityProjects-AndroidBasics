package com.example.android.solarsystemquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int mScore0 = 0;
    int mScore1 = 0;
    int mScore2 = 0;
    int mScore3 = 0;
    int mScore4_1 = 0;
    int mScore4_2 = 0;
    int mScore4_3 = 0;
    int mScore4_4 = 0;

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
                mScore1 = 20;
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
                mScore2 = 20;
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
                mScore3 = 20;
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
            case R.id.q4_a:
                if (checked) {
                    mScore4_1 = -10;
                } else {
                    mScore4_1 = 0;
                }
                break;
            case R.id.q4_b:
                if (checked) {
                    mScore4_2 = 10;
                } else {
                    mScore4_2 = 0;
                }
                break;
            case R.id.q4_c:
                if (checked) {
                    mScore4_3 = -10;
                } else {
                    mScore4_3 = 0;
                }
                break;
            case R.id.q4_d:
                if (checked) {
                    mScore4_4 = 10;
                } else {
                    mScore4_4 = 0;
                }
                break;
        }
        Log.v("MainActivity", "Score for question 4 is " +
                (mScore4_1 + mScore4_2 + mScore4_3 + mScore4_4));
    }

    public void onButtonClicked(View view) {
        // Check the star name
        EditText starNameView = (EditText) findViewById(R.id.starname);
        String starName = starNameView.getText().toString().toLowerCase();
        if(starName.equals("sun")) {
            mScore0 = 20;
        } else {
            mScore0 = 0;
        }

        // Check the total score
        int totalScore = mScore0 + mScore1 + mScore2 + mScore3 +
                mScore4_1 + mScore4_2 + mScore4_3 + mScore4_4;
        boolean highestScore = totalScore > 90;

        CharSequence textExtra = "";
        if (highestScore) {
            textExtra = "Well done !";
        } else {
            textExtra = "You could do better, please try again !";
        }

        // Create toast message
        Context context = getApplicationContext();
        CharSequence textToast = "Your total score is " + totalScore + "% " + textExtra;
        int durationToast = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, textToast, durationToast);
        toast.show();

        Log.v("MainActivity", "Star name provided is " + starName);
        Log.v("MainActivity", "Total score is " + totalScore);
        Log.v("MainActivity", "Is this the highest score: " + highestScore);
    }
}

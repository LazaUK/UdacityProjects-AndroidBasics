package com.example.android.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String scoreTeamRed = "";
    String scoreTeamGreen = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayForTeamRed(String score) {
        TextView scoreView = (TextView) findViewById(R.id.team_red_score);
        scoreView.setText(score);
    }

    public void displayForTeamGreen(String score) {
        TextView scoreView = (TextView) findViewById(R.id.team_green_score);
        scoreView.setText(score);
    }

    public void teamGreenGame(View view) {
        scoreTeamRed = "---";
        scoreTeamGreen = "Won";
        displayForTeamRed(scoreTeamRed);
        displayForTeamGreen(scoreTeamGreen);
    }

    public void teamGreenAdvantage(View view) {
        scoreTeamGreen = "A";
        displayForTeamGreen(scoreTeamGreen);
    }

    public void teamGreenThree(View view) {
        scoreTeamGreen = "40";
        displayForTeamGreen(scoreTeamGreen);
    }

    public void teamGreenTwo(View view) {
        scoreTeamGreen = "30";
        displayForTeamGreen(scoreTeamGreen);
    }

    public void teamGreenOne(View view) {
        scoreTeamGreen = "15";
        displayForTeamGreen(scoreTeamGreen);
    }

    public void teamRedGame(View view) {
        scoreTeamRed = "Won";
        scoreTeamGreen = "---";
        displayForTeamRed(scoreTeamRed);
        displayForTeamGreen(scoreTeamGreen);
    }

    public void teamRedAdvantage(View view) {
        scoreTeamRed = "A";
        displayForTeamRed(scoreTeamRed);
    }

    public void teamRedThree(View view) {
        scoreTeamRed = "40";
        displayForTeamRed(scoreTeamRed);
    }

    public void teamRedTwo(View view) {
        scoreTeamRed = "30";
        displayForTeamRed(scoreTeamRed);
    }

    public void teamRedOne(View view) {
        scoreTeamRed = "15";
        displayForTeamRed(scoreTeamRed);
    }

    public void newGame(View view) {
        scoreTeamRed = "love";
        scoreTeamGreen = "love";
        displayForTeamRed(scoreTeamRed);
        displayForTeamGreen(scoreTeamGreen);
    }

}

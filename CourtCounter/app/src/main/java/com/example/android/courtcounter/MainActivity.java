package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Global variables
    int totalPointsA = 0;
    int totalPointsB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(totalPointsA);
        displayForTeamB(totalPointsB);
    }

    public void reset(View view){
        totalPointsA = 0;
        totalPointsB = 0;
        displayForTeamA(totalPointsA);
        displayForTeamB(totalPointsB);
    }

    //Add points to team A
    public void markPoint1(View view){
        totalPointsA = totalPointsA + 1;
        displayForTeamA(totalPointsA);
    }
    public void markPoint2(View view){
        totalPointsA = totalPointsA + 2;
        displayForTeamA(totalPointsA);
    }
    public void markPoint3(View view){
        totalPointsA = totalPointsA + 3;
        displayForTeamA(totalPointsA);
    }

//---------------------------------------

    //Add points to team B
    public void markPointB1(View view){
        totalPointsB = totalPointsB + 1;
        displayForTeamB(totalPointsB);
    }
    public void markPointB2(View view){
        totalPointsB = totalPointsB + 2;
        displayForTeamB(totalPointsB);
    }
    public void markPointB3(View view){
        totalPointsB = totalPointsB + 3;
        displayForTeamB(totalPointsB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}

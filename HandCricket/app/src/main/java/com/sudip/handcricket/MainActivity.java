package com.sudip.handcricket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
    private int batBowl = 2;
    private int playerRuns = 0;
    private int playerWicket = 0;
    private int comRuns = 0;
    private int comWicket = 0;
    private ThreadLocalRandom randomNumberGenerator = ThreadLocalRandom.current();

    public void playOne(View view) {
        play(1);
    }

    public void playTwo(View view) {
        play(2);
    }

    public void playThree(View view) {
        play(3);
    }

    public void playFour(View view) {
        play(4);
    }

    public void playFive(View view) {
        play(5);
    }

    public void playSix(View view) {
        play(6);
    }

    private void play(int input) {
        if (batBowl == 1) {
            bat(input);
        } else if (batBowl == 0) {
            bowl(input);
        }
    }

    private void bat(int playerScore) {
        int comBall = randomNumberGenerator.nextInt(1, 7);

        TextView comPlayTextView = (TextView) findViewById(R.id.comPlay);
        comPlayTextView.setText("Com played " + comBall);

        if (comBall == playerScore) {
            playerWicket += 1;
        } else {
            playerRuns += playerScore;
        }

        if (playerWicket < 10) {
            TextView playerRunsTextView = (TextView) findViewById(R.id.playerRunsText);
            playerRunsTextView.setText(("Player " + playerRuns + "/" + playerWicket));
        } else if (comWicket == 0) {
            batBowl = 0;
            TextView playerRunsTextView = (TextView) findViewById(R.id.playerRunsText);
            playerRunsTextView.setText(("Player " + playerRuns + "/" + playerWicket));
        } else {
            batBowl = 2;
            TextView playerRunsTextView = (TextView) findViewById(R.id.playerRunsText);
            playerRunsTextView.setText(("Player " + playerRuns + "/" + playerWicket));

            TextView gameStatusTextView = (TextView) findViewById(R.id.gameStatus);
            if (playerRuns > comRuns) {
                gameStatusTextView.setText("Player Won");
            } else if (playerRuns > comRuns) {
                gameStatusTextView.setText("Player Lost");
            } else {
                gameStatusTextView.setText("Match Draw");
            }
        }
    }

    private void bowl(int playerBall) {
        int comScore = randomNumberGenerator.nextInt(1, 7);

        TextView comPlayTextView = (TextView) findViewById(R.id.comPlay);
        comPlayTextView.setText("Com played " + comScore);

        if (comScore == playerBall) {
            comWicket += 1;
        } else {
            comRuns += comScore;
        }

        if (comWicket < 10) {
            TextView comRunsTextView = (TextView) findViewById(R.id.comRunsText);
            comRunsTextView.setText(("Com " + comRuns + "/" + comWicket));
        } else if (playerWicket == 0) {
            batBowl = 1;
            TextView comRunsTextView = (TextView) findViewById(R.id.comRunsText);
            comRunsTextView.setText(("Com " + comRuns + "/" + comWicket));
        } else {
            batBowl = 2;
            TextView comRunsTextView = (TextView) findViewById(R.id.comRunsText);
            comRunsTextView.setText(("Com " + comRuns + "/" + comWicket));

            TextView gameStatusTextView = (TextView) findViewById(R.id.gameStatus);
            if (playerRuns > comRuns) {
                gameStatusTextView.setText("Player Won");
            } else if (playerRuns < comRuns) {
                gameStatusTextView.setText("Player Lost");
            } else {
                gameStatusTextView.setText("Match Draw");
            }
        }
    }

    public void restartGame(View view) {
        batBowl = toss();
        playerRuns = 0;
        playerWicket = 0;
        comRuns = 0;
        comWicket = 0;

        TextView playerRunsTextView = (TextView) findViewById(R.id.playerRunsText);
        playerRunsTextView.setText(("Player " + playerRuns + "/" + playerWicket));

        TextView comRunsTextView = (TextView) findViewById(R.id.comRunsText);
        comRunsTextView.setText(("Com " + comRuns + "/" + comWicket));

        Button playGame = (Button) findViewById(R.id.restartButton);
        playGame.setText("RESTART");
    }

    private int toss() {
        int tossReturn = randomNumberGenerator.nextInt(0, 2);
        TextView gameStatusTextView = (TextView) findViewById(R.id.gameStatus);
        if (tossReturn == 0){
            gameStatusTextView.setText("Com chose to bat first");
        }else{
            gameStatusTextView.setText("Com chose to bowl first");
        }
        return tossReturn;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
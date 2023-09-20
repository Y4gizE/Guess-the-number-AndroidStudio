package com.ege.higherorlower;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void makeToast(String string){
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    int randomNumber;
    public void guess(View view) {
        Random rand = new Random();
        EditText guessEditText = (EditText) findViewById(R.id.guessEditText);
        String guessStr = guessEditText.getText().toString();

        if (guessStr.isEmpty()) {
            makeToast("Please insert a number");
            return;
        }

        int guessInt = Integer.parseInt(guessStr);

        if (guessInt > randomNumber) {
            makeToast("Lower");
        } else if (guessInt < randomNumber) {
            makeToast("Higher");
        } else {
            makeToast("Correct!");
            randomNumber = rand.nextInt(20) + 1;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1 ;
    }
}
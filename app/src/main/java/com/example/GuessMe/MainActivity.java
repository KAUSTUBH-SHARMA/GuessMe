package com.example.GuessMe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText guessText;
    int computerNumber;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guessText=findViewById(R.id.editTextGuess);
        computerNumber=new Random().nextInt(100)+1;
        count=0;

    }
    public void buttonClicked(View view){
        String numberGuessed=guessText.getText().toString();
        if(numberGuessed.isEmpty()){
            Toast.makeText(this,"Enter a number please",Toast.LENGTH_SHORT).show();
            return;
        }
        int guess=Integer.parseInt(numberGuessed);

        if(guess<computerNumber){
            count++;
            Toast.makeText(this,"Number is Greater Then "+guess+" AttemptNo:"+count,Toast.LENGTH_SHORT).show();
        }
        else if(guess>computerNumber){
            count++;
            Toast.makeText(this,"Number is Less then"+guess+" Attempt No:"+count ,Toast.LENGTH_SHORT).show();
        }
        else {
            count++;
            Toast.makeText(this,"You Guessed It Correct Attempt No:"+count,Toast.LENGTH_SHORT).show();
            guessText.setText("");
            computerNumber=new Random().nextInt(100)+1;

            count=0;
        }

    }


}

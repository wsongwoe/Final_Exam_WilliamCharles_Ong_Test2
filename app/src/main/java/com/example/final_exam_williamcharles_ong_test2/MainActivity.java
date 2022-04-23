package com.example.final_exam_williamcharles_ong_test2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    EditText questionOne, answerOne;
    Button buttonAdd, buttonSubmit, buttonPreview;
    private String PREFER_NAME;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);

        questionOne = findViewById(R.id.questionOne);
        answerOne = findViewById(R.id.answerOne);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper myDB = new DBHelper(MainActivity.this);
                boolean result = myDB.insertQuestion(questionOne.getText().toString().trim(),
                        answerOne.getText().toString().trim());
                if (result) {
                    Toast.makeText(getApplicationContext(), "Saved Successfully", Toast.LENGTH_SHORT).show();
                    //clear fields

                    questionOne.setText(null);
                    answerOne.setText(null);

                    questionOne.requestFocus();
                } else {
                    Toast.makeText(getApplicationContext(), "Error Encountered while Saving.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);

                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);

                finish();
            }
        });
        buttonPreview = findViewById(R.id.buttonPreview);
        buttonPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PreviewQuestion.class);


                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);

                finish();
            }
        });

    }
}
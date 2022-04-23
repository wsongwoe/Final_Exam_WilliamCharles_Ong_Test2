package com.example.final_exam_williamcharles_ong_test2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddQuestion extends AppCompatActivity {
    EditText questionOne,answerOne;
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionOne = findViewById(R.id.questionOne);
        answerOne = findViewById(R.id.answerOne);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper myDB = new DBHelper(AddQuestion.this);
                myDB.insertQuestion(questionOne.getText().toString().trim(),
                        answerOne.getText().toString().trim());
            }
        });
    }
}

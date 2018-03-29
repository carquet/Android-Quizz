package com.example.android.quizapp;


import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton q1;
    RadioButton q2;
    CheckBox q3Answer1;
    CheckBox q3Answer3;
    CheckBox q3Answer4;
    EditText q4Answer;
    Integer answeredCorrectly;
    String instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answeredCorrectly = 0;
        instructions = "";
        q1 = findViewById(R.id.radio_question1_answer3);
        q2 = findViewById(R.id.radio_question2_answer2);
        q3Answer1 = findViewById(R.id.checkbox_question3_answer1);
        q3Answer3 = findViewById(R.id.checkbox_question3_answer3);
        q3Answer4 = findViewById(R.id.checkbox_question3_answer4);
        q4Answer = findViewById(R.id.free_answer_question4);

    }

    /**
     * This method is called when the submit button is clicked. It calls the methods that checks whether the correct button is checked or not and displays the total result.
     */


    public void submitAnswer(View view){
        checkRadioQuestions(q1);
        checkRadioQuestions(q2);
        checkQuestion3(q3Answer1, q3Answer3, q3Answer4);
        checkQuestion4(q4Answer);
        String toastMessage = getString(R.string.toast_message, answeredCorrectly);
        Toast.makeText(MainActivity.this,
                toastMessage, Toast.LENGTH_SHORT).show();
        answeredCorrectly = 0;
    }

    /**
     * This method checks whether the correct radio button has been checked and add the count of good answers
     * @param question are the correct radio buttons checked.
     *
     */
    void checkRadioQuestions(RadioButton question){
        if (question.isChecked()){
            answeredCorrectly = answeredCorrectly + 1;
        }

    }

    /** this method only check question 3 answers and add the count of good answer
     *
     * @param answer1 is the correct answer
     * @param answer2 is the correct answer
     * @param answer3 is the correct answer
     */
    void checkQuestion3(CheckBox answer1, CheckBox answer2, CheckBox answer3){
        if (answer1.isChecked() && answer2.isChecked() && answer3.isChecked()){
            answeredCorrectly = answeredCorrectly + 1;
        }
    }



    /** this method only check question 4 answers and add the count of good answer
     *
     * @param answer take the user input as a parameter.
     */
    void checkQuestion4(EditText answer){
        if(answer.getText().toString().toLowerCase().trim().contentEquals("in order to be")) answeredCorrectly = answeredCorrectly + 1;

    }


}

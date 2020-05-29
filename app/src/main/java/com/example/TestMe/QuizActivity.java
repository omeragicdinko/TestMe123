package com.example.TestMe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizActivity extends AppCompatActivity {
    private TextView questionTextDisplay;
    private Button a, b, c, d;
    private String correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        questionTextDisplay = findViewById(R.id.quiz_question_text);
        a = findViewById(R.id.quiz_answer_one);
        b = findViewById(R.id.quiz_answer_two);
        c = findViewById(R.id.quiz_answer_three);
        d = findViewById(R.id.quiz_answer_four);

        getQuestionsByCategory(SelectCategoryActivity.category_id, SelectCategoryActivity.question_counter);
    }

    private void getQuestionsByCategory(String category, int questionNumber) {
        Call<List<Question>> listCall = RetrofitProvider.getInstance().getQuestionsByCategory(category);
        listCall.enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                if (response.isSuccessful()) {
                    List<Question> questions = response.body();
                    questionTextDisplay.setText(questions.get(questionNumber).getQuestion_text());
                    if (SelectCategoryActivity.question_counter == 0) {
                        Collections.shuffle(questions);
                    }
                    ArrayList<String> answers = new ArrayList<>();

                    answers.add(questions.get(questionNumber).getChoice_one());
                    answers.add(questions.get(questionNumber).getChoice_two());
                    answers.add(questions.get(questionNumber).getChoice_three());
                    answers.add(questions.get(questionNumber).getChoice_four());

                    correctAnswer=answers.get(0);

                    Collections.shuffle(answers);

                    a.setText(answers.get(0));
                    b.setText(answers.get(1));
                    c.setText(answers.get(2));
                    d.setText(answers.get(3));

                    SelectCategoryActivity.question_counter++;
                }
            }
            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void onSubmit(View view){
        if(SelectCategoryActivity.question_counter <= 4){
            switch (view.getId()){
                case R.id.quiz_answer_one:
                    if(a.getText().equals(correctAnswer)){
                        SelectCategoryActivity.points_counter+=25;
                        Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "Not correct", Toast.LENGTH_SHORT).show();
                    }
                    break;

                case R.id.quiz_answer_two:
                    if(b.getText().equals(correctAnswer)){
                        SelectCategoryActivity.points_counter+=25;
                        Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "Not correct", Toast.LENGTH_SHORT).show();
                    }
                    break;

                case R.id.quiz_answer_three:
                    if(c.getText().equals(correctAnswer)){
                        SelectCategoryActivity.points_counter+=25;
                        Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "Not correct", Toast.LENGTH_SHORT).show();
                    }
                    break;

                case R.id.quiz_answer_four:
                    if(d.getText().equals(correctAnswer)){
                        SelectCategoryActivity.points_counter+=25;
                        Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "Not correct", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }

    }
}
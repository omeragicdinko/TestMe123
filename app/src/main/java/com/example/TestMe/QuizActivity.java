package com.example.TestMe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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
    public static final String EXTRA_CATEGORY_ID = "QuizActivity/EXTRA_CATEGORY_ID";
    public static final int EXTRA_QUESTION_NUMBER = 0;
    private TextView questionTextDisplay;
    private int countPoints, countQuestions;
    private Button a, b, c, d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        questionTextDisplay = findViewById(R.id.quiz_question_text);
        a = findViewById(R.id.quiz_answer_one);
        b = findViewById(R.id.quiz_answer_two);
        c = findViewById(R.id.quiz_answer_three);
        d = findViewById(R.id.quiz_answer_four);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null && SelectCategoryActivity.jk == 0){
            getQuestionsByCategory(bundle.getString(SelectCategoryActivity.EXTRA_CATEGORY_ID),SelectCategoryActivity.jk);
        }
        if(bundle != null && SelectCategoryActivity.jk !=0){
            getQuestionsByCategory(SelectCategoryActivity.dd,SelectCategoryActivity.jk);
        }
    }

    private void getQuestionsByCategory(String category, int questionNumber){
        Call<List<Question>> listCall = RetrofitProvider.getInstance().getQuestionsByCategory(category);
        listCall.enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                if(response.isSuccessful()){
                    List<Question> questions = response.body();
                    questionTextDisplay.setText(questions.get(questionNumber).getQuestion_text());
                    if(SelectCategoryActivity.jk == 0) {
                        Collections.shuffle(questions);
                    }
                    //get answers and shhuffle them as well here
                    ArrayList<String> answers = new ArrayList<String>();
                    answers.add(questions.get(questionNumber).getChoice_one());
                    answers.add(questions.get(questionNumber).getChoice_two());
                    answers.add(questions.get(questionNumber).getChoice_three());
                    answers.add(questions.get(questionNumber).getChoice_four());
                    Collections.shuffle(answers);
                    a.setText(answers.get(0));
                    b.setText(answers.get(1));
                    c.setText(answers.get(2));
                    d.setText(answers.get(3));
                    SelectCategoryActivity.jk++;
                }
            }

            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }



}

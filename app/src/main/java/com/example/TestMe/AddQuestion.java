package com.example.TestMe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddQuestion extends AppCompatActivity {
    private EditText questionText,choice_one,choice_two,choice_three,choice_four,category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        questionText = findViewById(R.id.editTextQuestion);
        choice_one = findViewById(R.id.editTextAnswer1);
        choice_two = findViewById(R.id.editTextAnswer2);
        choice_three = findViewById(R.id.editTextAnswer3);
        choice_four = findViewById(R.id.editTextAnswer4);
        category = findViewById(R.id.editTextCategory);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            getQuestion(bundle.getInt(QuestionListActivity.EXTRA_QUESTION_ID));
        }
    }

    public void onSaveClick(View view){
        Question question = new Question(3,questionText.getText().toString(),choice_one.getText().toString(),choice_two.getText().toString(),choice_three.getText().toString(),choice_four.getText().toString(),category.getText().toString());
        Call<Question> questionCall = RetrofitProvider.getInstance().addNewQuestion(question);
        questionCall.enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                if(response.isSuccessful()){
                    Toast.makeText(AddQuestion.this,"Question has been added",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AddQuestion.this,QuestionListActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void onCancel(View view){

        Intent intent = new Intent(this,Admin.class);
        startActivity(intent);
    }

    private void getQuestion(int id){
        Call<Question> questionCall = RetrofitProvider.getInstance().getQuestionById(id);
        questionCall.enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                if(response.isSuccessful()){
                    Question question = response.body();
                    questionText.setText(question.getQuestion_text());
                    choice_one.setText(question.getChoice_one());
                    choice_two.setText(question.getChoice_two());
                    choice_three.setText(question.getChoice_three());
                    choice_four.setText(question.getChoice_four());
                    category.setText(question.getCategory());
                }
            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}

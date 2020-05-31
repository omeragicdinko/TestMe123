package com.example.TestMe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddQuestionActivity extends AppCompatActivity {
    private EditText questionText,choice_one,choice_two,choice_three,choice_four,category;
    Button cancel_button, save_button;
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
        cancel_button = findViewById(R.id.cancel_button_aq);
        save_button = findViewById(R.id.save_button_aq);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            getQuestion(bundle.getInt(QuestionListActivity.EXTRA_QUESTION_ID));
            cancel_button.setText("Delete");
            save_button.setText("Update");
        }
    }

    public void onSaveClick(View view){
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            Call<Question> questionCall = RetrofitProvider.getInstance().getQuestionById(extras.getInt(QuestionListActivity.EXTRA_QUESTION_ID));
            questionCall.enqueue(new Callback<Question>() {
                @Override
                public void onResponse(Call<Question> call, Response<Question> response) {
                    if(response.isSuccessful()){
                        Question question = response.body();
                        question.setQuestion_text(questionText.getText().toString());
                        question.setChoice_one(choice_one.getText().toString());
                        question.setChoice_two(choice_two.getText().toString());
                        question.setChoice_three(choice_three.getText().toString());
                        question.setChoice_four(choice_four.getText().toString());
                        question.setCategory(category.getText().toString());
                        Call<Question> questionCall2 = RetrofitProvider.getInstance().updateQuestion(question,extras.getInt(QuestionListActivity.EXTRA_QUESTION_ID));
                        questionCall2.enqueue(new Callback<Question>() {
                            @Override
                            public void onResponse(Call<Question> call, Response<Question> response) {
                                if(response.isSuccessful()){
                                    Toast.makeText(AddQuestionActivity.this,"Question has been updated",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(AddQuestionActivity.this,QuestionListActivity.class);
                                    startActivity(intent);
                                }
                            }
                            @Override
                            public void onFailure(Call<Question> call, Throwable t) {
                                t.printStackTrace();
                            }
                        });
                    }
                }
                @Override
                public void onFailure(Call<Question> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }else{
            Question question = new Question(17,questionText.getText().toString(),choice_one.getText().toString(),choice_two.getText().toString(),choice_three.getText().toString(),choice_four.getText().toString(),category.getText().toString());
            Call<Question> questionCall = RetrofitProvider.getInstance().addNewQuestion(question);
            questionCall.enqueue(new Callback<Question>() {
                @Override
                public void onResponse(Call<Question> call, Response<Question> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(AddQuestionActivity.this,"Question has been added",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AddQuestionActivity.this,QuestionListActivity.class);
                        startActivity(intent);
                    }
                }
                @Override
                public void onFailure(Call<Question> call, Throwable t) { t.printStackTrace(); }
            });
        }

    }

    public void onCancel(View view){
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            Call<Question> questionCall = RetrofitProvider.getInstance().getQuestionById(extras.getInt(QuestionListActivity.EXTRA_QUESTION_ID));
            questionCall.enqueue(new Callback<Question>() {
                @Override
                public void onResponse(Call<Question> call, Response<Question> response) {
                    if(response.isSuccessful()){
                        Call<Void> questionCall2 = RetrofitProvider.getInstance().deleteQuestion(extras.getInt(QuestionListActivity.EXTRA_QUESTION_ID));
                        questionCall2.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if(response.isSuccessful()){
                                    Toast.makeText(AddQuestionActivity.this,"Question has been deleted",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(AddQuestionActivity.this,QuestionListActivity.class);
                                    startActivity(intent);
                                }
                            }
                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                t.printStackTrace();
                            }
                        });
                    }
                }
                @Override
                public void onFailure(Call<Question> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }else{
            Intent intent = new Intent(this,QuestionListActivity.class);
            startActivity(intent);
        }


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

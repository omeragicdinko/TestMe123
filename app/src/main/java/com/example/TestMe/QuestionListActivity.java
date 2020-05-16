package com.example.TestMe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Console;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionListActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("beaj32","belaj32");
        setContentView(R.layout.activity_question_list);
        Log.e("beaj33","belaj33");
        listView = findViewById(R.id.list_view_container);
        Log.e("beaj34","belaj34");
        getQuestions();
    }

    private void getQuestions(){
        Log.e("beaj2","belaj2");
        Call<List<Question>> listCall = RetrofitProvider.getInstance().getAllQuestions();
        Log.e("beaj4","belaj4");
        listCall.enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                Log.i("beaj1","belaj1");
                if(response.isSuccessful()){
                    Log.i("beaj3","belaj3");
                    List<Question> questions = response.body();
                    QuestionListViewAdapter adapter = new QuestionListViewAdapter(QuestionListActivity.this,questions);
                    listView.setAdapter(adapter);
                }else{

                }
            }
            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {
                Log.e("beaj","belaj");
            }
        });
    }
}

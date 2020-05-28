package com.example.TestMe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Console;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionListActivity extends AppCompatActivity {
    private ListView listView;
    public static final String EXTRA_QUESTION_ID = "QuestionListActivity/EXTRA_POST_ID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);
        listView = findViewById(R.id.list_view_container);
        listView = findViewById(R.id.list_view_container);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int post_id = (int) parent.getItemIdAtPosition(position);
                Intent intent = new Intent(QuestionListActivity.this,AddQuestion.class);
                intent.putExtra(EXTRA_QUESTION_ID,post_id);
                startActivity(intent);
            }
        });
        getQuestions();
    }

    private void getQuestions(){
        Call<List<Question>> listCall = RetrofitProvider.getInstance().getAllQuestions();
        listCall.enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                if(response.isSuccessful()){
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

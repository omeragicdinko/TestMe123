package com.example.TestMe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }
    public void onAdd(View view){
        Intent intent = new Intent(this, AddQuestion.class);
        startActivity(intent);
    }
    public void onView(View view){
        Intent intent = new Intent(this, QuestionListActivity.class);
        startActivity(intent);
    }
}

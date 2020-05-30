package com.example.TestMe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAdmin(View view){
        Intent intent = new Intent(this, AdminAccessActivity.class);
        startActivity(intent);
    }
    public void onQuiz(View view){
        Intent intent = new Intent(this, SelectCategoryActivity.class);
        startActivity(intent);
    }
}

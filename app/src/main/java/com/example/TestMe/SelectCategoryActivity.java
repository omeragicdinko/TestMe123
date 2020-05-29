package com.example.TestMe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectCategoryActivity extends AppCompatActivity {
    public static String category_id;
    public static int question_counter = 0;
    public static int points_counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);
    }

    public void onGeography(View view){
        Intent intent = new Intent(this, QuizActivity.class);
        category_id="Geography";
        startActivity(intent);
    }
    public void onHistory(View view){
        Intent intent = new Intent(this, QuizActivity.class);
        category_id="History";
        startActivity(intent);
    }
}

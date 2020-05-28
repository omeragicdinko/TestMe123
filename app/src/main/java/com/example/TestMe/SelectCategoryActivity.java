package com.example.TestMe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectCategoryActivity extends AppCompatActivity {
    public static final String EXTRA_CATEGORY_ID = "SelectCategoryActivity/EXTRA_CATEGORY_ID";
    public static String dd = "";
    public static String category_id;
    public static int jk = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);
    }

    public void onGeography(View view){
        Intent intent = new Intent(this, QuizActivity.class);
        dd="Geography";
        category_id="Geography";
        intent.putExtra(EXTRA_CATEGORY_ID,category_id);
        startActivity(intent);
    }
    public void onHistory(View view){
        Intent intent = new Intent(this, QuizActivity.class);
        category_id="History";
        dd="History";
        intent.putExtra(EXTRA_CATEGORY_ID,category_id);
        startActivity(intent);
    }
}

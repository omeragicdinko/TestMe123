package com.example.TestMe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    private TextView points1;
    Button tryAgain, home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        points1 = findViewById(R.id.points);
        points1.setText(String.valueOf(SelectCategoryActivity.points_counter)+" / 100");
        tryAgain = findViewById(R.id.try_again_button);
        home = findViewById(R.id.home_button);
        SelectCategoryActivity.question_counter = 0;
        SelectCategoryActivity.points_counter = 0;

    }

    public void onHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onTryAgain(View view){
        Intent intent = new Intent(this, SelectCategoryActivity.class);
        startActivity(intent);
    }
}

package com.example.TestMe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    private TextView points1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        points1 = findViewById(R.id.points);
        points1.setText(String.valueOf(SelectCategoryActivity.points_counter));
    }
}

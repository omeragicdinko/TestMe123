package com.example.TestMe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminAccessActivity extends AppCompatActivity {
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_access);

        password = findViewById(R.id.password_input);
    }
    public void onCancel(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void onSubmit(View view){
        String pass = password.getText().toString();
        if(pass.equals("admin123")){
            Toast.makeText(this, "Welcome Admin", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, QuestionListActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Wrong password", Toast.LENGTH_SHORT).show();
        }

    }
}

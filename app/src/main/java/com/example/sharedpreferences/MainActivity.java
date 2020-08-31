package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    String username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

        checkSession();
    }

    private void checkSession() {
        if (new CurrentUser(MainActivity.this).getPass() != "") {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
            finish();
        } else {
        }
    }

    public void onLogin(View view) {
        username = et1.getText().toString().trim();
        password = et2.getText().toString().trim();

        if(username.equals("admin") && password.equals("123")){
            new CurrentUser(MainActivity.this).setPass(password);
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
            finish();
        }else {
            Toast.makeText(this, "wrong username and password", Toast.LENGTH_SHORT).show();
        }
    }
}
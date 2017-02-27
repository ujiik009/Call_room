package com.example.phobia.call_room;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button loginButton, registerButton;
    private View userString;
    private View passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bindwidget();
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });


    }//main method

    private void bindwidget() {

        //Bind Widget
        registerButton = (Button) findViewById(R.id.register);
        loginButton = (Button) findViewById(R.id.login);
        userString = findViewById(R.id.user);
        passwordString = findViewById(R.id.password);

    }
}//Main Class

package com.example.alvinafandi.eatiwul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonLogin;
    private TextView textViewSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin = (Button) findViewById(R.id.masuk);
        textViewSignup = (TextView) findViewById(R.id.textViewSignup);

        buttonLogin.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);
    }
    public void onClick(View view){
        if(view == buttonLogin){
            loginPage();
        }
        if(view == textViewSignup){
            startActivity(new Intent(this,RegisterActivity.class));
        }
    }
    private void loginPage(){
        Intent intent = new Intent(this, CharacterActivity.class);
        startActivity(intent);
    }
}

package com.example.alvinafandi.eatiwul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin = findViewById(R.id.masuk);
        buttonLogin.setOnClickListener(this);
    }
    public void onClick(View view){
        if(view == buttonLogin){
            loginPage();
        }
    }
    private void loginPage(){
        Intent intent = new Intent(this, CharacterActivity.class);
        startActivity(intent);
    }
}

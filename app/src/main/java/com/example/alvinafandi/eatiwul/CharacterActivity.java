package com.example.alvinafandi.eatiwul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CharacterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        select = findViewById(R.id.selectChar);
        select.setOnClickListener(this);
    }
    public void onClick(View view){
        if (view == select){
            homePage();
        }
    }
    private void homePage(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}

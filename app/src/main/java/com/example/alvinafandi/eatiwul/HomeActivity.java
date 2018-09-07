package com.example.alvinafandi.eatiwul;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton change;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        change = findViewById(R.id.create);
        change.setOnClickListener(this);
    }
    public void onClick(View view){
        if (view == change){
            charPage();
        }
    }
    private void charPage(){
        Intent intent = new Intent(this, CharacterActivity.class);
        startActivity(intent);
    }
}

package com.example.alvinafandi.eatiwul;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddFood extends AppCompatActivity{
    EditText foodName;
    EditText foodDescription;
    EditText foodAddress;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView();
        databaseReference = FirebaseDatabase.getInstance().getReference("foods");
//        foodName = (EditText) findViewById(R.id.)

    }

    private void addFood(){
//        String name =
    }
}

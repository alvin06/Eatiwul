package com.example.alvinafandi.eatiwul;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;

public class FoodActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView detailFood;

    public void onResume(){
        super.onResume();
        BottomNavigationView mNavigationView = findViewById(R.id.navigation);
        mNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mNavigationView.getMenu().findItem(R.id.navigation_food).setChecked(true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        detailFood = findViewById(R.id.seePapeda);
        detailFood.setOnClickListener(this);

        BottomNavigationView mNavigationView = findViewById(R.id.navigation);
        mNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mNavigationView.getMenu().findItem(R.id.navigation_food).setChecked(true);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation:
                    Intent intent = new Intent(FoodActivity.this, HomeActivity.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    public void onClick(View view){
        if (view == detailFood){
            Intent intent = new Intent (this, DetailActivity.class);
            startActivity(intent);
        }
    }
}

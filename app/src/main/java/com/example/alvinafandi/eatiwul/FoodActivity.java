package com.example.alvinafandi.eatiwul;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class FoodActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView detailFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        detailFood = findViewById(R.id.seePapeda);
        detailFood.setOnClickListener(this);
        navigationDrawer();
    }


    public void onClick(View view){
        if (view == detailFood){
            Intent intent = new Intent (this, DetailActivity.class);
            startActivity(intent);
        }
    }
    public void navigationDrawer(){
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        finish();
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        break;
                    case R.id.navigation_food:
                        finish();
                        startActivity(new Intent(getApplicationContext(),FoodActivity.class));
                        break;
                    case R.id.navigation_notifications:
                        finish();
                        startActivity(new Intent(getApplicationContext(),NotifActivity.class));
                        break;
                    case R.id.navigation_profile:
                        finish();
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
    }
}

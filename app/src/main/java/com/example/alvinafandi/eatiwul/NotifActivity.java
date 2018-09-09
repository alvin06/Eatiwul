package com.example.alvinafandi.eatiwul;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class NotifActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif);
        navigationDrawer();
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
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);
    }
}

package com.example.alvinafandi.eatiwul;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonLogout;
    private TextView textViewNameProfile;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        buttonLogout = (Button) findViewById(R.id.logout);
        textViewNameProfile = (TextView) findViewById(R.id.textViewNameProfile);

//        String id = mAuth.getCurrentUser().getUid();
//        databaseReference = FirebaseDatabase.getInstance().getReference("users").child(id);
        textViewNameProfile.setText("hoho");
        buttonLogout.setOnClickListener(this);
        navigationDrawer();
    }


    @Override
    public void onClick(View view) {
        if(view == buttonLogout){
            FirebaseAuth.getInstance().signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));
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
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

    }
}

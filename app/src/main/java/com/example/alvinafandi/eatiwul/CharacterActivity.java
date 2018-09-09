package com.example.alvinafandi.eatiwul;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CharacterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button select;
    private ViewPager viewPager;
    private Button slideRight;
    private Button slideLeft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        select = (Button) findViewById(R.id.selectChar);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        slideLeft = (Button) findViewById(R.id.slideLeft);
        slideRight = (Button) findViewById(R.id.slideRight);

        slideRight.setOnClickListener(this);
        slideLeft.setOnClickListener(this);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        select.setOnClickListener(this);


        viewPager.setAdapter(viewPagerAdapter);
    }
    public void onClick(View view){
        if (view == select){
            homePage();
        }
        if (view == slideLeft){
            viewPager.setCurrentItem(viewPager.getCurrentItem()+1,true);
        }
        if (view == slideRight){
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1,true);
        }
    }
    private void homePage(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}

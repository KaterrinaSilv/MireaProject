package ru.mirea.serebriakovaea.mireaproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class DataClass extends AppCompatActivity {
    ViewPager slideViewPager;
    LinearLayout dotLinearLayout;

    Button btn_back, btn_next;

    TextView[] dots;
    ViewPageAdapter viewPageAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_data);

        btn_next = findViewById(R.id.btn_next);
        btn_back = findViewById(R.id.btn_back);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getItem(0)<2){
                    slideViewPager.setCurrentItem(getItem(1), true);
                }
                else {
                    Intent intent = new Intent(DataClass.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getItem(0)>0){
                    slideViewPager.setCurrentItem(getItem(-1), true);
                }
            }
        });

        slideViewPager = (ViewPager) findViewById(R.id.imageView);
        dotLinearLayout = (LinearLayout) findViewById(R.id.indicatorLayout);

        viewPageAdapter = new ViewPageAdapter(this);
        slideViewPager.setAdapter(viewPageAdapter);

        setUpIndicator(0);
        slideViewPager.addOnPageChangeListener(viewListener);




    }


    public void setUpIndicator(int position) {
        dots = new TextView[3];
        dotLinearLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.white));
            dotLinearLayout.addView(dots[i]);

        }
        dots[position].setTextColor(getResources().getColor(R.color.blu));
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            setUpIndicator(position);

            if (position > 0) {
                btn_back.setVisibility(View.VISIBLE);

            } else {
                btn_back.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    private int getItem(int i){
        return slideViewPager.getCurrentItem() + i;
    }


}

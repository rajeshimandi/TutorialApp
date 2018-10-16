package com.example.anuraj.tutorialsapplication.activities.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.anuraj.tutorialsapplication.R;

/**
 * Created by AnuRaj on 10/15/2018.
 */

public class ViewPagerActivity extends AppCompatActivity {

    TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        tabLayout = findViewById(R.id.tab_layout);
        FragmentPagerAdapter adapterViewPager = new PagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        vpPager.setOffscreenPageLimit(2);
        tabLayout.setupWithViewPager(vpPager);

        vpPager.setCurrentItem(1);

        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                Toast.makeText(ViewPagerActivity.this,
                        "Selected page position: " + position, Toast.LENGTH_SHORT).show();
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            // Called when the scroll state changes:
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}

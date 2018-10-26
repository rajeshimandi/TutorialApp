package com.example.anuraj.tutorialsapplication.retrofit;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.anuraj.tutorialsapplication.R;

import java.util.List;

/**
 * Created by AnuRaj on 10/16/2018.
 */

public class RetrofitActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HeroesAdapter adapter;

    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        progressBar = findViewById(R.id.progressBar);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HeroesViewModel model = ViewModelProviders.of(this).get(HeroesViewModel.class);

        model.getHeroes().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroes) {
                adapter = new HeroesAdapter(RetrofitActivity.this, heroes);
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
            }
        });

    }
}

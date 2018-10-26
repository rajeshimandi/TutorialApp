package com.example.anuraj.tutorialsapplication.retrofit;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AnuRaj on 10/16/2018.
 */

public class HeroesViewModel extends ViewModel {

    private MutableLiveData<List<Hero>> heroList;

    public LiveData<List<Hero>> getHeroes(){

        if(heroList == null){
            heroList = new MutableLiveData<List<Hero>>();
            loadHeroes();
        }

        return heroList;
    }

    private void loadHeroes(){

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(Api.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build();

        Api api = retrofit.create(Api.class);

        Call<List<Hero>> call = api.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                heroList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                // Error message Handling
            }
        });
    }

}

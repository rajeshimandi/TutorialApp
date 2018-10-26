package com.example.anuraj.tutorialsapplication.activities.async;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.anuraj.tutorialsapplication.R;
import com.example.anuraj.tutorialsapplication.activities.retrofit.Api;
import com.example.anuraj.tutorialsapplication.activities.retrofit.Hero;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by AnuRaj on 10/16/2018.
 */

public class AyncTaskActivity extends AppCompatActivity {

    Button btnGetHeroes;
    TextView txtHeroSize;
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        btnGetHeroes = findViewById(R.id.getHeroesBtn);
        txtHeroSize = findViewById(R.id.tv_hero);
        progressBar = findViewById(R.id.progressBar);

        btnGetHeroes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FetchHeroesAsync async = new FetchHeroesAsync();
                async.execute(Api.BASE_URL + "marvel");

            }
        });

    }

    public class FetchHeroesAsync extends AsyncTask<String, Void, List<Hero>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }


        @Override
        protected List<Hero> doInBackground(String... params) {
            HttpURLConnection urlConnection = null;

            try {
                URL url = new URL(params[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                String response = readStream(in);

                if (!TextUtils.isEmpty(response)) {
                    Type listType = new TypeToken<List<Hero>>() {
                    }.getType();
                    return new Gson().fromJson(response, listType);
                }

            } catch (MalformedURLException e) {

            } catch (IOException e) {

            } finally {
                if (null != urlConnection)
                    urlConnection.disconnect();
            }

            return null;
        }

        @Override
        protected void onPostExecute(List<Hero> heroes) {
            super.onPostExecute(heroes);
            progressBar.setVisibility(View.GONE);
            if (null != heroes) {
                txtHeroSize.setText("Heroes List Size:" + heroes.size());
            }
        }

    }

    /**
     * Returns response a string
     *
     * @param in input stream
     * @return response
     */
    private String readStream(InputStream in) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        StringBuilder total = new StringBuilder();
        String line;

        while ((line = r.readLine()) != null) {
            total.append(line).append('\n');
        }

        return total.toString();
    }

}

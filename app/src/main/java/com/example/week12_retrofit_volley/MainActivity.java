package com.example.week12_retrofit_volley;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tvCases,
            tvCritical,
            tvActive,
            tvDeaths,
            tvTodayCases,
            tvTodayDeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setComponents();
        fetchApiDataUsingRetrofit();

    }

    private void fetchApiDataUsingRetrofit() {

        String baseURL = "https://disease.sh/v2/";

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create(gson)).build();

        //implement retrofit client interface fucntion
        RetrofitApi retrofitAPI = retrofit.create(RetrofitApi.class);

        Call<Statistics> statisticsCall = retrofitAPI.getStatistics();

        /*IMPORTANT PART*/
        statisticsCall.enqueue(new Callback<Statistics>() {
            @Override
            public void onResponse(Call<Statistics> call, Response<Statistics> response) {

                //bind the data from API to the view
                tvCases.setText(
                        response.body().getCases().toString());
                tvTodayCases.setText(
                        response.body().getTodayCases().toString());

                tvDeaths.setText(response.body().getDeaths().toString());

                tvCritical.setText(
                        response.body().getCritical().toString());
                tvActive.setText(
                        response.body().getActive().toString());

                tvTodayDeaths.setText(
                        response.body().getTodayDeaths().toString());


            }

            @Override
            public void onFailure(Call<Statistics> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
                Toast.makeText(MainActivity.this, "Fail to get the data.." + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void setComponents() {
        // Link those objects with their respective id's
        // that we have given in .XML file
        tvCases
                = findViewById(R.id.tvCases);
        tvTodayCases
                = findViewById(R.id.tvTodayCases);
        tvDeaths
                = findViewById(R.id.tvDeaths);
        tvCritical
                = findViewById(R.id.tvCritical);
        tvActive
                = findViewById(R.id.tvActive);

        tvTodayDeaths
                = findViewById(R.id.tvTodayDeaths);

    }
}
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

    TextView tvCases,tvRecovered,tvCritical,
            tvActive,tvTodayCases,tvTodayDeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FindID();

        // Creating a method to fetch data using Retrofit2
        fetchApiDataUsingRetrofit();
    }

    private void FindID() {
        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);
    }

    public void fetchApiDataUsingRetrofit() {

        // Set up the Retrofit
        // https://disease.sh/v3/covid-19/all
        String baseUrl = "https://corona.lmao.ninja/v2/";
        Gson gson = new GsonBuilder().setLenient().create();
        // Create a Retrofit builder and pass the gson in
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // Implement the Retrofit Client interface function
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);

        Call<Statistics> statisticsCall = retrofitApi.getStatistics();

        statisticsCall.enqueue(new Callback<Statistics>(){
            // success
            @Override
            public void onResponse(Call<Statistics> call, Response<Statistics> response) {
                // bind the data from the API to the views
                tvCases.setText(response.body().getCases());  // return cases value
                tvRecovered.setText(response.body().getRecovered());
                tvCritical.setText(response.body().getCritical());
                tvActive.setText(response.body().getActive());
                tvTodayDeaths.setText(response.body().getTodayDeaths());
                tvTodayCases.setText(response.body().getTodayCases());
            }

            // failure
            @Override
            public void onFailure(Call<Statistics> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
                Toast.makeText(MainActivity.this, "Fail to get the data.." + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
package com.example.week12_retrofit_volley;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;

public interface RetrofitApi {
    @GET("all")
    Call<Statistics> getStatistics();

}

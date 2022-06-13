package com.example.week12_retrofit_volley;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Statistics {
    @SerializedName("cases")
    @Expose
    private String cases;

    @SerializedName("todayCases")
    @Expose
    private String todayCases;

    @SerializedName("deaths")
    @Expose
    private String deaths;

    // add value you want to use...
    @SerializedName("active")
    @Expose
    private String active;

    @SerializedName("critical")
    @Expose
    private String critical;

    @SerializedName("todayDeaths")
    @Expose
    private String todayDeaths;


    public Statistics(
            String cases,
            String todayCases,
            String deaths,
            String active,
            String critical,
            String todayDeaths
    ){
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.active = active;
        this.critical = critical;
        this.todayDeaths = todayDeaths;
    }

    String getCases(){return this.cases;}
    String getTodayCases(){return this.todayCases;}
    String getDeaths(){return this.deaths;}
    String getActive(){return this.active;}
    String getCritical(){return this.critical;}
    String getTodayDeaths(){return this.todayDeaths;}
}

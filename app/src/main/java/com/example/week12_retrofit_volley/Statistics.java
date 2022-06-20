package com.example.week12_retrofit_volley;
// POJO - Java Class

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

    @SerializedName("active")
    @Expose
    private String active;

    @SerializedName("critical")
    @Expose
    private String critical;

    @SerializedName("todayDeaths")
    @Expose
    private String todayDeaths;

    @SerializedName("recovered")
    @Expose
    private String recovered;

    public Statistics(
            String cases,
            String todayCases,
            String deaths,
            String active,
            String critical,
            String todayDeaths,
            String recovered
    ) {
        this.active = active;
        this.deaths = deaths;
        this.cases = cases;
        this.critical = critical;
        this.todayCases = todayCases;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
    }

    String getCases() {
        return this.cases;
    }

    /*void setCases(String cases) {
        this.cases = cases;
    }*/

    String getCritical() {
        return this.critical;
    }

    String getActive() {
        return this.active;
    }

    String getTodayCases() {
        return this.todayCases;
    }

    String getDeaths() {
        return this.deaths;
    }

    String getTodayDeaths() {
        return this.todayDeaths;
    }

    String getRecovered() {
        return this.recovered;
    }

}

/*
{
    "updated": 1655109213685,
    "cases": 540616720,
    "todayCases": 127254,
    "deaths": 6331624,
    "todayDeaths": 181,
    "recovered": 515943358,
    "todayRecovered": 262380,
    "active": 18341738,
    "critical": 36131,
    "casesPerOneMillion": 69356,
    "deathsPerOneMillion": 812.3,
    "tests": 6486426682,
    "testsPerOneMillion": 817772.08,
    "population": 7931827008,
    "oneCasePerPeople": 0,
    "oneDeathPerPeople": 0,
    "oneTestPerPeople": 0,
    "activePerOneMillion": 2312.42,
    "recoveredPerOneMillion": 65047.23,
    "criticalPerOneMillion": 4.56,
    "affectedCountries": 230
}
 */

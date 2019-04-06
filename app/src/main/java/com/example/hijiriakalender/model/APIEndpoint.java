package com.example.hijiriakalender.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIEndpoint {

    @GET("hijriCalendarByCity")
    Call<HijriResponse> getPrayerDateHijri(
              @Query("city") String city,
              @Query("country") String country
    );

}

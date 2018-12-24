package com.example.saiful.nearbyhospitals;

import com.example.saiful.nearbyhospitals.Nearby.NearbyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {

    @GET()
    Call<NearbyResponse> getNearby(@Url String url);
}

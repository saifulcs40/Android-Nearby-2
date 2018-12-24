package com.example.saiful.nearbyhospitals.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.saiful.nearbyhospitals.Adapter.NearbyAdapter;
import com.example.saiful.nearbyhospitals.ApiClient;
import com.example.saiful.nearbyhospitals.ApiService;
import com.example.saiful.nearbyhospitals.Nearby.NearbyResponse;
import com.example.saiful.nearbyhospitals.Nearby.Result;
import com.example.saiful.nearbyhospitals.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationActivity extends AppCompatActivity {

    private ApiService service;
    private Double lat =23.815438;
    private Double lon =90.370358;
    private int radius = 500;
    private String place_type = "hospital";

    private RecyclerView recyclerView;
    private NearbyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        recyclerView = findViewById(R.id.recycler_view_id);

        String url = String.format("place/nearbysearch/json?location=%f,%f&radius=%d&type=%s&key=%s",lat,lon,radius,place_type,getResources().getString(R.string.place_api_key));

        service = ApiClient.getRetrofit().create(ApiService.class);
        Call<NearbyResponse> nearbyResponseCall = service.getNearby(url);

        nearbyResponseCall.enqueue(new Callback<NearbyResponse>() {
            @Override
            public void onResponse(Call<NearbyResponse> call, Response<NearbyResponse> response) {
                if(response.code()==200){
                    NearbyResponse nearbyResponse = response.body();
                    List<Result> results = nearbyResponse.getResults();
                    adapter = new NearbyAdapter(results);
                    recyclerView.setLayoutManager(new LinearLayoutManager(LocationActivity.this));
                    recyclerView.setAdapter(adapter);
                    //Toast.makeText(LocationActivity.this, String.valueOf(results.size()), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NearbyResponse> call, Throwable t) {

            }
        });
    }
}

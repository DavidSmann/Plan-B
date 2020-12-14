package com.example.plan_b_exercise.Activities;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.plan_b_exercise.Adapter.MapAdapter;
import com.example.plan_b_exercise.Models.MapModel;
import com.example.plan_b_exercise.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;
    RecyclerView recyclerView;

    ArrayList<MapModel> mapModels;
    MapAdapter mapAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        recyclerView = findViewById(R.id.recyclerViewMap);
        Integer[] images = {R.drawable.dis1jpg, R.drawable.drink};


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mapModels = new ArrayList<>();
        for(int i = 0; i< images.length;i++){
            MapModel model = new MapModel(images[i]);
            mapModels.add(model);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                MapActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mapAdapter = new MapAdapter(MapActivity.this,mapModels);
        recyclerView.setAdapter(mapAdapter);
        mapAdapter.notifyDataSetChanged();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        LatLng PhnomPenh = new LatLng(11.581792, 104.932171);
        map.addMarker(new MarkerOptions().position(PhnomPenh).title("Phnom Penh"));
        map.moveCamera(CameraUpdateFactory.newLatLng(PhnomPenh));
    }

    public void onBackMap(View view) {
        Intent intent = new Intent(MapActivity.this,SearchActivity.class);
        startActivity(intent);
    }
}

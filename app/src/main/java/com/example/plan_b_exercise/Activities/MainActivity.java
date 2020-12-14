package com.example.plan_b_exercise.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.plan_b_exercise.Adapter.MainAdapter;
import com.example.plan_b_exercise.Models.MainModel;
import com.example.plan_b_exercise.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        Integer[] images = {R.drawable.dis1jpg, R.drawable.drink};

        mainModels = new ArrayList<>();
        for(int i = 0; i< images.length;i++){
            MainModel model = new MainModel(images[i]);
            mainModels.add(model);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mainAdapter = new MainAdapter(MainActivity.this,mainModels);
        recyclerView.setAdapter(mainAdapter);
        mainAdapter.notifyDataSetChanged();

    }

    public void onSearch(View view) {
        Intent myIntent = new Intent(MainActivity.this,
                PreSearchActivity.class);
        startActivity(myIntent);
    }
}

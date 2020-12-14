package com.example.plan_b_exercise.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.plan_b_exercise.Adapter.SearchAdapter;
import com.example.plan_b_exercise.Models.SearchModel;
import com.example.plan_b_exercise.R;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<SearchModel> searchModels;
    SearchAdapter searchAdapter;
    EditText searchBox;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recyclerView = findViewById(R.id.recyclerViewSearch);
        searchBox = findViewById(R.id.searchBox);
        imageView = findViewById(R.id.backSearch);
        Integer[] images= {
                R.drawable.drink,
                R.drawable.app_logo,
                R.drawable.dis1jpg,
                R.drawable.cover,
                R.drawable.food1,
                R.drawable.cover,
                R.drawable.drink,
                R.drawable.dis1jpg,
                R.drawable.cover,
        };

        searchModels = new ArrayList<>();
        for(int i =0; i<images.length;i++){
            SearchModel searchModel = new SearchModel(images[i]);
            searchModels.add(searchModel);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                SearchActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        searchAdapter = new SearchAdapter(SearchActivity.this,searchModels);
        recyclerView.setAdapter(searchAdapter);
        searchAdapter.notifyDataSetChanged();

        if (getIntent().getExtras() != null) {
            String value = getIntent().getStringExtra("key");
            searchBox.setText(value);

        }
    }

    public void onSearchMap(View view) {
        Intent intent = new Intent(SearchActivity.this,MapActivity.class);
        startActivity(intent);

    }

    public void onBackSearch(View view) {
        Intent intent = new Intent(SearchActivity.this,PreSearchActivity.class);
        startActivity(intent);
    }
}

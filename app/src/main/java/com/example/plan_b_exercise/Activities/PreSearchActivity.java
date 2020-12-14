package com.example.plan_b_exercise.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.plan_b_exercise.R;

public class PreSearchActivity extends AppCompatActivity {
    EditText editText;
    ImageView clearSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_search);

        editText = findViewById(R.id.searchBox);
        clearSearch = findViewById(R.id.clearSearch);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() > 0){
                    clearSearch.setVisibility(View.VISIBLE);
                }else{
                    clearSearch.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        clearSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch();
                    String contents = editText.getText().toString().trim();
                    if(contents.length() > 0){
                        //do search

                    }else{
                        //if something to do for empty edittext
                    }

                    return true;
                }
                return false;
            }
        });

    }

    private void performSearch() {

        InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(editText.getWindowToken(), 0);

        String value;
        value =  editText.getText().toString();
        Intent myIntent = new Intent(PreSearchActivity.this,
                SearchActivity.class);
        myIntent.putExtra(" key",value);
        startActivity(myIntent);
        //...perform search
    }

    public void onBackPreSearch(View view) {
        Intent intent = new Intent(PreSearchActivity.this,MainActivity.class);
        startActivity(intent);
    }
}

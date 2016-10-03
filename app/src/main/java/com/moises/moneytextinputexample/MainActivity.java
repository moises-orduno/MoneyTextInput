package com.moises.moneytextinputexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void onDifferentUses(View view){

        startActivity(new Intent(this,DifferentUsesActivity.class));

    }

    public void onFeatures(View view){

        startActivity(new Intent(this,FeaturesActivity.class));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

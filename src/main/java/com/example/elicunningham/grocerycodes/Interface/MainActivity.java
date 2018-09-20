package com.example.elicunningham.grocerycodes.Interface;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.elicunningham.grocerycodes.Application.GameManager;
import com.example.elicunningham.grocerycodes.Application.GroceryCodesApp;
import com.example.elicunningham.grocerycodes.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    GameManager manager;

    /**
     * Displays the MainActivity and gets the GameManager
     * @param savedInstanceState something
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the gameManager, or create a new one if one doesn't already exist
        GroceryCodesApp app = (GroceryCodesApp) getApplicationContext();
        manager = app.getManager();
    }

    /**
     * Starts the GameActivity (called when the StartGame button was pressed)
     * @param view something
     */
    public void startGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

}

package com.example.elicunningham.grocerycodes.Application;

import android.app.Application;
import android.content.Context;

import com.example.elicunningham.grocerycodes.Interface.Constants;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroceryCodesApp extends Application{
    private GameManager manager;

    public GameManager getManager() {
        if(manager == null) {
            setupGameManager();
        }
        return manager;
    }

    /**
     * Reads and Creates the GameManager from a file, or creates a
     * new one if one didn't already exist
     */
    private void setupGameManager(){
        Context context = getApplicationContext();
        // get the file where the GameManager json should be saved
        File gmFile = new File(context.getFilesDir(), Constants.GAME_MANAGER_FILE);
        Gson gson = new Gson();

        if(gmFile.exists()){
            System.out.println("File exists, trying to read from it");
            // if the GameManager file exists, read it in and create the new manager
            try {
                // open the file
                FileInputStream inputStream = openFileInput(Constants.GAME_MANAGER_FILE);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                // set up for reading from json
                String json;
                StringBuilder stringBuilder = new StringBuilder();

                System.out.println("Opened the file, about to start reading");
                // append each line of the file to the string
                while((json = bufferedReader.readLine()) != null) {
                    stringBuilder.append(json);
                }
                inputStream.close();
                json = stringBuilder.toString();

                System.out.println("Closed the file, reading is done.");

                // create the manager from the json
                manager = gson.fromJson(json, GameManager.class);
                System.out.println("Created the manager");

            } catch(IOException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("file doesn't exist, creating a new manager");
            // otherwise create a new game manager
            manager = new GameManager(getApplicationContext());

            try {
                System.out.println("Writing the new manager to json");
                //write the new manger to the json file
                String json = gson.toJson(manager);
                FileOutputStream outputStream = openFileOutput(Constants.GAME_MANAGER_FILE, Context.MODE_PRIVATE);
                outputStream.write(json.getBytes());
                outputStream.close();
                System.out.println("Finished writing");

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}

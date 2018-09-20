package com.example.elicunningham.grocerycodes.Model;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CodeList {
    private ArrayList<GroceryCode> incorrectList;
    private ArrayList<GroceryCode> correctList;

    /**
     * Creates the CodeList object
     * @param context the Application context, used to access the asset file of codes
     */
    public CodeList(Context context){
        incorrectList = new ArrayList<>();
        correctList = new ArrayList<>();
        initializeList(context);
    }

    /**
     * Reads the list of codes from the asset file, and creates the initial CodeList
     */
    private void initializeList(Context context) {
        BufferedReader reader = null;
        try {
            // read the codes from the codes asset
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open("codes")));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                // take a single line, split it up into the code and the name,
                List<String> list = Arrays.asList(mLine.split(","));
                // make a new GroceryCode object out of it and add it to the list
                incorrectList.add(new GroceryCode(list.get(0), list.get(1)));
                System.out.println(mLine);
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e){
                    //log the exception
                }
            }
        }
        shuffleList();
    }

    /**
     * Shuffles the list
     */
    public void shuffleList(){
        Collections.shuffle(incorrectList);
    }

    /**
     * Gets the next code from the CodeList
     * @return the next code
     */
    public GroceryCode getNextCode(){
        return incorrectList.remove(0);
    }

    /**
     * @return true if there are codes left in the list, false otherwise
     */
    public boolean hasCodes(){
        return !incorrectList.isEmpty();
    }

    /**
     * Adds the code to the list of codes that the player got correct
     * @param code the code the player got correct
     */
    public void gotCorrect(GroceryCode code){
        System.out.println("correctList is Null: " + (correctList==null));
        System.out.println("Code is null: " + (code==null));
        correctList.add(code);
        code.gotCorrect();
    }

    /**
     * Adds the code to the list of codes that the polayer got incorrect
     * @param code the code the player got incorrect
     */
    public void gotIncorrect(GroceryCode code){
        incorrectList.add(code);
        code.gotIncorrect();
    }
}

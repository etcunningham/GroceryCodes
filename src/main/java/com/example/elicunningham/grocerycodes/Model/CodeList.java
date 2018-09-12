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
    private ArrayList<GroceryCode> codeList;
    private Context context;

    public CodeList(Context context){
        this.context = context;
        codeList = new ArrayList<>();
        initializeList();
    }

    private void initializeList(){
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
                codeList.add(new GroceryCode(list.get(0), list.get(1)));
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

        shuffleList();
    }

    public void shuffleList(){
        Collections.shuffle(codeList);
    }

    public GroceryCode getNextCode(){
        return codeList.remove(0);
    }

    public boolean hasCodes(){
        return !codeList.isEmpty();
    }
}

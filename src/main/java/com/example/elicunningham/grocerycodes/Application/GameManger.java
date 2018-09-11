package com.example.elicunningham.grocerycodes.Application;

import com.example.elicunningham.grocerycodes.Model.GroceryCode;

import java.util.ArrayList;

public class GameManger {

    private ArrayList<GroceryCode> codes;

    public GameManger(){
        codes = new ArrayList<>();
        codes.add(new GroceryCode("Banana", "4011"));
        codes.add(new GroceryCode("Orange", "4012"));
    }

    public boolean hasCodesLeft(){
        return codes.isEmpty();
    }

    public GroceryCode getNextCode(){
        return codes.get(0);
    }
}

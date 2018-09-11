package com.example.elicunningham.grocerycodes.Model;

import java.util.ArrayList;

public class CodeList {
    private ArrayList<GroceryCode> codeList;

    public CodeList(){
        codeList = new ArrayList<>();
        codeList.add(new GroceryCode("Banana" , "4011"));
        codeList.add(new GroceryCode("Orange" , "4012"));
    }

    public GroceryCode getNextCode(){
        return codeList.remove(0);
    }

    public boolean hasCodes(){
        return !codeList.isEmpty();
    }
}

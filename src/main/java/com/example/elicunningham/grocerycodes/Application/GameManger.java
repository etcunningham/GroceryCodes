package com.example.elicunningham.grocerycodes.Application;

import com.example.elicunningham.grocerycodes.Model.CodeList;
import com.example.elicunningham.grocerycodes.Model.GroceryCode;

public class GameManger {

    private CodeList codes;

    public GameManger(){
        codes = new CodeList();
    }

    public boolean hasCodesLeft(){
        return codes.hasCodes();
    }

    public GroceryCode getNextCode(){
        return codes.getNextCode();
    }
}

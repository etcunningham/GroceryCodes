package com.example.elicunningham.grocerycodes.Application;

import android.content.Context;

import com.example.elicunningham.grocerycodes.Model.CodeList;
import com.example.elicunningham.grocerycodes.Model.GroceryCode;

public class GameManager {

    private CodeList codes;
    private GroceryCode currCode;

    public GameManager(Context context){
        codes = new CodeList(context);
    }

    public boolean hasCodesLeft(){
        return codes.hasCodes();
    }

    public GroceryCode getNextCode(){
        currCode = codes.getNextCode();
        return currCode;
    }

    public void rightAnswer(){
        codes.gotCorrect(currCode);
    }

    public void wrongAnswer(){
        codes.gotIncorrect(currCode);
    }
}

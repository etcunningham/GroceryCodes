package com.example.elicunningham.grocerycodes.Application;

import android.content.Context;

import com.example.elicunningham.grocerycodes.Model.CodeList;
import com.example.elicunningham.grocerycodes.Model.GroceryCode;

public class GameManger {

    private CodeList codes;
    private Context context;

    public GameManger(Context context){
        this.context = context;
        codes = new CodeList(context);
    }

    public boolean hasCodesLeft(){
        return codes.hasCodes();
    }

    public GroceryCode getNextCode(){
        return codes.getNextCode();
    }
}

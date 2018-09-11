package com.example.elicunningham.grocerycodes.Model;

public class GroceryCode {

    private String code;
    private String name;

    public GroceryCode(String name, String code){
        this.name = name;
        this.code = code;
    }

    public String getName(){
        return name;
    }

    public String getCode() {
        return code;
    }
}

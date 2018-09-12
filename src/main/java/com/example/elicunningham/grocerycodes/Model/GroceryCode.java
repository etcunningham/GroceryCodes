package com.example.elicunningham.grocerycodes.Model;

public class GroceryCode {

    private String code;
    private String name;

    public GroceryCode(String code, String name){
        System.out.println("makeing a new grocery code");
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

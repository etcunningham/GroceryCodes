package com.example.elicunningham.grocerycodes.Model;

public class GroceryCode {

    private String code;
    private String name;
    private boolean solved;
    private int numWrongGuesses;

    public GroceryCode(String code, String name){
        System.out.println("making a new grocery code");
        this.name = name;
        this.code = code;
        this.solved = false;
        this.numWrongGuesses = 0;
    }

    public String getName(){
        return name;
    }

    public String getCode() {
        return code;
    }

    public void gotCorrect(){
        solved = true;
    }

    public boolean isSolved(){
        return solved;
    }

    public void gotIncorrect(){
        numWrongGuesses++;
    }

    public int getNumWrongGuesses(){
        return numWrongGuesses;
    }
}

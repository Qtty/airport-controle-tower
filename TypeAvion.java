package com.usthb.modeles;

public enum TypeAvion{
    
    AIRBUS("AIRBUS"),
    BOEING("BOEING"),
    ATR("ATR");

    private String type  = "";

    TypeAvion(String type){
        this.type = type;
    }

    public String toString(){
        return type; 
    }
}
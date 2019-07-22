package com.usthb.modeles;

//énumération contenant les type d'avions
public enum TypeAvion{
    
    AIRBUS("AIRBUS"),
    BOEING("BOEING"),
    ATR("ATR");

    private String type  = "";

    //constructeur 
    TypeAvion(String type){
        this.type = type;
    }


    //redéfinition de la méthode toString
    public String toString(){
        return type; 
    }
}
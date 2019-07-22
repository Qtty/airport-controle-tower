package com.usthb.modeles;

//énumération contenant les types de moyens de transport
public enum TypeMoyen
{
    VOI("VOI"),
    CAM("CAM"),
    BUS("BUS"),
    AVI("AVI");

    private String type = "";


    //constructeur de l'énumération
    TypeMoyen(String type)
    {
        this.type = type;
    }


    //redéfinition de la méthode toString
    public String toString()
    {
        return type;
    }
}
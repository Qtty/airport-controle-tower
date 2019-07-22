package com.usthb.modeles;

//énumération contenant les orientations
public enum Orientations
{
    NORD("NORD"),
    SUD("SUD"),
    EST("EST"),
    OUEST("OUEST");

    private String orien = "";

    //constructeur de l'énumération
    Orientations(String orien)
    {
        this.orien = orien;
    }

    //redéfinition de la méthode toString
    public String toString()
    {
        return orien;
    }
}
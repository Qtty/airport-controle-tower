package com.usthb.modeles;

public enum Orientations
{
    NORD("NORD"),
    SUD("SUD"),
    EST("EST"),
    OUEST("OUEST");

    private String orien = "";

    Orientations(String orien)
    {
        this.orien = orien;
    }

    public String toString()
    {
        return orien;
    }
}
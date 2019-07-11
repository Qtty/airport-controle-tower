package com.usthb.modeles;

public class Route extends Couloir {
    
    public static int n = 0;
    private Boolean intersect;

    public Route(Boolean intersect){
        super();
        this.intersect = intersect;
        numeroSequentiel = String.format("R%03d",n);
        n++;

    }

    public Boolean getIntersect()
    {
        return intersect;
    }

    public String toString()
    {
        return super.toString() + String.format("Intersection: %b",intersect);
    }

}


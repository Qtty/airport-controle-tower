package com.usthb.modeles;

//classe route
public class Route extends Couloir {
    
    //variables propres au routes
    public static int n = 0;
    private Boolean intersect;


    //constructeur de la classe route, on appelle celui de la superclass ensuite on rajoute les attributs de la classe route
    public Route(Boolean intersect){
        super();
        this.intersect = intersect;
        numeroSequentiel = String.format("R%03d",n);
        n++;
    }


    //getter de l'attribut "intersect" de la classe route
    public Boolean getIntersect()
    {
        return intersect;
    }


    //redéfinition de la méthode toString pour la classe route
    public String toString()
    {
        return super.toString() + String.format("Intersection: %b",intersect);
    }
}


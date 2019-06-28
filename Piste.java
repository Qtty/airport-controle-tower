package com.usthb.modeles;

import com.usthb.modeles.Couloir;

public class Piste extends Couloir
{
    private static int n = 0;
    private int longeur;
    private float pente;
    private Orientation orientation;

    public Piste(int longeur,float pente,Orientation orientation)
    {
        super();
        numeroSequentiel = String.format("P%03d",n);
        this.pente = pente;
        this.longeur = longeur;
        this.orientation = orientation;
        n++;
    }

    public int getLongeur()
    {
        return longeur;
    }

    public float getPente()
    {
        return pente;
    }

    public Orientation getOrientation()
    {
        return orientation;
    }

    public String toString()
    {
        return super.toString() + String.format("longeur: %d\npente: %f\norientation: %s",longeur,pente,orientation);
    }

    public static Boolean checkInput(int l,String orien)
    {
        if (l > 4000)
        {
            System.out.println("[-] longeur doit etre <= 4000 m");
            return false;
        }

        try
        {
            Orientation.valueOf(orien);
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println("[-] Orientation invalid");
            return false;
        }

        return true;
    }

    public static void main(String[] args)
    {
        Piste p;
        Piste.checkInput(3999, "EST");
    }
}

enum Orientation
{
    NORD("NORD"),
    SUD("SUD"),
    EST("EST"),
    OUEST("OUEST");

    private String orien = "";

    Orientation(String orien)
    {
        this.orien = orien;
    }

    public String toString()
    {
        return orien;
    }
}
package com.usthb.modeles;

public class Piste extends Couloir
{
    private static int n = 0;
    private int longeur;
    private float pente;
    private Orientations orientation;

    public Piste(int longeur,float pente,Orientations orientation)
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

    public Orientations getOrientation()
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
            Orientations.valueOf(orien);
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println("[-] Orientations invalid");
            return false;
        }

        return true;
    }
}
package com.usthb.modeles;

//classe piste
public class Piste extends Couloir
{

    //varibales de la classe piste
    private static int n = 0;
    private int longeur;
    private float pente;
    private Orientations orientation;

    
    //constructeur de la classe piste, on appelle d'abord le constructeur de la super classe puis on rajoute les attributs de la classe piste
    public Piste(int longeur,float pente,Orientations orientation)
    {
        super();
        numeroSequentiel = String.format("P%03d",n);
        this.pente = pente;
        this.longeur = longeur;
        this.orientation = orientation;
        n++;
    }


    //getters qui retournent les attributs de la classe piste
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


    //redéfintion de la méthode toString pour la classe piste
    public String toString()
    {
        return super.toString() + String.format("Longeur: %d\nPente: %f\nOrientation: %s",longeur,pente,orientation);
    }


    /*méthode retournant un boolean qui permet de vérifier si une longueure est valide et si une chaine de charactere est une orientation valide
        en utilisant l'énumération Orientations
    */
    public static Boolean checkInput(int l,String orien)
    {
        if (l > 4000)
        {
            System.out.println("[-] La longeur doit etre <= 4000m");
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
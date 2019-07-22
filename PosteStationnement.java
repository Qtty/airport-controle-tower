package com.usthb.modeles;

//classe de poste de stationnement
public class PosteStationnement
{
    //variables de la classe
    private static int n = 0;
    private Boolean auContact;
    private String numeroSequentiel;
    private int[] position;


    //constructeur de la classe
    public PosteStationnement(Type type,int[] position)
    {
        auContact = true;
        numeroSequentiel = String.format("%s%03d",type,n);
        this.position = position;
        n++;
    }

    //second constructeur de la classe (surchargement)
    public PosteStationnement(Type type)
    {
        auContact = false;
        numeroSequentiel = String.format("%s%03d",type,n);
        n++;
    }

    //getters permettant de retourner les valeurs des variables de la classe 
    public Boolean getAuContact()
    {
        return auContact;
    }

    public String getNumeroSequentiel()
    {
        return numeroSequentiel;
    }

    public String getPosition()
    {
        if (auContact) return String.format("(%d,%d)",position[0],position[1]);
        return "eloigne";
    }


    //redéfinition de la méthode toString
    public String toString()
    {
        return String.format("numero sequentiel: %s\nau contact: %s\nposition: %s",numeroSequentiel,auContact,getPosition());
    }

    //méthode qui permet de vérifier si une chaine de charactere est un type de stationnement valide
    public static Boolean checkType(String type)
    {
        try
        {
            Type.valueOf(type);
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println("[-] type invalid");
            return false;
        }

        return true;
    }
}


//énumération contenant les type de stationnement
enum Type
{
    P("P"),
    A("A");

    private String type = "";

    //constructeur de l'énumération
    Type(String type)
    {
        this.type = type;
    }

    //redéfinition de la méthode toString
    public String toString()
    {
        return type;
    }
}
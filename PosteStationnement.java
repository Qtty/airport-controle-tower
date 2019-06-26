package com.usthb.modeles;

public class PosteStationnement
{
    private static int n = 0;
    private Boolean auContact;
    private String numeroSequentiel;
    private int[] position;

    public PosteStationnement(Type type,int[] position)
    {
        auContact = true;
        numeroSequentiel = String.format("%s%03d",type,n);
        this.position = position;
        n++;
    }

    public PosteStationnement(Type type)
    {
        auContact = false;
        numeroSequentiel = String.format("%s%03d",type,n);
        n++;
    }

    public Boolean getAuContact()
    {
        return auContact;
    }

    public String numeroSequentiel()
    {
        return numeroSequentiel;
    }

    public String getPosition()
    {
        if (auContact) return String.format("(%d,%d)",position[0],position[1]);
        return "eloigne";
    }

    public String toString()
    {
        return String.format("numero sequentiel: %s\nau contact: %s\nposition: %s",numeroSequentiel,auContact,getPosition());
    }

    public static void main(String[] args)
    {
        int[] x = {0,1};
        PosteStationnement p = new PosteStationnement(Type.P);

        System.out.println(p);
    }
}

enum Type
{
    P("P"),
    A("A");

    private String type = "";

    Type(String type)
    {
        this.type = type;
    }

    public String toString()
    {
        return type;
    }
}
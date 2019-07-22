package com.usthb.modeles;

import java.util.Scanner;

//super classe couloir
public class Couloir
{
    //variables de la super classe couloir
    protected String numeroSequentiel;
    protected int[][] occupation = new int[24][60];
    protected MoyenTransport moyen = null;


    //constructeur de la superclasse qui initialise un couloir
    public Couloir()
    {
        for (int i=0;i<24;i++)
        {
            for (int j=0;j<60;j++) occupation[i][j] = 0;
        }

    }


    //getters de la super classe qui retournent les attributs
    public String getNumeroSequentiel()
    {
        return numeroSequentiel;
    }

    public int[][] getOccupation()
    {
        return occupation;
    }

    public MoyenTransport getMoyen()
    {
        return moyen;
    }


    //setters de la super classe qui permettent de changer les valeur des attributs de la super classe
    public void setMoyen(MoyenTransport moyen)
    {
        this.moyen = moyen;
    }


    //setter qui permet de déterminer l'occupation d'un couloir à une ou plusieurs heures précises
    public void setOccupation()
    {
        Scanner sc = new Scanner(System.in);
        int t,x,y,c;

        System.out.println("Combien de moments voulez-vous modifier?");
        t = sc.nextInt();
        sc.nextLine();
        for (int i=0;i<t;i++)
        {
            System.out.println("L'heure");
            x = sc.nextInt();
            System.out.println("La minute");
            y = sc.nextInt();
            System.out.println("Saisissez l'occupation(1/0)");
            c = sc.nextInt();
            occupation[x][y] = c;
        }
    }


    //redéfinition de la méthode toString 
    public String toString()
    {
        String x = "Numero sequentiel: " + numeroSequentiel + "\nOccupation:\n";

        for (int i=0;i<24;i++)
        {
            for (int j=0;j<60;j++)
            {
                x += String.format("%d ",occupation[i][j]);
            }
            x += "\n";
        }
        return x;
    }
}
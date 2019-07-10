package com.usthb.modeles;
import java.util.Scanner;

public class Couloir
{
    protected String numeroSequentiel;
    protected int[][] occupation = new int[24][60];

    public Couloir()
    {
        for (int i=0;i<24;i++)
        {
            for (int j=0;j<60;j++) occupation[i][j] = 0;
        }

    }

    public String getNumeroSequentiel()
    {
        return numeroSequentiel;
    }

    public int[][] getOccupation()
    {
        return occupation;
    }

    public void setOccupation()
    {
        Scanner sc = new Scanner(System.in);
        int t,x,y,c;

        System.out.println("combien de moments a modifier?");
        t = sc.nextInt();
        sc.nextLine();
        for (int i=0;i<t;i++)
        {
            System.out.println("saisie l'heure");
            x = sc.nextInt();
            System.out.println("saisie la minute");
            y = sc.nextInt();
            System.out.println("saisie l'occupation(1/0)");
            c = sc.nextInt();
            occupation[x][y] = c;
        }

    }

    public String toString()
    {
        String x = "numeroSequentiel: " + numeroSequentiel + "\nL'occupation :\n";

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

    public static void main(String[] args)
    {
        Couloir a = new Couloir();
    }
}
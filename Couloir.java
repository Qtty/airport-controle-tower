package com.usthb.modeles;
import java.util.Scanner;

public class Couloir
{
    protected String numeroSequentiel;
    protected int[][] occupation = new int[24][60];

    public Couloir()
    {
        Scanner sc = new Scanner(System.in);
        int tmp = 0;
        Boolean c = true;
        for (int i=0;i<24;i++)
        {
            for (int j=0;j<60;j++)
            {
                while (c)
                {
                    System.out.println(String.format("saisie l'occupation pour le moment %02d:%02d(1/0)",i,j));
                    tmp = sc.nextInt();
                    if (tmp == 1 || tmp == 0) c = false;
                }
                occupation[i][j] = tmp;
                c = true;
            }
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

    public String toString()
    {
        String x = "numeroSequentiel: " + numeroSequentiel + "\n";

        for (int i=0;i<24;i++)
        {
            for (int j=0;j<60;j++)
            {
                x += occupation[i][j] + '\t';
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
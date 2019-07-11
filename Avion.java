package com.usthb.modeles;

public class Avion extends MoyenTransport{

    private int carburant, nombreVoyageurs;
    private static int n = 0;
    private TypeAvion typeAvion;

    public Avion(long numeroSerie, String modele, String entreprise ,TypeAvion typeAvion,int carburant, int nombreVoyageurs){
        
        super(numeroSerie,"",modele,entreprise);
        this.carburant = carburant;
        this.typeAvion = typeAvion;
        this.nombreVoyageurs = nombreVoyageurs;
        this.numeroSequentiel = String.format("AVI%03d",n);
        n++;

    }

    public int getCarburant(){
        return carburant;
    }

    public String getTypeAvion(){
        return String.format("%s", typeAvion);   
    }

    public int getNombreVoyageurs(){
        return nombreVoyageurs;
    }

    public String toString(){  
        return super.toString() + String.format("\nType: %s\nCarburant: %d\nNombre Voyageurs: %d\n",typeAvion,carburant,nombreVoyageurs);
    }

    public static Boolean checkType(String type){
        try
        {
            TypeAvion.valueOf(type);
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println("[-] Type d'avion invalid");
            return false;
        }

        return true;
    }

}


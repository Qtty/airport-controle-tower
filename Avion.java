package com.usthb.modeles;

//classe avion

public class Avion extends MoyenTransport{


    //variables de la classe avion
    private int carburant, nombreVoyageurs;
    private static int n = 0;
    private TypeAvion typeAvion;


    //constructeur de la classe avion, on appelle la super classe d'abord, puis on complète les attributs de la classe avion
    public Avion(long numeroSerie, String modele, String entreprise ,TypeAvion typeAvion,int carburant, int nombreVoyageurs){
        
        super(numeroSerie,"",modele,entreprise);
        this.carburant = carburant;
        this.typeAvion = typeAvion;
        this.nombreVoyageurs = nombreVoyageurs;
        this.numeroSequentiel = String.format("AVI%03d",n);
        n++;
    }
    

    //getters des attributs de la classe avion
    public int getCarburant(){
        return carburant;
    }

    public String getTypeAvion(){
        return String.format("%s", typeAvion);   
    }

    public int getNombreVoyageurs(){
        return nombreVoyageurs;
    }

    
    //redéfinition de la méthode toString pour la classe avion
    public String toString(){  
        return super.toString() + String.format("\nType: %s\nCarburant: %d\nNombre de voyageurs: %d\n",typeAvion,carburant,nombreVoyageurs);
    }



    //méthode qui vérifie si une chaine de charactere passé en paramètre est un type d'avion retournant un boolean  
    public static Boolean checkType(String type){
        try
        {
            TypeAvion.valueOf(type);
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println("[-] Le type d'avion est invalid");
            return false;
        }

        return true;
    }
}


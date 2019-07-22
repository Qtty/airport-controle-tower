package com.usthb.modeles;

//classe bus

public class Bus extends MoyenTransport{

    //variables propre au bus
    private static int n = 0;
    private int nombreSiege;

    //On appelle le constructeur de la super classe et on rajoute les attributs de la sous classe

    public Bus(long numeroSerie, String matricule, String modele, String entreprise,TypeMoyen type, int nombreSiege){

        super(numeroSerie,matricule,modele,entreprise);
        this.numeroSequentiel = String.format("%s%03d",TypeMoyen.BUS,n);
        this.nombreSiege = nombreSiege;
        n++;
     
    }
    
    
    //getter de l'attribut de la classe
    public int getNombreSiege(){
        return nombreSiege;
    }   
    
    
    // redéfinition de la méthode toString pour complementer la classe bus 
    public String toString(){
        return super.toString() + String.format("\nNombre de siege: %d\n", nombreSiege); 
    }
}  
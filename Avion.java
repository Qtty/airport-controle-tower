package com.usthb.modeles;
import com.usthb.modeles.MoyenTransport;
import com.usthb.modeles.TypeMoyen;

public class Avion extends MoyenTransport{

    private String compagnie, numeroSequentiel1, type1;
    private int carburant, nombreVoyageurs;
    private static int n = 0;

    public Avion(long numeroSerie, String modele, String compagnie,TypeMoyen type ,leType type1,int carburant, int nombreVoyageurs){
        
        super(numeroSerie,"",modele,"",type);
        this.compagnie = compagnie;
        this.carburant = carburant;
        this.nombreVoyageurs = nombreVoyageurs;
        numeroSequentiel1 = String.format("%s%03d",type1,n);
        n++;

    }

    public String getCompagnie(){
        return compagnie;
    }

    public String getNumeroSequentiel1(){
        return numeroSequentiel1;
    }

    public int getCarburant(){
        return carburant;
    }

    public int getNombreVoyageurs(){
        return nombreVoyageurs;
    }

    public String toString(){  
        return super.toString() + String.format("\nNumero sequentiel avion: %s\nCarburant: %d\nNombre Vouyageurs: %d\nCompagnie: %s\n",numeroSequentiel1,carburant,nombreVoyageurs,compagnie);
    }

    public static void main(String[] args)
    {
        Avion a = new Avion(1486,"ruski","bratan",TypeMoyen.AVI,leType.ATR, 500, 100);

        System.out.println(a);

    }

}

enum leType{
    
    AIRBUS("AIRBUS"),
    BOEING("BOEING"),
    ATR("ATR");

    private String type  = "";

    leType(String type){
        this.type = type;
    }

    public String toString(){
        return type; 
    }
}
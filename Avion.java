package com.usthb.modeles;
import com.usthb.modeles.MoyenTransport;
import com.usthb.modeles.TypeMoyen;

public class Avion extends MoyenTransport{

    private int carburant, nombreVoyageurs;
    private static int n = 0;
    private leType typeAvion;

    public Avion(long numeroSerie, String modele, String entreprise,TypeMoyen type ,leType typeAvion,int carburant, int nombreVoyageurs){
        
        super(numeroSerie,"",modele,entreprise,type);
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

    public Boolean checkTypeMoyen(String type){
        try
        {
            leType.valueOf(type);
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println("[-] Type d'avion invalid");
            return false;
        }

        return true;
    }

    public static void main(String[] args)
    {
        Avion a = new Avion(1486,"ruski","bratan",TypeMoyen.AVI,leType.AIRBUS, 500, 100);
            MoyenTransport b = new MoyenTransport(71486,"171732021451","ruski","bratan",TypeMoyen.CAM);
        Vehicule c = new Vehicule(14856,"1717320214851","ruski","bratan",TypeMoyen.VOI,"fun");
                Avion d = new Avion(14860,"ruski","bratan",TypeMoyen.AVI,leType.ATR, 500, 100);


        System.out.println(a + "\n"  + b+ "\n" + c + "\n" + d);

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
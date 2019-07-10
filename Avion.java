package com.usthb.modeles;

public class Avion extends MoyenTransport{

    private int carburant, nombreVoyageurs;
    private static int n = 0;
    private TypeAvion typeAvion;

    public Avion(long numeroSerie, String modele, String entreprise ,TypeAvion typeAvion,int carburant, int nombreVoyageurs){
        
        super(numeroSerie,"",modele,entreprise,TypeMoyen.AVI);
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

   /* public static void main(String[] args)
    {
        Avion a = new Avion(1486,"ruski","bratan",TypeMoyen.AVI,TypeAvion.AIRBUS, 500, 100);
        MoyenTransport b = new MoyenTransport(71486,"171732021451","ruski","bratan",TypeMoyen.CAM);
        Vehicule c = new Vehicule(14856,"1717320214851","ruski","bratan",TypeMoyen.VOI,"fun");
        Avion d = new Avion(14860,"ruski","bratan",TypeMoyen.AVI,TypeAvion.ATR, 500, 100);


        System.out.println(a + "\n"  + b+ "\n" + c + "\n" + d);

    }   */

}


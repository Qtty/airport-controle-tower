package com.usthb.modeles;
import com.usthb.modeles.MoyenTransport;
import com.usthb.modeles.TypeMoyen;

public class Bus extends MoyenTransport{

    private static int n = 0;
    private int nombreSiege;

    public Bus(long numeroSerie, String matricule, String modele, String entreprise,TypeMoyen type, int nombreSiege){

        super(numeroSerie,matricule,modele,entreprise,type);
        this.numeroSequentiel = String.format("%s%03d",TypeMoyen.BUS,n);
        this.nombreSiege = nombreSiege;
        n++;
     
    }

    public int getNombreSiege(){
        return nombreSiege;
    }   

    public String toString(){
        return super.toString() + String.format("\nNombre Siege %d\n", nombreSiege); 
    }

      
    public static void main(String[] args)
    {
        MoyenTransport b = new MoyenTransport(1486,"171732021451","ruski","bratan",TypeMoyen.CAM);
        Bus a = new Bus(1486,"171732021451","ruski","bratan",TypeMoyen.BUS, 50);

        System.out.println(a);

    }


}  
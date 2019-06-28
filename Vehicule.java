package com.usthb.modeles;

import com.usthb.modeles.MoyenTransport;
import com.usthb.modeles.TypeMoyen;

public class Vehicule extends MoyenTransport
{
    private static int n = 0;
    private String motifUtilisation;

    public Vehicule(long numeroSerie, String matricule, String modele, String entreprise, TypeMoyen type,String motifUtilisation)
    {
        super(numeroSerie, matricule, modele, entreprise, type);
        this.motifUtilisation = motifUtilisation;
        n++;
    }

    public String toString()
    {
        return super.toString() + String.format("\nmotif d'utilisation: %s",motifUtilisation);
    }

    public Boolean checkTypeMoyen(String type)
    {
        Boolean c = super.checkTypeMoyen(type);

        if (c && (type.equals(TypeMoyen.VOI.toString()) || type.equals(TypeMoyen.CAM.toString()))) return true;
        return false;
    }

    public String getMotifUtilisation()
    {
        return motifUtilisation;
    }
    
    public static void main(String[] args)
    {
        Vehicule a = new Vehicule(1486,"171732021451","ruski","bratan",TypeMoyen.CAM,"fun");

        System.out.println(a);

    }
}
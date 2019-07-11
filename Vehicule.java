package com.usthb.modeles;

public class Vehicule extends MoyenTransport
{
    private static int n = 0;
    private String motifUtilisation;

    public Vehicule(long numeroSerie, String matricule, String modele, String entreprise, TypeMoyen type,String motifUtilisation)
    {
        super(numeroSerie, matricule, modele, entreprise);
        this.numeroSequentiel = String.format("%s%03d",type,n);
        this.motifUtilisation = motifUtilisation;
        n++;
    }

    public String toString()
    {
        return super.toString() + String.format("\nmotif d'utilisation: %s\n",motifUtilisation);
    }

    public Boolean checkTypeMoyen(String type)
    {
        Boolean c = super.checkTypeMoyen(type);

        if (c && (type.equals(TypeMoyen.VOI.toString()) || type.equals(TypeMoyen.CAM.toString()))) return true;
        System.out.println("[-] type doit etre VOI ou CAM");
        return false;
    }

    public String getMotifUtilisation()
    {
        return motifUtilisation;
    }

}
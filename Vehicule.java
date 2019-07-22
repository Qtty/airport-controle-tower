package com.usthb.modeles;

//classe véhicule

public class Vehicule extends MoyenTransport
{
    //variables propre au véhicules
    private static int n = 0;
    private String motifUtilisation;


    //constructeur de la classe véhicule, on appelle d'abord la super class puis on rajoute les attribus des véhicules
    public Vehicule(long numeroSerie, String matricule, String modele, String entreprise, TypeMoyen type,String motifUtilisation)
    {
        super(numeroSerie, matricule, modele, entreprise);
        this.numeroSequentiel = String.format("%s%03d",type,n);
        this.motifUtilisation = motifUtilisation;
        n++;
    }


    //redéfinition de la méthode toString pour la classe véhicule
    public String toString()
    {
        return super.toString() + String.format("\nMotif d'utilisation: %s\n",motifUtilisation);
    }


    /*
        redéfinition de la méthode qui permet de vérifier si une chaine de characteres passé en paramètre est un moyen de type véhicule
        pour ce faire, elle compare la chaine avec les valeurs de l'énumération TypeMoyen qui représentent les véhicules
    */
    public Boolean checkTypeMoyen(String type)
    {
        Boolean c = super.checkTypeMoyen(type);

        if (c && (type.equals(TypeMoyen.VOI.toString()) || type.equals(TypeMoyen.CAM.toString()))) return true;
        System.out.println("[-] Le type doit etre VOI ou CAM");
        return false;
    }
    
    
    //getter de l'attribut de la classe véhicule 
    public String getMotifUtilisation()
    {
        return motifUtilisation;
    }
}
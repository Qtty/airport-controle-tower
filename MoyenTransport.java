package com.usthb.modeles;

public class MoyenTransport
{
    private static int n = 0;
    private long numeroSerie;
    private String matricule,modele,entreprise,numeroSequentiel;

    public MoyenTransport(long numeroSerie,String matricule,String modele,String entreprise,TypeMoyen type)
    {
        this.numeroSerie = numeroSerie;
        this.matricule = matricule;
        this.modele = modele;
        this.entreprise = entreprise;
        numeroSequentiel = String.format("%s%03d",type,n);
        n++;
    }

    public long getNumeroSerie()
    {
        return numeroSerie;
    }

    public String getMatricule()
    {
        return matricule;
    }

    public String getModele()
    {
        return modele;
    }

    public String getEntreprise()
    {
        return entreprise;
    }

    public String getNumeroSequentiel()
    {
        return numeroSequentiel;
    }

    public String toString()
    {
        return String.format("numero sequentiel: %s\nnumero de serie: %d\nmatricule: %s\nmodele: %s\nentreprise: %s",numeroSequentiel,numeroSerie,matricule,modele,entreprise);
    }

    public static void main(String[] args)
    {
        MoyenTransport a = new MoyenTransport(1486,"171732021451","ruski","bratan",TypeMoyen.VOL);

        System.out.println(a);

    }

}

enum TypeMoyen
{
    VOL("VOL"),
    CAM("CAM"),
    BUS("BUS"),
    AVI("AVI");

    private String type = "";

    TypeMoyen(String type)
    {
        this.type = type;
    }

    public String toString()
    {
        return type;
    }
}
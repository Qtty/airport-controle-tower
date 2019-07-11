package com.usthb.modeles;

public class MoyenTransport
{
    protected long numeroSerie;
    protected String matricule,modele,entreprise,numeroSequentiel;
    protected Couloir couloir = null;

    public MoyenTransport(long numeroSerie,String matricule,String modele,String entreprise)
    {
            this.numeroSerie = numeroSerie;
            this.matricule = matricule;
            this.modele = modele;
            this.entreprise = entreprise;      
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

    public Boolean checkTypeMoyen(String type)
    {
        try
        {
            TypeMoyen.valueOf(type);
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println("[-] type moyen invalid");
            return false;
        }

        return true;
    }

    public static TypeMoyen getType(String type){
        return TypeMoyen.valueOf(type);
    }
    
    public Couloir getCouloir()
    {
        return couloir;
    }

    public void setCouloir(Couloir couloir)
    {
        this.couloir = couloir;
    }
   
}

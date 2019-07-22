package com.usthb.modeles;

//super classe des moyens de transports

public class MoyenTransport
{
    //variables de la super classe
    protected long numeroSerie;
    protected String matricule,modele,entreprise,numeroSequentiel;
    protected Couloir couloir = null;

    
    //constructeur de la super classe
    public MoyenTransport(long numeroSerie,String matricule,String modele,String entreprise)
    {
            this.numeroSerie = numeroSerie;
            this.matricule = matricule;
            this.modele = modele;
            this.entreprise = entreprise;      
    }


    //getters qui retournent les valeurs des attributs de la super classe
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

    public static TypeMoyen getType(String type){
        return TypeMoyen.valueOf(type);
    }
    
    public Couloir getCouloir()
    {
        return couloir;
    }


    //setter qui permet de donner une valeur a l'attribut couloir de la super classe
    public void setCouloir(Couloir couloir)
    {
        this.couloir = couloir;
    }
   

    //redéfinition de la méthode toString pour la super classe 
    public String toString()
    {
        return String.format("Numero sequentiel: %s\nNumero de serie: %d\nMatricule: %s\nModele: %s\nEntreprise: %s",numeroSequentiel,numeroSerie,matricule,modele,entreprise);
    }


    //méthode qui vérifie si une chaine de charactere passé en paramètre est un type de moyen de transport valide en utilisant l'énumération TypeMoyen
    public Boolean checkTypeMoyen(String type)
    {
        try
        {
            TypeMoyen.valueOf(type);
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println("[-] Le type du moyen est invalid");
            return false;
        }

        return true;
    }
}

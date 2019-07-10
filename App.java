package com.usthb.controleur;

import com.usthb.modeles.*;
import java.util.Scanner;
import java.util.ArrayList;

public class App
{
    public static void main(String[] argc)
    {
        int menuChoice;
        int l = 1;
        ArrayList<MoyenTransport> lesMoyens = new ArrayList(),tmp;
        ArrayList<Avion> lesAvions = new ArrayList();
        ArrayList<Route> lesRoutes = new ArrayList();
        ArrayList<Piste> lesPistes = new ArrayList();
        Avion tmpAvion;
        Route tmpRoute;

        for(int i=0;i<4;i++) lesRoutes.add(new Route(false));
        for(int i=0;i<4;i++) lesPistes.add(new Piste(55,25,Orientations.NORD));

        while(l == 1){
            Menu.leMenu();
            menuChoice = Menu.sc.nextInt();
            Menu.sc.nextLine();
            switch(menuChoice){
                case 1 :
                    tmp = Menu.saisirMoyenTransport();
                    if (tmp != null) lesMoyens.addAll(tmp);
                    break;
                    
                case 2 :
                    tmpAvion = Menu.saisirAvion();
                    if (tmpAvion != null) lesAvions.add(tmpAvion);
                    break;

                case 3 :
                    Menu.chercherRoute(lesRoutes);
                    break;
                case 4 :
                    Menu.chercherPiste(lesPistes);
                    break;
                case 5 :
                    Menu.autoriserMoyen(lesMoyens);
                    break;
                case 6 : break;
                default : System.out.println("Choix incorrecte, veuillez entrer un choix valide [1-8] "); 
            }
            System.out.println("Voulez vous continuer?(1/0)");   
            l = Menu.sc.nextInt();
            Menu.sc.nextLine();
        }
    }
}

class Menu{
    static Scanner sc = new Scanner(System.in);

    public static void leMenu()
    {
        System.out.println("----Tour de controle----");
        System.out.println("Bienvenu dans le Menu.");
        System.out.println("1. Ajouter un moyen de transport \n2. Ajouter un avion \n3. Chercher une route libre à un horaire donné \n4. Chercher une piste libre à un horaire donné \n5. Afficher  la  liste  des  moyens  de  transport, sélectionner  un  moyen,  puis  l’autoriser  à utiliser une route libre à un horaire donné. \n6.  Afficher la liste des avions, sélectionner un moyen, puis l’autoriser à utiliser une route libre à un horaire donné.");
    }

    public static ArrayList saisirMoyenTransport()
    {
        
        ArrayList arr = new ArrayList();
        long numeroSerie;
        int nombreSiege;
        String matricule, modele, entreprise, type; 

        System.out.println("Donnez le numero de serie/matricule/modele/entreprise/type");
        numeroSerie = sc.nextLong();
        sc.nextLine();
        matricule = sc.nextLine();
        modele = sc.nextLine();
        entreprise = sc.nextLine();
        type = sc.nextLine();
        if( type.equals("VOI")|| type.equals("CAM"))
        {
            System.out.println("Donnez le motif d'utilisation");
            String motifUtilisation = sc.nextLine();
            Vehicule vh = new Vehicule(numeroSerie, matricule, modele, entreprise, MoyenTransport.getType(type), motifUtilisation);
            arr.add(vh);
        }
        else 
        {
                if(type.equals("BUS")) 
                {
                    System.out.println("Donnez le nombre de siege");
                    nombreSiege = sc.nextInt();
                    Bus bs = new Bus(numeroSerie, matricule, modele, entreprise, MoyenTransport.getType(type), nombreSiege);
                    arr.add(bs);
                }
                else
                {
                    System.out.println("Vous avez saisis un mauvais type!");
                    return null;
                }   
        }
        return arr;
    }

    public static Avion saisirAvion()
    {
        int carburant, nombreVoyageurs;
        long numeroSerie;
        String type;
        String modele,entreprise;

        System.out.println("Donnez le numero de serie/modele/entreprise/type d'avion/carburant/nombre de voyageurs");

        numeroSerie = sc.nextLong();
        sc.nextLine();
        modele = sc.nextLine();
        entreprise = sc.nextLine();
        type = sc.nextLine();
        carburant = sc.nextInt();
        nombreVoyageurs = sc.nextInt();

        if (Avion.checkType(type))
        {
            System.out.println("avoin ajoutees");
            return new Avion(numeroSerie, modele, entreprise, TypeAvion.valueOf(type), carburant, nombreVoyageurs);
        }
        else
        {
            System.out.println("Vous avez saisis un mauvais type!");
            return null;
        }
    }

    public static Route chercherRoute(ArrayList<Route> lesRoutes)
    {
        int x,y;

        System.out.println("saisie l'heure/la minute");
        x = sc.nextInt();
        y = sc.nextInt();
        sc.nextLine();
        if (x >= 24 || x < 0 || y >=60 || y < 0)
        {
            System.out.println("temps invalid");
            return null;
        }
        for (Route r: lesRoutes)
        {
            if (r.getOccupation()[x][y] == 0)
            {
                System.out.println("route trouve:\n" + r);
                return r;
            }
        }
        System.out.println("aucune route libre");
        return null;
    }

    public static Piste chercherPiste(ArrayList<Piste> lesPistes)
    {
        int x,y;

        System.out.println("saisie l'heure/la minute");
        x = sc.nextInt();
        y = sc.nextInt();
        sc.nextLine();
        if (x >= 24 || x < 0 || y >=60 || y < 0)
        {
            System.out.println("temps invalid");
            return null;
        }
        for (Piste p: lesPistes)
        {
            if (p.getOccupation()[x][y] == 0)
            {
                System.out.println("piste trouve:\n" + p);
                return p;
            }
        }
        System.out.println("aucune piste libre");
        return null;
    }

    public static void autoriserMoyen(ArrayList<MoyenTransport> lesMoyens)
    {
        int c=1,y,m;
        for(MoyenTransport m: lesMoyens)
        {
            System.out.println(String.format("[%d] %s",c++,m));
        }
        System.out.println("saisie l'heure/la minute");
        c = sc.nextInt();
        y = sc.nextInt();


    }
}

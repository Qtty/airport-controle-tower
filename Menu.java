package com.usthb.controleur;

import com.usthb.modeles.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu
{
    static Scanner sc = new Scanner(System.in);

    public static void leMenu()
    {
        int menuChoice;
        int l = 1;
        ArrayList<MoyenTransport> lesMoyens = new ArrayList();
        ArrayList<MoyenTransport> lesAvions = new ArrayList();
        ArrayList<Couloir> lesRoutes = new ArrayList();
        ArrayList<Couloir> lesPistes = new ArrayList();
        MoyenTransport tmp;

        for(int i=0;i<4;i++) lesRoutes.add(new Route(false));
        for(int i=0;i<4;i++) lesPistes.add(new Piste(55,25,Orientations.NORD));

        while(l == 1){
            Menu.afficherMenu();
            menuChoice = Menu.sc.nextInt();
            Menu.sc.nextLine();
            switch(menuChoice){
                case 1 :
                    tmp = Menu.saisirMoyenTransport();
                    if (tmp != null) lesMoyens.add(tmp);
                    break;
                    
                case 2 :
                    tmp = Menu.saisirAvion();
                    if (tmp != null) lesAvions.add(tmp);
                    break;

                case 3 :
                    Menu.chercherCouloir(lesRoutes);
                    break;

                case 4 :
                    Menu.chercherCouloir(lesPistes);
                    break;

                case 5 :
                    Menu.autoriserMoyen(lesMoyens,lesRoutes);
                    break;

                case 6 :
                    Menu.autoriserMoyen(lesAvions,lesPistes);
                    break;

                default : System.out.println("[-] Choix incorrecte, veuillez entrer un choix valide [1-6] "); 
            }
            System.out.println("[?] Voulez vous continuer?(1/0)");   
            l = Menu.sc.nextInt();
            Menu.sc.nextLine();
        }
    }
    
    public static void afficherMenu()
    {
        System.out.println("----Tour de controle----");
        System.out.println("Bienvenu dans le Menu.");
        System.out.println("1. Ajouter un moyen de transport \n2. Ajouter un avion \n3. Chercher une route libre à un horaire donné \n4. Chercher une piste libre à un horaire donné \n5. Afficher  la  liste  des  moyens  de  transport, sélectionner  un  moyen,  puis  l’autoriser  à utiliser une route libre à un horaire donné. \n6. Afficher la liste des avions, sélectionner un moyen, puis l’autoriser à utiliser une route libre à un horaire donné.");
    }

    public static MoyenTransport saisirMoyenTransport()
    {
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
            System.out.println("[+] moyen ajoutee");
            return vh;
        }
        else 
        {
                if(type.equals("BUS")) 
                {
                    System.out.println("Donnez le nombre de siege");
                    nombreSiege = sc.nextInt();
                    Bus bs = new Bus(numeroSerie, matricule, modele, entreprise, MoyenTransport.getType(type), nombreSiege);
                    System.out.println("[+] moyen ajoutee");
                    return bs;
                }
                else
                {
                    System.out.println("[-] Vous avez saisis un mauvais type!");
                    return null;
                }   
        }
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
            System.out.println("[+] avoin ajoutees");
            return new Avion(numeroSerie, modele, entreprise, TypeAvion.valueOf(type), carburant, nombreVoyageurs);
        }
        else
        {
            System.out.println("[-] Vous avez saisis un mauvais type!");
            return null;
        }
    }

    public static Couloir chercherCouloir(ArrayList<Couloir> lesCouloirs)
    {
        int x,y;

        System.out.println("saisie l'heure/la minute");
        x = sc.nextInt();
        y = sc.nextInt();
        sc.nextLine();
        if (x >= 24 || x < 0 || y >=60 || y < 0)
        {
            System.out.println("[-] temps invalid");
            return null;
        }
        for (Couloir c: lesCouloirs)
        {
            if (c.getOccupation()[x][y] == 0)
            {
                System.out.println("[+] couloir trouvee:\n" + c);
                c.getOccupation()[x][y] = 1;
                return c;
            }
        }
        System.out.println("[+] aucune couloir libre");
        return null;
    }

    public static void autoriserMoyen(ArrayList<MoyenTransport> lesMoyens,ArrayList<Couloir> lesCouloirs)
    {
        int c=1,m;
        Couloir tmp;
        for(MoyenTransport k: lesMoyens)
        {
            System.out.println(String.format("[%d] %s",c++,k));
        }
        System.out.println("saisie le moyen");
        m = sc.nextInt();
        tmp = chercherCouloir(lesCouloirs);
        if (tmp != null)
        {
            lesMoyens.get(m-1).setCouloir(tmp);
            tmp.setMoyen(lesMoyens.get(m-1));
            System.out.println("[+] autorisation donnee");
        }
    }

}
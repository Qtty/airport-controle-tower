package com.usthb.controleur;

import com.usthb.modeles.*;
import java.util.Scanner;
import java.util.ArrayList;

//classe menu contenant tout ce qui est en relation avec le menu et ses fonctionalités 
public class Menu
{
    static Scanner sc = new Scanner(System.in);

    //méthode qui gère le programme et le menu et l'appel aux fonctions celon le choix de l'utilisateur 
    public static void leMenu()
    {
        int menuChoice;
        int l = 1;
        
        //les listes des différents moyens possible
        ArrayList<MoyenTransport> lesMoyens = new ArrayList();
        ArrayList<MoyenTransport> lesAvions = new ArrayList();
        ArrayList<Couloir> lesRoutes = new ArrayList();
        ArrayList<Couloir> lesPistes = new ArrayList();
        MoyenTransport tmp;


        for(int i=0;i<4;i++) lesRoutes.add(new Route(false));
        for(int i=0;i<4;i++) lesPistes.add(new Piste(55,25,Orientations.NORD));
        
        //boucle principale du programme
        while(l == 1){
            Menu.afficherMenu();
            menuChoice = Menu.sc.nextInt();
            Menu.sc.nextLine();
            //gestion du choix de l'utilisateur par un switch
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

                default : System.out.println("[-] Choix incorrecte, veuillez entrer un choix valide: [1-6]"); 
            }
            System.out.println("[?] Voulez vous continuer?(1/0)");   
            l = Menu.sc.nextInt();
            Menu.sc.nextLine();
        }
    }
    

    //méthode qui affiche le menu
    public static void afficherMenu()
    {
        System.out.println("----Tour de controle----");
        System.out.println("Bienvenu dans le Menu.");
        System.out.println("1. Ajouter un moyen de transport \n2. Ajouter un avion \n3. Chercher une route libre à un horaire donné \n4. Chercher une piste libre à un horaire donné \n5. Afficher  la  liste  des  moyens  de  transport, sélectionner  un  moyen,  puis  l’autoriser  à utiliser une route libre à un horaire donné. \n6. Afficher la liste des avions, sélectionner un moyen, puis l’autoriser à utiliser une route libre à un horaire donné.");
    }


    /*méthode qui permet de saisir un moyen de transport et qui retourne un élément de type véhicule ou bus (typecast en tant que moyen de transport) 
        dépandant des données saisies par l'utilisateur
    */
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
        //on vérifie si le type est un véhicule ou bus et si le type est invalide on retourne un null
        if( type.equals("VOI")|| type.equals("CAM"))
        {
            System.out.println("Donnez le motif d'utilisation");
            String motifUtilisation = sc.nextLine();
            Vehicule vh = new Vehicule(numeroSerie, matricule, modele, entreprise, MoyenTransport.getType(type), motifUtilisation);
            System.out.println("[+] Moyen ajoute");
            return vh;
        }
        else 
        {
                if(type.equals("BUS")) 
                {
                    System.out.println("Donnez le nombre de siege");
                    nombreSiege = sc.nextInt();
                    Bus bs = new Bus(numeroSerie, matricule, modele, entreprise, MoyenTransport.getType(type), nombreSiege);
                    System.out.println("[+] Moyen ajoute");
                    return bs;
                }
                else
                {
                    System.out.println("[-] Vous avez saisis un mauvais type!");
                    return null;
                }   
        }
    }


    //méthode qui permet de saisir un avion et qui retourne un élément de type avion
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

        //on vérifie si le type d'avion est valide 
        if (Avion.checkType(type))
        {
            System.out.println("[+] Avion ajoute");
            return new Avion(numeroSerie, modele, entreprise, TypeAvion.valueOf(type), carburant, nombreVoyageurs);
        }
        else
        {
            System.out.println("[-] Vous avez saisis un mauvais type!");
            return null;
        }
    }


    /*méthode qui permet de chercher un couloir libre à une heure précise et qui le retourne si il existe, sinon on retourne null si aucun couloir 
        n'est libre ou si le temps saisi par l'utilisateur est incorrecte
    */
    public static Couloir chercherCouloir(ArrayList<Couloir> lesCouloirs)
    {
        int x,y;

        System.out.println("Saisissez l'heure/la minute");
        x = sc.nextInt();
        y = sc.nextInt();
        sc.nextLine();
        //on vérifie si le temps est valide
        if (x >= 24 || x < 0 || y >=60 || y < 0)
        {
            System.out.println("[-] Temps invalide");
            return null;
        }
        //on parcour la liste des couloirs pour chercher un couloir libre a l'heure donnée
        for (Couloir c: lesCouloirs)
        {
            if (c.getOccupation()[x][y] == 0)
            {
                System.out.println("[+] Couloir trouve:\n" + c);
                c.getOccupation()[x][y] = 1;
                return c;
            }
        }
        System.out.println("[+] Aucun couloir libre");
        return null;
    }


    //méthode qui permet d'autoriser un moyen de transport a utiliser un couloir 
    public static void autoriserMoyen(ArrayList<MoyenTransport> lesMoyens,ArrayList<Couloir> lesCouloirs)
    {
        int c=1,m;
        Couloir tmp;
        /*affichage de la liste des moyens de transports (en utilisant le typecaseon peut aussi afficher la liste des avions quand le paramètre passé 
        est la liste d'avions)
        */
        for(MoyenTransport k: lesMoyens)
        {
            System.out.println(String.format("[%d] %s",c++,k));
        }
        System.out.println("Saisissez le numéro du moyen de transport");
        m = sc.nextInt();
        //on cherche si un couloir est libre
        tmp = chercherCouloir(lesCouloirs);
        //si on trouve un couloir libre on autorise le moyen de transport selectioné a l'utiliser
        if (tmp != null)
        {
            lesMoyens.get(m-1).setCouloir(tmp);
            tmp.setMoyen(lesMoyens.get(m-1));
            System.out.println("[+] Autorisation donnee");
        }
    }

}
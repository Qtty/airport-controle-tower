package com.usthb.controleur;

import com.usthb.modeles.*;
import java.util.Scanner;
import com.usthb.modeles.Bus;
import com.usthb.modeles.Vehicule;
import com.usthb.modeles.MoyenTransport;
import java.util.ArrayList;

public class menu{
    private ArrayList arr = new ArrayList();
    public void leMenu(){
        System.out.println("----Tour de controle----");
        System.out.println("Bienvenu dans le menu.");
        System.out.println("1. Saisie de moyens de transport \n2. Saisie d’avions \n3. Ajouter un moyen de transport \n4. Ajouter un avion \n5. Chercher une route libre à un horaire donné \n6. Chercher une piste libre à un horaire donné \n7. Afficher  la  liste  des  moyens  de  transport, sélectionner  un  moyen,  puis  l’autoriser  à utiliser une route libre à un horaire donné. \n8.  Afficher la liste des avions, sélectionner un moyen, puis l’autoriser à utiliser une route libre à un horaire donné.");
    }
    public ArrayList saisirMoyenTransport(){
        
        ArrayList arr = new ArrayList();
        long numeroSerie;
        int nombreSiege;
        String matricule, modele, entreprise, type; 
        Scanner sc = new Scanner(System.in);

        System.out.println("Donnez le numero de serie/matricule/modele/entreprise/type");
        numeroSerie = sc.nextLong();
        sc.nextLine();
        matricule = sc.nextLine();
        modele = sc.nextLine();
        entreprise = sc.nextLine();
        type = sc.nextLine();
        if( type.equals("VOI") == true || type.equals("CAM") == true ){
            System.out.prinln("Donnez le motif d'utilisation");
            String motifUtilisation = sc.nextLine();
           Vehicule vh = new Vehicule(numeroSerie, matricule, modele, entreprise, MoyenTransport.getType(type), motifUtilisation);
           arr.add(vh);
        }   else {
                if(type.compareTo("BUS") == 0) {
                    nombreSiege = sc.nextInt();
                    Bus bs = new Bus(numeroSerie, matricule, modele, entreprise, MoyenTransport.getType(type), nombreSiege);
                    arr.add(bs);
                    }else{
                        System.out.println("Vous avez saisis un mauvais type!");
                    }   
                }
        return arr;
    }


    public static void main(String[] argc){
        Scanner sc = new Scanner(System.in);
        int menuChoice;
        int l = 1;
        ArrayList al = new ArrayList();
        menu mn = new menu();
        while(l == 1){
            mn.leMenu();
            menuChoice = sc.nextInt();
            switch(menuChoice){
                case 1 : al.add(mn.saisirMoyenTransport()); break;
                case 2 : break;
                case 3 : 
                    for(int i = 0; i < mn.arr.size(); i++){
                        if ( al.contains(mn.arr.get(i)) == false)  al.add(mn.arr.get(i));
                    }
                    System.out.println("oyoyoyv2");
                    System.out.println(al.get(0));
                    break;
                case 4 : break;
                case 5 : break;
                case 6 : break;
                case 7 : break;
                case 8 : break;
                default : System.out.println("Choix incorrecte, veuillez entrer un choix valide [1-8] "); 
            }
            System.out.println("Voulez vous continuer?(1/0)");   
            l = sc.nextInt(); 
        }
    }

}

package fr.uvsq.poo.employe;

import java.util.ArrayList;
import java.util.List;

public class Entreprise {
    private String nom;
    private List<Employe> listeEmployes = new ArrayList<Employe>();

    public Entreprise(String nom){}

    public Entreprise(String nom,Employe... values){
            this.nom = nom;
            for(int i = 0; i<values.length;i++){
                listeEmployes.add(values[i]);
            }

    }

    public void afficher(){
        for(int i = 0;i<listeEmployes.size(); i++){
            System.out.println(listeEmployes.get(i).calculSalaire());
        }
    }

    public void ajouter(Employe e){
        listeEmployes.add(e);
    }
}

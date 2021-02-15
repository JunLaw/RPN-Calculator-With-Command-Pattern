package fr.uvsq.poo.employe;

public class Employe {
    private final String nom;
    private final String adresse;
    protected double salaireBase;
    protected int anciennete;

    public Employe(String nom,String adresse,double salaireBase,int anciennete){
        this.nom = nom;
        this.adresse = adresse;
        this.salaireBase = salaireBase;
        this.anciennete = anciennete;
    }

   public double calculSalaire(){
        return salaireBase + (anciennete * 20.0);
    }

}

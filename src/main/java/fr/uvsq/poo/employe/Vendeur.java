package fr.uvsq.poo.employe;

public class Vendeur extends Employe {
    private int commission;

    public Vendeur(String nom,String adresse,double salaireBase,int anciennete,int commission){
        super(nom,adresse,salaireBase,anciennete);
        this.commission = commission;
    }

    @Override
    public double calculSalaire(){
        return super.calculSalaire() + commission;
    }
}

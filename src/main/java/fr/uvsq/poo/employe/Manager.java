package fr.uvsq.poo.employe;

public class Manager extends Employe {
    private int employe;

    public Manager(String nom,String adresse,double salaireBase,int anciennete,int employe){
        super(nom,adresse,salaireBase,anciennete);
        this.employe = employe;

    }

    @Override
    public double calculSalaire(){
        return super.calculSalaire() + 100.0*employe;
    }


}

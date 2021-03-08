package fr.uvsq.poo.annuaire;

import java.time.LocalDate;
import java.util.HashMap;

public class Personnel {
    private String nom;
    private String prenom;
    private String fonction;
    private LocalDate dateNaissance;
    private HashMap<String,Integer> numTels;

    public static class Builder{
        private String nom;
        private String prenom;
        private String fonction;
        private LocalDate dateNaissance;
        private HashMap<String,Integer> numTels = null;

        public Builder(String nom,String prenom,String fonction,LocalDate dateNaissance){

            this.nom = nom;
            this.prenom = prenom;
            this.fonction = fonction;
            this.dateNaissance = dateNaissance;

        }

        public Builder numTels(HashMap<String,Integer> numTels){
            this.numTels = numTels;
            return this;
        }

        public Personnel build(){
            return new Personnel(this);
        }
    }

    private Personnel(Builder builder) {
        nom = builder.nom;
        prenom = builder.prenom;
        fonction = builder.fonction;
        dateNaissance = builder.dateNaissance;
        numTels = builder.numTels;
    }
}

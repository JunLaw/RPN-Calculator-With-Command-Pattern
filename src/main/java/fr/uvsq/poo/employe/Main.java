package fr.uvsq.poo.employe;

public class Main {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Employe e1 = new Employe("noob","oui",1500.0,3);
        Vendeur v1 = new Vendeur("lol","non",2000,4,100);
        Manager m1 = new Manager("ya","rook",2500,10,10);
        System.out.println(e1.calculSalaire());
        System.out.println(v1.calculSalaire());
        System.out.println(m1.calculSalaire());
        Entreprise ent = new Entreprise("minou",e1,v1,m1);
        ent.afficher();
    }
}

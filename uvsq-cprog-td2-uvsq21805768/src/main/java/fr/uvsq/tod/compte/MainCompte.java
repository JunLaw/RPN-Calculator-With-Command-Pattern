package fr.uvsq.tod.compte;

public class MainCompte {

	public static void main(String[] args) {
		Compte c1 = new Compte(99);
		Compte c2 = new Compte(20);
		System.out.println("Les soldes des comptes c1 et c2 sont: "+c1.getBalance()+" et "+c2.getBalance());

	}

}

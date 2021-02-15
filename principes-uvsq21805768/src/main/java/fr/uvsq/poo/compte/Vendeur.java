package fr.uvsq.poo.compte;

public class Vendeur extends Employee {

	@Override
	public double calculsalaire(int annees, int commission){
		return 1500 + 20*annees + commission;

}	
}

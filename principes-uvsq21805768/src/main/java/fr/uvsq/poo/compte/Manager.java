package fr.uvsq.poo.compte;

public class Manager extends Employee {
	
	@Override
	public double calculsalaire(int annees, int personnes){
		return 1500 + 20*annees + 100*personnes;

}	
}

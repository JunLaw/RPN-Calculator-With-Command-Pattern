package fr.uvsq.tod.compte;

/**
 * La classe <code>Compte</code> représente un compte bancaire.
 *
 * @author hal
 * @version 2020
 */
public class Compte {
	private int balance;
	
	public Compte() {
		balance = 0;
	}
  public Compte(int initialBalance) {
	  if(initialBalance < 0) {
		  System.out.println("ERROR:Balance should be positive!");
	  }
	  else balance = initialBalance;
  }

  public int getBalance() {
	  if(balance != 0) return balance;
	  else return 0;
  }
  
  public void credit(int m){
		if(m<0) {	
			System.out.println("On ne peut pas créditer un montant négatif");
		}
		else
			balance += m;

	}
  
  public void debit(int m) {
	  if(m > balance) {
		  System.out.print("Solde du compte insuffisant pour réaliser le débit");
		}
		else {
			if(m<0) {
				System.out.print("On ne peut pas débiter un montant négatif");
			}
			else {
				balance -= m ;
			}
		}
}
  public void virement(Compte a, Compte b, int montant) {
	  a.credit(montant);
	  b.debit(montant);
  }
}

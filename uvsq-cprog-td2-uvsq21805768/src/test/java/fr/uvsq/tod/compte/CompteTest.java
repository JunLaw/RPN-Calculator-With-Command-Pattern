package fr.uvsq.tod.compte;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompteTest {
  @Test
  public void shouldCreateAnAccountWithTheSpecifiedBalance() {
    Compte c = new Compte(100);
    assertEquals(100, c.getBalance());
  }
  @Test
  public void avoidNegativeBalance() {
	  Compte c = new Compte();
	  assertTrue(c.getBalance() >= 0);
  }
}

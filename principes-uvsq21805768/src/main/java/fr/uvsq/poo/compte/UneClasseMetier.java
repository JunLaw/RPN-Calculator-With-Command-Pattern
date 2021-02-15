package fr.uvsq.poo.compte;

import java.time.LocalDateTime;

interface InterfaceUneClasseMetier{
	public void uneMethode();
}

public class UneClasseMetier implements InterfaceUneClasseMetier{
	public void uneMethode() {
		System.out.println(LocalDateTime.now()+": Début de uneMethodeMetier"); //log message
		// Traitements métiers
		System.out.println(LocalDateTime.now()+": Fin de uneMethodeMetier"); //log message
	
	}
}

/*
public class UneClasseMetier {
	public void uneMethode() {
		System.out.println(LocalDateTime.now()+": Début de uneMethodeMetier"); //log message
		// Traitements métiers
		System.out.println(LocalDateTime.now()+": Fin de uneMethodeMetier"); //log message
	
	}
}
*/
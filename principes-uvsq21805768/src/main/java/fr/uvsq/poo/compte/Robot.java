package fr.uvsq.poo.compte;

class Position{
	private int x;
	private int y;
	Position( int a, int o){
		this.x = a;
		this.y = o;
	}
}

class Direction{
	private String droite;
	private String sens;
	Direction(String d, String s){
		this.droite = d;
		this.sens = s;
	}
}
public class Robot {
	private Position position ;
	private Direction direction ;
	
	public void tourne() { /* tourne d'un quart de tour */
	
		
	}
	public void avance() { /* avance d'une case */
		
		
	}
}

class RobotStatique extends Robot{
	//@Override
	//public void avance() { thrown new UnsupportedOperationException();}
	
}

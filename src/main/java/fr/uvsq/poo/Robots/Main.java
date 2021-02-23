package fr.uvsq.poo.Robots;

public class Main {

    public static void main( String[] args ){

        Robot r1 = new Robot(new Position(5,2),Direction.NORD);
        Robot r2 = new Robot(new Position(1,3),Direction.NORD);
        Robot r3 = new Robot(new Position(1,4),Direction.NORD);
        Robot.avanceTous();
    }
}

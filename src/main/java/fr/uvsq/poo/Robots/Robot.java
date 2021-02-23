package fr.uvsq.poo.Robots;

import java.util.ArrayList;
import java.util.List;

public class Robot {

    private Position position;
    private Direction direction;
    private static List<Robot> liste = new ArrayList<Robot>();

    public Robot(Position pos,Direction dir){
        this.direction = dir;
        this.position = pos;
        liste.add(this);
    }

    public void tourne(){

    }

    public void avance(){
        switch (direction){
            case EST:
                position.setX(position.getX() +1);
                break;
            case SUD:
                position.setY(position.getY() +1);
                break;
            case NORD:
                position.setY(position.getY() -1);
                break;
            case OUEST:
                position.setX(position.getX() -1);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }
    }

    public static void avanceTous(){
        //position.setX(2);
        for(int i = 0; i< liste.size();i++){
            liste.get(i).avance();
        }
    }
}
